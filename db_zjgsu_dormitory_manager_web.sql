/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : db_zjgsu_dormitory_manager_web

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-05-03 18:00:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `admin` VALUES ('2', '123', '123', '0');

-- ----------------------------
-- Table structure for `building`
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `location` varchar(128) DEFAULT NULL,
  `dormitory_manager_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dormitory_id_fk` (`dormitory_manager_id`),
  CONSTRAINT `dormitory_id_fk` FOREIGN KEY (`dormitory_manager_id`) REFERENCES `dormitory_manager` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES ('1', '01幢', '金沙港生活区', '1');
INSERT INTO `building` VALUES ('7', '07幢', '金沙港生活区', '24');
INSERT INTO `building` VALUES ('12', '12幢', '金沙港生活区', '22');
INSERT INTO `building` VALUES ('19', '19幢', '金沙港生活区', '25');
INSERT INTO `building` VALUES ('29', '29幢', '钱江湾生活区', '23');
INSERT INTO `building` VALUES ('38', '38幢', '钱江湾生活区', '2');
INSERT INTO `building` VALUES ('46', '46幢', '钱江湾生活区', '3');

-- ----------------------------
-- Table structure for `dormitory`
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(32) NOT NULL,
  `building_id` int(11) NOT NULL,
  `floor` varchar(32) NOT NULL,
  `max_number` int(2) NOT NULL,
  `lived_number` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `building_id_fk` (`building_id`),
  CONSTRAINT `building_id_fk` FOREIGN KEY (`building_id`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES ('1', '01-101', '1', '1', '4', '1');
INSERT INTO `dormitory` VALUES ('2', '07-205', '7', '2', '4', '1');
INSERT INTO `dormitory` VALUES ('3', '12-209', '12', '2', '4', '1');
INSERT INTO `dormitory` VALUES ('4', '19-319', '19', '3', '4', '0');
INSERT INTO `dormitory` VALUES ('5', '19-506', '19', '5', '4', '1');
INSERT INTO `dormitory` VALUES ('6', '29-113', '29', '1', '4', '0');
INSERT INTO `dormitory` VALUES ('7', '29-309', '29', '3', '4', '1');
INSERT INTO `dormitory` VALUES ('8', '29-601', '29', '6', '4', '0');
INSERT INTO `dormitory` VALUES ('13', '38-102', '38', '1', '4', '0');
INSERT INTO `dormitory` VALUES ('14', '38-116', '38', '1', '4', '0');
INSERT INTO `dormitory` VALUES ('15', '38-223', '38', '2', '4', '1');
INSERT INTO `dormitory` VALUES ('16', '38-503', '38', '5', '4', '0');
INSERT INTO `dormitory` VALUES ('20', '46-811', '46', '8', '4', '1');

-- ----------------------------
-- Table structure for `dormitory_manager`
-- ----------------------------
DROP TABLE IF EXISTS `dormitory_manager`;
CREATE TABLE `dormitory_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitory_manager
-- ----------------------------
INSERT INTO `dormitory_manager` VALUES ('1', 'ZJGSU-DM1588433232279', '王阿姨', '123456', '女');
INSERT INTO `dormitory_manager` VALUES ('2', 'ZJGSU-DM1588433298590', '张阿姨', '123456', '女');
INSERT INTO `dormitory_manager` VALUES ('3', 'ZJGSU-DM1588433384651', '赵阿姨', '123456', '女');
INSERT INTO `dormitory_manager` VALUES ('22', 'ZJGSU-DM1588433310183', '李大叔', '123456', '男');
INSERT INTO `dormitory_manager` VALUES ('23', 'ZJGSU-DM1588433336291', '孙大叔', '123456', '男');
INSERT INTO `dormitory_manager` VALUES ('24', 'ZJGSU-DM1588433404495', '林大叔', '123456', '男');
INSERT INTO `dormitory_manager` VALUES ('25', 'ZJGSU-DM1588433991213', '钱大叔', '123456', '男');

-- ----------------------------
-- Table structure for `live`
-- ----------------------------
DROP TABLE IF EXISTS `live`;
CREATE TABLE `live` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `dormitory_id` int(11) NOT NULL,
  `live_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id_live_fk` (`student_id`),
  KEY `dormitory_id_live_fk` (`dormitory_id`),
  CONSTRAINT `dormitory_id_live_fk` FOREIGN KEY (`dormitory_id`) REFERENCES `dormitory` (`id`),
  CONSTRAINT `student_id_live_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of live
-- ----------------------------
INSERT INTO `live` VALUES ('1', '1', '15', '2020-04-27');
INSERT INTO `live` VALUES ('2', '2', '7', '2020-04-27');
INSERT INTO `live` VALUES ('3', '8', '20', '2020-04-27');
INSERT INTO `live` VALUES ('6', '3', '2', '2020-04-27');
INSERT INTO `live` VALUES ('7', '4', '3', '2020-04-28');
INSERT INTO `live` VALUES ('8', '5', '1', '2020-04-28');
INSERT INTO `live` VALUES ('9', '9', '5', '2020-05-03');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `sex` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'ZJGSU-S1587810259633', '谢晓露', '1623090108', '女');
INSERT INTO `student` VALUES ('2', 'ZJGSU-S1587812284038', '张三', 'zhangsan', '男');
INSERT INTO `student` VALUES ('3', 'ZJGSU-S1587812295132', '李四', 'lisi', '男');
INSERT INTO `student` VALUES ('4', 'ZJGSU-S1587812313444', '王五', 'wangwu', '男');
INSERT INTO `student` VALUES ('5', 'ZJGSU-S1588077016056', '赵六', 'zhaoliu', '女');
INSERT INTO `student` VALUES ('8', 'ZJGSU-S1588428054376', '周七', 'zhouqi', '女');
INSERT INTO `student` VALUES ('9', 'ZJGSU-S1588483363026', '吴八', 'wuba', '男');
