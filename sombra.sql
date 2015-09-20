CREATE DATABASE sombra;
USE sombra;
CREATE TABLE `Lot` (
  `lotId` bigint(20) NOT NULL AUTO_INCREMENT,
  `lotName` varchar(20) NOT NULL DEFAULT 'Lot name',
  `description` varchar(200) NOT NULL DEFAULT 'Lot description',
  `price` decimal(8, 2) NOT NULL DEFAULT '0',
  `catId` bigint(20) NOT NULL,
  `usrId` bigint(20) NOT NULL,
  `cityId` bigint(20) NOT NULL,
  `picture` varchar(20),
  `available` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`lotId`)
);

CREATE TABLE `Category` (
  `catId` bigint(20) NOT NULL AUTO_INCREMENT,
  `catName` varchar(20) NOT NULL UNIQUE,
  PRIMARY KEY (`catId`)
);

CREATE TABLE `User` (
  `usrId` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL UNIQUE,
  `password` varchar(20) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`usrId`)
);

CREATE TABLE `City` (
  `cityId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(20) NOT NULL UNIQUE,
  PRIMARY KEY (`cityId`)
);

ALTER TABLE `Lot` ADD CONSTRAINT `Lot_fk0` FOREIGN KEY (`catId`) REFERENCES `Category`(`catId`);

ALTER TABLE `Lot` ADD CONSTRAINT `Lot_fk1` FOREIGN KEY (`usrId`) REFERENCES `User`(`usrId`);

ALTER TABLE `Lot` ADD CONSTRAINT `Lot_fk2` FOREIGN KEY (`cityId`) REFERENCES `City`(`cityId`);

INSERT INTO `Category` (`catId`, `catName`) VALUES ('1', 'Desktops'), ('2', 'Laptops'), ('3', 'Mobile phones');

INSERT INTO `City` (`cityId`, `cityName`) VALUES ('1', 'Lviv'), ('2', 'Ivano-Frankivsk'), ('3', 'Kyiv');

INSERT INTO `User` (`usrId`, `email`, `password`, `firstName`, `lastName`, `enabled`, `role`) VALUES ('1', 'cam@cam.com', 'Cnfhjcnf', 'An', 'St', '1', 'admin');

INSERT INTO `Lot` 
(`lotId`, `lotName`, `description`, `price`, `catId`, `usrId`, `cityId`, `picture`, `available`) VALUES 
('1', 'Apple MacBook Air', 'Apple MacBook Air (black)', '600', '2', '1', '1', './img/Air_black.jpg', '1'),
('2', 'HP Transformer', 'HP Transformer', '400', '2', '1', '2', './img/hp-transformer.jpg', '1'),
('3', 'ASUS Laptop UL30A (white)', '', '500', '2', '1', '3', './img/Laptop-Asus-UL30A.jpg', '1'),
('4', 'Pink HP', 'Pink HP', '300', '2', '1', '2', './img/pink-hp.png', '1'),
('5', 'Apple iPhone 6', 'Apple iPhone 6', '350', '3', '1', '2', './img/Apple-iPhone-6-Plus.jpg', '1'),
('6', 'HP Transformer', 'HP Transformer', '450', '2', '1', '1', './img/transformer_t300e.png', '1');
