INSERT INTO `project` (`id`,`created`,`modified`,`version`,`name`) VALUES (1,'2014-12-18 16:36:17','2014-12-18 16:36:17',0,'Project1');
INSERT INTO `project` (`id`,`created`,`modified`,`version`,`name`) VALUES (2,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Project2');

INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (1,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill1');
INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (2,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill2');
INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (3,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill3');
INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (4,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill4');
INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (5,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill5');
INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (6,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill6');
INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (7,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill7');
INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (8,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill8');
INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (9,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill9');
INSERT INTO `skill` (`id`,`created`,`modified`,`version`,`name`) VALUES (10,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'Skill10');

INSERT INTO `user` (`id`,`created`,`modified`,`version`,`email`,`password`,`role`,`projectId`) VALUES (1,'2014-12-18 16:36:18','2014-12-18 16:36:18',1,'user1@gmail.com','pass','ROLE_DEVELOPER',1);
INSERT INTO `user` (`id`,`created`,`modified`,`version`,`email`,`password`,`role`,`projectId`) VALUES (2,'2014-12-18 16:36:18','2014-12-18 16:36:18',1,'user2@gmail.com','pass','ROLE_QA',1);
INSERT INTO `user` (`id`,`created`,`modified`,`version`,`email`,`password`,`role`,`projectId`) VALUES (3,'2014-12-18 16:36:18','2014-12-18 16:36:18',1,'user3@gmail.com','pass','ROLE_DEVELOPER',1);
INSERT INTO `user` (`id`,`created`,`modified`,`version`,`email`,`password`,`role`,`projectId`) VALUES (4,'2014-12-18 16:36:18','2014-12-18 16:36:18',1,'user4@gmail.com','pass','ROLE_DEVELOPER',2);
INSERT INTO `user` (`id`,`created`,`modified`,`version`,`email`,`password`,`role`,`projectId`) VALUES (5,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'user5@gmail.com','pass','ROLE_DEVELOPER',2);

INSERT INTO `contactinfo` (`userId`,`created`,`modified`,`version`,`birthday`,`firstName`,`lastName`) VALUES (1,'2014-12-18 16:36:18','2014-12-18 16:36:18',1,'2014-12-18','user1','user1');
INSERT INTO `contactinfo` (`userId`,`created`,`modified`,`version`,`birthday`,`firstName`,`lastName`) VALUES (2,'2014-12-18 16:36:18','2014-12-18 16:36:18',1,'2014-12-18','user2','user2');
INSERT INTO `contactinfo` (`userId`,`created`,`modified`,`version`,`birthday`,`firstName`,`lastName`) VALUES (3,'2014-12-18 16:36:18','2014-12-18 16:36:18',1,'2014-12-18','user3','user3');
INSERT INTO `contactinfo` (`userId`,`created`,`modified`,`version`,`birthday`,`firstName`,`lastName`) VALUES (4,'2014-12-18 16:36:18','2014-12-18 16:36:18',1,'2014-12-18','user4','user4');
INSERT INTO `contactinfo` (`userId`,`created`,`modified`,`version`,`birthday`,`firstName`,`lastName`) VALUES (5,'2014-12-18 16:36:18','2014-12-18 16:36:18',0,'2014-12-18','user5','user5');

INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (1,1);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (2,1);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (3,1);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (4,1);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (5,1);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (1,2);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (2,2);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (3,2);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (4,2);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (1,3);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (2,3);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (3,3);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (1,4);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (2,4);
INSERT INTO `user_skill` (`userId`,`skillId`) VALUES (1,5);
