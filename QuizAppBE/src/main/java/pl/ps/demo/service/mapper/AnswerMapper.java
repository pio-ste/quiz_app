package pl.ps.demo.service.mapper;

import pl.ps.demo.model.entity.Answer;
import pl.ps.demo.service.dto.AnswerDTO;

public class AnswerMapper {

    public AnswerMapper() {
    }

    public static AnswerDTO mapFromEntityToDto(Answer answer){
        return AnswerDTO.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .isCorrect(answer.getCorrect())
                .build();
    }

    public static Answer mapFromDtoToEntity(AnswerDTO answerDTO) {
        return Answer.builder()
                .id(answerDTO.getId())
                .content(answerDTO.getContent())
                .isCorrect(answerDTO.getCorrect())
                .build();
    }
}
