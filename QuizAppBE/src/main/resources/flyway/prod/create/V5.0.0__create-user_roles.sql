CREATE TABLE user_roles
(
    id_users int8 NOT NULL,
    id_roles int8 NOT NULL,
    CONSTRAINT user_roles_pkey PRIMARY KEY (id_users, id_roles),
    CONSTRAINT fk_roles FOREIGN KEY (id_roles) REFERENCES roles (id),
    CONSTRAINT fk_users FOREIGN KEY (id_users) REFERENCES users (id)
);

-- Permissions

ALTER TABLE user_roles
    OWNER TO postgres;
GRANT ALL ON TABLE user_roles TO postgres;