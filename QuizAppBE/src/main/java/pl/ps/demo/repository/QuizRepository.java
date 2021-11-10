package pl.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ps.demo.entity.Quiz;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Quiz findQuizById(Long id);

    List<Quiz> findQuizByUser_Id(Long id);
}
