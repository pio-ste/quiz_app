package pl.ps.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "answer", schema = "quiz_app")
public class Answer extends IdField{

    @Column(name = "content", nullable = false, length = 200)
    @NotNull
    private String content;

    @Column(name = "is_correct", nullable = false, columnDefinition = "boolean default false")
    @NotNull
    private Boolean isCorrect;

    @OneToMany(mappedBy = "answer")
    @JsonManagedReference
    private Set<UserAnswer> userAnswers;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false, foreignKey = @ForeignKey(name = "fk_question"))
    @JsonBackReference
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

    public Answer(AnswerBuilder answerBuilder){
        super(answerBuilder);
        this.content = answerBuilder.content;
        this.isCorrect = answerBuilder.isCorrect;
        this.userAnswers = answerBuilder.userAnswers;
        this.question = answerBuilder.question;
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

    public static AnswerBuilder builder() {
        return new AnswerBuilder();
    }

    public static final class AnswerBuilder extends IdField.Builder<AnswerBuilder>{
        private String content;
        private Boolean isCorrect;
        private Set<UserAnswer> userAnswers;
        private Question question;

        @Override
        public AnswerBuilder getThis() {
            return this;
        }

        public AnswerBuilder content(String content){
            this.content = content;
            return this;
        }

        public AnswerBuilder isCorrect(Boolean isCorrect){
            this.isCorrect = isCorrect;
            return this;
        }

        public AnswerBuilder userAnswers(Set<UserAnswer> userAnswers){
            this.userAnswers = userAnswers;
            return this;
        }

        public AnswerBuilder question(Question question){
            this.question = question;
            return this;
        }

        public Answer build(){
            return new Answer(this);
        }
    }
}
