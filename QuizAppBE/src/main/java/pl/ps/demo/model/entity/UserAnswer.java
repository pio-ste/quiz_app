package pl.ps.demo.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_answer", schema = "quiz_app")
public class UserAnswer extends IdField {

    private Boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false, foreignKey = @ForeignKey(name = "fk_question"))
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id", nullable = false, foreignKey = @ForeignKey(name = "fk_answer"))
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false, foreignKey = @ForeignKey(name = "fk_participant"))
    private Participant participant;

    public UserAnswer(Long id, Boolean isCorrect, Question question, Answer answer, Participant participant) {
        super(id);
        this.isCorrect = isCorrect;
        this.question = question;
        this.answer = answer;
        this.participant = participant;
    }

    public UserAnswer() {
    }

    public UserAnswer(UserAnswerBuilder userAnswerBuilder) {
        super(userAnswerBuilder);
        this.isCorrect = userAnswerBuilder.isCorrect;
        this.question = userAnswerBuilder.question;
        this.answer = userAnswerBuilder.answer;
        this.participant = userAnswerBuilder.participant;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public static UserAnswerBuilder builder() {
        return new UserAnswerBuilder();
    }

    public static final class UserAnswerBuilder extends IdField.Builder<UserAnswerBuilder> {
        private Boolean isCorrect;
        private Question question;
        private Answer answer;
        private Participant participant;

        @Override
        public UserAnswerBuilder getThis() {
            return this;
        }

        public UserAnswerBuilder isCorrect(Boolean isCorrect) {
            this.isCorrect = isCorrect;
            return this;
        }

        public UserAnswerBuilder question(Question question) {
            this.question = question;
            return this;
        }

        public UserAnswerBuilder answer(Answer answer) {
            this.answer = answer;
            return this;
        }

        public UserAnswerBuilder participant(Participant participant) {
            this.participant = participant;
            return this;
        }

        public UserAnswer build() {
            return new UserAnswer(this);
        }
    }
}