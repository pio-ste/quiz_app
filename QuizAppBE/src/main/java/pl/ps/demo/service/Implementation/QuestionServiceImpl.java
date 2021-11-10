package pl.ps.demo.service.Implementation;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.ps.demo.entity.Question;
import pl.ps.demo.entity.Quiz;
import pl.ps.demo.repository.QuestionRepository;
import pl.ps.demo.repository.QuizRepository;
import pl.ps.demo.service.Interface.QuestionService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final QuizRepository quizRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public Question saveQuestion(Long idQuiz, Question question, MultipartFile multipartFile) {
        Quiz quiz = quizRepository.findQuizById(idQuiz);
        if (!multipartFile.isEmpty()){
            try {
                Byte[] byteImg = new Byte[multipartFile.getBytes().length];

                int i = 0;
                for (byte b : multipartFile.getBytes()){
                    byteImg[i++] = b;
                }
                question.setImg(byteImg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        question.setQuiz(quiz);
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Question updateQuestion(Question question) {
        Question newQuestion = questionRepository.findQuestionById(question.getId());
        newQuestion.setContent(question.getContent());
        newQuestion.setPoints(question.getPoints());
        newQuestion.setTime(question.getTime());
        return questionRepository.save(newQuestion);
    }

    @Override
    public List<Question> getQuestion(Long id) {
        return null;
    }

    @Override
    public List<Question> getQuestionWithUserAnswersIdQuiz(Long idQuiz) {
        return questionRepository.findQuestionByQuiz_Id(idQuiz);
    }

    @Override
    public List<Question> getQuestionWithAnswersByIdQuiz(Long idQuiz) {
        return questionRepository.findQuestionByQuiz_Id(idQuiz).stream()
                .map((n) -> Question.builder()
                            .id(n.getId())
                            .content(n.getContent())
                            .img(n.getImg())
                            .time(n.getTime())
                            .points(n.getPoints())
                            .answers(n.getAnswers())
                            .build())
                .collect(Collectors.toList());
    }
}
