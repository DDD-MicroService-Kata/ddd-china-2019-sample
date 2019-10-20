CREATE TABLE t_profile
(
    username VARCHAR(20) NOT NULL,
    bio       VARCHAR(20) NULL,
    image     VARCHAR(20) NULL,
    CONSTRAINT t_profile_pk
        PRIMARY KEY (username)
);