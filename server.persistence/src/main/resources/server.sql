CREATE SCHEMA `server` DEFAULT CHARACTER SET utf8 ;

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