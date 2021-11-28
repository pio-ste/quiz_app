package pl.ps.demo.service.dto;

public class QuestionDTO {

    private Long id;
    private String content;
    private Byte[] img;
    private Integer time;
    private Integer points;

    public QuestionDTO(Long id, String content, Byte[] img, Integer time, Integer points) {
        this.id = id;
        this.content = content;
        this.img = img;
        this.time = time;
        this.points = points;
    }

    public QuestionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private String content;
        private Byte[] img;
        private Integer time;
        private Integer points;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder img(Byte[] img) {
            this.img = img;
            return this;
        }

        public Builder time(Integer time) {
            this.time = time;
            return this;
        }

        public Builder points(Integer points) {
            this.points = points;
            return this;
        }

        public QuestionDTO build() {
            QuestionDTO questionDTO = new QuestionDTO();

            questionDTO.id = this.id;
            questionDTO.content = this.content;
            questionDTO.img = this.img;
            questionDTO.time = this.time;
            questionDTO.points = this.points;

            return questionDTO;
        }

    }
}
