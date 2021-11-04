package pl.ps.demo.service.Implementation;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.ps.demo.DTO.QuestionAnswerDTO;
import pl.ps.demo.entity.Question;
import pl.ps.demo.entity.Quiz;
import pl.ps.demo.repository.QuestionRepository;
import pl.ps.demo.repository.QuizRepository;
import pl.ps.demo.service.Interface.QuestionService;

import javax.transaction.Transactional;
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
    public Question saveQuestion(Long idQuiz, Question question) {
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {

    }

    @Override
    public Question updateQuestion(Long id, Long idQuiz, Question question) {
        return null;
    }

    @Override
    public List<Question> getQuestion(Long id) {
        return null;
    }

    @Override
    public List<Question> getQuestionWithAnswers(Long idQuiz) {
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
