/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : db_tianditu

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-08-22 10:54:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(256) NOT NULL COMMENT '密码(存储有salt)',
  `mobile` char(11) NOT NULL COMMENT '手机',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT '邮箱(可为空)',
  `extra` varchar(256) NOT NULL DEFAULT '' COMMENT '备注(可为空)',
  PRIMARY KEY (`id`),
  KEY `index_name` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '18222919406', '994683607@qq.com', '超级管理员');
INSERT INTO `admin` VALUES ('104', 'admin3', '19402600297a305197962a5633e7711e', '18229819406', '994673607@qq.com', '测试用户');
INSERT INTO `admin` VALUES ('105', 'admin13', 'e00cf25ad42683b3df678c61f42c6bda', '18229819406', '994683607@qq,com', '测试');

-- ----------------------------
-- Table structure for tianditu
-- ----------------------------
DROP TABLE IF EXISTS `tianditu`;
CREATE TABLE `tianditu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `place` varchar(255) DEFAULT NULL,
  `title` text,
  `extra` text,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tianditu
-- ----------------------------
INSERT INTO `tianditu` VALUES ('1', '常德市', '统一后台功能管理', '版本2.0发布增加统一后台管理，增加更新日志功能。', '2018-08-08');
INSERT INTO `tianditu` VALUES ('54', '常德市', '发布网页端和HTML', '版本1.0发布，常德前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('55', '长沙市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('56', '岳阳市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-04');
INSERT INTO `tianditu` VALUES ('57', '怀化市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-04');
INSERT INTO `tianditu` VALUES ('58', '衡阳市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-09');
INSERT INTO `tianditu` VALUES ('59', '株洲市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-17');
INSERT INTO `tianditu` VALUES ('60', '永州市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-02');
INSERT INTO `tianditu` VALUES ('61', '株洲市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-04');
INSERT INTO `tianditu` VALUES ('62', '株洲市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-02');
INSERT INTO `tianditu` VALUES ('63', '郴州市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-08');
INSERT INTO `tianditu` VALUES ('64', '张家界市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('65', '邵阳市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('66', '益阳市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('67', '娄底市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('68', '吉首市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-02');
INSERT INTO `tianditu` VALUES ('69', '湘潭市', '发布网页端和HTML', '版本1.0发布，前端页面基本完成', '2018-08-07');
INSERT INTO `tianditu` VALUES ('70', '永州市', '统一后台功能管理', '版本2.0发布增加统一后台管理，增加更新日志功能。', '2018-08-08');
INSERT INTO `tianditu` VALUES ('71', '常德市', '统一后台功能管理12', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('72', '常德市', '发布网页端和HTML', '前端页面基本完成2', '2018-08-03');
INSERT INTO `tianditu` VALUES ('73', '常德市', '支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('74', '怀化市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('75', '怀化市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('76', '怀化市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('100', '长沙市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('101', '长沙市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('102', '长沙市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('104', '岳阳市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('105', '岳阳市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('106', '岳阳市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('107', '衡阳市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('108', '衡阳市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('109', '衡阳市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('110', '株洲市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('111', '株洲市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('112', '株洲市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('113', '永州市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('114', '永州市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('115', '永州市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('116', '郴州市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('117', '郴州市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('118', '郴州市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('119', '张家界市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('120', '张家界市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('121', '张家界市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('122', '邵阳市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('123', '邵阳市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('124', '邵阳市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('125', '娄底市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('126', '娄底市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('127', '娄底市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('128', '吉首市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('129', '吉首市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('130', '吉首市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('131', '湘潭市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('132', '湘潭市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('133', '湘潭市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
INSERT INTO `tianditu` VALUES ('134', '永州市', '统一后台功能管理', '版本3.0发布，前后端页面整合，优化各项节点', '2018-08-10');
INSERT INTO `tianditu` VALUES ('135', '永州市', '发布网页端和HTML', '前端页面基本完成', '2018-08-03');
INSERT INTO `tianditu` VALUES ('136', '永州市', '\r\n支持瓦片跨域调用', '发布版本V3.16.3。 解决瓦片调用跨域问题； 解决域名实时信息、影像元数据请求失败bug； 升级系统服务，优化系统bug。', '2018-08-15');
