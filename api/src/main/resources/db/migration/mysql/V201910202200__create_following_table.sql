CREATE TABLE t_following
(
    followed    VARCHAR(20) NOT NULL,
    followed_by VARCHAR(20) NOT NULL,
    CONSTRAINT t_following
        PRIMARY KEY (followed, followed_by)
);