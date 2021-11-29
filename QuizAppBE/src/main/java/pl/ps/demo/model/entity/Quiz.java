package pl.ps.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "quiz", schema = "quiz_app")
public class Quiz extends IdField {

    private String title;

    private String description;

    private Integer maxPoints;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "users_id", foreignKey = @ForeignKey(name = "fk_users"))
    private User user;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Participant> participants;

    public Quiz(Long id, String title, String description, Integer maxPoints, LocalDateTime startDate, LocalDateTime endDate, User user, Set<Question> questions, Set<Participant> participants) {
        super(id);
        this.title = title;
        this.description = description;
        this.maxPoints = maxPoints;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.questions = questions;
        this.participants = participants;
    }

    public Quiz() {
    }

    public Quiz(QuizBuilder quizBuilder) {
        super(quizBuilder);
        this.title = quizBuilder.title;
        this.description = quizBuilder.description;
        this.maxPoints = quizBuilder.maxPoints;
        this.startDate = quizBuilder.startDate;
        this.endDate = quizBuilder.endDate;
        this.user = quizBuilder.user;
        this.questions = quizBuilder.questions;
        this.participants = quizBuilder.participants;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    public static QuizBuilder builder() {
        return new QuizBuilder();
    }

    public static final class QuizBuilder extends IdField.Builder<QuizBuilder> {
        private String title;
        private String description;
        private Integer maxPoints;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private User user;
        private Set<Question> questions;
        private Set<Participant> participants;

        @Override
        public QuizBuilder getThis() {
            return this;
        }

        public QuizBuilder title(String title) {
            this.title = title;
            return this;
        }

        public QuizBuilder description(String description) {
            this.description = description;
            return this;
        }

        public QuizBuilder maxPoints(Integer maxPoints) {
            this.maxPoints = maxPoints;
            return this;
        }

        public QuizBuilder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public QuizBuilder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public QuizBuilder user(User user) {
            this.user = user;
            return this;
        }

        public QuizBuilder questions(Set<Question> questions) {
            this.questions = questions;
            return this;
        }

        public QuizBuilder participants(Set<Participant> participants) {
            this.participants = participants;
            return this;
        }

        public Quiz build() {
            return new Quiz(this);
        }
    }
}
