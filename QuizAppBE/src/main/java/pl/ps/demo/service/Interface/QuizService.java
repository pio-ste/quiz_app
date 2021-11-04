package pl.ps.demo.service.Interface;

import pl.ps.demo.entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz addQuiz(Long idUser, Quiz quiz);

    void deleteQuiz(Integer id);

    Quiz updateQuiz(Long id, Long idUser, Quiz quiz);

    List<Quiz> getQuiz(Integer id);

    List<Quiz> getAllUserQuizzes(Integer id);
}
