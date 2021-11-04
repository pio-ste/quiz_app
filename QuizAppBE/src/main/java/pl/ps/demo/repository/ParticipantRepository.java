package pl.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ps.demo.ENUMS.Status;
import pl.ps.demo.entity.Participant;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    Participant findParticipantById(Long id);

    List<Participant> findParticipantByStatus(Status status);

    List<Participant> findParticipantByResultIsGreaterThanEqual(Integer result);

    List<Participant> findParticipantByResultIsLessThanEqual(Integer result);
}
