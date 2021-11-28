package pl.ps.demo.service.mapper;

import pl.ps.demo.model.entity.UserAnswer;
import pl.ps.demo.service.dto.UserAnswerDTO;

public class UserAnswerMapper {

    public UserAnswerMapper() {
    }

    public static UserAnswerDTO mapFromEntityToDto(UserAnswer userAnswer){
        return UserAnswerDTO.builder()
                .id(userAnswer.getId())
                .isCorrect(userAnswer.getCorrect())
                .idQuestion(userAnswer.getQuestion().getId())
                .build();
    }

    public static UserAnswer mapFromDtoToEntity(UserAnswerDTO userAnswerDTO) {
        return UserAnswer.builder()
                .id(userAnswerDTO.getId())
                .isCorrect(userAnswerDTO.getCorrect())
                .build();
    }
}
