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
  `id` INT UNSIGNED NOT NULL DEFAULT 1,
  `userId` INT UNSIGNED NOT NULL,
  `token` VARCHAR(45) NOT NULL,
  `creationDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastTouch` DATETIME NOT NULL,
  `valid` TINYINT NOT NULL DEFAULT TRUE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

-- Bool, Boolean: These types are synonyms for TINYINT(1). A value of zero is considered false. Non-zero values are considered true.
-- test token
INSERT INTO `server`.`token` (`id`, `userId`, `token`, `creationDate`, `lastTouch`, `valid`) VALUES ('1', '10000', 'sdfsdfsdfds', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1);
