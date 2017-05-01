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
    body VARCHAR(5000),
    subject VARCHAR(255),
    created DATETIME DEFAULT CURRENT_TIMESTAMP
    );

DROP TABLE timeOffRequests IF EXISTS;
CREATE TABLE timeOffRequests(
    id INTEGER AUTO_INCREMENT Primary Key,
    manager VARCHAR(60) NOT NULL,
    employee VARCHAR(60) NOT NULL,
    description VARCHAR(1023),
    reason VARCHAR(255) NOT NULL,
    created DATETIME DEFAULT CURRENT_TIMESTAMP,
    startTimestamp DATETIME NOT NULL,
    endTimestamp DATETIME NOT NULL
    );

DROP TABLE timeOffResponses IF EXISTS;
CREATE TABLE timeOffResponses(
    id INTEGER Primary Key,
    manager VARCHAR(60) NOT NULL,
    reason VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    closed DATETIME DEFAULT CURRENT_TIMESTAMP,
    approved BOOLEAN NOT NULL
    );

DROP TABLE timeOff IF EXISTS;
CREATE TABLE timeOff(
    id INTEGER Primary Key,
    employee VARCHAR(60) NOT NULL,
    reason VARCHAR(255) NOT NULL,
    startTimestamp DATETIME NOT NULL,
    endTimestamp DATETIME NOT NULL
    );