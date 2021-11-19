package pl.ps.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ps.demo.model.entity.Answer;
import pl.ps.demo.model.entity.Question;
import pl.ps.demo.model.repository.AnswerRepository;
import pl.ps.demo.model.repository.QuestionRepository;
import pl.ps.demo.service.AnswerService;
import pl.ps.demo.service.QuestionService;
import pl.ps.demo.service.validator.Validator;

import java.util.List;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    public AnswerServiceImpl(AnswerRepository answerRepository, QuestionRepository questionRepository, QuestionService questionService) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.questionService = questionService;
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
        //TODO przykladowe zastosowanie getByIdOrThrow // mozna nazwac np. getOrThrow rowniez
        Answer newAnswer = answerRepository.getByIdOrThrow(answer.getId());
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
        questionService.getQuestion(idQuestion);
        var answerValidator = new Validator();
        answerValidator.validate(idQuestion);
        return answerRepository.findAnswerByIdQuestion(idQuestion);
    }
}
