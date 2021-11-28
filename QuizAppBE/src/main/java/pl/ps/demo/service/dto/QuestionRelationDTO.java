package pl.ps.demo.service.dto;

import java.util.Set;

public class QuestionRelationDTO {

    private Long id;
    private String content;
    private Byte[] img;
    private Integer time;
    private Integer points;
    private Set<UserAnswerDTO> userAnswers;
    private Set<AnswerDTO> answers;

    public QuestionRelationDTO(Long id, String content, Byte[] img, Integer time, Integer points, Set<UserAnswerDTO> userAnswers, Set<AnswerDTO> answers) {
        this.id = id;
        this.content = content;
        this.img = img;
        this.time = time;
        this.points = points;
        this.userAnswers = userAnswers;
        this.answers = answers;
    }

    public QuestionRelationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte[] getImg() {
        return img;
    }

    public void setImg(Byte[] img) {
        this.img = img;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Set<UserAnswerDTO> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Set<UserAnswerDTO> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public Set<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<AnswerDTO> answers) {
        this.answers = answers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String content;
        private Byte[] img;
        private Integer time;
        private Integer points;
        private Set<UserAnswerDTO> userAnswers;
        private Set<AnswerDTO> answers;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder img(Byte[] img) {
            this.img = img;
            return this;
        }

        public Builder time(Integer time) {
            this.time = time;
            return this;
        }

        public Builder points(Integer points) {
            this.points = points;
            return this;
        }

        public Builder userAnswers(Set<UserAnswerDTO> userAnswers) {
            this.userAnswers = userAnswers;
            return this;
        }

        public Builder answers(Set<AnswerDTO> answers) {
            this.answers = answers;
            return this;
        }

        public QuestionRelationDTO build() {
            QuestionRelationDTO questionRelationDTO = new QuestionRelationDTO();

            questionRelationDTO.id = this.id;
            questionRelationDTO.content = this.content;
            questionRelationDTO.img = this.img;
            questionRelationDTO.time = this.time;
            questionRelationDTO.points = this.points;
            questionRelationDTO.userAnswers = this.userAnswers;
            questionRelationDTO.answers = this.answers;

            return questionRelationDTO;
        }

    }
}
