package pl.ps.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question", schema = "quiz_app")
public class Question extends IdField{

    @Column(name = "content", nullable = false, length = 300)
    private String content;

    @Column(name = "time", nullable = false, length = 3)
    private Integer time;

    @Column(name = "points", nullable = false, length = 2)
    private Integer points;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false, foreignKey = @ForeignKey(name = "fk_quiz"))
    private Quiz quiz;

    @OneToMany(mappedBy = "question")
    private Set<UserAnswer> userAnswers;

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers;

    public Question(Long id, String content, Integer time, Integer points, Quiz quiz, Set<UserAnswer> userAnswers, Set<Answer> answers) {
        super(id);
        this.content = content;
        this.time = time;
        this.points = points;
        this.quiz = quiz;
        this.userAnswers = userAnswers;
        this.answers = answers;
    }

    public Question() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
