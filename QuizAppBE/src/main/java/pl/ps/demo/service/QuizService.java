package pl.ps.demo.service;

import pl.ps.demo.model.entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz saveQuiz(Long idUser, Quiz quiz);

    void deleteQuiz(Long id);

    Quiz updateQuiz(Quiz quiz);

    Quiz getQuiz(Long id);

    List<Quiz> getAllUserQuizzes(Long id);
}