--user--
--password 12345, 12355, 12344
INSERT INTO "user" (id, email, first_name, last_name, "password", user_name)
VALUES (1, 'use1@gmail.com', 'Adam', 'Nowak', '$2a$12$sqFEGAGW.N82oapRcKvcs./3K.ma3YzHFW6Z/brklRJUVFM59K7PO', 'adam1');
INSERT INTO "user" (id, email, first_name, last_name, "password", user_name)
VALUES (2, 'use2@gmail.com', 'Kamil', 'Kowalczyk', '$2a$12$3UhyHZV9eY6TXBNof3hTmOPmZculu1/4DygHAoHRYLGvUnigg.KQO', 'adam2');
INSERT INTO "user" (id, email, first_name, last_name, "password", user_name)
VALUES (3, 'use3@gmail.com', 'Karol', 'Nowak', '$2a$12$0.1CMiq48J/nDtOQ9yKD8ezo.yX0R75HWGt8Lgp4SPywqhaj3IkZm', 'adam3');

--roles--

INSERT INTO "role" (id, role_name)
VALUES (1, 'STUDENT');
INSERT INTO "role" (id, role_name)
VALUES (2, 'TUTOR');

--user_role--
INSERT INTO "user_role" (id_user, id_role)
VALUES (1, 2);
INSERT INTO "user_role" (id_user, id_role)
VALUES (2, 2);
INSERT INTO "user_role" (id_user, id_role)
VALUES (3, 1);

