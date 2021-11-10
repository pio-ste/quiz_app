package pl.ps.demo.service.Interface;

import pl.ps.demo.ENUMS.Status;
import pl.ps.demo.entity.Participant;

import java.util.List;

public interface ParticipantService {

    Participant saveParticipant(Long idUser, Long idQuiz, Participant participant);

    void deleteParticipant(Long id);

    Participant getParticipant(Long id);

    List<Participant> getParticipantByStatus(Status status);

    List<Participant> getParticipantGreaterThanResult(Integer result);

    List<Participant> getParticipantLessThanResult(Integer result);

    List<Participant> getAllParticipant(Long id);
}
