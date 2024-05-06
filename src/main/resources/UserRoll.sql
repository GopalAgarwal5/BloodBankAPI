-- DROP SCHEMA IF EXISTS `bloodbankdb`;
-- CREATE SCHEMA `bloodbankdb`;
use `bloodbankdb1`;
-- SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `user_roll` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roll` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO roll values("Manager"),("Operator");