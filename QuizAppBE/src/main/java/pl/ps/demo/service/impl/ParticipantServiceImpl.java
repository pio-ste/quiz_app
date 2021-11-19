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
    public Participant saveParticipant(ParticipantDTO participantDTO) {
        User user = userRepository.findUserById(participantDTO.getUserID());
        Quiz quiz = quizRepository.findQuizById(participantDTO.getQuizID());
        Participant participant = Participant.builder()
                .result(participantDTO.getResult())
                .status(participantDTO.getStatus())
                .quiz(quiz)
                .user(user)
                .build();
        return participantRepository.save(participant);
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }

    @Override
    public Participant getParticipant(Long id) {
        return participantRepository.findParticipantById(id);
    }

    @Override
    public List<Participant> getParticipantByStatus(Status status, Long idQuiz) {
        return participantRepository.findParticipantByStatusAndQuiz_Id(status, idQuiz);
    }

    @Override
    public List<Participant> getParticipantGreaterThanResult(Integer result, Long idQuiz) {
        return participantRepository.findParticipantByResultIsGreaterThanEqualAndQuiz_Id(result, idQuiz);
    }

    @Override
    public List<Participant> getParticipantLessThanResult(Integer result, Long idQuiz) {
        return participantRepository.findParticipantByResultIsLessThanEqualAndQuiz_Id(result, idQuiz);
    }

    @Override
    public List<Participant> getAllParticipant(Long id) {
        return participantRepository.findParticipantByQuiz_Id(id);
    }
}
