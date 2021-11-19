package pl.ps.demo.DTO;

public class UserAnswerDTO {

    private Boolean isCorrect;
    private Long questionID;
    private Long answerID;
    private Long participantID;

    public UserAnswerDTO() {
    }

    public UserAnswerDTO(Boolean isCorrect, Long questionID, Long answerID, Long participantID) {
        this.isCorrect = isCorrect;
        this.questionID = questionID;
        this.answerID = answerID;
        this.participantID = participantID;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public Long getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Long answerID) {
        this.answerID = answerID;
    }

    public Long getParticipantID() {
        return participantID;
    }

    public void setParticipantID(Long participantID) {
        this.participantID = participantID;
    }
}
