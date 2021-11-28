package pl.ps.demo.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class QuizDTO {

    private Long id;
    private String title;
    private String description;
    private Integer maxPoints;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;

    public QuizDTO(Long id, String title, String description, Integer maxPoints, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.maxPoints = maxPoints;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public QuizDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String title;
        private String description;
        private Integer maxPoints;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder maxPoints(Integer maxPoints){
            this.maxPoints = maxPoints;
            return this;
        }

        public Builder startDate(LocalDateTime startDate){
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDateTime endDate){
            this.endDate = endDate;
            return this;
        }

        public QuizDTO build(){
            QuizDTO quizDTO = new QuizDTO();

            quizDTO.id = this.id;
            quizDTO.title = this.title;
            quizDTO.description = this.description;
            quizDTO.maxPoints = this.maxPoints;
            quizDTO.startDate = this.startDate;
            quizDTO.endDate = this.endDate;

            return quizDTO;
        }
    }
}
