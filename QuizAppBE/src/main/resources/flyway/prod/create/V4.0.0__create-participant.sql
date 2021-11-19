CREATE TABLE participant
(
    id       bigserial   NOT NULL,
    "result" int4        NOT NULL,
    status   varchar(15) NOT NULL,
    quiz_id  int8        NOT NULL,
    user_id  int8        NOT NULL,
    CONSTRAINT participant_pkey PRIMARY KEY (id),
    CONSTRAINT fk_quiz FOREIGN KEY (quiz_id) REFERENCES quiz (id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Permissions

ALTER TABLE participant
    OWNER TO postgres;
GRANT ALL ON TABLE participant TO postgres;