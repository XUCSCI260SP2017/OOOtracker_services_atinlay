DROP TABLE users IF EXISTS;
CREATE TABLE users(
    id INTEGER AUTO_INCREMENT Primary Key,
    username VARCHAR(60) NOT NULL,
    first_name VARCHAR(60),
    last_name VARCHAR(60),
    password VARCHAR(60) NOT NULL,
    enabled TINYINT NOT NULL DEFAULT 1,
    manager_id VARCHAR(60),
    role VARCHAR(15) NOT NULL
    );

DROP TABLE messages IF EXISTS;
CREATE TABLE messages(
    id INTEGER AUTO_INCREMENT Primary Key,
    to_id VARCHAR(60),
    from_id VARCHAR(60),
    body VARCHAR(1023),
    subject VARCHAR(255),
    created DATETIME DEFAULT CURRENT_TIMESTAMP
    );

