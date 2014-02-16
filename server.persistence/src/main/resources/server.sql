CREATE SCHEMA `server` DEFAULT CHARACTER SET utf8 ;

--
-- TABLE USER
--
CREATE TABLE `server`.`user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT DEFAULT 10000,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `creationdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastupdate` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

-- insert some dummy users
INSERT INTO server.user (username, email, password, lastupdate) VALUE ("dummy", "dummy@dummy.de", "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", CURRENT_TIMESTAMP);
-- a94a8fe5ccb19ba61c4c0873d391e987982fbbd3 = test
insert into server.user (username, email, password, lastupdate) value ("dummy2", "dummy2@dummy.de", "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", CURRENT_TIMESTAMP);
-- a94a8fe5ccb19ba61c4c0873d391e987982fbbd3 = test
insert into server.user (username, email, password, lastupdate) value ("dummy3", "dummy3@dummy.de", "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3", CURRENT_TIMESTAMP);
-- a94a8fe5ccb19ba61c4c0873d391e987982fbbd3 = test


--
-- TABLE TOKEN
--
CREATE TABLE `server`.`token` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT DEFAULT 1,
  `userId` INT UNSIGNED NOT NULL,
  `token` VARCHAR(45) NOT NULL,
  `creationDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastTouch` DATETIME NOT NULL,
  `valid` TINYINT(1) NOT NULL DEFAULT TRUE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

-- Bool, Boolean: These types are synonyms for TINYINT(1). A value of zero is considered false. Non-zero values are considered true.
-- test token
INSERT INTO `server`.`token` (`id`, `userId`, `token`, `creationDate`, `lastTouch`, `valid`) VALUES ('1', '10000', 'sdfsdfsdfds', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);

--
-- TABLE WISHLIST
--
CREATE TABLE `server`.`wishlist` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userid` INT(10) NOT NULL,
  `productid` VARCHAR(45) NOT NULL,
  `producttype` VARCHAR(45) NOT NULL,
  `creationdate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

-- add some test values for user 10000
INSERT INTO `server`.`wishlist` (`id`, `userid`, `productid`, `producttype`) VALUES ('1', '10000', '15213', 'C');
INSERT INTO `server`.`wishlist` (`id`, `userid`, `productid`, `producttype`) VALUES ('2', '10000', '14589', 'O');
INSERT INTO `server`.`wishlist` (`id`, `userid`, `productid`, `producttype`) VALUES ('3', '10000', '65483', 'C');
INSERT INTO `server`.`wishlist` (`id`, `userid`, `productid`, `producttype`) VALUES ('4', '10000', '89896', 'O');
INSERT INTO `server`.`wishlist` (`id`, `userid`, `productid`, `producttype`) VALUES ('5', '10001', '33333', 'C');
INSERT INTO `server`.`wishlist` (`id`, `userid`, `productid`, `producttype`) VALUES ('6', '10002', '44444', 'O');
