package pl.ps.demo.service.dto;

import pl.ps.demo.model.enums.Status;

public class ParticipantDTO {
    private Integer result;
    private Status status;
    private Long quizID;
    private Long userID;

    public ParticipantDTO() {
    }

    public ParticipantDTO(Integer result, Status status, Long quizID, Long userID) {
        this.result = result;
        this.status = status;
        this.quizID = quizID;
        this.userID = userID;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getQuizID() {
        return quizID;
    }

    public void setQuizID(Long quizID) {
        this.quizID = quizID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
