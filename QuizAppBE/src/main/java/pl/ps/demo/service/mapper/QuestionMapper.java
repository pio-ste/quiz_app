package pl.ps.demo.service.mapper;

import pl.ps.demo.model.entity.Question;
import pl.ps.demo.service.dto.AnswerDTO;
import pl.ps.demo.service.dto.QuestionDTO;
import pl.ps.demo.service.dto.QuestionRelationDTO;
import pl.ps.demo.service.dto.UserAnswerDTO;

import java.util.stream.Collectors;

public class QuestionMapper {

    public QuestionMapper() {
    }

    public static QuestionDTO mapFromEntityToDto(Question question){
        return QuestionDTO.builder()
                .id(question.getId())
                .content(question.getContent())
                .img(question.getImg())
                .points(question.getPoints())
                .time(question.getTime())
                .build();
    }

    public static QuestionRelationDTO mapFromEntityToDtoRelation(Question question){
        return QuestionRelationDTO.builder()
                .id(question.getId())
                .content(question.getContent())
                .img(question.getImg())
                .points(question.getPoints())
                .time(question.getTime())
                .userAnswers(question.getUserAnswers().stream().map((n) ->
                        UserAnswerDTO.builder()
                                .idQuestion(n.getId())
                                .isCorrect(n.getCorrect())
                                .build())
                        .collect(Collectors.toSet()))
                .answers(question.getAnswers().stream().map((n) ->
                        AnswerDTO.builder()
                                .id(n.getId())
                                .content(n.getContent())
                                .isCorrect(n.getCorrect())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }

    public static Question mapFromDtoToEntity(QuestionDTO questionDTO) {
        return Question.builder()
                .id(questionDTO.getId())
                .content(questionDTO.getContent())
                .img(questionDTO.getImg())
                .points(questionDTO.getPoints())
                .time(questionDTO.getTime())
                .build();
    }
}
