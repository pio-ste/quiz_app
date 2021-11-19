package pl.ps.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ps.demo.model.entity.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends AbstractJpaRepository<Question> {

    Question findQuestionById(Long id);

    List<Question> findQuestionByQuiz_Id(Long id);

    /*@Query(value = "select new pl.ps.demo.DTO.QuestionAnswerDTO(q.id, q.content, q.img, q.time, q.points, a.id, a.content, a.isCorrect)\n" +
            "from Question q \n" +
            "inner join Answer a on q.id = a.question.id \n" +
            "where q.quiz.id = :idQuiz")
    List<QuestionAnswerDTO> findQuestionByQuery(Long idQuiz);*/

}
