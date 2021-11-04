-- quiz_app."role" definition

-- Drop table

-- DROP TABLE "role";

CREATE TABLE "role" (
                        id int8 NOT NULL,
                        role_name varchar(10) NOT NULL,
                        CONSTRAINT role_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE quiz_app."role" OWNER TO postgres;
GRANT ALL ON TABLE quiz_app."role" TO postgres;


-- quiz_app."user" definition

-- Drop table

-- DROP TABLE "user";

CREATE TABLE "user" (
                        id int8 NOT NULL,
                        email varchar(50) NOT NULL,
                        first_name varchar(50) NOT NULL,
                        last_name varchar(50) NOT NULL,
                        "password" varchar(100) NOT NULL,
                        user_name varchar(50) NOT NULL,
                        CONSTRAINT uq_fields UNIQUE (user_name, email),
                        CONSTRAINT user_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE quiz_app."user" OWNER TO postgres;
GRANT ALL ON TABLE quiz_app."user" TO postgres;


-- quiz_app.quiz definition

-- Drop table

-- DROP TABLE quiz;

CREATE TABLE quiz (
                      id int8 NOT NULL,
                      description varchar(500) NOT NULL,
                      end_date timestamp NOT NULL,
                      max_points int4 NOT NULL,
                      start_date timestamp NOT NULL,
                      title varchar(200) NOT NULL,
                      user_id int8 NOT NULL,
                      CONSTRAINT quiz_pkey PRIMARY KEY (id),
                      CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES quiz_app."user"(id)
);

-- Permissions

ALTER TABLE quiz_app.quiz OWNER TO postgres;
GRANT ALL ON TABLE quiz_app.quiz TO postgres;


-- quiz_app.user_role definition

-- Drop table

-- DROP TABLE user_role;

CREATE TABLE user_role (
                           id_user int8 NOT NULL,
                           id_role int8 NOT NULL,
                           CONSTRAINT fk_role FOREIGN KEY (id_role) REFERENCES quiz_app.role(id),
                           CONSTRAINT fk_user FOREIGN KEY (id_user) REFERENCES quiz_app."user"(id)
);

-- Permissions

ALTER TABLE quiz_app.user_role OWNER TO postgres;
GRANT ALL ON TABLE quiz_app.user_role TO postgres;


-- quiz_app.participant definition

-- Drop table

-- DROP TABLE participant;

CREATE TABLE participant (
                             id int8 NOT NULL,
                             "result" int4 NOT NULL,
                             status varchar(15) NOT NULL,
                             quiz_id int8 NOT NULL,
                             user_id int8 NOT NULL,
                             CONSTRAINT participant_pkey PRIMARY KEY (id),
                             CONSTRAINT fk_quiz FOREIGN KEY (quiz_id) REFERENCES quiz_app.quiz(id),
                             CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES quiz_app."user"(id)
);

-- Permissions

ALTER TABLE quiz_app.participant OWNER TO postgres;
GRANT ALL ON TABLE quiz_app.participant TO postgres;


-- quiz_app.question definition

-- Drop table

-- DROP TABLE question;

CREATE TABLE question (
                          id int8 NOT NULL,
                          "content" varchar(300) NOT NULL,
                          img oid NULL,
                          points int4 NOT NULL,
                          "time" int4 NOT NULL,
                          quiz_id int8 NOT NULL,
                          CONSTRAINT question_pkey PRIMARY KEY (id),
                          CONSTRAINT fk_quiz FOREIGN KEY (quiz_id) REFERENCES quiz_app.quiz(id)
);

-- Permissions

ALTER TABLE quiz_app.question OWNER TO postgres;
GRANT ALL ON TABLE quiz_app.question TO postgres;


-- quiz_app.answer definition

-- Drop table

-- DROP TABLE answer;

CREATE TABLE answer (
                        id int8 NOT NULL,
                        "content" varchar(200) NOT NULL,
                        is_correct bool NOT NULL DEFAULT false,
                        question_id int8 NOT NULL,
                        CONSTRAINT answer_pkey PRIMARY KEY (id),
                        CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES quiz_app.question(id)
);

-- Permissions

ALTER TABLE quiz_app.answer OWNER TO postgres;
GRANT ALL ON TABLE quiz_app.answer TO postgres;


-- quiz_app.user_answer definition

-- Drop table

-- DROP TABLE user_answer;

CREATE TABLE user_answer (
                             id int8 NOT NULL,
                             is_correct bool NOT NULL DEFAULT false,
                             answer_id int8 NOT NULL,
                             participant_id int8 NOT NULL,
                             question_id int8 NOT NULL,
                             CONSTRAINT user_answer_pkey PRIMARY KEY (id),
                             CONSTRAINT fk_answer FOREIGN KEY (answer_id) REFERENCES quiz_app.answer(id),
                             CONSTRAINT fk_participant FOREIGN KEY (participant_id) REFERENCES quiz_app.participant(id),
                             CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES quiz_app.question(id)
);

-- Permissions

ALTER TABLE quiz_app.user_answer OWNER TO postgres;
GRANT ALL ON TABLE quiz_app.user_answer TO postgres;