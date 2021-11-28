package pl.ps.demo.service.dto;

import pl.ps.demo.model.enums.Status;

public class ParticipantDTO {

    private Long id;
    private Integer result;
    private Status status;

    public ParticipantDTO() {
    }

    public ParticipantDTO(Long id, Integer result, Status status) {
        this.id = id;
        this.result = result;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Integer result;
        private Status status;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder result(Integer result) {
            this.result = result;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public ParticipantDTO build() {
            ParticipantDTO participantDTO = new ParticipantDTO();

            participantDTO.id = this.id;
            participantDTO.result = this.result;
            participantDTO.status = this.status;

            return participantDTO;
        }
    }
}
