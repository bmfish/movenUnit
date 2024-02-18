/*
 Navicat Premium Data Transfer

 Source Server         : jdyuntest
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : 116.196.96.64:3306
 Source Schema         : wc

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 18/02/2024 13:04:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_wc_daily_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_wc_daily_detail`;
CREATE TABLE `t_wc_daily_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_id` bigint(24) NULL DEFAULT NULL,
  `amount` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rec_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rec_com` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6915 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
