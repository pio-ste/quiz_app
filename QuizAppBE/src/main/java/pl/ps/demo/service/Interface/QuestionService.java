package pl.ps.demo.service.Interface;

import org.springframework.data.domain.Pageable;
import pl.ps.demo.DTO.QuestionAnswerDTO;
import pl.ps.demo.entity.Question;

import java.util.List;

public interface QuestionService {

    Question saveQuestion(Long idQuiz, Question question);

    void deleteQuestion(Long id);

    Question updateQuestion(Long id, Long idQuiz, Question question);

    List<Question> getQuestion(Long id);

    List<Question> getQuestionWithAnswers(Long idQuiz);
}
