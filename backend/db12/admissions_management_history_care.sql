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
-- Table structure for table `history_care`
--

DROP TABLE IF EXISTS `history_care`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history_care` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_customer` int NOT NULL,
  `end_time` datetime NOT NULL,
  `start_time` datetime NOT NULL,
  `concern_level` varchar(45) NOT NULL,
  `note` varchar(1225) DEFAULT NULL,
  `potential_level` varchar(45) DEFAULT NULL,
  `action` varchar(45) DEFAULT NULL,
  `method` varchar(45) DEFAULT NULL,
  `purpose` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(450) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_customer_fk_idx` (`id_customer`),
  KEY `id_product_fk_hc_idx` (`product_name`),
  KEY `pk_user_history_care_idx` (`user_name`),
  CONSTRAINT `id_customer_fk` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`),
  CONSTRAINT `pk_user_history_care` FOREIGN KEY (`user_name`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_care`
--

LOCK TABLES `history_care` WRITE;
/*!40000 ALTER TABLE `history_care` DISABLE KEYS */;
INSERT INTO `history_care` VALUES (1,1,'2020-09-10 08:12:12','2020-09-10 08:12:12','Good','oke','diamon','call','phone','introduce product','Node js','Lan'),(2,2,'2020-09-10 09:16:12','2020-09-10 09:16:12','Average','dont need','gold','text','zalo','introduce product','Frontent','Lan'),(3,3,'2020-10-09 10:34:12','2020-10-09 10:34:12','Poor','may be','platium','call','phone','answer question','Full stack java','Lan'),(4,4,'2020-10-11 11:24:46','2020-10-11 11:24:46','Good','oke','normal',NULL,NULL,'introduce product','PHP','Lan'),(5,1,'2020-09-12 08:12:12','2020-09-12 09:12:12','Good','oke','diamon',NULL,NULL,'answer question','Node js','Lan'),(6,1,'2020-08-13 11:00:45','2020-08-08 10:00:39','Excellent','Good Use bd border-radius of an element. Great for images, buttons, or                       any other element border-radius of an element. Great for                       images, buttons, or.',NULL,'meet again','Phone','Intro product','Java Backend','Okio Sami'),(7,1,'2020-08-31 11:00:38','2020-08-31 10:00:36','Good','Good Useand border-radius of an element. Great for images, buttons, or                       any other element border-radius of an element. Great for                       images, buttons, or.',NULL,'meet again','Text','Intro product','Java Backend','Okio Sami'),(8,1,'2020-08-31 12:00:58','2020-08-07 11:00:56','Poor','Good Use border utilities r-radius of an element. Great for images, buttons, or                       any other element border-radius of an element. Great for                       images, buttons, or.',NULL,'meet again','Phone','Intro product','JS full','Okio Sami'),(9,1,'2020-08-19 13:00:12','2020-08-12 13:00:09','Excellent','Good Use border utilities to quickly style the border and ',NULL,'meet again','Phone','Intro product','JS full','Okio Sami'),(10,1,'2020-08-21 10:37:23','2020-08-19 10:37:19','Good','Good Use border utilities to quickly style the border and  ',NULL,'meet again','Phone','Intro product','JS full','Manh'),(11,1,'2020-08-31 13:00:28','2020-08-31 12:00:26','Average','Good Use bd border-radius of an element. Great for images, buttons, or  Good Use bd border-radius of an element. Great for images, buttons, or  Good Use bd border-radius of an element. Great for images, buttons, or  Good Use bd border-radius of an element. Great for images, buttons, or                       any other element border-radius of an element. Great for                       images, buttons, or.',NULL,'call again','Meet','Intro product','JS full','Manh'),(12,1,'2020-08-31 16:00:38','2020-08-31 16:00:36','Poor','Good Useand border-radius of an element. Great for images, buttons, or                       any other element border-radius of an element. Great for                       images, buttons, or.',NULL,'meet again','Text','Intro product','JS full','Lan'),(13,1,'2020-08-31 18:00:24','2020-08-31 17:00:22','Average','Good Useand border-radius of an element. Great for images, buttons, or                       any other element border-radius of an element. Great for                       images, buttons, or.',NULL,'meet again','Another','Intro product','JS full','Dung123'),(14,1,'2020-08-31 20:00:19','2020-08-31 16:00:17','Excellent','Good Use border utilities to quickly style the border and  ',NULL,'none ddd','Text','Intro product','JS full','Dung123'),(15,3,'2020-08-31 17:00:28','2020-08-31 16:00:27','Excellent','Good Useand border-radius of an element. Great for images, buttons, or                       any other element border-radius of an element. Great for                       images, buttons, or.',NULL,'meet again','Text','Intro product','JS full','Dung123'),(18,1,'2020-09-05 09:00:47','2020-09-04 09:00:44','Excellent','1111',NULL,'sdaf','Phone','asdfjksad;lf','sadfsdf','ABC ABC');
/*!40000 ALTER TABLE `history_care` ENABLE KEYS */;
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
