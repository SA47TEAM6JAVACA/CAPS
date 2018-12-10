CREATE DATABASE IF NOT EXISTS capsteam6;
CREATE TABLE IF NOT EXISTS `capsteam6`.`course` (
  `cid` INT NOT NULL AUTO_INCREMENT,
  `cname` VARCHAR(45) NULL,
  `startdate` DATE NULL,
  `enddate` DATE NULL,
  `fee` DOUBLE NULL,
  `room` INT NULL,
  `studentlimit` INT NULL,
  `current_enrollno` INT NULL,
  `credit` DOUBLE NULL,
  PRIMARY KEY (`cid`));


CREATE TABLE IF NOT EXISTS `capsteam6`.`lecturer` (
  `lid` INT NOT NULL AUTO_INCREMENT,
  `firstmiddlename` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `lpassword` VARCHAR(45) NULL,
  `lemail` VARCHAR(45) NULL,
  PRIMARY KEY (`lid`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `capsteam6`.`lecturer_course` (
  `course_id` INT NOT NULL,
  `lecturerid` INT NOT NULL,
  PRIMARY KEY (`course_id`,lecturerid),
  CONSTRAINT `course_id`
  FOREIGN KEY (`course_id`)
   REFERENCES `capsteam6`.`course` (`cid`),
    CONSTRAINT `lecturerid`
    FOREIGN KEY (`lecturerid`)
    REFERENCES `capsteam6`.`lecturer` (`lid`));


CREATE TABLE IF NOT EXISTS `capsteam6`.`student` (
  `sid` INT NOT NULL AUTO_INCREMENT,
  `firstmiddlename` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `spassword` VARCHAR(45) NULL,
  `semail` VARCHAR(45) NULL,
  PRIMARY KEY (`sid`));


CREATE TABLE IF NOT EXISTS `capsteam6`.`admin` (
  `aid` INT NOT NULL AUTO_INCREMENT,
  `firstmiddlename` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `apassword` VARCHAR(45) NULL,
  `aemail` VARCHAR(45) NULL,
  PRIMARY KEY (`aid`));

CREATE TABLE IF NOT EXISTS `capsteam6`.`student_course` (
  `scid` INT NOT NULL AUTO_INCREMENT,
  `stuid` INT NOT NULL,
  `courseid` INT NOT NULL,
  `attendence` DOUBLE NULL,
  `enroll_date` DATE NULL,
  `score` DOUBLE NULL,
  PRIMARY KEY (`scid`),
  CONSTRAINT `STU_ID`
    FOREIGN KEY (`stuid`)
    REFERENCES `capsteam6`.`student` (`sid`),
  CONSTRAINT `C_ID`
    FOREIGN KEY (`courseid`)
    REFERENCES `capsteam6`.`course` (`cid`));
