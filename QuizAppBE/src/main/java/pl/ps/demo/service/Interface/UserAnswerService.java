package pl.ps.demo.service.Interface;

import pl.ps.demo.DTO.UserAnswerDTO;
import pl.ps.demo.entity.UserAnswer;

import java.util.List;

public interface UserAnswerService {

    UserAnswer saveUserAnswer(UserAnswerDTO userAnswerDTO);

    List<UserAnswer> getUserAnswers(Long idQuestion);
}
