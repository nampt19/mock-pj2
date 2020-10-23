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
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id_deal` int NOT NULL AUTO_INCREMENT,
  `id_customer` int NOT NULL,
  `id_user` int NOT NULL,
  `transaction_time` datetime NOT NULL,
  `id_product` int NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `note` varchar(1145) DEFAULT NULL,
  PRIMARY KEY (`id_deal`),
  UNIQUE KEY `iddeal_UNIQUE` (`id_deal`),
  KEY `id_user_idx` (`id_user`),
  KEY `id_customer_idx` (`id_customer`),
  KEY `id_product_fk_t_idx` (`id_product`),
  CONSTRAINT `id_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`),
  CONSTRAINT `id_product_fk_t` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`),
  CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,1,4,'2020-09-01 08:21:18',1,'Đang thanh toán','ok'),(2,2,5,'2020-08-31 18:04:12',2,'Đã hủy','sadfsdafsfd'),(3,3,6,'2020-08-19 16:23:06',3,NULL,NULL),(4,4,4,'2020-08-19 09:12:59',4,NULL,NULL),(5,5,5,'2020-08-19 05:34:34',1,NULL,NULL),(6,6,3,'2020-08-19 06:54:35',2,NULL,NULL),(7,7,4,'2020-08-19 07:32:38',3,NULL,NULL),(8,8,3,'2020-08-19 08:24:02',4,NULL,NULL),(9,9,6,'2020-08-19 09:57:08',1,NULL,NULL),(10,10,5,'2020-09-01 08:38:09',2,NULL,''),(11,9,4,'2020-08-31 18:04:59',3,'Đã thanh toán',''),(12,1,4,'2020-08-19 11:28:34',4,NULL,NULL),(13,4,5,'2020-08-19 11:28:34',1,NULL,NULL),(14,5,6,'2020-08-19 11:28:34',2,NULL,NULL),(15,2,3,'2020-08-19 11:28:34',3,NULL,NULL),(16,6,5,'2020-08-19 11:28:34',4,NULL,NULL),(17,3,4,'2020-08-19 11:28:34',1,NULL,NULL),(18,3,4,'2020-08-19 11:28:34',2,NULL,NULL),(19,8,4,'2020-08-19 11:28:34',3,NULL,NULL),(20,9,5,'2020-08-19 11:28:34',4,NULL,NULL),(21,6,6,'2020-08-19 11:28:34',1,NULL,NULL),(22,2,4,'2020-08-19 11:28:34',2,NULL,NULL);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-01 17:26:45
