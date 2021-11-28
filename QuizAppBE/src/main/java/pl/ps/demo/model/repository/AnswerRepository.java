package pl.ps.demo.model.repository;

import org.springframework.stereotype.Repository;
import pl.ps.demo.model.entity.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends AbstractJpaRepository<Answer> {

    List<Answer> findAnswerByQuestion_IdAndIsCorrect(Long id, Boolean isCorrect);

    List<Answer> findAnswerByQuestion_Id(Long idQuestion);
}
