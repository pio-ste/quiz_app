CREATE TABLE question
(
    id        bigserial    NOT NULL,
    "content" varchar(300) NOT NULL,
    img       oid          NULL,
    points    int4         NOT NULL,
    "time"    int4         NOT NULL,
    quiz_id   int8         NOT NULL,
    CONSTRAINT question_pkey PRIMARY KEY (id),
    CONSTRAINT fk_quiz FOREIGN KEY (quiz_id) REFERENCES quiz (id)
);

-- Permissions

ALTER TABLE question
    OWNER TO postgres;
GRANT ALL ON TABLE question TO postgres;