INSERT INTO users(id,username,password,first_name,last_name,enabled, manager_id, role)
    VALUES (0,'staudigelc@xavier.edu','password','Chris','Staudigel',true, 'ellisa4@xavier.edu', 'ROLE_WORKER');
INSERT INTO users(id,username,password,first_name,last_name,enabled, role)
    VALUES (1,'ellisa4@xavier.edu','password','Andre','Ellis',true, 'ROLE_MANAGER');
INSERT INTO users(id,username,password,first_name,last_name,enabled, manager_id, role)
    VALUES (2,'mcnameel@xavier.edu','password','Luke','McNamee',true, 'ellisa4@xavier.edu', 'ROLE_HR');

INSERT INTO messages(to_id,from_id,subject,body) VALUES ('staudigelc@xavier.edu','ellisa4@xavier.edu','Hello Luke','This message is for Rob');
INSERT INTO messages(id,created,to_id,from_id,subject,body) VALUES (101,'2014-07-10 14:35:00','staudigelc@xavier.edu','ellisa4@xavier.edu','How are you Rob?','This message is for Rob');
INSERT INTO messages(id,created,to_id,from_id,subject,body) VALUES (102,'2014-07-11 21:15:00','staudigelc@xavier.edu','ellisa4@xavier.edu','Is this secure?','This message is for Rob');

INSERT INTO messages(id,created,to_id,from_id,subject,body) VALUES (110,'2014-07-12 10:00:00','ellisa4@xavier.edu','mcnameel@xavier.edu','Hello Joe','This message is for Joe');
INSERT INTO messages(id,created,to_id,from_id,subject,body) VALUES (111,'2014-07-12 10:00:00','ellisa4@xavier.edu','mcnameel@xavier.edu','Greetings Joe','This message is for Joe');
INSERT INTO messages(id,created,to_id,from_id,subject,body) VALUES (112,'2014-07-12 10:00:00','ellisa4@xavier.edu','mcnameel@xavier.edu','Is this secure?','This message is for Joe');
