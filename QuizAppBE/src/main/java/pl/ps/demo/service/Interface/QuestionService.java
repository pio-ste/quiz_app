package pl.ps.demo.service.Interface;

import org.springframework.web.multipart.MultipartFile;
import pl.ps.demo.entity.Question;

import java.util.List;

public interface QuestionService {

    Question saveQuestion(Long idQuiz, Question question, MultipartFile multipartFile);

    void deleteQuestion(Long id);

    Question updateQuestion(Question question);

    List<Question> getQuestion(Long id);

    List<Question> getQuestionWithAnswersByIdQuiz(Long idQuiz);

    List<Question> getQuestionWithUserAnswersIdQuiz(Long idQuiz);
}
