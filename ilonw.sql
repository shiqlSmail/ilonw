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

 Date: 03/09/2019 18:46:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
-- Table structure for cms_prefrence_area_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `cms_prefrence_area_product_relation`;
CREATE TABLE `cms_prefrence_area_product_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prefrence_area_id` bigint(20) NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '优选专区和产品关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_prefrence_area_product_relation
-- ----------------------------
INSERT INTO `cms_prefrence_area_product_relation` VALUES (1, 1, 12);
INSERT INTO `cms_prefrence_area_product_relation` VALUES (2, 1, 13);
INSERT INTO `cms_prefrence_area_product_relation` VALUES (3, 1, 14);
INSERT INTO `cms_prefrence_area_product_relation` VALUES (4, 1, 18);
INSERT INTO `cms_prefrence_area_product_relation` VALUES (5, 1, 7);
INSERT INTO `cms_prefrence_area_product_relation` VALUES (6, 2, 7);
INSERT INTO `cms_prefrence_area_product_relation` VALUES (7, 1, 22);
INSERT INTO `cms_prefrence_area_product_relation` VALUES (24, 1, 23);

-- ----------------------------
-- Table structure for cms_subject_product_relation
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject_product_relation`;
CREATE TABLE `cms_subject_product_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject_id` bigint(20) NULL DEFAULT NULL,
  `product_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专题商品关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cms_subject_product_relation
-- ----------------------------
INSERT INTO `cms_subject_product_relation` VALUES (1, 1, 26);
INSERT INTO `cms_subject_product_relation` VALUES (2, 1, 27);
INSERT INTO `cms_subject_product_relation` VALUES (3, 1, 28);
INSERT INTO `cms_subject_product_relation` VALUES (4, 1, 29);
INSERT INTO `cms_subject_product_relation` VALUES (5, 2, 30);
INSERT INTO `cms_subject_product_relation` VALUES (6, 2, 31);
INSERT INTO `cms_subject_product_relation` VALUES (7, 2, 35);
INSERT INTO `cms_subject_product_relation` VALUES (29, 2, 36);
INSERT INTO `cms_subject_product_relation` VALUES (30, 2, 32);
INSERT INTO `cms_subject_product_relation` VALUES (31, 3, 33);
INSERT INTO `cms_subject_product_relation` VALUES (38, 3, 34);

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
-- Table structure for pms_member_price
-- ----------------------------
DROP TABLE IF EXISTS `pms_member_price`;
CREATE TABLE `pms_member_price`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `member_level_id` bigint(20) NULL DEFAULT NULL,
  `member_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '会员价格',
  `member_level_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 201 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品会员价格表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pms_member_price
-- ----------------------------
INSERT INTO `pms_member_price` VALUES (26, 7, 1, 500.00, NULL);
INSERT INTO `pms_member_price` VALUES (27, 8, 1, 500.00, NULL);
INSERT INTO `pms_member_price` VALUES (28, 9, 1, 500.00, NULL);
INSERT INTO `pms_member_price` VALUES (29, 10, 1, 500.00, NULL);
INSERT INTO `pms_member_price` VALUES (30, 11, 1, 500.00, NULL);
INSERT INTO `pms_member_price` VALUES (31, 12, 1, 500.00, NULL);
INSERT INTO `pms_member_price` VALUES (32, 13, 1, 500.00, NULL);
INSERT INTO `pms_member_price` VALUES (33, 14, 1, 500.00, NULL);
INSERT INTO `pms_member_price` VALUES (37, 18, 1, 500.00, NULL);
INSERT INTO `pms_member_price` VALUES (44, 7, 2, 480.00, NULL);
INSERT INTO `pms_member_price` VALUES (45, 7, 3, 450.00, NULL);
INSERT INTO `pms_member_price` VALUES (52, 22, 1, NULL, NULL);
INSERT INTO `pms_member_price` VALUES (53, 22, 2, NULL, NULL);
INSERT INTO `pms_member_price` VALUES (54, 22, 3, NULL, NULL);
INSERT INTO `pms_member_price` VALUES (58, 24, 1, NULL, NULL);
INSERT INTO `pms_member_price` VALUES (59, 24, 2, NULL, NULL);
INSERT INTO `pms_member_price` VALUES (60, 24, 3, NULL, NULL);
INSERT INTO `pms_member_price` VALUES (112, 23, 1, 88.00, '黄金会员');
INSERT INTO `pms_member_price` VALUES (113, 23, 2, 88.00, '白金会员');
INSERT INTO `pms_member_price` VALUES (114, 23, 3, 66.00, '钻石会员');
INSERT INTO `pms_member_price` VALUES (142, 31, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (143, 31, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (144, 31, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (148, 32, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (149, 32, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (150, 32, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (154, 33, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (155, 33, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (156, 33, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (169, 36, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (170, 36, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (171, 36, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (172, 35, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (173, 35, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (174, 35, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (175, 34, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (176, 34, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (177, 34, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (178, 30, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (179, 30, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (180, 30, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (186, 26, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (187, 26, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (188, 26, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (192, 27, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (193, 27, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (194, 27, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (195, 28, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (196, 28, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (197, 28, 3, NULL, '钻石会员');
INSERT INTO `pms_member_price` VALUES (198, 29, 1, NULL, '黄金会员');
INSERT INTO `pms_member_price` VALUES (199, 29, 2, NULL, '白金会员');
INSERT INTO `pms_member_price` VALUES (200, 29, 3, NULL, '钻石会员');

-- ----------------------------
-- Table structure for pms_product
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) NULL DEFAULT NULL,
  `product_category_id` bigint(20) NULL DEFAULT NULL,
  `feight_template_id` bigint(20) NULL DEFAULT NULL,
  `product_attribute_category_id` bigint(20) NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '货号',
  `delete_status` int(1) NULL DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `publish_status` int(1) NULL DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `new_status` int(1) NULL DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `recommand_status` int(1) NULL DEFAULT NULL COMMENT '推荐状态；0->不推荐；1->推荐',
  `verify_status` int(1) NULL DEFAULT NULL COMMENT '审核状态：0->未审核；1->审核通过',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `sale` int(11) NULL DEFAULT NULL COMMENT '销量',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `promotion_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '促销价格',
  `gift_growth` int(11) NULL DEFAULT 0 COMMENT '赠送的成长值',
  `gift_point` int(11) NULL DEFAULT 0 COMMENT '赠送的积分',
  `use_point_limit` int(11) NULL DEFAULT NULL COMMENT '限制使用的积分数',
  `sub_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '副标题',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品描述',
  `original_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '市场价',
  `stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  `low_stock` int(11) NULL DEFAULT NULL COMMENT '库存预警值',
  `unit` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位',
  `weight` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品重量，默认为克',
  `preview_status` int(1) NULL DEFAULT NULL COMMENT '是否为预告商品：0->不是；1->是',
  `service_ids` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `album_pics` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '画册图片，连产品图片限制为5张，以逗号分割',
  `detail_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `detail_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品详情网页内容',
  `detail_mobile_html` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '移动端网页详情',
  `promotion_start_time` datetime NULL DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` datetime NULL DEFAULT NULL COMMENT '促销结束时间',
  `promotion_per_limit` int(11) NULL DEFAULT NULL COMMENT '活动限购数量',
  `promotion_type` int(1) NULL DEFAULT NULL COMMENT '促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购',
  `brand_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌名称',
  `product_category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品分类名称',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pms_product
-- ----------------------------
INSERT INTO `pms_product` VALUES (1, 49, 7, 0, 0, '银色星芒刺绣网纱底裤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 1, 1, 1, 1, 100, 0, 100.00, NULL, 0, 100, NULL, '111', '111', 120.00, 100, 20, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, NULL, 0, '七匹狼', '外套');
INSERT INTO `pms_product` VALUES (2, 49, 7, 0, 0, '银色星芒刺绣网纱底裤2', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86578', 1, 1, 1, 1, 1, 1, 0, 100.00, NULL, 0, 100, NULL, '111', '111', 120.00, 100, 20, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤2', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '<p>银色星芒刺绣网纱底裤</p>', '<p>银色星芒刺绣网纱底裤</p>', NULL, NULL, NULL, 0, '七匹狼', '外套');
INSERT INTO `pms_product` VALUES (3, 1, 7, 0, 0, '银色星芒刺绣网纱底裤3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86579', 1, 1, 1, 1, 1, 1, 0, 100.00, NULL, 0, 100, NULL, '111', '111', 120.00, 100, 20, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤3', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, NULL, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (4, 1, 7, 0, 0, '银色星芒刺绣网纱底裤4', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86580', 1, 1, 1, 1, 1, 1, 0, 100.00, NULL, 0, 100, NULL, '111', '111', 120.00, 100, 20, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤4', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, NULL, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (5, 1, 7, 0, 0, '银色星芒刺绣网纱底裤5', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86581', 1, 0, 1, 1, 1, 1, 0, 100.00, NULL, 0, 100, NULL, '111', '111', 120.00, 100, 20, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤5', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, NULL, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (6, 1, 7, 0, 0, '银色星芒刺绣网纱底裤6', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86582', 1, 1, 1, 1, 1, 1, 0, 100.00, NULL, 0, 100, NULL, '111', '111', 120.00, 100, 20, '件', 1000.00, 0, NULL, '银色星芒刺绣网纱底裤6', '银色星芒刺绣网纱底裤', NULL, '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', '银色星芒刺绣网纱底裤', NULL, NULL, NULL, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (7, 1, 7, 0, 1, '女式超柔软拉毛运动开衫', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 0, 0, 0, 0, 0, 0, 249.00, 0.00, 0, 100, 0, '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 299.00, 100, 0, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (8, 1, 7, 0, 1, '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 0, 0, 0, 0, 0, 0, 249.00, 0.00, 0, 100, 0, '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 299.00, 100, 0, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (9, 1, 7, 0, 1, '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 0, 0, 0, 0, 0, 0, 249.00, 0.00, 0, 100, 0, '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 299.00, 100, 0, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (10, 1, 7, 0, 1, '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 0, 0, 0, 0, 0, 0, 249.00, 0.00, 0, 100, 0, '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 299.00, 100, 0, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (11, 1, 7, 0, 1, '女式超柔软拉毛运动开衫1', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 1, 0, 1, 0, 0, 0, 249.00, 0.00, 0, 100, 0, '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 299.00, 100, 0, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (12, 1, 7, 0, 1, '女式超柔软拉毛运动开衫2', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 1, 0, 1, 0, 0, 0, 249.00, 0.00, 0, 100, 0, '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 299.00, 100, 0, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (13, 1, 7, 0, 1, '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 1, 0, 1, 0, 0, 0, 249.00, 0.00, 0, 100, 0, '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 299.00, 100, 0, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (14, 1, 7, 0, 1, '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 0, 0, 1, 0, 0, 0, 249.00, 0.00, 0, 100, 0, '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 299.00, 100, 0, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (18, 1, 7, 0, 1, '女式超柔软拉毛运动开衫3', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180522/web.png', 'No86577', 1, 0, 0, 1, 0, 0, 0, 249.00, 0.00, 0, 100, 0, '匠心剪裁，垂感质地', '匠心剪裁，垂感质地', 299.00, 100, 0, '件', 0.00, 0, 'string', '女式超柔软拉毛运动开衫', 'string', 'string', 'string', 'string', 'string', 'string', '2018-04-26 10:41:03', '2018-04-26 10:41:03', 0, 0, '万和', '外套');
INSERT INTO `pms_product` VALUES (22, 6, 7, 0, 1, 'test', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', '', 1, 1, 0, 0, 0, 0, 0, 0.00, NULL, 0, 0, 0, 'test', '', 0.00, 100, 0, '', 0.00, 1, '1,2', '', '', '', '', '', '', '', NULL, NULL, 0, 0, '小米', '外套');
INSERT INTO `pms_product` VALUES (23, 6, 19, 0, 1, '毛衫测试', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', 'NO.1098', 1, 1, 1, 1, 0, 0, 0, 99.00, NULL, 99, 99, 1000, '毛衫测试11', 'xxx', 109.00, 100, 0, '件', 1000.00, 1, '1,2,3', '毛衫测试', '毛衫测试', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', '毛衫测试', '毛衫测试', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/155x54.bmp\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/APP登录bg1080.jpg\" width=\"500\" height=\"500\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/APP登录界面.jpg\" width=\"500\" height=\"500\" /></p>', '', NULL, NULL, 0, 2, '小米', '手机通讯');
INSERT INTO `pms_product` VALUES (24, 6, 7, 0, NULL, 'xxx', '', '', 1, 0, 0, 0, 0, 0, 0, 0.00, NULL, 0, 0, 0, 'xxx', '', 0.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 0, '小米', '外套');
INSERT INTO `pms_product` VALUES (26, 3, 19, 0, 3, '华为 HUAWEI P20 ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf58Ndefaac16.jpg', '6946605', 0, 1, 1, 1, 0, 100, 0, 3788.00, NULL, 3788, 3788, 0, 'AI智慧全面屏 6GB +64GB 亮黑色 全网通版 移动联通电信4G手机 双卡双待手机 双卡双待', '', 4288.00, 1000, 0, '件', 0.00, 1, '2,3,1', '', '', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ab46a3cN616bdc41.jpg,http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ac1bf5fN2522b9dc.jpg', '', '', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44f1cNf51f3bb0.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa8Nfcf71c10.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad44fa9N40e78ee0.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f4N1c94bdda.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5ad457f5Nd30de41d.jpg\" /><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/5b10fb0eN0eb053fb.jpg\" /></p>', '', NULL, NULL, 0, 1, '华为', '手机通讯');
INSERT INTO `pms_product` VALUES (27, 6, 19, 0, 3, '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/xiaomi.jpg', '7437788', 0, 1, 1, 1, 0, 0, 0, 2699.00, NULL, 2699, 2699, 0, '骁龙845处理器，红外人脸解锁，AI变焦双摄，AI语音助手小米6X低至1299，点击抢购', '小米8 全面屏游戏智能手机 6GB+64GB 黑色 全网通4G 双卡双待', 2699.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '<p><img class=\"wscnph\" src=\"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b2254e8N414e6d3a.jpg\" width=\"500\" /></p>', '', NULL, NULL, 0, 3, '小米', '手机通讯');
INSERT INTO `pms_product` VALUES (28, 6, 19, 0, 3, '小米 红米5A 全网通版 3GB+32GB 香槟金 移动联通电信4G手机 双卡双待', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a9d248cN071f4959.jpg', '7437789', 0, 1, 1, 1, 0, 0, 0, 649.00, NULL, 649, 649, 0, '8天超长待机，137g轻巧机身，高通骁龙处理器小米6X低至1299，点击抢购', '', 649.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 4, '小米', '手机通讯');
INSERT INTO `pms_product` VALUES (29, 51, 19, 0, 3, 'Apple iPhone 8 Plus 64GB 红色特别版 移动联通电信4G手机', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5acc5248N6a5f81cd.jpg', '7437799', 0, 1, 1, 0, 0, 0, 0, 5499.00, NULL, 5499, 5499, 0, '【限时限量抢购】Apple产品年中狂欢节，好物尽享，美在智慧！速来 >> 勾选[保障服务][原厂保2年]，获得AppleCare+全方位服务计划，原厂延保售后无忧。', '', 5499.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 0, '苹果', '手机通讯');
INSERT INTO `pms_product` VALUES (30, 50, 8, 0, 1, 'HLA海澜之家简约动物印花短袖T恤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ad83a4fN6ff67ecd.jpg!cc_350x449.jpg', 'HNTBJ2E042A', 0, 1, 1, 1, 0, 0, 0, 98.00, NULL, 0, 0, 0, '2018夏季新品微弹舒适新款短T男生 6月6日-6月20日，满300减30，参与互动赢百元礼券，立即分享赢大奖', '', 98.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 0, '海澜之家', 'T恤');
INSERT INTO `pms_product` VALUES (31, 50, 8, 0, 1, 'HLA海澜之家蓝灰花纹圆领针织布短袖T恤', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5ac98b64N70acd82f.jpg!cc_350x449.jpg', 'HNTBJ2E080A', 0, 1, 0, 0, 0, 0, 0, 98.00, NULL, 0, 0, 0, '2018夏季新品短袖T恤男HNTBJ2E080A 蓝灰花纹80 175/92A/L80A 蓝灰花纹80 175/92A/L', '', 98.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 0, '海澜之家', 'T恤');
INSERT INTO `pms_product` VALUES (32, 50, 8, 0, NULL, 'HLA海澜之家短袖T恤男基础款', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5a51eb88Na4797877.jpg', 'HNTBJ2E153A', 0, 1, 0, 0, 0, 0, 0, 68.00, NULL, 0, 0, 0, 'HLA海澜之家短袖T恤男基础款简约圆领HNTBJ2E153A藏青(F3)175/92A(50)', '', 68.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 0, '海澜之家', 'T恤');
INSERT INTO `pms_product` VALUES (33, 6, 35, 0, NULL, '小米（MI）小米电视4A ', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b02804dN66004d73.jpg', '4609652', 0, 1, 0, 0, 0, 0, 0, 2499.00, NULL, 0, 0, 0, '小米（MI）小米电视4A 55英寸 L55M5-AZ/L55M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视', '', 2499.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 0, '小米', '手机数码');
INSERT INTO `pms_product` VALUES (34, 6, 35, 0, NULL, '小米（MI）小米电视4A 65英寸', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b028530N51eee7d4.jpg', '4609660', 0, 1, 0, 0, 0, 0, 0, 3999.00, NULL, 0, 0, 0, ' L65M5-AZ/L65M5-AD 2GB+8GB HDR 4K超高清 人工智能网络液晶平板电视', '', 3999.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 0, '小米', '手机数码');
INSERT INTO `pms_product` VALUES (35, 58, 29, 0, NULL, '耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b235bb9Nf606460b.jpg', '6799342', 0, 1, 0, 0, 0, 0, 0, 369.00, NULL, 0, 0, 0, '耐克NIKE 男子 休闲鞋 ROSHE RUN 运动鞋 511881-010黑色41码', '', 369.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 0, 'NIKE', '男鞋');
INSERT INTO `pms_product` VALUES (36, 58, 29, 0, NULL, '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180615/5b19403eN9f0b3cb8.jpg', '6799345', 0, 1, 1, 1, 0, 0, 0, 499.00, NULL, 0, 0, 0, '耐克NIKE 男子 气垫 休闲鞋 AIR MAX 90 ESSENTIAL 运动鞋 AJ1285-101白色41码', '', 499.00, 100, 0, '', 0.00, 0, '', '', '', '', '', '', '', '', NULL, NULL, 0, 0, 'NIKE', '男鞋');

-- ----------------------------
-- Table structure for pms_product_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attribute_value`;
CREATE TABLE `pms_product_attribute_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `product_attribute_id` bigint(20) NULL DEFAULT NULL,
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 228 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '存储产品参数信息的表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pms_product_attribute_value
-- ----------------------------
INSERT INTO `pms_product_attribute_value` VALUES (1, 9, 1, 'X');
INSERT INTO `pms_product_attribute_value` VALUES (2, 10, 1, 'X');
INSERT INTO `pms_product_attribute_value` VALUES (3, 11, 1, 'X');
INSERT INTO `pms_product_attribute_value` VALUES (4, 12, 1, 'X');
INSERT INTO `pms_product_attribute_value` VALUES (5, 13, 1, 'X');
INSERT INTO `pms_product_attribute_value` VALUES (6, 14, 1, 'X');
INSERT INTO `pms_product_attribute_value` VALUES (7, 18, 1, 'X');
INSERT INTO `pms_product_attribute_value` VALUES (8, 7, 1, 'X');
INSERT INTO `pms_product_attribute_value` VALUES (9, 7, 1, 'XL');
INSERT INTO `pms_product_attribute_value` VALUES (10, 7, 1, 'XXL');
INSERT INTO `pms_product_attribute_value` VALUES (11, 22, 7, 'x,xx');
INSERT INTO `pms_product_attribute_value` VALUES (12, 22, 24, 'no110');
INSERT INTO `pms_product_attribute_value` VALUES (13, 22, 25, '春季');
INSERT INTO `pms_product_attribute_value` VALUES (14, 22, 37, '青年');
INSERT INTO `pms_product_attribute_value` VALUES (15, 22, 38, '2018年春');
INSERT INTO `pms_product_attribute_value` VALUES (16, 22, 39, '长袖');
INSERT INTO `pms_product_attribute_value` VALUES (124, 23, 7, '米白色,浅黄色');
INSERT INTO `pms_product_attribute_value` VALUES (125, 23, 24, 'no1098');
INSERT INTO `pms_product_attribute_value` VALUES (126, 23, 25, '春季');
INSERT INTO `pms_product_attribute_value` VALUES (127, 23, 37, '青年');
INSERT INTO `pms_product_attribute_value` VALUES (128, 23, 38, '2018年春');
INSERT INTO `pms_product_attribute_value` VALUES (129, 23, 39, '长袖');
INSERT INTO `pms_product_attribute_value` VALUES (130, 1, 13, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (131, 1, 14, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (132, 1, 15, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (133, 1, 16, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (134, 1, 17, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (135, 1, 18, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (136, 1, 19, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (137, 1, 20, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (138, 1, 21, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (139, 2, 13, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (140, 2, 14, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (141, 2, 15, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (142, 2, 16, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (143, 2, 17, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (144, 2, 18, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (145, 2, 19, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (146, 2, 20, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (147, 2, 21, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (183, 31, 24, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (184, 31, 25, '夏季');
INSERT INTO `pms_product_attribute_value` VALUES (185, 31, 37, '青年');
INSERT INTO `pms_product_attribute_value` VALUES (186, 31, 38, '2018年夏');
INSERT INTO `pms_product_attribute_value` VALUES (187, 31, 39, '短袖');
INSERT INTO `pms_product_attribute_value` VALUES (198, 30, 24, NULL);
INSERT INTO `pms_product_attribute_value` VALUES (199, 30, 25, '夏季');
INSERT INTO `pms_product_attribute_value` VALUES (200, 30, 37, '青年');
INSERT INTO `pms_product_attribute_value` VALUES (201, 30, 38, '2018年夏');
INSERT INTO `pms_product_attribute_value` VALUES (202, 30, 39, '短袖');
INSERT INTO `pms_product_attribute_value` VALUES (203, 26, 43, '金色,银色');
INSERT INTO `pms_product_attribute_value` VALUES (204, 26, 45, '5.0');
INSERT INTO `pms_product_attribute_value` VALUES (205, 26, 46, '4G');
INSERT INTO `pms_product_attribute_value` VALUES (206, 26, 47, 'Android');
INSERT INTO `pms_product_attribute_value` VALUES (207, 26, 48, '3000');
INSERT INTO `pms_product_attribute_value` VALUES (213, 27, 43, '黑色,蓝色');
INSERT INTO `pms_product_attribute_value` VALUES (214, 27, 45, '5.8');
INSERT INTO `pms_product_attribute_value` VALUES (215, 27, 46, '4G');
INSERT INTO `pms_product_attribute_value` VALUES (216, 27, 47, 'Android');
INSERT INTO `pms_product_attribute_value` VALUES (217, 27, 48, '3000ml');
INSERT INTO `pms_product_attribute_value` VALUES (218, 28, 43, '金色,银色');
INSERT INTO `pms_product_attribute_value` VALUES (219, 28, 45, '5.0');
INSERT INTO `pms_product_attribute_value` VALUES (220, 28, 46, '4G');
INSERT INTO `pms_product_attribute_value` VALUES (221, 28, 47, 'Android');
INSERT INTO `pms_product_attribute_value` VALUES (222, 28, 48, '2800ml');
INSERT INTO `pms_product_attribute_value` VALUES (223, 29, 43, '金色,银色');
INSERT INTO `pms_product_attribute_value` VALUES (224, 29, 45, '4.7');
INSERT INTO `pms_product_attribute_value` VALUES (225, 29, 46, '4G');
INSERT INTO `pms_product_attribute_value` VALUES (226, 29, 47, 'IOS');
INSERT INTO `pms_product_attribute_value` VALUES (227, 29, 48, '1960ml');

-- ----------------------------
-- Table structure for pms_product_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category`;
CREATE TABLE `pms_product_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上机分类的编号：0表示一级分类',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(1) NULL DEFAULT NULL COMMENT '分类级别：0->1级；1->2级',
  `product_count` int(11) NULL DEFAULT NULL,
  `product_unit` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nav_status` int(1) NULL DEFAULT NULL COMMENT '是否显示在导航栏：0->不显示；1->显示',
  `show_status` int(1) NULL DEFAULT NULL COMMENT '显示状态：0->不显示；1->显示',
  `sort` int(11) NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `keywords` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品分类' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pms_product_category
-- ----------------------------
INSERT INTO `pms_product_category` VALUES (1, 0, '服装', 0, 100, '件', 1, 1, 1, NULL, '服装', '服装分类');
INSERT INTO `pms_product_category` VALUES (2, 0, '手机数码', 0, 100, '件', 1, 1, 1, NULL, '手机数码', '手机数码');
INSERT INTO `pms_product_category` VALUES (3, 0, '家用电器', 0, 100, '件', 1, 1, 1, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/subject_cate_jiadian.png', '家用电器', '家用电器');
INSERT INTO `pms_product_category` VALUES (4, 0, '家具家装', 0, 100, '件', 1, 1, 1, NULL, '家具家装', '家具家装');
INSERT INTO `pms_product_category` VALUES (5, 0, '汽车用品', 0, 100, '件', 1, 1, 1, NULL, '汽车用品', '汽车用品');
INSERT INTO `pms_product_category` VALUES (7, 1, '外套', 1, 100, '件', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_waitao.png', '外套', '外套');
INSERT INTO `pms_product_category` VALUES (8, 1, 'T恤', 1, 100, '件', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_tshirt.png', 'T恤', 'T恤');
INSERT INTO `pms_product_category` VALUES (9, 1, '休闲裤', 1, 100, '件', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_xiuxianku.png', '休闲裤', '休闲裤');
INSERT INTO `pms_product_category` VALUES (10, 1, '牛仔裤', 1, 100, '件', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_niuzaiku.png', '牛仔裤', '牛仔裤');
INSERT INTO `pms_product_category` VALUES (11, 1, '衬衫', 1, 100, '件', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_chenshan.png', '衬衫', '衬衫分类');
INSERT INTO `pms_product_category` VALUES (13, 12, '家电子分类1', 1, 1, 'string', 0, 1, 0, 'string', 'string', 'string');
INSERT INTO `pms_product_category` VALUES (14, 12, '家电子分类2', 1, 1, 'string', 0, 1, 0, 'string', 'string', 'string');
INSERT INTO `pms_product_category` VALUES (19, 2, '手机通讯', 1, 0, '件', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_shouji.png', '手机通讯', '手机通讯');
INSERT INTO `pms_product_category` VALUES (29, 1, '男鞋', 1, 0, '', 0, 0, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_xie.png', '', '');
INSERT INTO `pms_product_category` VALUES (30, 2, '手机配件', 1, 0, '', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_peijian.png', '手机配件', '手机配件');
INSERT INTO `pms_product_category` VALUES (31, 2, '摄影摄像', 1, 0, '', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_sheying.png', '', '');
INSERT INTO `pms_product_category` VALUES (32, 2, '影音娱乐', 1, 0, '', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_yule.png', '', '');
INSERT INTO `pms_product_category` VALUES (33, 2, '数码配件', 1, 0, '', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_yule.png', '', '');
INSERT INTO `pms_product_category` VALUES (34, 2, '智能设备', 1, 0, '', 1, 1, 0, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20190129/product_cate_zhineng.png', '', '');
INSERT INTO `pms_product_category` VALUES (35, 3, '电视', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (36, 3, '空调', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (37, 3, '洗衣机', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (38, 3, '冰箱', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (39, 3, '厨卫大电', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (40, 3, '厨房小电', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (41, 3, '生活电器', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (42, 3, '个护健康', 1, 0, '', 0, 0, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (43, 4, '厨房卫浴', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (44, 4, '灯饰照明', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (45, 4, '五金工具', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (46, 4, '卧室家具', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (47, 4, '客厅家具', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (48, 5, '全新整车', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (49, 5, '车载电器', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (50, 5, '维修保养', 1, 0, '', 1, 1, 0, '', '', '');
INSERT INTO `pms_product_category` VALUES (51, 5, '汽车装饰', 1, 0, '', 1, 1, 0, '', '', '');

-- ----------------------------
-- Table structure for pms_product_category_attribute_relation
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_category_attribute_relation`;
CREATE TABLE `pms_product_category_attribute_relation`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_category_id` bigint(20) NULL DEFAULT NULL,
  `product_attribute_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pms_product_category_attribute_relation
-- ----------------------------
INSERT INTO `pms_product_category_attribute_relation` VALUES (1, 24, 24);
INSERT INTO `pms_product_category_attribute_relation` VALUES (5, 26, 24);
INSERT INTO `pms_product_category_attribute_relation` VALUES (7, 28, 24);
INSERT INTO `pms_product_category_attribute_relation` VALUES (9, 25, 24);
INSERT INTO `pms_product_category_attribute_relation` VALUES (10, 25, 25);

-- ----------------------------
-- Table structure for pms_product_full_reduction
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_full_reduction`;
CREATE TABLE `pms_product_full_reduction`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `full_price` decimal(10, 2) NULL DEFAULT NULL,
  `reduce_price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品满减表(只针对同商品)' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pms_product_full_reduction
-- ----------------------------
INSERT INTO `pms_product_full_reduction` VALUES (1, 7, 100.00, 20.00);
INSERT INTO `pms_product_full_reduction` VALUES (2, 8, 100.00, 20.00);
INSERT INTO `pms_product_full_reduction` VALUES (3, 9, 100.00, 20.00);
INSERT INTO `pms_product_full_reduction` VALUES (4, 10, 100.00, 20.00);
INSERT INTO `pms_product_full_reduction` VALUES (5, 11, 100.00, 20.00);
INSERT INTO `pms_product_full_reduction` VALUES (6, 12, 100.00, 20.00);
INSERT INTO `pms_product_full_reduction` VALUES (7, 13, 100.00, 20.00);
INSERT INTO `pms_product_full_reduction` VALUES (8, 14, 100.00, 20.00);
INSERT INTO `pms_product_full_reduction` VALUES (9, 18, 100.00, 20.00);
INSERT INTO `pms_product_full_reduction` VALUES (10, 7, 200.00, 50.00);
INSERT INTO `pms_product_full_reduction` VALUES (11, 7, 300.00, 100.00);
INSERT INTO `pms_product_full_reduction` VALUES (14, 22, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (16, 24, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (34, 23, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (44, 31, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (46, 32, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (48, 33, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (53, 36, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (54, 35, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (55, 34, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (56, 30, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (57, 26, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (59, 27, 0.00, 0.00);
INSERT INTO `pms_product_full_reduction` VALUES (60, 28, 500.00, 50.00);
INSERT INTO `pms_product_full_reduction` VALUES (61, 28, 1000.00, 120.00);
INSERT INTO `pms_product_full_reduction` VALUES (62, 29, 0.00, 0.00);

-- ----------------------------
-- Table structure for pms_product_ladder
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_ladder`;
CREATE TABLE `pms_product_ladder`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL COMMENT '满足的商品数量',
  `discount` decimal(10, 2) NULL DEFAULT NULL COMMENT '折扣',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '折后价格',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 68 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品阶梯价格表(只针对同商品)' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pms_product_ladder
-- ----------------------------
INSERT INTO `pms_product_ladder` VALUES (1, 7, 3, 0.70, 0.00);
INSERT INTO `pms_product_ladder` VALUES (2, 8, 3, 0.70, 0.00);
INSERT INTO `pms_product_ladder` VALUES (3, 9, 3, 0.70, 0.00);
INSERT INTO `pms_product_ladder` VALUES (4, 10, 3, 0.70, 0.00);
INSERT INTO `pms_product_ladder` VALUES (5, 11, 3, 0.70, 0.00);
INSERT INTO `pms_product_ladder` VALUES (6, 12, 3, 0.70, 0.00);
INSERT INTO `pms_product_ladder` VALUES (7, 13, 3, 0.70, 0.00);
INSERT INTO `pms_product_ladder` VALUES (8, 14, 3, 0.70, 0.00);
INSERT INTO `pms_product_ladder` VALUES (12, 18, 3, 0.70, 0.00);
INSERT INTO `pms_product_ladder` VALUES (14, 7, 4, 0.60, 0.00);
INSERT INTO `pms_product_ladder` VALUES (15, 7, 5, 0.50, 0.00);
INSERT INTO `pms_product_ladder` VALUES (18, 22, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (20, 24, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (38, 23, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (48, 31, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (50, 32, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (52, 33, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (57, 36, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (58, 35, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (59, 34, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (60, 30, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (61, 26, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (64, 27, 2, 0.80, 0.00);
INSERT INTO `pms_product_ladder` VALUES (65, 27, 3, 0.75, 0.00);
INSERT INTO `pms_product_ladder` VALUES (66, 28, 0, 0.00, 0.00);
INSERT INTO `pms_product_ladder` VALUES (67, 29, 0, 0.00, 0.00);

-- ----------------------------
-- Table structure for pms_sku_stock
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_stock`;
CREATE TABLE `pms_sku_stock`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NULL DEFAULT NULL,
  `sku_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'sku编码',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `stock` int(11) NULL DEFAULT 0 COMMENT '库存',
  `low_stock` int(11) NULL DEFAULT NULL COMMENT '预警库存',
  `sp1` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售属性1',
  `sp2` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sp3` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示图片',
  `sale` int(11) NULL DEFAULT NULL COMMENT '销量',
  `promotion_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '单品促销价格',
  `lock_stock` int(11) NULL DEFAULT 0 COMMENT '锁定库存',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 110 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'sku的库存' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pms_sku_stock
-- ----------------------------
INSERT INTO `pms_sku_stock` VALUES (1, 7, 'string', 100.00, 0, 5, 'string', 'string', 'string', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (2, 8, 'string', 100.00, 0, 5, 'string', 'string', 'string', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (3, 9, 'string', 100.00, 0, 5, 'string', 'string', 'string', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (4, 10, 'string', 100.00, 0, 5, 'string', 'string', 'string', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (5, 11, 'string', 100.00, 0, 5, 'string', 'string', 'string', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (6, 12, 'string', 100.00, 0, 5, 'string', 'string', 'string', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (7, 13, 'string', 100.00, 0, 5, 'string', 'string', 'string', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (8, 14, 'string', 100.00, 0, 5, 'string', 'string', 'string', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (9, 18, 'string', 100.00, 0, 5, 'string', 'string', 'string', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (10, 7, 'string', 0.00, 0, 0, 'string', 'string', 'sp3', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (11, 7, 'string', 0.00, 0, 0, 'string', 'string', 'sp33', 'string', 0, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (12, 22, '111', 99.00, 0, NULL, 'x', 'M', NULL, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (13, 22, '112', 99.00, 0, NULL, 'xx', 'M', NULL, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/2018032614134591_20180326141345650 (4).png', NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (78, 23, '201806070023001', 99.00, 0, NULL, '米白色', 'M', NULL, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (79, 23, '201806070023002', 99.00, 0, NULL, '米白色', 'X', NULL, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/1522738681.jpg', NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (80, 23, '201806070023003', 99.00, 0, NULL, '浅黄色', 'M', NULL, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/2017091716493787_20170917164937650 (1).png', NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (81, 23, '201806070023004', 99.00, 0, NULL, '浅黄色', 'X', NULL, 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180604/2017091716493787_20170917164937650 (1).png', NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (90, 26, '201806070026001', 3788.00, 499, NULL, '金色', '16G', NULL, NULL, NULL, 3588.00, -8);
INSERT INTO `pms_sku_stock` VALUES (91, 26, '201806070026002', 3999.00, 500, NULL, '金色', '32G', NULL, NULL, NULL, 3799.00, 0);
INSERT INTO `pms_sku_stock` VALUES (92, 26, '201806070026003', 3788.00, 500, NULL, '银色', '16G', NULL, NULL, NULL, 3588.00, 0);
INSERT INTO `pms_sku_stock` VALUES (93, 26, '201806070026004', 3999.00, 500, NULL, '银色', '32G', NULL, NULL, NULL, 3799.00, 0);
INSERT INTO `pms_sku_stock` VALUES (98, 27, '201808270027001', 2699.00, 97, NULL, '黑色', '32G', NULL, NULL, NULL, NULL, -24);
INSERT INTO `pms_sku_stock` VALUES (99, 27, '201808270027002', 2999.00, 100, NULL, '黑色', '64G', NULL, NULL, NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (100, 27, '201808270027003', 2699.00, 100, NULL, '蓝色', '32G', NULL, NULL, NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (101, 27, '201808270027004', 2999.00, 100, NULL, '蓝色', '64G', NULL, NULL, NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (102, 28, '201808270028001', 649.00, 99, NULL, '金色', '16G', NULL, NULL, NULL, NULL, -8);
INSERT INTO `pms_sku_stock` VALUES (103, 28, '201808270028002', 699.00, 99, NULL, '金色', '32G', NULL, NULL, NULL, NULL, -8);
INSERT INTO `pms_sku_stock` VALUES (104, 28, '201808270028003', 649.00, 100, NULL, '银色', '16G', NULL, NULL, NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (105, 28, '201808270028004', 699.00, 100, NULL, '银色', '32G', NULL, NULL, NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (106, 29, '201808270029001', 5499.00, 99, NULL, '金色', '32G', NULL, NULL, NULL, NULL, -8);
INSERT INTO `pms_sku_stock` VALUES (107, 29, '201808270029002', 6299.00, 100, NULL, '金色', '64G', NULL, NULL, NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (108, 29, '201808270029003', 5499.00, 100, NULL, '银色', '32G', NULL, NULL, NULL, NULL, 0);
INSERT INTO `pms_sku_stock` VALUES (109, 29, '201808270029004', 6299.00, 100, NULL, '银色', '64G', NULL, NULL, NULL, NULL, 0);

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
INSERT INTO `shop_loop` VALUES ('08482db9741f4ec48acb04876405ca9a00042', '1', 'ffa319d0-1f11-40fd-b380-0e30670472a91_120418114114_7.jpg', 'NORMAL', '2019/08/28 13:21:42', NULL, 1);
INSERT INTO `shop_loop` VALUES ('15829e8ce00b446a84a139bf7bff688100039', '22222232', '692fb61e-795d-474c-b613-4f0bd3ce91480c32d8b0bee481c7d9a62f80249236e3.jpg', 'NORMAL', '2019/08/28 11:34:39', NULL, 2);
INSERT INTO `shop_loop` VALUES ('1fe54fbf6c8340d9ac71e73574aa31ec00010', '11', 'ca5fe70f-d968-4923-8d09-a2d0b092d7521-120p6215453e1.jpg', 'NORMAL', '2019/08/28 13:23:10', NULL, 1);
INSERT INTO `shop_loop` VALUES ('2d6814ad79954865b80830c00ce9061000045', '11', 'c1c2c8e4-95b0-4d82-a593-e8c568a56bdc1_120418114114_3.jpg', 'NORMAL', '2019/08/28 13:25:45', NULL, 11);
INSERT INTO `shop_loop` VALUES ('7374979022734649b2fb2fc1b802b14d00020', '1', '4d40bd04-c411-4ac7-a24e-a049c0610ddf5f280647956f4915855cf38b3e1cd3730004.jpg', 'NORMAL', '2019/08/28 13:27:20', NULL, 1);
INSERT INTO `shop_loop` VALUES ('80f89c160d154e9fbe47e6581ae1383100032', '1', 'fcf0b147-0006-4208-9646-d49185a2170b1_140224140643_4.png', 'NORMAL', '2019/08/28 13:22:32', NULL, 2);
INSERT INTO `shop_loop` VALUES ('9e175e8dff8f46438c2d30e790a5396e00053', '1', '1f6d7531-3e88-4db3-9a40-f6e9a5ad33771_140224140643_4.png', 'NORMAL', '2019/08/28 13:27:53', NULL, 1);

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
  `admin_status` int(5) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`admin_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES (1, 10000, '师奇隆', 'NAN', 27, 'admin', 'admin', '17621663876', 'jack1053996819@163.com', 'ADMIN', 'admin', NULL, 'admin', '2019/08/19 00:00:00', '2019/08/19 16:10:35', 1);
INSERT INTO `sys_admin` VALUES (2, 152068, '100001', 'NAN', 12, '123', '456', '1234343434243', '233432435', '1', '2113213', NULL, 'admin', '2019/08/20 09:09:42', '2019/08/20 09:09:42', 1);
INSERT INTO `sys_admin` VALUES (3, 125575, '2c34q', 'NAN', 11, '12', '12', '121212', '12121212', '1', '1212', NULL, 'admin', '2019/08/20 09:57:06', '2019/08/20 09:57:06', 1);
INSERT INTO `sys_admin` VALUES (4, 185168, '100001', 'NAN', 111, '111', '111', '111', '111', '3', '111', NULL, '111', '2019/08/20 09:57:58', '2019/08/20 09:57:58', 1);
INSERT INTO `sys_admin` VALUES (5, 106881, '100001', 'NAN', 1111, '1111', '1111', '1111', '1111', '2', '1111', NULL, '1111', '2019/08/20 11:32:24', '2019/08/20 11:32:24', 1);
INSERT INTO `sys_admin` VALUES (6, 137617, '111', 'BM', 222, '222', '222', '222', '222', NULL, NULL, NULL, '111', '2019/08/20 11:36:41', '2019/08/20 11:36:41', 1);
INSERT INTO `sys_admin` VALUES (7, 101081, '111', 'BM', 222, '222', '222', '222', '222', NULL, NULL, NULL, '222', '2019/08/20 11:38:37', '2019/08/20 11:38:37', 1);
INSERT INTO `sys_admin` VALUES (8, 164803, '333', 'BM', 333, '333', '333', '333', '333', NULL, NULL, NULL, '333', '2019/08/20 11:40:04', '2019/08/20 11:40:04', 2);

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
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` int(10) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept_createtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept_updatetime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dept_status` int(5) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`dept_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 'ADMIN', 'ADMIN', '2019/08/20 16:18:33', '2019/08/20 16:18:33', 1);
INSERT INTO `sys_dept` VALUES (2, '技术部', 'JISHUBU', '2019/08/20 16:24:13', '2019/08/20 16:24:13', 1);

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
-- Table structure for sys_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_login`;
CREATE TABLE `sys_login`  (
  `login_id` int(10) NOT NULL AUTO_INCREMENT,
  `login_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_status` int(5) NULL DEFAULT NULL,
  `login_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_code` int(10) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`login_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_login
-- ----------------------------
INSERT INTO `sys_login` VALUES (1, '127.0.0.1', 'admin', '成都', 1, '2019/08/20 00：00：00', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (2, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/20 17:59:32', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (3, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/20 18:00:33', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (4, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/21 10:51:30', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (5, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/22 17:23:26', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (6, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/23 15:08:05', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (7, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/23 15:29:11', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (8, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/23 16:17:57', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (9, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/23 16:20:40', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (10, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 10:01:42', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (11, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 10:57:53', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (12, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 10:57:55', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (13, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 11:28:08', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (14, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 12:50:31', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (15, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 12:58:37', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (16, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 13:33:53', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (17, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 13:33:53', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (18, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 13:41:53', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (19, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 13:41:53', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (20, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 13:55:13', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (21, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 13:59:41', 'ADMIN', 10000);
INSERT INTO `sys_login` VALUES (22, '127.0.0.1', '师奇隆', '成都', 1, '2019/08/28 14:09:59', 'ADMIN', 10000);

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
) ENGINE = InnoDB AUTO_INCREMENT = 131 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, 'index_home.html', 'iconfont icon-home', '系统首页');
INSERT INTO `sys_menu` VALUES (2, 0, '', 'iconfont icon-yonghuguanli', '系统管理');
INSERT INTO `sys_menu` VALUES (3, 0, '', 'iconfont icon-users', '用户管理');
INSERT INTO `sys_menu` VALUES (4, 0, '', 'iconfont icon-iconsp2', '产品管理');
INSERT INTO `sys_menu` VALUES (5, 0, '', 'iconfont icon-suoshuzhiwei', '交易管理');
INSERT INTO `sys_menu` VALUES (6, 0, '', 'iconfont icon-xiangmuguanli', '支付管理');
INSERT INTO `sys_menu` VALUES (7, 0, '', 'iconfont icon-usergroup', '会员管理');
INSERT INTO `sys_menu` VALUES (8, 0, '', 'iconfont icon-guanggao', '广告管理');
INSERT INTO `sys_menu` VALUES (9, 0, '', 'iconfont icon-system-copy', '框架说明');
INSERT INTO `sys_menu` VALUES (10, 0, '', 'iconfont icon-dianpu', '店铺管理');
INSERT INTO `sys_menu` VALUES (11, 0, '', 'iconfont icon-department', '统计分析');
INSERT INTO `sys_menu` VALUES (100, 2, NULL, NULL, '菜单管理');
INSERT INTO `sys_menu` VALUES (101, 2, 'system_info.html', '', '系统设置');
INSERT INTO `sys_menu` VALUES (102, 2, 'system_info.html', '', '配置管理');
INSERT INTO `sys_menu` VALUES (103, 3, 'userinfo.html?userid=1', '', '个人信息');
INSERT INTO `sys_menu` VALUES (104, 3, 'loginHistory.html', '', '登录记录');
INSERT INTO `sys_menu` VALUES (105, 3, 'dept.html', '', '部门管理');
INSERT INTO `sys_menu` VALUES (106, 3, 'role.html', '', '角色管理');
INSERT INTO `sys_menu` VALUES (107, 3, 'position.html', '', '职位管理');
INSERT INTO `sys_menu` VALUES (108, 3, 'administrator.html', '', '系统用户');
INSERT INTO `sys_menu` VALUES (109, 4, 'product_Manage.html?id=0', '', '商品管理');
INSERT INTO `sys_menu` VALUES (110, 4, 'Brand_Manage.html', '', '品牌管理');
INSERT INTO `sys_menu` VALUES (111, 4, 'classify.html', '', '分类管理');
INSERT INTO `sys_menu` VALUES (112, 5, 'order_list.html', '', '订单列表');
INSERT INTO `sys_menu` VALUES (113, 5, 'delivery_list.html', '', '发货管理');
INSERT INTO `sys_menu` VALUES (114, 5, 'wuliu.html', '', '快递物流');
INSERT INTO `sys_menu` VALUES (115, 6, 'defray.html', '', '支付设置');
INSERT INTO `sys_menu` VALUES (116, 6, 'defray_type.html', '', '支付类型');
INSERT INTO `sys_menu` VALUES (117, 7, 'member.html', '', '会员列表');
INSERT INTO `sys_menu` VALUES (118, 7, 'member.html', '', '会员等级');
INSERT INTO `sys_menu` VALUES (119, 7, 'member.html', '', '收货地址');
INSERT INTO `sys_menu` VALUES (120, 8, 'advertise.html', '', '广告管理');
INSERT INTO `sys_menu` VALUES (121, 9, 'rizhi_list.html', '', '字体库');
INSERT INTO `sys_menu` VALUES (122, 9, 'explanation.html', '', '结构说明');
INSERT INTO `sys_menu` VALUES (123, 9, 'module.html', '', '模块说明');
INSERT INTO `sys_menu` VALUES (124, 10, 'shopinfo.html', '', '店铺信息');
INSERT INTO `sys_menu` VALUES (125, 11, 'product_statistics.html', '', '交易统计');
INSERT INTO `sys_menu` VALUES (126, 11, 'product_statistics.html', '', '商品统计');
INSERT INTO `sys_menu` VALUES (127, 11, 'product_statistics.html', '', '品牌统计');
INSERT INTO `sys_menu` VALUES (128, 2, 'http://localhost:8080/druid/index.html', NULL, '网站数据源监控');
INSERT INTO `sys_menu` VALUES (129, 2, 'http://localhost:8000/druid/index.html', NULL, '后台数据源监控');
INSERT INTO `sys_menu` VALUES (130, 4, 'product_loop.html?id=0', NULL, '轮播图管理');

-- ----------------------------
-- Table structure for sys_position
-- ----------------------------
DROP TABLE IF EXISTS `sys_position`;
CREATE TABLE `sys_position`  (
  `position_id` int(10) NOT NULL AUTO_INCREMENT,
  `position_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position_createtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position_updatetime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position_status` int(5) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`position_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_position
-- ----------------------------
INSERT INTO `sys_position` VALUES (1, 'KEFU', '客服', '2019/08/20 17:11:39', '2019/08/20 17:11:39', 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_createtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_updatetime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_status` int(5) NULL DEFAULT NULL,
  PRIMARY KEY USING BTREE (`role_id`)
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'ADMIN', '超级管理员', '2019/08/20 17:04:11', '2019/08/20 17:04:11', 1);
INSERT INTO `sys_role` VALUES (2, 'SYSADMIN', '系统管理员', '2019/08/20 17:04:12', '2019/08/20 17:04:12', 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of table_file
-- ----------------------------
INSERT INTO `table_file` VALUES (8, '02adb54ce26145c69f0cc7e00cb691220002.jpg', '20190829/', 'jpg', '347546byte', '.jpg', '27259137-2e03-4898-a1cc-0d86e4c01c6802adb54ce26145c69f0cc7e00cb691220002.jpg', '2019/08/29 12:21:33', '今天天气不错', 'ilonw', '1', '2019/08/29 12:21:33', '1000000695598649');
INSERT INTO `table_file` VALUES (9, 'Belvita 焙朗 - 早餐饼 - 兔子篇.mp4', ':\\ilonw\\apache-tomcat-8888\\webapps\\upload\\20190829/Belvita 焙朗 - 早餐饼 - 兔子篇.mp4', 'mp4', '4.01MB', '.mp4', 'dc6da086-530e-4abc-ae18-40dc6d70e94fBelvita 焙朗 - 早餐饼 - 兔子篇.mp4', '2019/08/29 17:06:39', '', 'ilonw', '1', '2019/08/29 17:06:39', '1000000751591890');

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

SET FOREIGN_KEY_CHECKS = 1;
