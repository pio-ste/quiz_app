SET datestyle = dmy;

INSERT INTO "users" (id, email, first_name, last_name, "password", user_name)
VALUES (1, 'user1@gmail.com', 'Adam', 'Nowak', '$2a$12$sqFEGAGW.N82oapRcKvcs./3K.ma3YzHFW6Z/brklRJUVFM59K7PO', 'user1');
INSERT INTO "users" (id, email, first_name, last_name, "password", user_name)
VALUES (2, 'user2@gmail.com', 'Kamil', 'Kowalczyk', '$2a$12$3UhyHZV9eY6TXBNof3hTmOPmZculu1/4DygHAoHRYLGvUnigg.KQO', 'user2');
INSERT INTO "users" (id, email, first_name, last_name, "password", user_name)
VALUES (3, 'user3@gmail.com', 'Karol', 'Nowak', '$2a$12$0.1CMiq48J/nDtOQ9yKD8ezo.yX0R75HWGt8Lgp4SPywqhaj3IkZm', 'user3');
INSERT INTO "users" (id, email, first_name, last_name, "password", user_name)
VALUES (4, 'user4@gmail.com', 'Robert', 'Lewandowski', '$2a$12$BBglqljCCEJgfaiifWOUBO4immYktdbGH2BZdTUeEG5gzaYhlhDme', 'user4');

--roles--

INSERT INTO "roles" (id, role_name)
VALUES (1, 'STUDENT');
INSERT INTO "roles" (id, role_name)
VALUES (2, 'TUTOR');

--user_role--
INSERT INTO "user_roles" (id_users, id_roles)
VALUES (1, 2);
INSERT INTO "user_roles" (id_users, id_roles)
VALUES (2, 2);
INSERT INTO "user_roles" (id_users, id_roles)
VALUES (3, 1);
INSERT INTO "user_roles" (id_users, id_roles)
VALUES (4, 1);


--quiz--
INSERT INTO "quiz" (id, description, end_date, max_points, start_date, title, users_id)
VALUES (1, 'przykładowy test', '2021-03-20 9:30:20', 150, '2017-03-20 9:30:20', 'test1', 2);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (1, 'Ile kot ma łap?', null, 2, 30, 1);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (1, '1', false, 1);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (2, '2', false, 1);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (3, '3', false, 1);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (4, '4', true, 1);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (2, 'Jakiego koloru jest trawa?', null, 2, 30, 1);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (5, 'Czerwonego', false, 2);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (6, 'Różowego', false, 2);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (7, 'Zielonego', true, 2);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (8, 'Czarnego', false, 2);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (3, 'W którym roku była bitwa pod Grunwaldem?', null, 2, 30, 1);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (9, '1410', true, 3);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (10, '1555', false, 3);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (11, '2020', false, 3);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (12, '1212', false, 3);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (4, 'Stolica Polski to:', null, 2, 30, 1);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (13, 'Kraków', false, 4);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (14, 'Warszawa', true, 4);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (15, 'Poznań', false, 4);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (16, 'Gdańsk', false, 4);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (5, 'Stolica Niemiec to:', null, 2, 30, 1);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (17, 'Berlin', true, 5);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (18, 'Monachium', false, 5);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (19, 'Dortmund', false, 5);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (20, 'Lipsk', false, 5);

--quiz--
INSERT INTO "quiz" (id, description, end_date, max_points, start_date, title, users_id)
VALUES (2, 'przykładowy test 2', '2021-04-19 9:30:20', 150, '2019-03-18 9:30:20', 'test2', 2);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (6, 'Ile pies ma łap?', null, 2, 30, 2);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (21, '1', false, 6);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (22, '2', false, 6);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (23, '3', false, 6);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (24, '4', true, 6);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (7, 'Jakiego koloru jest niebo?', null, 2, 30, 2);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (25, 'Czerwonego', false, 7);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (26, 'Różowego', false, 7);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (27, 'Zielonego', false, 7);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (28, 'NIebieskiego', true, 7);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (8, 'Wynik działania 4 + 4 to:', null, 2, 30, 2);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (29, '8', true, 8);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (30, '22', false, 8);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (31, '1', false, 8);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (32, '3', false, 8);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (9, 'Stolica Czech to:', null, 2, 30, 2);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (33, 'Kraków', false, 9);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (34, 'Brno', false, 9);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (35, 'Praga', true, 9);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (36, 'Pilzno', false, 9);

--question--
INSERT INTO "question" (id, "content", img, points, "time", quiz_id)
VALUES (10, 'Stolica Węgier to:', null, 2, 30, 2);

--answer--
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (37, 'Budapeszt', true, 10);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (38, 'Pecz', false, 10);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (39, 'Dortmund', false, 10);
INSERT INTO "answer" (id, "content", is_correct, question_id)
VALUES (40, 'Eger', false, 10);


--participant--
INSERT INTO "participant" (id, "result", status, quiz_id, users_id)
VALUES (1, 30, 'FINISHED', 1, 3);

--user_answer--
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (1, true, 4, 1, 1);
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (2, false, 5, 1, 2);
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (3, false, 10, 1, 3);
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (4, false, 16, 1, 4);
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (5, false, 19, 1, 5);

--participant--
INSERT INTO "participant" (id, "result", status, quiz_id, users_id)
VALUES (2, 90, 'FINISHED', 2, 4);

--user_answer--
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (6, true, 24, 2, 6);
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (7, true, 28, 2, 7);
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (8, true, 29, 2, 8);
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (9, false, 36, 2, 9);
INSERT INTO "user_answer" (id, is_correct, answer_id, participant_id, question_id)
VALUES (10, false, 40, 2, 10);












