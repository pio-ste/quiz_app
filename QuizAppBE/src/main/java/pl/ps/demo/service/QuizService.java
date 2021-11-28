package pl.ps.demo.service;

import pl.ps.demo.service.dto.QuizDTO;

import java.util.List;

public interface QuizService {

    QuizDTO saveQuiz(Long idUser, QuizDTO quizDTO);

    void deleteQuiz(Long idQuiz);

    QuizDTO updateQuiz(QuizDTO quizDTO);

    QuizDTO getQuiz(Long idQuiz);

    List<QuizDTO> getAllUserQuizzes(Long idUser);
}
