package pl.ps.demo.service.dto;

public class AnswerDTO {

    private Long id;
    private String content;
    private Boolean isCorrect;

    public AnswerDTO() {
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

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String content;
        private Boolean isCorrect;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder content(String content){
            this.content = content;
            return this;
        }

        public Builder isCorrect(Boolean isCorrect){
            this.isCorrect = isCorrect;
            return this;
        }

        public AnswerDTO build(){
            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.id = this.id;
            answerDTO.content = this.content;
            answerDTO.isCorrect = this.isCorrect;
            return answerDTO;
        }
    }
}
