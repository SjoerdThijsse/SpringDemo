DROP SCHEMA IF EXISTS springdemo;
CREATE SCHEMA IF NOT EXISTS springdemo;

USE springdemo;

CREATE TABLE IF NOT EXISTS `user` (
  `userId` INT(11) AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY(`userID`)
) engine=InnoDB;

SELECT * FROM user;
SELECT * FROM user WHERE userId=?;

INSERT INTO user(username, password, email)
VALUES(?, ?, ?);

UPDATE user
SET usename=?, password=?, email=?
WHERE userId=?;

DELETE FROM user WHERE userId=?