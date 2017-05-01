SET DB_CLOSE_DELAY -1;         
;              
CREATE USER IF NOT EXISTS SA SALT 'a5a1397e99b0aa53' HASH '8a1070b98c605ce65f5d6a3bf1acdf6607b03ef9b706edce783fd54c25301797' ADMIN;            
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_5F9DCE9B_F3C2_4AD6_80AA_5D5283107FA5 START WITH 1 BELONGS_TO_TABLE;     
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_5EFC60C1_6836_4586_9B56_471E3A1EC6E9 START WITH 113 BELONGS_TO_TABLE;   
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_16E632BC_F9FA_4AFA_8029_2BE6B6345DB4 START WITH 3 BELONGS_TO_TABLE;     
CREATE MEMORY TABLE PUBLIC.USERS(
    ID INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_16E632BC_F9FA_4AFA_8029_2BE6B6345DB4) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_16E632BC_F9FA_4AFA_8029_2BE6B6345DB4,
    USERNAME VARCHAR(60) NOT NULL,
    FIRST_NAME VARCHAR(60),
    LAST_NAME VARCHAR(60),
    PASSWORD VARCHAR(60) NOT NULL,
    ENABLED TINYINT DEFAULT 1 NOT NULL,
    MANAGER_ID VARCHAR(60),
    ROLE VARCHAR(15) NOT NULL
);         
ALTER TABLE PUBLIC.USERS ADD CONSTRAINT PUBLIC.CONSTRAINT_4 PRIMARY KEY(ID);   
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.USERS;    
INSERT INTO PUBLIC.USERS(ID, USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, ENABLED, MANAGER_ID, ROLE) VALUES
(0, 'staudigelc@xavier.edu', 'Chris', 'Staudigel', 'password', 1, 'ellisa4@xavier.edu', 'ROLE_WORKER'),
(1, 'ellisa4@xavier.edu', 'Andre', 'Ellis', 'password', 1, NULL, 'ROLE_MANAGER'),
(2, 'mcnameel@xavier.edu', 'Luke', 'McNamee', 'password', 1, 'ellisa4@xavier.edu', 'ROLE_HR');             
CREATE MEMORY TABLE PUBLIC.MESSAGES(
    ID INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_5EFC60C1_6836_4586_9B56_471E3A1EC6E9) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_5EFC60C1_6836_4586_9B56_471E3A1EC6E9,
    TO_ID VARCHAR(60),
    FROM_ID VARCHAR(60),
    BODY VARCHAR(5000),
    SUBJECT VARCHAR(255),
    CREATED DATETIME DEFAULT CURRENT_TIMESTAMP()
);  
ALTER TABLE PUBLIC.MESSAGES ADD CONSTRAINT PUBLIC.CONSTRAINT_1 PRIMARY KEY(ID);
-- 6 +/- SELECT COUNT(*) FROM PUBLIC.MESSAGES; 
INSERT INTO PUBLIC.MESSAGES(ID, TO_ID, FROM_ID, BODY, SUBJECT, CREATED) VALUES
(1, 'staudigelc@xavier.edu', 'ellisa4@xavier.edu', 'This message is for Rob', 'Hello Luke', TIMESTAMP '2017-04-30 17:29:21.358'),
(101, 'staudigelc@xavier.edu', 'ellisa4@xavier.edu', 'This message is for Rob', 'How are you Rob?', TIMESTAMP '2014-07-10 14:35:00.0'),
(102, 'staudigelc@xavier.edu', 'ellisa4@xavier.edu', 'This message is for Rob', 'Is this secure?', TIMESTAMP '2014-07-11 21:15:00.0'),
(110, 'ellisa4@xavier.edu', 'mcnameel@xavier.edu', 'This message is for Joe', 'Hello Joe', TIMESTAMP '2014-07-12 10:00:00.0'),
(111, 'ellisa4@xavier.edu', 'mcnameel@xavier.edu', 'This message is for Joe', 'Greetings Joe', TIMESTAMP '2014-07-12 10:00:00.0'),
(112, 'ellisa4@xavier.edu', 'mcnameel@xavier.edu', 'This message is for Joe', 'Is this secure?', TIMESTAMP '2014-07-12 10:00:00.0');         
CREATE MEMORY TABLE PUBLIC.TIMEOFFREQUESTS(
    ID INTEGER DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_5F9DCE9B_F3C2_4AD6_80AA_5D5283107FA5) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_5F9DCE9B_F3C2_4AD6_80AA_5D5283107FA5,
    MANAGER VARCHAR(60) NOT NULL,
    EMPLOYEE VARCHAR(60) NOT NULL,
    DESCRIPTION VARCHAR(1023),
    REASON VARCHAR(255) NOT NULL,
    CREATED DATETIME DEFAULT CURRENT_TIMESTAMP(),
    STARTTIMESTAMP DATETIME NOT NULL,
    ENDTIMESTAMP DATETIME NOT NULL
);             
ALTER TABLE PUBLIC.TIMEOFFREQUESTS ADD CONSTRAINT PUBLIC.CONSTRAINT_15 PRIMARY KEY(ID);        
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TIMEOFFREQUESTS;          
CREATE MEMORY TABLE PUBLIC.TIMEOFFRESPONSES(
    ID INTEGER NOT NULL,
    MANAGER VARCHAR(60) NOT NULL,
    REASON VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    CLOSED DATETIME DEFAULT CURRENT_TIMESTAMP(),
    APPROVED BOOLEAN NOT NULL
);             
ALTER TABLE PUBLIC.TIMEOFFRESPONSES ADD CONSTRAINT PUBLIC.CONSTRAINT_F PRIMARY KEY(ID);        
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TIMEOFFRESPONSES;         
CREATE MEMORY TABLE PUBLIC.TIMEOFF(
    ID INTEGER NOT NULL,
    EMPLOYEE VARCHAR(60) NOT NULL,
    REASON VARCHAR(255) NOT NULL,
    STARTTIMESTAMP DATETIME NOT NULL,
    ENDTIMESTAMP DATETIME NOT NULL
);  
ALTER TABLE PUBLIC.TIMEOFF ADD CONSTRAINT PUBLIC.CONSTRAINT_D PRIMARY KEY(ID); 
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.TIMEOFF;  
