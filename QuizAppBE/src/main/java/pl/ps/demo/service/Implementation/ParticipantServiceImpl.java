package pl.ps.demo.service.Implementation;

import org.springframework.stereotype.Service;
import pl.ps.demo.ENUMS.Status;
import pl.ps.demo.entity.Participant;
import pl.ps.demo.entity.Quiz;
import pl.ps.demo.entity.User;
import pl.ps.demo.repository.ParticipantRepository;
import pl.ps.demo.repository.QuizRepository;
import pl.ps.demo.repository.UserRepository;
import pl.ps.demo.service.Interface.ParticipantService;

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
    public Participant saveParticipant(Long idUser, Long idQuiz, Participant participant) {
        User user = userRepository.findUserById(idUser);
        Quiz quiz = quizRepository.findQuizById(idQuiz);
        participant.setUser(user);
        participant.setQuiz(quiz);
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
    public List<Participant> getParticipantByStatus(Status status) {
        return participantRepository.findParticipantByStatus(status);
    }

    @Override
    public List<Participant> getParticipantGreaterThanResult(Integer result) {
        return participantRepository.findParticipantByResultIsGreaterThanEqual(result);
    }

    @Override
    public List<Participant> getParticipantLessThanResult(Integer result) {
        return participantRepository.findParticipantByResultIsLessThanEqual(result);
    }

    @Override
    public List<Participant> getAllParticipant(Long id) {
        return participantRepository.findParticipantByQuiz_Id(id);
    }
}
