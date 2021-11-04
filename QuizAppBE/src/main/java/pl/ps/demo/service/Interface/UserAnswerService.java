package pl.ps.demo.service.Interface;

import pl.ps.demo.entity.UserAnswer;

import java.util.List;

public interface UserAnswerService {

    UserAnswer saveUserAnswer(Long idParticipant, Long idAnswer, Long idQuestion, UserAnswer userAnswer);

    List<UserAnswer> getUserAnswers(Integer idQuestion);
}
