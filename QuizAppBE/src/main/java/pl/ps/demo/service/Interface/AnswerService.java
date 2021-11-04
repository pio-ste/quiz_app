package pl.ps.demo.service.Interface;

import pl.ps.demo.entity.Answer;
import pl.ps.demo.entity.Question;

import java.util.List;

public interface AnswerService {

    Answer saveAnswer(Long idQuestion, Answer answer);

    void deleteAnswer(Long id);

    Answer getAnswer(Long id);

    List<Answer> getAnswers(Long id, Boolean isCorrect);

    List<Answer> getAnswers(Question question);
}
