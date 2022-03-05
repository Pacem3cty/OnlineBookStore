# Host: localhost  (Version: 5.5.22)
# Date: 2020-06-25 14:57:19
# Generator: MySQL-Front 5.3  (Build 4.9)

/*!40101 SET NAMES utf8 */;

#
# Source for table "customer"
#

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(10) NOT NULL,
  `loginname` varchar(20) NOT NULL,
  `password` varchar(18) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `loginname` (`loginname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "customer"
#

INSERT INTO `customer` VALUES ('105535','Bot','123456'),('145372','Tex','654321');
