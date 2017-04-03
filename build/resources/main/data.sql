INSERT INTO user(id,email,password,first_name,last_name,enabled) VALUES (0,'staudigelc@xavier.edu','password','Chris','Staudigel',true);
INSERT INTO user(id,email,password,first_name,last_name,enabled) VALUES (1,'ellisa4@xavier.edu','password','Andre','Ellis',true);
INSERT INTO user(id,email,password,first_name,last_name,enabled) VALUES (2,'mcnameel@xavier.edu','password','Luke','McNamee',true);
/*
INSERT INTO role(role_id,name) VALUES ('mcnameel@xavier.edu','ROLE_USER');
INSERT INTO role(user_roles,role) VALUES ('mcnameel@xavier.edu','ROLE_ADMIN');
INSERT INTO role(user_roles,role) VALUES ('staudigelc@xavier.edu','ROLE_USER');
INSERT INTO role(user_roles,role) VALUES ('staudigelc@xavier.edu','ROLE_ADMIN');
INSERT INTO role(username,role) VALUES ('ellisa4@xavier.edu','ROLE_ROLE');
INSERT INTO role(username,role) VALUES ('ellisa4@xavier.edu','ROLE_ADMIN');
*/
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (100,'2017-04-01 11:30:00',0,1,'Hello Luke','This message is for Rob');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (101,'2014-07-10 14:35:00',0,1,'How are you Rob?','This message is for Rob');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (102,'2014-07-11 21:15:00',0,1,'Is this secure?','This message is for Rob');

INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (110,'2014-07-12 10:00:00',1,0,'Hello Joe','This message is for Joe');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (111,'2014-07-12 10:00:00',1,0,'Greetings Joe','This message is for Joe');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (112,'2014-07-12 10:00:00',1,0,'Is this secure?','This message is for Joe');

INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (120,'2014-07-12 10:00:00',2,2,'Hello Self','Ready to Hack!');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (121,'2014-07-12 10:00:00',0,2,'Stuff and more stuff', 'wordswordswordsowrdswords');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (122,'2014-07-12 10:00:00',0,2,'yoyoyoyo','howslifethough');

-- XSS Test with Angular
-- {{ 'a'.constructor.prototype.charAt=[].join; $eval("x=alert('Got you!')") }}
-- {{ 'a'.constructor.prototype.charAt=[].join; $eval("x=alert(document.cookie)") }}


