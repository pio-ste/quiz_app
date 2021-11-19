package pl.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ps.demo.ENUMS.RoleName;
import pl.ps.demo.ENUMS.Status;
import pl.ps.demo.entity.Participant;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    Participant findParticipantById(Long id);

    List<Participant> findParticipantByStatusAndQuiz_Id(Status status, Long idQuiz);

    List<Participant> findParticipantByResultIsGreaterThanEqualAndQuiz_Id(Integer result, Long idQuiz);

    List<Participant> findParticipantByResultIsLessThanEqualAndQuiz_Id(Integer result, Long idQuiz);

    List<Participant> findParticipantByQuiz_Id(Long id);
}
