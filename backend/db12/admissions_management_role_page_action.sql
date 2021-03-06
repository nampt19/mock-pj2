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
-- Table structure for table `role_page_action`
--

DROP TABLE IF EXISTS `role_page_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role_page_action` (
  `id_role_page_action` int NOT NULL AUTO_INCREMENT,
  `id_role` int NOT NULL,
  `id_page` int NOT NULL,
  `id_action` int NOT NULL,
  PRIMARY KEY (`id_role_page_action`),
  UNIQUE KEY `id_UNIQUE` (`id_role_page_action`),
  KEY `id_role_fk_idx` (`id_role`),
  KEY `id_page_fk_idx` (`id_page`),
  KEY `id_action_fk_idx` (`id_action`),
  CONSTRAINT `id_action_fk` FOREIGN KEY (`id_action`) REFERENCES `action` (`id_action`),
  CONSTRAINT `id_page_fk` FOREIGN KEY (`id_page`) REFERENCES `page` (`id_page`),
  CONSTRAINT `id_role_fk01` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=269 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_page_action`
--

LOCK TABLES `role_page_action` WRITE;
/*!40000 ALTER TABLE `role_page_action` DISABLE KEYS */;
INSERT INTO `role_page_action` VALUES (1,1,1,4),(2,1,3,1),(3,1,3,2),(4,1,3,3),(5,1,3,4),(6,1,4,1),(7,1,4,2),(8,1,4,3),(9,1,4,4),(16,3,1,4),(17,3,4,1),(18,3,4,2),(19,3,4,4),(20,3,8,4),(21,1,6,1),(22,1,6,2),(23,1,6,3),(24,1,6,4),(41,1,10,1),(42,1,10,2),(43,1,10,3),(44,1,10,4),(46,3,10,4),(47,1,4,5),(48,1,5,1),(49,1,5,2),(50,1,5,3),(51,1,5,4),(52,1,3,5),(68,29,5,4),(69,29,5,1),(70,29,5,2),(71,29,10,4),(72,29,10,1),(73,29,10,2),(116,1,4,6),(117,1,11,1),(118,1,11,4),(245,2,8,4),(246,2,8,1),(247,2,8,2),(248,2,4,4),(249,2,4,1),(250,2,4,2),(251,2,4,6),(252,2,5,4),(253,2,5,1),(254,2,5,2),(255,2,10,4),(256,2,10,1),(257,2,10,2),(258,2,11,4),(259,2,11,1),(260,32,4,4),(261,32,4,1),(262,32,10,4),(263,32,10,2),(264,32,11,4),(265,32,11,1);
/*!40000 ALTER TABLE `role_page_action` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-04 13:46:55
