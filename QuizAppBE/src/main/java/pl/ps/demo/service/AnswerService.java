package pl.ps.demo.service;

import pl.ps.demo.service.dto.AnswerDTO;

import java.util.List;

public interface AnswerService {

    List<AnswerDTO> saveAnswers(Long idQuestion, List<AnswerDTO> answers);

    void deleteAnswer(Long id);

    AnswerDTO updateAnswer(AnswerDTO answerDTO);

    List<AnswerDTO> getAnswers(Long id, Boolean isCorrect);

    List<AnswerDTO> getAnswers(Long idQuestion);
}
