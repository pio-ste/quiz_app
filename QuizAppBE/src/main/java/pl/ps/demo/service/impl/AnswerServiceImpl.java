package pl.ps.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ps.demo.exception.MyCustomException;
import pl.ps.demo.model.entity.Answer;
import pl.ps.demo.model.entity.Question;
import pl.ps.demo.model.repository.AnswerRepository;
import pl.ps.demo.model.repository.QuestionRepository;
import pl.ps.demo.service.AnswerService;
import pl.ps.demo.service.QuestionService;
import pl.ps.demo.service.dto.AnswerDTO;
import pl.ps.demo.service.mapper.AnswerMapper;
import pl.ps.demo.service.validation.AnswerValidation;
import pl.ps.demo.service.validation.QuizValidation;

import java.util.LinkedList;
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
    public List<AnswerDTO> saveAnswers(Long idQuestion, List<AnswerDTO> answersDTO) {
        List<String> exceptionList = new LinkedList<>();
        var answerValidation = new AnswerValidation(exceptionList, answersDTO);
        answerValidation.validate();
        Question question = questionRepository.getByIdOrThrow(idQuestion);
        List<Answer> answers = new LinkedList<>();
        answersDTO.forEach(answerDTO -> answers.add(AnswerMapper.mapFromDtoToEntity(answerDTO)));
        answers.forEach(answer -> answer.setQuestion(question));
        answerRepository.saveAll(answers);
        answersDTO.clear();
        answers.forEach(answer -> answersDTO.add(AnswerMapper.mapFromEntityToDto(answer)));
        return answersDTO;
    }

    @Override
    public void deleteAnswer(Long id) {
        if (id <= 0) throw new MyCustomException("Id can not be lower or equal 0!!");
        answerRepository.deleteOrThrow(id);
    }

    @Override
    public AnswerDTO updateAnswer(AnswerDTO answerDTO) {
        var answer = answerRepository.getByIdOrThrow(answerDTO.getId());
        answer.setContent(answerDTO.getContent());
        answer.setCorrect(answerDTO.getCorrect());
        return AnswerMapper.mapFromEntityToDto(answer);
    }

    @Override
    public List<AnswerDTO> getAnswers(Long idQuestion, Boolean isCorrect) {
        questionRepository.getByIdOrThrow(idQuestion);
        List<AnswerDTO> answersDTO = new LinkedList<>();
        answerRepository.findAnswerByQuestion_IdAndIsCorrect(idQuestion, isCorrect).forEach(answer ->
                answersDTO.add(AnswerMapper.mapFromEntityToDto(answer)));
        return answersDTO;
    }

    @Override
    public List<AnswerDTO> getAnswers(Long idQuestion) {
        questionRepository.getByIdOrThrow(idQuestion);
        List<AnswerDTO> answersDTO = new LinkedList<>();
        answerRepository.findAnswerByQuestion_Id(idQuestion).forEach(answer ->
                answersDTO.add(AnswerMapper.mapFromEntityToDto(answer)));
        return answersDTO;
    }
}
