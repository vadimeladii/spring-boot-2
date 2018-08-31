ALTER TABLE "user" ADD CONSTRAINT uq_username UNIQUE (username);

ALTER TABLE role ADD CONSTRAINT uq_type UNIQUE (type);