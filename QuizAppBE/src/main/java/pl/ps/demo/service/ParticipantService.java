package pl.ps.demo.service;

import pl.ps.demo.service.dto.ParticipantDTO;
import pl.ps.demo.model.enums.Status;
import pl.ps.demo.model.entity.Participant;

import java.util.List;

public interface ParticipantService {

    Participant saveParticipant(ParticipantDTO participantDTO);

    void deleteParticipant(Long id);

    Participant getParticipant(Long id);

    List<Participant> getParticipantByStatus(Status status, Long idQuiz);

    List<Participant> getParticipantGreaterThanResult(Integer result, Long idQuiz);

    List<Participant> getParticipantLessThanResult(Integer result, Long idQuiz);

    List<Participant> getAllParticipant(Long id);
}
