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
                        "password" varchar(20) NOT NULL,
                        user_name varchar(50) NOT NULL,
                        CONSTRAINT uq_fields UNIQUE (user_name, email),
                        CONSTRAINT user_pkey PRIMARY KEY (id)
);

-- Permissions

ALTER TABLE quiz_app."user" OWNER TO postgres;
GRANT ALL ON TABLE quiz_app."user" TO postgres;


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