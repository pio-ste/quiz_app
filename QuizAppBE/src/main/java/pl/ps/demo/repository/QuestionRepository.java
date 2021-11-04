package pl.ps.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ps.demo.DTO.QuestionAnswerDTO;
import pl.ps.demo.entity.Question;
import pl.ps.demo.entity.Quiz;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findQuestionById(Long id);

    List<Question> findQuestionByQuiz(Quiz quiz);

    List<Question> findQuestionByQuiz_Id(Long id);

    @Query(value = "select new pl.ps.demo.DTO.QuestionAnswerDTO(q.id, q.content, q.img, q.time, q.points, a.id, a.content, a.isCorrect)\n" +
            "from Question q \n" +
            "inner join Answer a on q.id = a.question.id \n" +
            "where q.quiz.id = :idQuiz")
    List<QuestionAnswerDTO> findQuestionByQuery(Long idQuiz);

}
