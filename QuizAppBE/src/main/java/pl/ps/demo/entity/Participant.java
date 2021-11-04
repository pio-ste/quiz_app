package pl.ps.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import pl.ps.demo.ENUMS.RoleName;
import pl.ps.demo.ENUMS.Status;

import javax.persistence.*;

@Entity
@Table(name = "participant", schema = "quiz_app")
public class Participant extends IdField{

    @Column(name = "result", nullable = false, length = 3)
    @NotNull
    private Integer result;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 15)
    @NotNull
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false, foreignKey = @ForeignKey(name = "fk_quiz"))
    @JsonBackReference
    private Quiz quiz;

    public Participant(Long id, Integer result, Status status, User user, Quiz quiz) {
        super(id);
        this.result = result;
        this.status = status;
        this.user = user;
        this.quiz = quiz;
    }

    public Participant() {
    }

    public Participant(ParticipantBuilder participantBuilder){
        super(participantBuilder);
        this.result = participantBuilder.result;
        this.status = participantBuilder.status;
        this.user = participantBuilder.user;
        this.quiz = participantBuilder.quiz;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public static ParticipantBuilder builder(){
        return new ParticipantBuilder();
    }

    public static final class ParticipantBuilder extends IdField.Builder<ParticipantBuilder>{
        private Integer result;
        private Status status;
        private User user;
        private Quiz quiz;

        @Override
        public ParticipantBuilder getThis() {
            return this;
        }

        public ParticipantBuilder result(Integer result){
            this.result = result;
            return this;
        }

        public ParticipantBuilder status(Status status){
            this.status = status;
            return this;
        }

        public ParticipantBuilder user(User user){
            this.user = user;
            return this;
        }

        public ParticipantBuilder quiz(Quiz quiz){
            this.quiz = quiz;
            return this;
        }

        public Participant build(){
            return new Participant(this);
        }
    }
}
