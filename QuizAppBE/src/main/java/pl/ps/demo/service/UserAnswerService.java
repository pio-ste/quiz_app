package pl.ps.demo.service;

import pl.ps.demo.service.dto.UserAnswerDTO;

import java.util.List;

public interface UserAnswerService {

    UserAnswerDTO saveUserAnswer(Long idAnswer, Long idParticipant, UserAnswerDTO userAnswerDTO);

    List<UserAnswerDTO> getUserAnswers(Long idQuestion);
}
