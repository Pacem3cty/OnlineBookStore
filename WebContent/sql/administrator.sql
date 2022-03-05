# Host: localhost  (Version: 5.5.22)
# Date: 2020-06-25 14:56:21
# Generator: MySQL-Front 5.3  (Build 4.9)

/*!40101 SET NAMES utf8 */;

#
# Source for table "administrator"
#

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` varchar(10) NOT NULL,
  `loginname` varchar(20) NOT NULL,
  `password` varchar(18) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `loginname` (`loginname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "administrator"
#

INSERT INTO `administrator` VALUES ('200066','_Pacem','04181025'),('369851','Starling','04181025');
