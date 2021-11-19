CREATE TABLE quiz
(
    id          bigserial    NOT NULL,
    description varchar(500) NOT NULL,
    end_date    timestamp    NOT NULL,
    max_points  int4         NOT NULL,
    start_date  timestamp    NOT NULL,
    title       varchar(200) NOT NULL,
    users_id    int8         NOT NULL,
    CONSTRAINT quiz_pkey PRIMARY KEY (id),
    CONSTRAINT fk_users FOREIGN KEY (users_id) REFERENCES users (id)
);

-- Permissions

ALTER TABLE quiz
    OWNER TO postgres;
GRANT ALL ON TABLE quiz TO postgres;