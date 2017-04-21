INSERT INTO users(username,password,first_name,last_name,enabled, manager_id, role)
    VALUES ('worker','password','user','user',true, 'manager', 'ROLE_WORKER');
INSERT INTO users(username,password,first_name,last_name,enabled, role)
    VALUES ('manager','password','user','user',true, 'ROLE_MANAGER');
INSERT INTO users(username,password,first_name,last_name,enabled, manager_id, role)
    VALUES ('hr','password','user','user',true, 'manager', 'ROLE_HR');

INSERT INTO messages(created,to_id,from_id,subject,body) VALUES ('2014-07-10 14:35:00','worker','manager','Hello Luke','This message is for Rob');
INSERT INTO messages(created,to_id,from_id,subject,body) VALUES ('2014-07-10 14:35:00','manager','worker','How are you Rob?','This message is for Rob');
INSERT INTO messages(created,to_id,from_id,subject,body) VALUES ('2014-07-11 21:15:00','hr','manager','Is this secure?','This message is for Rob');

INSERT INTO messages(created,to_id,from_id,subject,body) VALUES ('2014-07-12 10:00:00','worker','hr','Hello Joe','This message is for Joe');
INSERT INTO messages(created,to_id,from_id,subject,body) VALUES ('2014-07-12 10:00:00','hr','worker','Greetings Joe','This message is for Joe');
INSERT INTO messages(created,to_id,from_id,subject,body) VALUES ('2014-07-12 10:00:00','manager','hr','Is this secure?','This message is for Joe');
