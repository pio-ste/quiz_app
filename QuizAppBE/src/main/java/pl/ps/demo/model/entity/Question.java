package pl.ps.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question", schema = "quiz_app")
public class Question extends IdField {

    @Column(name = "content", nullable = false, length = 300)
    @NotNull
    private String content;

    @Column(name = "img")
    @Lob
    private Byte[] img;

    @Column(name = "time", nullable = false, length = 3)
    @NotNull
    private Integer time;

    @Column(name = "points", nullable = false, length = 2)
    @NotNull
    private Integer points;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false, foreignKey = @ForeignKey(name = "fk_quiz"))
    @JsonIgnore
    private Quiz quiz;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<UserAnswer> userAnswers;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Answer> answers;

    public Question(Long id, String content, Byte[] img, Integer time, Integer points, Quiz quiz, Set<UserAnswer> userAnswers, Set<Answer> answers) {
        super(id);
        this.content = content;
        this.img = img;
        this.time = time;
        this.points = points;
        this.quiz = quiz;
        this.userAnswers = userAnswers;
        this.answers = answers;
    }

    public Question() {
    }

    public Question(QuestionBuilder questionBuilder) {
        super(questionBuilder);
        this.content = questionBuilder.content;
        this.img = questionBuilder.img;
        this.time = questionBuilder.time;
        this.points = questionBuilder.points;
        this.quiz = questionBuilder.quiz;
        this.userAnswers = questionBuilder.userAnswers;
        this.answers = questionBuilder.answers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte[] getImg() {
        return img;
    }

    public void setImg(Byte[] img) {
        this.img = img;
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

    public static QuestionBuilder builder() {
        return new QuestionBuilder();
    }

    public static final class QuestionBuilder extends IdField.Builder<QuestionBuilder> {

        private String content;
        private Byte[] img;
        private Integer time;
        private Integer points;
        private Quiz quiz;
        private Set<UserAnswer> userAnswers;
        private Set<Answer> answers;

        @Override
        public QuestionBuilder getThis() {
            return this;
        }

        public QuestionBuilder content(String content) {
            this.content = content;
            return this;
        }

        public QuestionBuilder img(Byte[] img) {
            this.img = img;
            return this;
        }

        public QuestionBuilder time(Integer time) {
            this.time = time;
            return this;
        }

        public QuestionBuilder points(Integer points) {
            this.points = points;
            return this;
        }

        public QuestionBuilder quiz(Quiz quiz) {
            this.quiz = quiz;
            return this;
        }

        public QuestionBuilder userAnswers(Set<UserAnswer> userAnswers) {
            this.userAnswers = userAnswers;
            return this;
        }

        public QuestionBuilder answers(Set<Answer> answers) {
            this.answers = answers;
            return this;
        }

        public Question build() {
            return new Question(this);
        }
    }
}
