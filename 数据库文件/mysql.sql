-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: leetcode
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `leet_code_problem`
--

DROP TABLE IF EXISTS `leet_code_problem`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leet_code_problem`
(
    `id`          int NOT NULL AUTO_INCREMENT COMMENT '题目id',
    `no`          varchar(10) DEFAULT NULL COMMENT '题目编号',
    `name`        varchar(25) DEFAULT NULL COMMENT '题目标题',
    `description` text COMMENT '题目描述',
    `pass_rate`   varchar(20) DEFAULT NULL COMMENT '题目通过率',
    `level`       varchar(25) DEFAULT NULL COMMENT '题目难度等级',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    `deleted`     varchar(30) DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='力扣题目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leet_code_problem`
--

LOCK TABLES `leet_code_problem` WRITE;
/*!40000 ALTER TABLE `leet_code_problem`
    DISABLE KEYS */;
INSERT INTO `leet_code_problem`
VALUES (1, '1', '题目一', '题目一描述', '50', '3', '2022-11-05 15:48:47.000', '2022-11-05 15:49:46.000', '0'),
       (2, '2', '题目二', '题目二描述', '30', '2', '2022-11-05 15:50:13.000', '2022-11-05 15:50:15.000', '0');
/*!40000 ALTER TABLE `leet_code_problem`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leet_code_solution`
--

DROP TABLE IF EXISTS `leet_code_solution`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leet_code_solution`
(
    `id`               int NOT NULL AUTO_INCREMENT COMMENT '题解id',
    `problem_id`       varchar(10) DEFAULT NULL COMMENT '题目id',
    `problem_solution` text COMMENT '解题代码',
    `solution_author`  varchar(40) DEFAULT NULL COMMENT '解题人',
    `create_time`      datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '首次提交解题时间',
    `update_time`      datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新答案时间',
    `deleted`          varchar(30) DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='力扣题解';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leet_code_solution`
--

LOCK TABLES `leet_code_solution` WRITE;
/*!40000 ALTER TABLE `leet_code_solution`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `leet_code_solution`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role`
(
    `id`          mediumtext COMMENT '角色Id',
    `name`        varchar(25) DEFAULT NULL COMMENT '角色名称',
    `code`        varchar(25) DEFAULT NULL COMMENT '角色code',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    `deleted`     varchar(30) DEFAULT '0'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role`
    DISABLE KEYS */;
INSERT INTO `role`
VALUES ('1', '管理员', 'admin', '2022-11-26 10:43:43.398', '2022-11-26 10:43:43.398', '0'),
       ('2', '普通用户', 'normal_user', '2022-11-26 10:43:43.410', '2022-11-26 10:43:43.410', '0'),
       ('3', '尊贵用户', 'vip_user', '2022-11-26 10:43:43.420', '2022-11-26 10:43:43.420', '0');
/*!40000 ALTER TABLE `role`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user`
(
    `id`          mediumtext COMMENT '主键id',
    `user_name`   varchar(25) DEFAULT NULL COMMENT '用户名',
    `real_name`   varchar(25) DEFAULT NULL COMMENT '真实2姓名',
    `phone`       varchar(11) DEFAULT NULL COMMENT '手机号',
    `password`    varchar(25) DEFAULT NULL COMMENT '密码',
    `role_ids`    varchar(40) DEFAULT NULL COMMENT '关联角色id列表',
    `province`    varchar(10) DEFAULT NULL COMMENT '省份',
    `city`        varchar(10) DEFAULT NULL COMMENT '市',
    `county`      varchar(10) DEFAULT NULL COMMENT '区',
    `create_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
    `update_time` datetime(3) DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '更新时间',
    `deleted`     varchar(30) DEFAULT '0' COMMENT '是否删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user`
    DISABLE KEYS */;
INSERT INTO `user`
VALUES ('1595303332723654657', '帅哥', '陈一', '13100000000', '123456789', '1,2,3', '湖北', '武汉', '蔡甸',
        '2022-11-23 14:28:48.510', '2022-11-26 11:13:57.374', '0'),
       ('1595979978342486017', '123', '123', '123', '123', '1', '123', '123', '123', '2022-11-25 11:17:33.394',
        '2022-11-26 11:13:57.363', '0'),
       ('1596340874801963010', '1234', '123', '123', '123', '1', '123', '123', '123', '2022-11-26 11:11:37.806',
        '2022-11-26 11:11:37.806', '0'),
       ('1596534928391053313', 'test', '456', '13100000001', 'asdasdqwe', '1', '123', '123', '123',
        '2022-11-27 00:02:43.773', '2022-11-27 00:25:58.212', '2022-11-27 00:25:58');
/*!40000 ALTER TABLE `user`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2022-11-27  0:27:42
