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

 Date: 19/08/2019 17:58:21
*/


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
-- Records of alipay_order
-- ----------------------------
INSERT INTO `alipay_order` VALUES ('201908151000', '935-10001', 0.10, '2019-08-15 18:58:16', '2019-08-15 18:58:14', '购物', '10000', '20190815');

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
INSERT INTO `ilonw_user` VALUES ('1', '10000', 'smail', '师奇隆', 1, 26, '1994-10-15', '2019-08-01 10:52:33', 1, '四川省成都市武侯区', '127.0.0.1', NULL, '17621663876', 'jack1053996819@163.com', '21232f297a57a5a743894a0e4a801fc3');

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
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('20190815', '购物', '10000', 0.10, '2019-08-15 18:58:01', '2019-08-15 18:57:57', 'ALIPAY', 'CREATE');

-- ----------------------------
-- Table structure for shop_loop
-- ----------------------------
DROP TABLE IF EXISTS `shop_loop`;
CREATE TABLE `shop_loop`  (
  `loop_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `loop_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loop_pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loop_status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loop_createtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loop_updatetime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loop_index` int(5) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`loop_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of shop_loop
-- ----------------------------
INSERT INTO `shop_loop` VALUES ('fc42bd4667514da889372528a971625600038', '师奇隆', 'ilonw图片', 'NORMAL', '2019/08/17 22:38:38', NULL, 2);

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin`  (
  `admin_id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_code` int(10) NOT NULL,
  `admin_username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_sex` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_age` int(4) NULL DEFAULT NULL,
  `admin_dept` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `admin_position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `admin_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `admin_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_createtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_updatetime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`admin_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES (1, 10000, '师奇隆', '男', 27, 'admin', 'admin', '17621663876', 'jack1053996819@163.com', 'admin', 'admin', NULL, 'admin', '2019/08/19 00:00:00', '2019/08/19 16:10:35');

-- ----------------------------
-- Table structure for sys_app
-- ----------------------------
DROP TABLE IF EXISTS `sys_app`;
CREATE TABLE `sys_app`  (
  `app_channel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_id` int(10) NOT NULL,
  `app_key` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_createtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_status` int(2) NOT NULL,
  `app_channel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_private_key` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `app_public_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY USING BTREE (`app_channel`)
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
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pid` int(10) NULL DEFAULT NULL,
  `url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 122 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, 'index_home.html', 'iconfont icon-home', '系统首页');
INSERT INTO `sys_menu` VALUES (2, 0, '', 'iconfont icon-iconsp2', '产品管理');
INSERT INTO `sys_menu` VALUES (3, 0, '', 'iconfont icon-suoshuzhiwei', '交易管理');
INSERT INTO `sys_menu` VALUES (4, 0, '', 'iconfont icon-xiangmuguanli', '支付管理');
INSERT INTO `sys_menu` VALUES (5, 0, '', 'iconfont icon-yonghuguanli', '系统管理');
INSERT INTO `sys_menu` VALUES (6, 0, '', 'iconfont icon-usergroup', '会员管理');
INSERT INTO `sys_menu` VALUES (7, 0, '', 'iconfont icon-guanggao', '广告管理');
INSERT INTO `sys_menu` VALUES (8, 0, '', 'iconfont icon-system-copy', '框架说明');
INSERT INTO `sys_menu` VALUES (9, 0, '', 'iconfont icon-dianpu', '店铺管理');
INSERT INTO `sys_menu` VALUES (100, 2, 'product_Manage.html?id=0', '', '商品管理');
INSERT INTO `sys_menu` VALUES (101, 2, 'Brand_Manage.html', '', '品牌管理');
INSERT INTO `sys_menu` VALUES (102, 2, 'product_statistics.html', '', '产品统计');
INSERT INTO `sys_menu` VALUES (103, 2, 'classify.html', '', '分类管理');
INSERT INTO `sys_menu` VALUES (104, 7, 'advertise.html', '', '广告管理');
INSERT INTO `sys_menu` VALUES (105, 3, 'order_list.html', '', '订单列表');
INSERT INTO `sys_menu` VALUES (106, 3, 'delivery_list.html', '', '发货管理');
INSERT INTO `sys_menu` VALUES (107, 3, 'wuliu.html', '', '快递物流');
INSERT INTO `sys_menu` VALUES (109, 4, 'defray.html', '', '支付设置');
INSERT INTO `sys_menu` VALUES (110, 4, 'defray_type.html', '', '支付类型');
INSERT INTO `sys_menu` VALUES (111, 6, 'member.html', '', '会员列表');
INSERT INTO `sys_menu` VALUES (112, 6, 'member.html', '', '会员等级');
INSERT INTO `sys_menu` VALUES (113, 5, 'system_info.html', '', '系统设置');
INSERT INTO `sys_menu` VALUES (114, 5, 'administrator.html', '', '系统用户');
INSERT INTO `sys_menu` VALUES (115, 8, 'rizhi_list.html', '', '字体库');
INSERT INTO `sys_menu` VALUES (116, 8, 'explanation.html', '', '结构说明');
INSERT INTO `sys_menu` VALUES (117, 8, 'module.html', '', '模块说明');
INSERT INTO `sys_menu` VALUES (118, 5, 'userinfo.html?userid=1', '', '个人信息');
INSERT INTO `sys_menu` VALUES (119, 5, 'administrators.html', '', '登录记录');
INSERT INTO `sys_menu` VALUES (120, 9, 'shopinfo.html', '', '店铺信息');
INSERT INTO `sys_menu` VALUES (121, 5, NULL, NULL, '菜单管理');

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
) ENGINE = InnoDB AUTO_INCREMENT = 0 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;



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

