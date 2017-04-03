INSERT INTO admin(id,email,password,first_name,last_name) VALUES (0,'admin@example.com','password','Admin','Way');

INSERT INTO user(id,email,password,first_name,last_name) VALUES (0,'ellisa4@xavier.edu','password','Andre','Ellis');
INSERT INTO user(id,email,password,first_name,last_name) VALUES (1,'staudigelc@xavier.edu','password','Chris','Staudigel');
INSERT INTO user(id,email,password,first_name,last_name) VALUES (2,'mcnameel@xavier.edu','password','Luke','McNamee');
INSERT INTO user(id,email,password,first_name,last_name) VALUES (3,'user@example.com','password','User','Way');

INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (100,'2017-04-01 11:30:00',0,2,'Hello Andre','We need to make this work within our context');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (101,'2017-04-01 14:35:00',0,1,'How are you Andre?','This message is for Rob');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (102,'2017-04-01 21:15:00',0,1,'Is this secure?','This message is for Rob');

INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (110,'2017-04-01 10:00:00',1,0,'Hello Chris','This message is for Chris');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (111,'2017-04-01 11:00:00',1,0,'Greetings Joe','This message is also for Chris');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (112,'2017-04-01 12:00:00',1,0,'Is this secure?','This message is for ahlksvdjhfb');

INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (120,'2017-04-11 10:00:00',2,2,'Hello me!','I really hope this works');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (121,'2017-04-01 11:00:00',0,2,'summary','im running out of ideas');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (122,'2017-04-01 12:00:00',0,2,'um yeah', 'I dont have anything else to say');

INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (130,'2017-04-11 10:00:00',3,2,'Hello Team!','I have used code I found online to make a messaging system');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (131,'2017-04-01 11:00:00',3,2,'Event','But we should make the event');
INSERT INTO message(id,created,to_id,from_id,summary,text) VALUES (132,'2017-04-01 12:00:00',3,2,'Feel free to use', 'Try to play around with this');

-- XSS Test with Angular
-- {{ 'a'.constructor.prototype.charAt=[].join; $eval("x=alert('Got you!')") }}
-- {{ 'a'.constructor.prototype.charAt=[].join; $eval("x=alert(document.cookie)") }}


