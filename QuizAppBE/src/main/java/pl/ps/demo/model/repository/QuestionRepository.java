package pl.ps.demo.model.repository;

import org.springframework.stereotype.Repository;
import pl.ps.demo.model.entity.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends AbstractJpaRepository<Question> {

    Question findQuestionById(Long id);

    List<Question> findQuestionByQuiz_Id(Long id);

    List<Question> findQuestionByQuiz_User_Id(Long idUser);

    List<Question> findQuestionByQuiz_IdAndQuiz_User_Id(Long idQuiz, Long idUser);

}
