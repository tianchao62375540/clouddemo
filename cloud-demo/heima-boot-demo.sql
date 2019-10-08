/*
 Navicat Premium Data Transfer

 Source Server         : windowMysql
 Source Server Type    : MySQL
 Source Server Version : 50617
 Source Host           : localhost:3306
 Source Schema         : heima-boot-demo

 Target Server Type    : MySQL
 Target Server Version : 50617
 File Encoding         : 65001

 Date: 08/10/2019 22:32:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓名',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别 1：男  2：女',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `created` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `updated` datetime(6) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'tianchao', '123456', '田超', 22, 1, '2019-09-30', '22xxx', '2019-09-30 23:02:56.000000', '2019-09-30 23:02:59.000000');
INSERT INTO `tb_user` VALUES (2, 'tom_123456', '123456', 'Tom', 12, 1, '2019-10-01', 'xxxxxxdsadasdasdsad', '2019-10-01 14:10:43.977000', '2019-10-01 14:10:43.977000');
INSERT INTO `tb_user` VALUES (3, 'tom_123456', '123456', 'Tom', 12, 1, '2019-10-01', NULL, '2019-10-01 14:11:44.374000', '2019-10-01 14:11:44.374000');

SET FOREIGN_KEY_CHECKS = 1;
