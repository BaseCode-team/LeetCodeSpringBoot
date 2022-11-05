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
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `leet_code_problem`
--

DROP TABLE IF EXISTS `leet_code_problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leet_code_problem` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `no` int DEFAULT NULL COMMENT '题目编号',
  `name` varchar(25) DEFAULT NULL COMMENT '题目标题',
  `description` text COMMENT '题目描述',
  `pass_rate` varchar(20) DEFAULT NULL COMMENT '题目通过率',
  `level` int DEFAULT NULL COMMENT '题目难度等级',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='力扣题目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leet_code_problem`
--

LOCK TABLES `leet_code_problem` WRITE;
/*!40000 ALTER TABLE `leet_code_problem` DISABLE KEYS */;
INSERT INTO `leet_code_problem` VALUES (1,1,'题目一','题目一描述','50',3,'2022-11-05 15:48:47','2022-11-05 15:49:46'),(2,2,'题目二','题目二描述','30',2,'2022-11-05 15:50:13','2022-11-05 15:50:15');
/*!40000 ALTER TABLE `leet_code_problem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leet_code_solution`
--

DROP TABLE IF EXISTS `leet_code_solution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leet_code_solution` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '题解id',
  `problem_id` int DEFAULT NULL COMMENT '题目id',
  `problem_solution` text COMMENT '解题代码',
  `solution_author` varchar(40) DEFAULT NULL COMMENT '解题人',
  `create_time` datetime DEFAULT NULL COMMENT '首次提交解题时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新答案时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='力扣题解';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leet_code_solution`
--

LOCK TABLES `leet_code_solution` WRITE;
/*!40000 ALTER TABLE `leet_code_solution` DISABLE KEYS */;
/*!40000 ALTER TABLE `leet_code_solution` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-05 15:57:26
