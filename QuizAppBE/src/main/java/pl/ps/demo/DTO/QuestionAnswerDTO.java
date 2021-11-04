package pl.ps.demo.DTO;

public class QuestionAnswerDTO {

    private Long idQuestion;
    private String contentQuestion;
    private byte[] img;
    private Integer time;
    private Integer points;
    private Long idAnswer;
    private String contentAnswer;
    private Boolean isCorrect;



    public QuestionAnswerDTO() {
    }

    public QuestionAnswerDTO(Long idQuestion, String contentQuestion, byte[] img, Integer time, Integer points, Long idAnswer, String contentAnswer, Boolean isCorrect) {
        this.idQuestion = idQuestion;
        this.contentQuestion = contentQuestion;
        this.img = img;
        this.time = time;
        this.points = points;
        this.idAnswer = idAnswer;
        this.contentAnswer = contentAnswer;
        this.isCorrect = isCorrect;
    }

    public Long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getContentQuestion() {
        return contentQuestion;
    }

    public void setContentQuestion(String contentQuestion) {
        this.contentQuestion = contentQuestion;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
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

    public Long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getContentAnswer() {
        return contentAnswer;
    }

    public void setContentAnswer(String contentAnswer) {
        this.contentAnswer = contentAnswer;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
