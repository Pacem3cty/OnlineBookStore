# Host: localhost  (Version: 5.5.22)
# Date: 2020-06-25 14:56:57
# Generator: MySQL-Front 5.3  (Build 4.9)

/*!40101 SET NAMES utf8 */;

#
# Source for table "goodsinfo"
#

DROP TABLE IF EXISTS `goodsinfo`;
CREATE TABLE `goodsinfo` (
  `id` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(20) NOT NULL,
  `price` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

#
# Data for table "goodsinfo"
#

INSERT INTO `goodsinfo` VALUES ('10106','《他改变了中国》实体书','56.4'),('10321','《Java核心技术》实体书','147.5'),('10347','《Java7》实体书','56.1'),('10574','《Java经典实例》实体书','133.2'),('10658','《JSP&Servlet》实体书','93.1'),('12306','《岛上书店》实体书','17.5');
