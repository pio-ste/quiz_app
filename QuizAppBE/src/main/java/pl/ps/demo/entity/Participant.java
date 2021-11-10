package pl.ps.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import pl.ps.demo.ENUMS.Status;

import javax.persistence.*;
import java.util.Set;

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
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false, foreignKey = @ForeignKey(name = "fk_quiz"))
    @JsonIgnore
    private Quiz quiz;

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<UserAnswer> userAnswers;

    public Participant(Long id, Integer result, Status status, User user, Quiz quiz, Set<UserAnswer> userAnswers) {
        super(id);
        this.result = result;
        this.status = status;
        this.user = user;
        this.quiz = quiz;
        this.userAnswers = userAnswers;
    }

    public Participant() {
    }

    public Participant(ParticipantBuilder participantBuilder){
        super(participantBuilder);
        this.result = participantBuilder.result;
        this.status = participantBuilder.status;
        this.user = participantBuilder.user;
        this.quiz = participantBuilder.quiz;
        this.userAnswers = participantBuilder.userAnswers;
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

    public Set<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Set<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public static ParticipantBuilder builder(){
        return new ParticipantBuilder();
    }

    public static final class ParticipantBuilder extends IdField.Builder<ParticipantBuilder>{
        private Integer result;
        private Status status;
        private User user;
        private Quiz quiz;
        private Set<UserAnswer> userAnswers;

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

        public ParticipantBuilder userAnswers(Set<UserAnswer> userAnswers){
            this.userAnswers = userAnswers;
            return this;
        }

        public Participant build(){
            return new Participant(this);
        }
    }
}
