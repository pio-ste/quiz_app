package pl.ps.demo.service;

import pl.ps.demo.model.entity.Answer;

import java.util.List;

public interface AnswerService {

    List<Answer> saveAnswers(Long idQuestion, List<Answer> answers);

    void deleteAnswer(Long id);

    Answer updateAnswer(Answer answer);

    Answer getAnswer(Long id);

    List<Answer> getAnswers(Long id, Boolean isCorrect);

    List<Answer> getAnswers(Long idQuestion);
}
