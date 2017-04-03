DROP TABLE users IF EXISTS;
CREATE TABLE users(user_name VARCHAR(20), password VARCHAR(25), first_name VARCHAR(255), last_name VARCHAR(255), );

DROP TABLE messages IF EXISTS;
CREATE TABLE messages(sender_user_name VARCHAR(20), rec_user_name VARCHAR(20), msg_subject VARCHAR(100), msg_body VARCHAR(255), );
