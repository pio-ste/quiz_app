CREATE TABLE answer
(
    id          bigserial    NOT NULL,
    "content"   varchar(200) NOT NULL,
    is_correct  bool         NOT NULL DEFAULT false,
    question_id int8         NOT NULL,
    CONSTRAINT answer_pkey PRIMARY KEY (id),
    CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES question (id)
);

-- Permissions

ALTER TABLE answer
    OWNER TO postgres;
GRANT ALL ON TABLE answer TO postgres;