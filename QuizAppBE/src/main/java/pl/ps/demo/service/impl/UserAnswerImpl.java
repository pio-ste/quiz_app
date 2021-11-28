package pl.ps.demo.service.impl;

import org.springframework.stereotype.Service;
import pl.ps.demo.exception.MyCustomException;
import pl.ps.demo.service.dto.UserAnswerDTO;
import pl.ps.demo.model.entity.Answer;
import pl.ps.demo.model.entity.Participant;
import pl.ps.demo.model.entity.Question;
import pl.ps.demo.model.entity.UserAnswer;
import pl.ps.demo.model.repository.AnswerRepository;
import pl.ps.demo.model.repository.ParticipantRepository;
import pl.ps.demo.model.repository.QuestionRepository;
import pl.ps.demo.model.repository.UserAnswerRepository;
import pl.ps.demo.service.UserAnswerService;
import pl.ps.demo.service.mapper.UserAnswerMapper;
import pl.ps.demo.service.validation.QuestionValidation;
import pl.ps.demo.service.validation.UserAnswerValidation;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserAnswerImpl implements UserAnswerService {

    private final UserAnswerRepository userAnswerRepository;
    private final ParticipantRepository participantRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public UserAnswerImpl(UserAnswerRepository userAnswerRepository, ParticipantRepository participantRepository, AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.userAnswerRepository = userAnswerRepository;
        this.participantRepository = participantRepository;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public UserAnswerDTO saveUserAnswer(Long idAnswer, Long idParticipant, UserAnswerDTO userAnswerDTO) {
        List<String> exceptionList = new LinkedList<>();
        var userAnswerValidation = new UserAnswerValidation(exceptionList, userAnswerDTO);
        userAnswerValidation.validate();
        var participant = participantRepository.getByIdOrThrow(idParticipant);
        var answer = answerRepository.getByIdOrThrow(idAnswer);
        var question = questionRepository.getByIdOrThrow(userAnswerDTO.getIdQuestion());
        UserAnswer userAnswer = UserAnswer.builder()
                .id(userAnswerDTO.getId())
                .isCorrect(userAnswerDTO.getCorrect())
                .participant(participant)
                .answer(answer)
                .question(question)
                .build();
        userAnswerRepository.save(userAnswer);
        return UserAnswerMapper.mapFromEntityToDto(userAnswer);
    }

    @Override
    public List<UserAnswerDTO> getUserAnswers(Long idQuestion) {
        questionRepository.getByIdOrThrow(idQuestion);
        List<UserAnswerDTO> userAnswerDTOS = new LinkedList<>();
        userAnswerRepository.findUserAnswerByQuestionIdCheck(idQuestion).forEach(userAnswer ->
                userAnswerDTOS.add(UserAnswerMapper.mapFromEntityToDto(userAnswer)));
        return userAnswerDTOS;
    }
}
