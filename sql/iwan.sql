/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.23 : Database - epidemic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`epidemic` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `epidemic`;

/*Table structure for table `epideic_category` */

DROP TABLE IF EXISTS `epideic_category`;

CREATE TABLE `epideic_category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '上级类id',
  `category_name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '类名',
  `is_delete` tinyint DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_time` decimal(10,0) DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `epideic_category` */

/*Table structure for table `epidemic_case` */

DROP TABLE IF EXISTS `epidemic_case`;

CREATE TABLE `epidemic_case` (
  `case_id` bigint NOT NULL AUTO_INCREMENT COMMENT '病例id',
  `patient_id` bigint NOT NULL COMMENT '患者id',
  `illness_id` bigint NOT NULL COMMENT '病id',
  `infected_region_id` bigint NOT NULL DEFAULT '0' COMMENT '感染地区id',
  `infected_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '感染详细地址',
  `is_cure` tinyint NOT NULL DEFAULT '0' COMMENT '是否治愈（0否 1是）',
  `is_hosp` tinyint NOT NULL DEFAULT '0' COMMENT '是否住院（0否 1是）',
  `is_die` tinyint NOT NULL DEFAULT '0' COMMENT '是否死亡（0否 1是）',
  `infect_time` datetime DEFAULT NULL COMMENT '感染时间',
  `cure_time` datetime DEFAULT NULL COMMENT '治愈时间',
  `is_delete` tinyint(3) unsigned zerofill NOT NULL DEFAULT '000' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`case_id`,`patient_id`,`illness_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `epidemic_case` */

/*Table structure for table `epidemic_case_hospital` */

DROP TABLE IF EXISTS `epidemic_case_hospital`;

CREATE TABLE `epidemic_case_hospital` (
  `case_hospital_id` bigint NOT NULL AUTO_INCREMENT COMMENT '病例医院id',
  `case_id` bigint NOT NULL COMMENT '病例id',
  `hospital_id` bigint NOT NULL COMMENT '医院id',
  `visit_time` int NOT NULL DEFAULT '0' COMMENT '看病次数',
  `number` int NOT NULL DEFAULT '0' COMMENT '第几个去的医院',
  `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创见者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`case_hospital_id`,`case_id`,`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `epidemic_case_hospital` */

/*Table structure for table `epidemic_history` */

DROP TABLE IF EXISTS `epidemic_history`;

CREATE TABLE `epidemic_history` (
  `patient_id` bigint NOT NULL COMMENT '病人id',
  `illness_id` bigint NOT NULL COMMENT '病id（病史未登记）',
  PRIMARY KEY (`patient_id`,`illness_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `epidemic_history` */

/*Table structure for table `epidemic_hospital` */

DROP TABLE IF EXISTS `epidemic_hospital`;

CREATE TABLE `epidemic_hospital` (
  `hospital_id` bigint NOT NULL AUTO_INCREMENT COMMENT '医院id',
  `hospital_name` varchar(50) NOT NULL DEFAULT '' COMMENT '医院名称',
  `establish_region_id` bigint NOT NULL DEFAULT '0' COMMENT '地区id',
  `estabilsh_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '详细地址',
  `is_public` tinyint NOT NULL DEFAULT '0' COMMENT '是否公立（0是 1否）',
  `president` varchar(30) NOT NULL DEFAULT '' COMMENT '院长',
  `level` varchar(50) NOT NULL DEFAULT '' COMMENT '医院等级',
  `type` varchar(50) NOT NULL DEFAULT '' COMMENT '医院类型',
  `establish_time` datetime DEFAULT NULL COMMENT '建立时间',
  `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(30) NOT NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) NOT NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`hospital_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `epidemic_hospital` */

/*Table structure for table `epidemic_illness` */

DROP TABLE IF EXISTS `epidemic_illness`;

CREATE TABLE `epidemic_illness` (
  `illness_id` bigint NOT NULL AUTO_INCREMENT COMMENT '病id',
  `illness_name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '病名',
  `catrgory_id` bigint NOT NULL DEFAULT '0' COMMENT '所属类id',
  `symptom` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '症状描述',
  `pathogeny` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '病原描述',
  `ponderance` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '严重性描述',
  `is_fectious` tinyint NOT NULL DEFAULT '0' COMMENT '是否传染（0否 1是）',
  `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `craeted_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`illness_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `epidemic_illness` */

/*Table structure for table `epidemic_omplication` */

DROP TABLE IF EXISTS `epidemic_omplication`;

CREATE TABLE `epidemic_omplication` (
  `complication_id` bigint NOT NULL COMMENT '并发症id',
  `infectious_id` bigint NOT NULL COMMENT '传染病id（引发）',
  PRIMARY KEY (`complication_id`,`infectious_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `epidemic_omplication` */

/*Table structure for table `epidemic_patient` */

DROP TABLE IF EXISTS `epidemic_patient`;

CREATE TABLE `epidemic_patient` (
  `patient_id` bigint NOT NULL AUTO_INCREMENT COMMENT '病人id',
  `patient_name` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `avatar` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '照片',
  `height` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '身高（cm 0为没数据）',
  `weight` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '体重（kg 0为没数据）',
  `fat` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '体脂率（0为没数据）',
  `phone` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '电话',
  `live_region_id` bigint NOT NULL DEFAULT '0' COMMENT '住址地区id',
  `live_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '详细地址',
  `birth_time` datetime DEFAULT NULL COMMENT '出生日期',
  `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(30) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `epidemic_patient` */

/*Table structure for table `epidemic_sequelae` */

DROP TABLE IF EXISTS `epidemic_sequelae`;

CREATE TABLE `epidemic_sequelae` (
  `sequelae_id` bigint NOT NULL COMMENT '后遗症id',
  `infectious_id` bigint NOT NULL COMMENT '传染病id（引发）',
  PRIMARY KEY (`sequelae_id`,`infectious_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `epidemic_sequelae` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
