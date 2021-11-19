package pl.ps.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ps.demo.model.entity.Answer;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public interface AnswerRepository extends AbstractJpaRepository<Answer> {

    long countByQuestion(Long id);

    Answer findAnswerById(Long id);

    List<Answer> findAnswerByQuestion_IdAndIsCorrect(Long id, Boolean isCorrect);

    List<Answer> findAnswerByQuestion_Id(Long idQuestion);

    default List<Answer> findAnswerByIdQuestion(Long idQuestion) {
        //getByIdOrThrow(idQuestion);
        if(countByQuestion(idQuestion) == 0) {
            throw new EntityNotFoundException("There is no Answer for idQuestion: " + idQuestion);
        }
        return findAnswerByQuestion_Id(idQuestion);
    }
}
