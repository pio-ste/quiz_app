package pl.ps.demo.service;

import pl.ps.demo.model.enums.Status;
import pl.ps.demo.service.dto.ParticipantDTO;

import java.util.List;

public interface ParticipantService {

    ParticipantDTO saveParticipant(Long idUser, Long idQuiz, ParticipantDTO participantDTO);

    void deleteParticipant(Long id);

    ParticipantDTO getParticipant(Long id);

    List<ParticipantDTO> getParticipantByStatus(Status status, Long idQuiz);

    List<ParticipantDTO> getParticipantGreaterThanResult(Integer result, Long idQuiz);

    List<ParticipantDTO> getParticipantLessThanResult(Integer result, Long idQuiz);

    List<ParticipantDTO> getAllParticipant(Long id);
}
