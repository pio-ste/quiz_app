CREATE TABLE roles (
                       id bigserial NOT NULL,
                       role_name varchar(10) NOT NULL,
                       CONSTRAINT roles_pkey PRIMARY KEY (id)
);

ALTER TABLE quiz_app.roles OWNER TO postgres;
GRANT ALL ON TABLE quiz_app.roles TO postgres;