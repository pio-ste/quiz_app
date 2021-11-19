package pl.ps.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ps.demo.model.entity.UserAnswer;

import java.util.List;

public interface UserAnswerRepository extends AbstractJpaRepository<UserAnswer> {

    UserRepository findUserAnswerById(Long id);

    List<UserAnswer> findUserAnswerByQuestion_Id(Long idQuestion);
}
