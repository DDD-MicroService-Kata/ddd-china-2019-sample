CREATE TABLE t_user
(
    username VARCHAR(20) NOT NULL,
    email    VARCHAR(20) NULL,
    password VARCHAR(20) NULL,
    CONSTRAINT t_user_pk
        PRIMARY KEY (username)
);
