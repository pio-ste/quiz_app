package pl.ps.demo.service.impl;

import org.springframework.stereotype.Service;
import pl.ps.demo.service.dto.ParticipantDTO;
import pl.ps.demo.model.enums.Status;
import pl.ps.demo.model.entity.Participant;
import pl.ps.demo.model.entity.Quiz;
import pl.ps.demo.model.entity.User;
import pl.ps.demo.model.repository.ParticipantRepository;
import pl.ps.demo.model.repository.QuizRepository;
import pl.ps.demo.model.repository.UserRepository;
import pl.ps.demo.service.ParticipantService;
import pl.ps.demo.service.mapper.ParticipantMapper;
import pl.ps.demo.service.validation.ParticipantValidation;
import pl.ps.demo.service.validation.QuizValidation;

import java.util.LinkedList;
import java.util.List;


@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    public ParticipantServiceImpl(ParticipantRepository participantRepository, UserRepository userRepository, QuizRepository quizRepository) {
        this.participantRepository = participantRepository;
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public ParticipantDTO saveParticipant(Long idUser, Long idQuiz, ParticipantDTO participantDTO) {
        List<String> exceptionList = new LinkedList<>();
        var participantValidation = new ParticipantValidation(exceptionList, participantDTO);
        participantValidation.validate();
        User user = userRepository.getByIdOrThrow(idUser);
        Quiz quiz = quizRepository.getByIdOrThrow(idQuiz);
        Participant participant = Participant.builder()
                .result(participantDTO.getResult())
                .status(participantDTO.getStatus())
                .quiz(quiz)
                .user(user)
                .build();
        return ParticipantMapper.mapFromEntityToDto(participantRepository.save(participant));
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteOrThrow(id);
    }

    @Override
    public ParticipantDTO getParticipant(Long id) {
        return ParticipantMapper.mapFromEntityToDto(participantRepository.getByIdOrThrow(id));
    }

    @Override
    public List<ParticipantDTO> getParticipantByStatus(Status status, Long idQuiz) {
        quizRepository.getByIdOrThrow(idQuiz);
        List<ParticipantDTO> participantDTOS = new LinkedList<>();
        participantRepository.findParticipantByStatusAndQuiz_Id(status, idQuiz).forEach(participant ->
                participantDTOS.add(ParticipantMapper.mapFromEntityToDto(participant)));
        return participantDTOS;
    }

    @Override
    public List<ParticipantDTO> getParticipantGreaterThanResult(Integer result, Long idQuiz) {
        quizRepository.getByIdOrThrow(idQuiz);
        List<ParticipantDTO> participantDTOS = new LinkedList<>();
        participantRepository.findParticipantByResultIsGreaterThanEqualAndQuiz_Id(result, idQuiz).forEach(participant ->
                participantDTOS.add(ParticipantMapper.mapFromEntityToDto(participant)));
        return participantDTOS;
    }

    @Override
    public List<ParticipantDTO> getParticipantLessThanResult(Integer result, Long idQuiz) {
        quizRepository.getByIdOrThrow(idQuiz);
        List<ParticipantDTO> participantDTOS = new LinkedList<>();
        participantRepository.findParticipantByResultIsLessThanEqualAndQuiz_Id(result, idQuiz).forEach(participant ->
                participantDTOS.add(ParticipantMapper.mapFromEntityToDto(participant)));
        return participantDTOS;
    }

    @Override
    public List<ParticipantDTO> getAllParticipant(Long idQuiz) {
        quizRepository.getByIdOrThrow(idQuiz);
        List<ParticipantDTO> participantDTOS = new LinkedList<>();
        participantRepository.findParticipantByQuiz_Id(idQuiz).forEach(participant ->
                participantDTOS.add(ParticipantMapper.mapFromEntityToDto(participant)));
        return participantDTOS;
    }
}
