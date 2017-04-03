insert into user(id,email,password,first_name,last_name) values (0,'ellisa4@xavier.edu','password','Andre','Ellis');
insert into user(id,email,password,first_name,last_name) values (1,'staudigelc@xavier.edu','password','Chris','Staudigel');
insert into user(id,email,password,first_name,last_name) values (2,'mcnameel@xavier.edu','password','Luke','McNamee');

insert into message(id,created,to_id,from_id,summary,text) values (100,'2017-04-01 11:30:00',0,1,'Hello Luke','This message is for Rob');
insert into message(id,created,to_id,from_id,summary,text) values (101,'2014-07-10 14:35:00',0,1,'How are you Rob?','This message is for Rob');
insert into message(id,created,to_id,from_id,summary,text) values (102,'2014-07-11 21:15:00',0,1,'Is this secure?','This message is for Rob');

insert into message(id,created,to_id,from_id,summary,text) values (110,'2014-07-12 10:00:00',1,0,'Hello Joe','This message is for Joe');
insert into message(id,created,to_id,from_id,summary,text) values (111,'2014-07-12 10:00:00',1,0,'Greetings Joe','This message is for Joe');
insert into message(id,created,to_id,from_id,summary,text) values (112,'2014-07-12 10:00:00',1,0,'Is this secure?','This message is for Joe');

insert into message(id,created,to_id,from_id,summary,text) values (120,'2014-07-12 10:00:00',2,2,'Hello Self','Ready to Hack!');
insert into message(id,created,to_id,from_id,summary,text) values (121,'2014-07-12 10:00:00',0,2,'XSS in Script','<script>alert(''xss'');</script>');
insert into message(id,created,to_id,from_id,summary,text) values (122,'2014-07-12 10:00:00',0,2,'XSS in HTML',''');document.write(''thank you come again'');//');

-- XSS Test with Angular
-- {{ 'a'.constructor.prototype.charAt=[].join; $eval("x=alert('Got you!')") }}
-- {{ 'a'.constructor.prototype.charAt=[].join; $eval("x=alert(document.cookie)") }}


