package pl.ps.demo.model.repository;

import pl.ps.demo.model.entity.UserAnswer;

import java.util.List;

public interface UserAnswerRepository extends AbstractJpaRepository<UserAnswer> {

    List<UserAnswer> findUserAnswerByQuestion_Id(Long idQuestion);

    default List<UserAnswer> findUserAnswerByQuestionIdCheck(Long idQuestion){
        getByIdOrThrow(idQuestion);
        return findUserAnswerByQuestion_Id(idQuestion);
    }
}
