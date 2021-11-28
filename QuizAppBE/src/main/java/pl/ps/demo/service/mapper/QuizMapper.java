package pl.ps.demo.service.mapper;

import pl.ps.demo.model.entity.Quiz;
import pl.ps.demo.service.dto.QuizDTO;

public class QuizMapper {

    public QuizMapper() {
    }

    public static QuizDTO mapFromEntityToDto(Quiz quiz){
        return QuizDTO.builder()
                .id(quiz.getId())
                .description(quiz.getDescription())
                .title(quiz.getTitle())
                .maxPoints(quiz.getMaxPoints())
                .startDate(quiz.getStartDate())
                .endDate(quiz.getEndDate())
                .build();
    }

    public static Quiz mapFromDtoToEntity(QuizDTO quizDTO){
        return Quiz.builder()
                .id(quizDTO.getId())
                .description(quizDTO.getDescription())
                .title(quizDTO.getTitle())
                .maxPoints(quizDTO.getMaxPoints())
                .startDate(quizDTO.getStartDate())
                .endDate(quizDTO.getEndDate())
                .build();
    }
}
