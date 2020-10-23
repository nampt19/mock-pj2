-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: admissions_management
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
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
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction` (
  `id_deal` int(11) NOT NULL AUTO_INCREMENT,
  `id_customer` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `transaction_time` datetime NOT NULL,
  `id_product` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `note` varchar(1145) DEFAULT NULL,
  PRIMARY KEY (`id_deal`),
  UNIQUE KEY `iddeal_UNIQUE` (`id_deal`),
  KEY `id_user_idx` (`id_user`),
  KEY `id_customer_idx` (`id_customer`),
  CONSTRAINT `id_customer` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`),
  CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,1,4,'2020-09-05 09:53:15',1,'Đã hủy','ok'),(2,2,5,'2020-09-04 11:10:46',2,'Đã thanh toán','sadfsdafsfd'),(3,3,6,'2020-09-03 15:03:39',3,'Đã thanh toán',''),(4,4,4,'2020-08-19 09:12:59',4,'Đã thanh toán',NULL),(5,5,5,'2020-09-05 16:11:39',1,'Đang thanh toán','123'),(6,6,3,'2020-09-07 11:16:14',2,'Đã thanh toán','abc'),(7,7,4,'2020-09-03 14:22:33',3,'Đã thanh toán',''),(8,7,4,'2020-09-03 14:22:33',3,'Đã thanh toán',''),(9,4,4,'2020-08-19 09:12:59',4,'Đã thanh toán',NULL),(10,5,5,'2020-09-03 14:23:08',1,'Đang thanh toán',''),(11,6,3,'2020-08-19 06:54:35',2,'Đã thanh toán',NULL),(12,7,4,'2020-09-03 14:22:33',3,'Đã thanh toán',''),(13,7,4,'2020-09-03 14:22:33',3,'Đã thanh toán',''),(14,4,4,'2020-08-19 09:12:59',4,'Đã thanh toán',NULL),(15,5,5,'2020-09-03 14:23:08',1,'Đang thanh toán',''),(16,6,3,'2020-08-19 06:54:35',2,'Đã thanh toán',NULL),(30,2,3,'2020-09-05 16:04:04',1,'Đã hủy','sdfdsf'),(31,21,3,'2020-10-01 22:04:35',3,'Đã thanh toán','80%');
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

-- Dump completed on 2020-10-23 15:08:35
