CREATE TABLE user_answer
(
    id             bigserial NOT NULL,
    is_correct     bool      NOT NULL DEFAULT false,
    answer_id      int8      NOT NULL,
    participant_id int8      NOT NULL,
    question_id    int8      NOT NULL,
    CONSTRAINT user_answer_pkey PRIMARY KEY (id),
    CONSTRAINT fk_answer FOREIGN KEY (answer_id) REFERENCES answer (id),
    CONSTRAINT fk_participant FOREIGN KEY (participant_id) REFERENCES participant (id),
    CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES question (id)
);

-- Permissions

ALTER TABLE user_answer
    OWNER TO postgres;
GRANT ALL ON TABLE user_answer TO postgres;