package pl.ps.demo.model.repository;

import pl.ps.demo.model.entity.Quiz;

import java.util.List;

public interface QuizRepository extends AbstractJpaRepository<Quiz> {

    Quiz findQuizById(Long id);

    List<Quiz> findQuizByUser_Id(Long id);
}
