DROP SCHEMA IF EXISTS springdemo;
CREATE SCHEMA IF NOT EXISTS springdemo;

USE springdemo;

CREATE TABLE IF NOT EXISTS `users` (
  `userId` INT(11) AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY(`userID`),
  UNIQUE(`username`)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `user_roles` (
	`userId` INT(11) NOT NULL,
    `role` VARCHAR(255) NOT NULL,
	FOREIGN KEY(`userId`) REFERENCES users(`userId`)
) ENGINE=InnoDB;

INSERT INTO `users` (`username`, `password`, `email`)
VALUES('sjoerd', 'thijsse', 'sjoerd.thijsse@naturalis.nl');
INSERT INTO `user_roles` (`userId`, `role`)
VALUES('1', 'ROLE_USER');
INSERT INTO `user_roles` (`userId`, `role`)
VALUES('1', 'ROLE_ADMIN');

INSERT INTO `users` (`username`, `password`, `email`)
VALUES('henk', 'jaap', 'henk.jaap@naturalis.nl');
INSERT INTO `user_roles` (`userId`, `role`)
VALUES('2', 'ROLE_USER');