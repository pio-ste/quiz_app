package pl.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ps.demo.entity.Question;
import pl.ps.demo.entity.UserAnswer;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {

    UserRepository findUserAnswerById(Long id);

    List<UserAnswer> findUserAnswerByQuestion_Id(Long idQuestion);
}
