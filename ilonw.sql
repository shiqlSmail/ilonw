/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50096
 Source Host           : localhost:3306
 Source Schema         : ilonw

 Target Server Type    : MySQL
 Target Server Version : 50096
 File Encoding         : 65001

 Date: 06/08/2019 16:30:08
*/

SET NAMES utf8mb4;

-- ----------------------------
-- Table structure for alipay_order
-- ----------------------------
DROP TABLE IF EXISTS `alipay_order`;
CREATE TABLE `alipay_order`  (
  `alipay_order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_amount` decimal(15, 2) NULL DEFAULT NULL,
  `alipay_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `alipay_updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `return_body` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ilonw_dict
-- ----------------------------
DROP TABLE IF EXISTS `ilonw_dict`;
CREATE TABLE `ilonw_dict`  (
  `dict_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dict_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dict_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`dict_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ilonw_logs
-- ----------------------------
DROP TABLE IF EXISTS `ilonw_logs`;
CREATE TABLE `ilonw_logs`  (
  `log_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `log_author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_createtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_result` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `log_param` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `log_request` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_times` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`log_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ilonw_user
-- ----------------------------
DROP TABLE IF EXISTS `ilonw_user`;
CREATE TABLE `ilonw_user`  (
  `ilonw_user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_user_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_user_nikename` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_user_sex` int(11) NULL DEFAULT NULL,
  `ilonw_user_age` int(11) NULL DEFAULT NULL,
  `ilonw_user_brithday` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_user_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ilonw_user_status` int(11) NULL DEFAULT NULL,
  `ilonw_user_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_user_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_user_image` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_user_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ilonw_user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`ilonw_user_phone`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ilonw_user
-- ----------------------------
INSERT INTO `ilonw_user` VALUES ('4', '16801124', NULL, NULL, NULL, NULL, NULL, '2019-08-01 12:34:00', 1, NULL, '127.0.0.1', NULL, '13817043212', NULL, NULL);
INSERT INTO `ilonw_user` VALUES ('702ecc4f16784d169242bbeb83cae18f00059', '16801124', NULL, NULL, NULL, NULL, NULL, '2019-08-01 12:34:00', 1, NULL, '127.0.0.1', NULL, '13817043214', NULL, NULL);
INSERT INTO `ilonw_user` VALUES ('11', '16801124', NULL, NULL, NULL, NULL, NULL, '2019-08-01 12:34:00', 1, NULL, '127.0.0.1', NULL, '1381704553212', NULL, NULL);
INSERT INTO `ilonw_user` VALUES ('15', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-01 10:52:33', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '1762166322448676', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `ilonw_user` VALUES ('13', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-01 10:52:33', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '1762166322876', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `ilonw_user` VALUES ('14', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-01 10:52:33', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '17621663833676', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `ilonw_user` VALUES ('5', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-01 10:52:33', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '17621663874', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `ilonw_user` VALUES ('1', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-01 10:52:33', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '17621663876', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `ilonw_user` VALUES ('2', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-01 10:52:33', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '176216638761', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `ilonw_user` VALUES ('3', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-03 17:36:22', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '176216638762', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `ilonw_user` VALUES ('4', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-01 10:52:33', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '176216638763', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');
INSERT INTO `ilonw_user` VALUES ('12', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-01 10:52:33', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '17621663q11874', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` decimal(15, 2) NULL DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `pay_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pay_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_email
-- ----------------------------
DROP TABLE IF EXISTS `sys_email`;
CREATE TABLE `sys_email`  (
  `email_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email_code` int(6) NULL DEFAULT NULL,
  `email_status` int(2) NULL DEFAULT NULL,
  `email_createtime` datetime NULL DEFAULT NULL,
  `email_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`email_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_email
-- ----------------------------
INSERT INTO `sys_email` VALUES ('1', 111111, 2, '2019-08-04 23:27:41', 'jack1053996819@163.com');

-- ----------------------------
-- Table structure for sys_emailurl
-- ----------------------------
DROP TABLE IF EXISTS `sys_emailurl`;
CREATE TABLE `sys_emailurl`  (
  `email_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email_status` int(2) NULL DEFAULT NULL,
  `email_createtime` datetime NULL DEFAULT NULL,
  `email_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`email_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_emailurl
-- ----------------------------
INSERT INTO `sys_emailurl` VALUES ('1', 'http://www.ilonw.com', 1, '2019-08-04 23:28:04', 'jack1053996819@163.com');

-- ----------------------------
-- Table structure for sys_sms
-- ----------------------------
DROP TABLE IF EXISTS `sys_sms`;
CREATE TABLE `sys_sms`  (
  `sms_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sms_code` int(6) NULL DEFAULT NULL,
  `sms_status` int(2) NULL DEFAULT NULL,
  `sms_createtime` datetime NULL DEFAULT NULL,
  `sms_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`sms_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_sms
-- ----------------------------
INSERT INTO `sys_sms` VALUES ('1', 111111, 2, '2019-08-04 22:54:10', '17621663876');
INSERT INTO `sys_sms` VALUES ('7b4a229378c041e6a5e7e9783d0ce76000035', 111111, 1, '2019-08-06 12:31:35', '17621663876');

-- ----------------------------
-- Table structure for table_file
-- ----------------------------
DROP TABLE IF EXISTS `table_file`;
CREATE TABLE `table_file`  (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_path` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_size` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_fixname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_new_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_file_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ilonw_file_context` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `platform` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `auther` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Identification` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片唯一标识，不同于ID',
  PRIMARY KEY USING BTREE (`file_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for wxpay_order
-- ----------------------------
DROP TABLE IF EXISTS `wxpay_order`;
CREATE TABLE `wxpay_order`  (
  `wxpay_order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nonce_str` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_fee` int(17) NULL DEFAULT NULL,
  `spbill_create_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wxpay_createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `wxpay_updatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `prepay_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `return_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `return_msg` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `err_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `err_code_des` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

