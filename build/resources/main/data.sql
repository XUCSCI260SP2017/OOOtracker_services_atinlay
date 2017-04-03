insert into user(id,email,password,first_name,last_name) values (0,'ellisa4@xavier.edu','password','Andre','Ellis');
insert into user(id,email,password,first_name,last_name) values (1,'staudigelc@xavier.edu','password','Chris','Staudigel');
insert into user(id,email,password,first_name,last_name) values (2,'mcnameel@xavier.edu','password','Luke','McNamee');

insert into message(id,created,to_id,from_id,summary,text) values (100,'2017-04-01 11:30:00',0,2,'Hello Andre','We need to make this work within our context');
insert into message(id,created,to_id,from_id,summary,text) values (101,'2017-04-01 14:35:00',0,1,'How are you Andre?','This message is for Rob');
insert into message(id,created,to_id,from_id,summary,text) values (102,'2017-04-01 21:15:00',0,1,'Is this secure?','This message is for Rob');

insert into message(id,created,to_id,from_id,summary,text) values (110,'2017-04-01 10:00:00',1,0,'Hello Chris','This message is for Chris');
insert into message(id,created,to_id,from_id,summary,text) values (111,'2017-04-01 10:00:00',1,0,'Greetings Joe','This message is also for Chris');
insert into message(id,created,to_id,from_id,summary,text) values (112,'2017-04-01 10:00:00',1,0,'Is this secure?','This message is for ahlksvdjhfb');

insert into message(id,created,to_id,from_id,summary,text) values (120,'2014-04-11 10:00:00',2,2,'Hello me!','I really hope this works');
insert into message(id,created,to_id,from_id,summary,text) values (121,'2017-04-01 11:00:00',0,2,'summary','im running out of ideas');
insert into message(id,created,to_id,from_id,summary,text) values (122,'2017-04-01 12:00:00',0,2,'um yeah', 'I dont have anything else to say');

-- XSS Test with Angular
-- {{ 'a'.constructor.prototype.charAt=[].join; $eval("x=alert('Got you!')") }}
-- {{ 'a'.constructor.prototype.charAt=[].join; $eval("x=alert(document.cookie)") }}


