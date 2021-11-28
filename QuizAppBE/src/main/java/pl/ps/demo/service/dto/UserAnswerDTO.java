package pl.ps.demo.service.dto;

public class UserAnswerDTO {

    private Long id;
    private Boolean isCorrect;
    private Long idQuestion;

    public UserAnswerDTO() {
    }

    public UserAnswerDTO(Long id, Boolean isCorrect, Long idQuestion) {
        this.id = id;
        this.isCorrect = isCorrect;
        this.idQuestion = idQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Boolean isCorrect;
        private Long idQuestion;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder isCorrect(Boolean isCorrect){
            this.isCorrect = isCorrect;
            return this;
        }

        public Builder idQuestion(Long idQuestion){
            this.idQuestion = idQuestion;
            return this;
        }

        public UserAnswerDTO build(){
            UserAnswerDTO userAnswerDTO = new UserAnswerDTO();
            userAnswerDTO.id = this.id;
            userAnswerDTO.isCorrect = this.isCorrect;
            userAnswerDTO.idQuestion = this.idQuestion;
            return userAnswerDTO;
        }

    }
}
