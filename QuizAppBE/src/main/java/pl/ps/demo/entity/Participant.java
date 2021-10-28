package pl.ps.demo.entity;

import pl.ps.demo.ENUMS.RoleName;
import pl.ps.demo.ENUMS.Status;

import javax.persistence.*;

@Entity
@Table(name = "participant", schema = "quiz_app")
public class Participant extends IdField{

    @Column(name = "result", nullable = false, length = 3)
    private Integer result;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 15)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false, foreignKey = @ForeignKey(name = "fk_quiz"))
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
}
