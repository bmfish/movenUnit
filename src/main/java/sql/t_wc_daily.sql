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

 Date: 18/02/2024 13:02:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_wc_daily
-- ----------------------------
DROP TABLE IF EXISTS `t_wc_daily`;
CREATE TABLE `t_wc_daily`  (
  `date_id` bigint(24) NULL DEFAULT NULL,
  `in_come` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `in_come_amount` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `out_go` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `out_go_amount` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flow_size` int(10) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `date` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1784 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
