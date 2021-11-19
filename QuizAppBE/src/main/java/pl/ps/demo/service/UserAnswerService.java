package pl.ps.demo.service;

import pl.ps.demo.service.dto.UserAnswerDTO;
import pl.ps.demo.model.entity.UserAnswer;

import java.util.List;

public interface UserAnswerService {

    UserAnswer saveUserAnswer(UserAnswerDTO userAnswerDTO);

    List<UserAnswer> getUserAnswers(Long idQuestion);
}
