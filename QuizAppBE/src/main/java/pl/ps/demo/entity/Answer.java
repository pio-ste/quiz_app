package pl.ps.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "answer", schema = "quiz_app")
public class Answer extends IdField{

    @Column(name = "content", nullable = false, length = 200)
    private String content;

    @Column(name = "is_correct", nullable = false, columnDefinition = "boolean default false")
    private Boolean isCorrect;

    @OneToMany(mappedBy = "answer")
    private Set<UserAnswer> userAnswers;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false, foreignKey = @ForeignKey(name = "fk_question"))
    private Question question;

    public Answer(Long id, String content, Boolean isCorrect, Set<UserAnswer> userAnswers, Question question) {
        super(id);
        this.content = content;
        this.isCorrect = isCorrect;
        this.userAnswers = userAnswers;
        this.question = question;
    }

    public Answer() {
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

    public Set<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Set<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
