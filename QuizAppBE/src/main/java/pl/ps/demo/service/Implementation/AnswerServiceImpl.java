package pl.ps.demo.service.Implementation;

import org.springframework.stereotype.Service;
import pl.ps.demo.entity.Answer;
import pl.ps.demo.entity.Question;
import pl.ps.demo.repository.AnswerRepository;
import pl.ps.demo.repository.QuestionRepository;
import pl.ps.demo.service.Interface.AnswerService;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }


    @Override
    public List<Answer> saveAnswers(Long idQuestion, List<Answer> answers) {
        Question question = questionRepository.findQuestionById(idQuestion);
        answers.forEach(answer -> answer.setQuestion(question));
        return answerRepository.saveAll(answers);
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        Answer newAnswer = answerRepository.findAnswerById(answer.getId());
        newAnswer.setContent(answer.getContent());
        newAnswer.setCorrect(answer.getCorrect());
        return answerRepository.save(newAnswer);
    }

    @Override
    public Answer getAnswer(Long id) {
        return null;
    }

    @Override
    public List<Answer> getAnswers(Long id, Boolean isCorrect) {
        return answerRepository.findAnswerByQuestion_IdAndIsCorrect(id, isCorrect);
    }

    @Override
    public List<Answer> getAnswers(Long idQuestion) {
        return answerRepository.findAnswerByQuestion_Id(idQuestion);
    }
}
