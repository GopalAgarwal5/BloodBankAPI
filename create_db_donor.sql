DROP SCHEMA IF EXISTS `bloodbankdb`;
CREATE SCHEMA `bloodbankdb`;
use `bloodbankdb`;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `donor_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `adhaar_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `donor_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address_line` varchar(128) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `postal_code` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `donor_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DONOR_idx` (`donor_id`),
  CONSTRAINT `FK_DONOR` 
  FOREIGN KEY (`donor_id`) 
  REFERENCES `donor_detail` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


// optional 

CREATE TABLE `donor_detail_address` (
  `donor_id` int NOT NULL,
  `address_id` int NOT NULL,
  PRIMARY KEY (`donor_id`,`address_id`),
  KEY `FK_DONOR_idx` (`donor_id`),
  CONSTRAINT `FK_DONOR` FOREIGN KEY (`donor_id`) REFERENCES `donor_detail` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ADDRESS` FOREIGN KEY (`address_id`) REFERENCES `donor_address` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1; 


SET FOREIGN_KEY_CHECKS = 1;
