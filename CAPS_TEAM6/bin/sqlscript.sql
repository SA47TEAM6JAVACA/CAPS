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
    
    
    
    
INSERT INTO `capsteam6`.`admin` (`aid`, `firstmiddlename`, `lastname`, `apassword`, `aemail`) VALUES ('1', 'Marry', 'Tom', 'sqSQSQ', 'dwagiygw@nus.edu');
INSERT INTO `capsteam6`.`admin` (`aid`, `firstmiddlename`, `lastname`, `apassword`, `aemail`) VALUES ('2', 'Stephen', 'Curry', 'sajojoc30', 'jcabsson@nus.edu');
INSERT INTO `capsteam6`.`admin` (`aid`, `firstmiddlename`, `lastname`, `apassword`, `aemail`) VALUES ('3', 'Kevin', 'Durant', 'xsaiubpie', 'vuyovcw@nus.edu');
INSERT INTO `capsteam6`.`admin` (`aid`, `firstmiddlename`, `lastname`, `apassword`, `aemail`) VALUES ('4', 'Klay', 'Thompson', 'cuidbvpw', 'cbipbcpe@nus.edu');


INSERT INTO `capsteam6`.`course` (`cid`, `cname`, `startdate`, `enddate`, `fee`, `room`, `studentlimit`, `current_enrollno`, `credit`) VALUES ('1', 'C#', '2018-08-01', '2018-08-16', '3000', '305', '150', '120', '5');

INSERT INTO `capsteam6`.`course` (`cid`, `cname`, `startdate`, `enddate`, `fee`, `room`, `studentlimit`, `current_enrollno`, `credit`) VALUES ('2', 'SQL', '2018-08-17', '2018-08-30', '2000', '305', '150', '120', '4');

INSERT INTO `capsteam6`.`course` (`cid`, `cname`, `startdate`, `enddate`, `fee`, `room`, `studentlimit`, `current_enrollno`, `credit`) VALUES ('3', 'UI', '2018-09-01', '2018-09-24', '4000', '305', '150', '120', '6');

INSERT INTO `capsteam6`.`course` (`cid`, `cname`, `startdate`, `enddate`, `fee`, `room`, `studentlimit`, `current_enrollno`, `credit`) VALUES ('4', 'ASP', '2018-09-25', '2018-10-15', '3000', '305', '150', '120', '5');

INSERT INTO `capsteam6`.`course` (`cid`, `cname`, `startdate`, `enddate`, `fee`, `room`, `studentlimit`, `current_enrollno`, `credit`) VALUES ('5', 'JAVA', '2018-10-16', '2018-11-24', '5000', '305', '150', '120', '6');




INSERT INTO `capsteam6`.`lecturer` (`lid`, `firstmiddlename`, `lastname`, `lpassword`, `lemail`) VALUES ('1', 'Steve', 'Nash', 'cjibeivcauy', 'chievwyi@nus.edu');

INSERT INTO `capsteam6`.`lecturer` (`lid`, `firstmiddlename`, `lastname`, `lpassword`, `lemail`) VALUES ('2', 'Kobe', 'Brayant', 'cbwicbiqf', 'vnoiwbvuyW@nus.edu');

INSERT INTO `capsteam6`.`lecturer` (`lid`, `firstmiddlename`, `lastname`, `lpassword`, `lemail`) VALUES ('3', 'Larry', 'Bird', 'cboibqwydv', 'ebudibq@nus.edu');

INSERT INTO `capsteam6`.`lecturer` (`lid`, `firstmiddlename`, `lastname`, `lpassword`, `lemail`) VALUES ('4', 'Tim', 'Duncan', 'oywqcug', 'cbuqovu@nus.edu');

INSERT INTO `capsteam6`.`lecturer` (`lid`, `firstmiddlename`, `lastname`, `lpassword`, `lemail`) VALUES ('5', 'Shaq', 'Oneal', 'vwvcouv', 'ieuvce@nus.edu');



INSERT INTO `capsteam6`.`lecturer_course` (`course_id`, `lecturerid`) VALUES ('1', '1');

INSERT INTO `capsteam6`.`lecturer_course` (`course_id`, `lecturerid`) VALUES ('2', '1');

INSERT INTO `capsteam6`.`lecturer_course` (`course_id`, `lecturerid`) VALUES ('3', '2');

INSERT INTO `capsteam6`.`lecturer_course` (`course_id`, `lecturerid`) VALUES ('4', '3');

INSERT INTO `capsteam6`.`lecturer_course` (`course_id`, `lecturerid`) VALUES ('5', '4');



INSERT INTO `capsteam6`.`student` (`sid`, `firstmiddlename`, `lastname`, `spassword`, `semail`) VALUES ('1', 'Allen', 'Iverson', 'abcde', 'e0319488@u.nus.edu');

INSERT INTO `capsteam6`.`student` (`sid`, `firstmiddlename`, `lastname`, `spassword`, `semail`) VALUES ('2', 'John', 'Wall', 'cjeidbwi', 'eiwqbdi@nus.edu');

INSERT INTO `capsteam6`.`student` (`sid`, `firstmiddlename`, `lastname`, `spassword`, `semail`) VALUES ('3', 'Dwyan', 'Wade', 'cooypqv', 'niqjbsxv@nus.edu');

INSERT INTO `capsteam6`.`student` (`sid`, `firstmiddlename`, `lastname`, `spassword`, `semail`) VALUES ('4', 'Leborn', 'James', 'uievcyvq', 'xbqhixvuy@nus.edu');

INSERT INTO `capsteam6`.`student` (`sid`, `firstmiddlename`, `lastname`, `spassword`, `semail`) VALUES ('5', 'Derick', 'Rose', 'qhbhilvuy', 'whlivy@nus.edu');



INSERT INTO `capsteam6`.`student_course` (`scid`, `stuid`, `courseid`, `attendence`, `enroll_date`, `score`) VALUES ('1', '3', '1', '0.9', '2018-08-01', '85');

INSERT INTO `capsteam6`.`student_course` (`scid`, `stuid`, `courseid`, `attendence`, `enroll_date`, `score`) VALUES ('2', '2', '2', '0.98', '2018-08-17', '90');

INSERT INTO `capsteam6`.`student_course` (`scid`, `stuid`, `courseid`, `attendence`, `enroll_date`, `score`) VALUES ('3', '1', '3', '0.88', '2018-09-01', '80');

INSERT INTO `capsteam6`.`student_course` (`scid`, `stuid`, `courseid`, `attendence`, `enroll_date`, `score`) VALUES ('4', '2', '4', '0.6', '2018-09-25', '95');

INSERT INTO `capsteam6`.`student_course` (`scid`, `stuid`, `courseid`, `attendence`, `enroll_date`, `score`) VALUES ('5', '3', '4', '0.75', '2018-10-16', '75');




