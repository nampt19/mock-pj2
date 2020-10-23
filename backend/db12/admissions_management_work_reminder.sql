-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: admissions_management
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `work_reminder`
--

DROP TABLE IF EXISTS `work_reminder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_reminder` (
  `id_reminder` int NOT NULL AUTO_INCREMENT,
  `id_customer` int NOT NULL,
  `title` varchar(150) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `done` tinyint(1) NOT NULL,
  `user_name` varchar(450) NOT NULL,
  PRIMARY KEY (`id_reminder`),
  KEY `pk_customer_reminder_idx` (`id_customer`),
  KEY `pk_user_reminer_idx` (`user_name`),
  CONSTRAINT `pk_customer_reminder` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`),
  CONSTRAINT `pk_user_reminder` FOREIGN KEY (`user_name`) REFERENCES `user` (`username`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_reminder`
--

LOCK TABLES `work_reminder` WRITE;
/*!40000 ALTER TABLE `work_reminder` DISABLE KEYS */;
INSERT INTO `work_reminder` VALUES (5,3,'Gọi lại cho khách','2020-08-22 12:23:12','Gọi điện tư vấn khóa học Node JS vào tối nay 7p.m',1,'Lan'),(21,2,'Gặp mặt khách hàng ','2020-08-31 14:21:31','\"Tiệm gà rán bang Ken Tấc Ky\" giới thiệu khóa học full-stack js',0,'Dung123'),(25,3,'Gặp mặt khách hàng ','2020-08-31 15:26:24','\"Ngôi nhà cafe HTM\" giới thiệu khóa học full-stack js',0,'Dung123'),(28,2,'Gọi khách hàng ','2020-08-31 15:36:29','Không say không pay :<',0,'Dung123'),(30,2,'Gặp mặt khách hàng ','2020-08-31 15:39:56','\"Ngôi nhà cafe HTM\" giới thiệu khóa học full-stack js',1,'Dung123'),(35,1,'Gặp mặt khách hàng ','2020-08-31 16:15:44','\"Ngôi nhà cafe HTM\" giới thiệu khóa học full-stack js',1,'Dung123'),(36,1,'Gặp mặt khách hàng ','2020-08-31 16:26:31','\"Ngôi nhà cafe HTM\" giới thiệu khóa học full-stack js',1,'Dung123'),(38,1,'Gọi khách hàng ','2020-08-31 16:37:47','Quán gà hương vị Ken Tấc Ki được tạo ra bởi any thing solution and server',0,'Lan'),(39,1,'Gặp mặt khách hàng ','2020-08-31 16:37:47','\"Ngôi nhà cafe HTM\" giới thiệu khóa học full-stack js',0,'Lan');
/*!40000 ALTER TABLE `work_reminder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-04 13:46:54
