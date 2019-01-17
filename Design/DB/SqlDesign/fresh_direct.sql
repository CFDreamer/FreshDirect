/*
Navicat MySQL Data Transfer

Source Server         : CF
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : fresh_direct

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-17 16:12:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_f_ad`
-- ----------------------------
DROP TABLE IF EXISTS `t_f_ad`;
CREATE TABLE `t_f_ad` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `image_path` varchar(255) DEFAULT NULL,
  `gid` int(5) NOT NULL,
  `url` varchar(255) DEFAULT NULL COMMENT '活动的url',
  `isdisplay` int(2) DEFAULT '0' COMMENT '是否展示(0：不展示；1展示)',
  `isdeleted` int(2) DEFAULT '0' COMMENT '0：未删除；1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_f_ad
-- ----------------------------

-- ----------------------------
-- Table structure for `t_g_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_g_info`;
CREATE TABLE `t_g_info` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `typeid` int(2) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `now_price` double NOT NULL COMMENT '现价',
  `old_price` double NOT NULL COMMENT '原价',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `sell_count` int(10) DEFAULT '0' COMMENT '销量',
  `isenable` int(2) DEFAULT '1' COMMENT '商品是否上架（0：未上架；1：上架）',
  `clickcount` int(10) DEFAULT '0' COMMENT '商品的点击次数',
  `stock` int(10) NOT NULL COMMENT '商品的库存',
  `operator_id` int(5) NOT NULL COMMENT '操作员id',
  `isdeleted` int(2) DEFAULT '0' COMMENT '是否删除（0：未删除；1：已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_g_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_g_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_g_type`;
CREATE TABLE `t_g_type` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `typeid` int(2) NOT NULL,
  `typename` varchar(50) NOT NULL,
  `parent_id` int(2) DEFAULT NULL COMMENT '当parent_id为null时说明是大类，否则是小分类',
  `isdeleted` int(2) DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_g_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_o_detail`
-- ----------------------------
DROP TABLE IF EXISTS `t_o_detail`;
CREATE TABLE `t_o_detail` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `ono` varchar(255) NOT NULL,
  `gid` int(5) NOT NULL,
  `count` int(5) NOT NULL,
  `isdeleted` int(2) DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_o_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `t_o_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_o_info`;
CREATE TABLE `t_o_info` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `ono` varchar(255) NOT NULL,
  `uid` int(5) NOT NULL,
  `allprice` double(2,0) NOT NULL,
  `state` int(2) DEFAULT '0' COMMENT '订单的状态（0：未完成；1：已完成）',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `isdeleted` int(2) DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_o_info
-- ----------------------------

-- ----------------------------
-- Table structure for `t_u_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_u_address`;
CREATE TABLE `t_u_address` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) NOT NULL,
  `name` varchar(30) NOT NULL COMMENT '收货人的姓名',
  `phone` varchar(30) NOT NULL COMMENT '收货人的电话',
  `address` varchar(255) NOT NULL COMMENT '收货人的地址',
  `isdefault` int(2) DEFAULT '0' COMMENT '是否为默认地址（1：默认；0：非默认）',
  `use_count` int(5) DEFAULT '0' COMMENT '使用次数',
  `isdeleted` int(2) DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_u_address
-- ----------------------------

-- ----------------------------
-- Table structure for `t_u_collections`
-- ----------------------------
DROP TABLE IF EXISTS `t_u_collections`;
CREATE TABLE `t_u_collections` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) NOT NULL COMMENT '用户id',
  `gid` int(5) NOT NULL COMMENT '收藏商品的id',
  `isdeleted` int(2) DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_u_collections
-- ----------------------------

-- ----------------------------
-- Table structure for `t_u_shopcar`
-- ----------------------------
DROP TABLE IF EXISTS `t_u_shopcar`;
CREATE TABLE `t_u_shopcar` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(5) NOT NULL,
  `gid` int(5) NOT NULL,
  `count` int(5) NOT NULL,
  `add_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `isdeleted` int(2) DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_u_shopcar
-- ----------------------------

-- ----------------------------
-- Table structure for `t_u_type`
-- ----------------------------
DROP TABLE IF EXISTS `t_u_type`;
CREATE TABLE `t_u_type` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `usagetype` int(2) NOT NULL,
  `typename` varchar(50) NOT NULL,
  `isdeleted` int(2) DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_u_type
-- ----------------------------

-- ----------------------------
-- Table structure for `t_u_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_u_user`;
CREATE TABLE `t_u_user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `sex` char(2) NOT NULL,
  `password` varchar(255) NOT NULL,
  `usagetype` int(2) DEFAULT '0' COMMENT '用户的类型（0：会员；1：管理员；2：超级管理员）',
  `image_path` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `birthday` date NOT NULL,
  `sign_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `isenable` int(2) DEFAULT '1' COMMENT '账号是否可用（0：不可用；1：可用）',
  `isdeleted` int(2) DEFAULT '0' COMMENT '是否删除（0：未删除；1已删除）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_u_user
-- ----------------------------
