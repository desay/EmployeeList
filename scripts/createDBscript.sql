CREATE SCHEMA `test` ;

CREATE TABLE `test`.`employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `position` VARCHAR(255) NOT NULL,
  `department` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `createDate` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `test`.`employee` (`id`, `createDate`, `description`, `name`, `surname`, `position`, `department`) VALUES ('1', '2016-05-20', 'description', 'olga', 'pavluchenko', 'developer', 'it');
INSERT INTO `test`.`employee` (`id`, `createDate`, `description`, `name`, `surname`, `position`, `department`) VALUES ('2', '2016-05-19', 'description1', 'elena', 'borisova', 'hr', 'hr');
INSERT INTO `test`.`employee` (`id`, `createDate`, `description`, `name`, `surname`, `position`, `department`) VALUES ('3', '2016-05-19', 'description2', 'vasily', 'pupkin', 'senior developer', 'it');
INSERT INTO `test`.`employee` (`id`, `createDate`, `description`, `name`, `surname`, `position`, `department`) VALUES ('4', '2016-05-21', 'description3', 'alexaander', 'petrov', 'cto', 'managment');
