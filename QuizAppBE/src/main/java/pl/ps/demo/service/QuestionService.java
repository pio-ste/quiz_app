package pl.ps.demo.service;

import org.springframework.web.multipart.MultipartFile;
import pl.ps.demo.model.entity.Question;

import java.util.List;

public interface QuestionService {

    Question saveQuestion(Long idQuiz, Question question, MultipartFile multipartFile);

    void deleteQuestion(Long id);

    Question updateQuestion(Question question);

    Question getQuestion(Long id);

    List<Question> getQuestionWithAnswersByIdQuiz(Long idQuiz);

    List<Question> getQuestionWithUserAnswersIdQuiz(Long idQuiz);
}
