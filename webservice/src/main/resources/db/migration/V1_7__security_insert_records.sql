INSERT INTO "user"(id, username, password) VALUES(1, 'veladii', 'pass');

INSERT INTO role(id, type) values (1, 'SIMPLE');

INSERT INTO user_role(id, id_user, id_role) VALUES(1, 1, 1);