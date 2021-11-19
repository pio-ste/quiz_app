-- roles definition

-- Drop table

-- DROP TABLE roles;

CREATE TABLE roles (
                       id bigserial NOT NULL,
                       role_name varchar(10) NOT NULL,
                       CONSTRAINT roles_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE roles OWNER TO postgres;
GRANT ALL ON TABLE roles TO postgres;


-- users definition

-- Drop table

-- DROP TABLE users;

CREATE TABLE users (
                       id bigserial NOT NULL,
                       email varchar(50) NOT NULL,
                       first_name varchar(50) NOT NULL,
                       last_name varchar(50) NOT NULL,
                       "password" varchar(100) NOT NULL,
                       user_name varchar(50) NOT NULL,
                       CONSTRAINT uq_fields UNIQUE (user_name, email),
                       CONSTRAINT users_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE users OWNER TO postgres;
GRANT ALL ON TABLE users TO postgres;


-- quiz definition

-- Drop table

-- DROP TABLE quiz;

CREATE TABLE quiz (
                      id bigserial NOT NULL,
                      description varchar(500) NOT NULL,
                      end_date timestamp NOT NULL,
                      max_points int4 NOT NULL,
                      start_date timestamp NOT NULL,
                      title varchar(200) NOT NULL,
                      users_id int8 NOT NULL,
                      CONSTRAINT quiz_pkey PRIMARY KEY (id),
                      CONSTRAINT fk_users FOREIGN KEY (users_id) REFERENCES users(id)
);

-- Permissions

ALTER TABLE quiz OWNER TO postgres;
GRANT ALL ON TABLE quiz TO postgres;


-- user_roles definition

-- Drop table

-- DROP TABLE user_roles;

CREATE TABLE user_roles (
                            id_users int8 NOT NULL,
                            id_roles int8 NOT NULL,
                            CONSTRAINT user_roles_pkey PRIMARY KEY (id_users, id_roles),
                            CONSTRAINT fk_roles FOREIGN KEY (id_roles) REFERENCES roles(id),
                            CONSTRAINT fk_users FOREIGN KEY (id_users) REFERENCES users(id)
);

-- Permissions

ALTER TABLE user_roles OWNER TO postgres;
GRANT ALL ON TABLE user_roles TO postgres;


-- participant definition

-- Drop table

-- DROP TABLE participant;

CREATE TABLE participant (
                             id bigserial NOT NULL,
                             "result" int4 NOT NULL,
                             status varchar(15) NOT NULL,
                             quiz_id int8 NOT NULL,
                             user_id int8 NOT NULL,
                             CONSTRAINT participant_pkey PRIMARY KEY (id),
                             CONSTRAINT fk_quiz FOREIGN KEY (quiz_id) REFERENCES quiz(id),
                             CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Permissions

ALTER TABLE participant OWNER TO postgres;
GRANT ALL ON TABLE participant TO postgres;


-- question definition

-- Drop table

-- DROP TABLE question;

CREATE TABLE question (
                          id bigserial NOT NULL,
                          "content" varchar(300) NOT NULL,
                          img oid NULL,
                          points int4 NOT NULL,
                          "time" int4 NOT NULL,
                          quiz_id int8 NOT NULL,
                          CONSTRAINT question_pkey PRIMARY KEY (id),
                          CONSTRAINT fk_quiz FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);

-- Permissions

ALTER TABLE question OWNER TO postgres;
GRANT ALL ON TABLE question TO postgres;


-- answer definition

-- Drop table

-- DROP TABLE answer;

CREATE TABLE answer (
                        id bigserial NOT NULL,
                        "content" varchar(200) NOT NULL,
                        is_correct bool NOT NULL DEFAULT false,
                        question_id int8 NOT NULL,
                        CONSTRAINT answer_pkey PRIMARY KEY (id),
                        CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES question(id)
);

-- Permissions

ALTER TABLE answer OWNER TO postgres;
GRANT ALL ON TABLE answer TO postgres;


-- user_answer definition

-- Drop table

-- DROP TABLE user_answer;

CREATE TABLE user_answer (
                             id bigserial NOT NULL,
                             is_correct bool NOT NULL DEFAULT false,
                             answer_id int8 NOT NULL,
                             participant_id int8 NOT NULL,
                             question_id int8 NOT NULL,
                             CONSTRAINT user_answer_pkey PRIMARY KEY (id),
                             CONSTRAINT fk_answer FOREIGN KEY (answer_id) REFERENCES answer(id),
                             CONSTRAINT fk_participant FOREIGN KEY (participant_id) REFERENCES participant(id),
                             CONSTRAINT fk_question FOREIGN KEY (question_id) REFERENCES question(id)
);

-- Permissions

ALTER TABLE user_answer OWNER TO postgres;
GRANT ALL ON TABLE user_answer TO postgres;