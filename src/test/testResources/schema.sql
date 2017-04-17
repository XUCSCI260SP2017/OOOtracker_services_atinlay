DROP TABLE users IF EXISTS;
CREATE TABLE users(
    id INTEGER AUTO_INCREMENT Primary Key,
    username VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255) NOT NULL,
    enabled TINYINT NOT NULL DEFAULT 1,
    manager_id VARCHAR(255),
    );

DROP TABLE authorities IF EXISTS;
CREATE TABLE authorities (
    authority VARCHAR(255),
    username VARCHAR(255)
    );

DROP TABLE messages IF EXISTS;
CREATE TABLE messages(
    id INTEGER AUTO_INCREMENT Primary Key,
    to_id VARCHAR(255),
    from_id VARCHAR(255),
    body VARCHAR(1000),
    subject VARCHAR(255),
    created DATETIME DEFAULT CURRENT_TIMESTAMP
    );

