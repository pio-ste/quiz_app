package pl.ps.demo.model.repository;

import pl.ps.demo.model.entity.Participant;
import pl.ps.demo.model.enums.Status;

import java.util.List;

public interface ParticipantRepository extends AbstractJpaRepository<Participant> {

    List<Participant> findParticipantByStatusAndQuiz_Id(Status status, Long idQuiz);

    List<Participant> findParticipantByResultIsGreaterThanEqualAndQuiz_Id(Integer result, Long idQuiz);

    List<Participant> findParticipantByResultIsLessThanEqualAndQuiz_Id(Integer result, Long idQuiz);

    List<Participant> findParticipantByQuiz_Id(Long idQuiz);
}
