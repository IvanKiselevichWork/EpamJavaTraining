-- create database
DROP DATABASE IF EXISTS `personal_finance`;
CREATE SCHEMA IF NOT EXISTS `personal_finance` DEFAULT CHARACTER SET utf8;
USE `personal_finance`;

-- create table user
CREATE TABLE IF NOT EXISTS `personal_finance`.`user` (
    `idUser` INT NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(45) NOT NULL,
    `hash` VARCHAR(64) NOT NULL,
    PRIMARY KEY (`idUser`)
);

-- create table record
CREATE TABLE IF NOT EXISTS `personal_finance`.`record` (
    `idRecord` INT NOT NULL AUTO_INCREMENT,
    `userId` INT NOT NULL,
    `cause` VARCHAR(255) NOT NULL,
    `date` DATETIME NOT NULL,
    `amount` DECIMAL(13, 4) NOT NULL,
    PRIMARY KEY (`idRecord`),
    CONSTRAINT `FK_UserRecord` FOREIGN KEY (`userId`)
    REFERENCES `user`(`idUser`)
);