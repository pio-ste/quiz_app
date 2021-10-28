package pl.ps.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_answer", schema = "quiz_app")
public class UserAnswer extends IdField{

    @Column(name = "is_correct", nullable = false, columnDefinition = "boolean default false")
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
}
