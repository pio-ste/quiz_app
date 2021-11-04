package pl.ps.demo.service.Implementation;

import pl.ps.demo.ENUMS.Status;
import pl.ps.demo.entity.Participant;
import pl.ps.demo.service.Interface.ParticipantService;

import java.util.List;

public class ParticipantServiceImpl implements ParticipantService {
    @Override
    public Participant saveParticipant(Long idUser, Long idQuiz, Participant participant) {
        return null;
    }

    @Override
    public void deleteParticipant(Long id) {

    }

    @Override
    public Participant getParticipant(Long id) {
        return null;
    }

    @Override
    public List<Participant> getParticipantByStatus(Status status) {
        return null;
    }

    @Override
    public List<Participant> getParticipantGreaterThanResult(Integer result) {
        return null;
    }

    @Override
    public List<Participant> getParticipantLessThanResult(Integer result) {
        return null;
    }
}
