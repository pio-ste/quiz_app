package pl.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ps.demo.entity.Answer;
import pl.ps.demo.entity.Question;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Answer findAnswerById(Long id);

    List<Answer> findAnswerByIdAndIsCorrect(Long id, Boolean isCorrect);

    List<Answer> findAnswerByQuestion(Question question);
}
