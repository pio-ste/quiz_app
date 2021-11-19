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