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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `create_by_id_user` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE KEY `id_customer_UNIQUE` (`id_customer`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `create_by_id_user_fk_c_idx` (`create_by_id_user`),
  CONSTRAINT `create_by_id_user_fk_c` FOREIGN KEY (`create_by_id_user`) REFERENCES `user` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Hien121','0978346290','hien.thu@gmail.com','Thanh Hoa',3,'2020-09-06 09:12:58'),(2,'Hoai','0978346291','hoai.le@gmail.com','Hai Phong',4,'2020-08-19 17:20:12'),(3,'Dung','0315738292','dung.tiien@gmail.com','Nghe An',5,'2020-08-19 14:53:21'),(4,'Ha','0983453172','ha.hoang@gmail.com','Bac Giang',6,'2020-08-19 10:12:09'),(5,'Thanh','0923315327','thanh.tien@gmail.com','Binh Dinh',3,'2020-09-06 08:27:29'),(6,'Trung','0912832456','trung.nguyen@gmail.com','Ha Noi',4,'2020-09-06 08:27:29'),(7,'Tien','0985343761','tien.nguyen@gmail.com','Ha Tinh',5,'2020-09-06 08:30:24'),(8,'Hoang','0918733560','hoang.nguyen@gmail.com','Can Tho',6,'2020-09-06 08:46:25'),(9,'Yen','0918733562','yen.chung@gmail.com','Bac Ninh',3,'2020-09-06 08:46:25'),(10,'An123','0918733563','an.nguyen@gmail.com','Ha Tinh',4,'2020-09-06 08:30:24'),(21,'Herbert J Stines1','0348984168','namakain.1u@gmail.com','2969  Turkey Pen Lane',3,'2020-09-05 09:51:54'),(22,'Herbert J Stines','0348984161','a.inu@gmail.com','2969  Turkey Pen Lane',3,'2020-09-05 16:01:22'),(23,'aaa','0912314151','aa.aa@aa.aa','asdasd',96,'2020-09-07 15:18:41'),(24,'Herbert J Stines','0348984167','nam.akainu@gmail.com','2969  Turkey Pen Lane',3,'2020-10-01 22:05:10');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
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
