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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `id_group` int DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `create_by_id_admin` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `id_group_fk_01_idx` (`id_group`),
  KEY `create_by_id_admin_fk_u_idx` (`create_by_id_admin`),
  CONSTRAINT `create_by_id_admin_fk_u` FOREIGN KEY (`create_by_id_admin`) REFERENCES `user` (`id_user`),
  CONSTRAINT `id_group_fk_01` FOREIGN KEY (`id_group`) REFERENCES `group_user` (`id_group`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tiendat','OO2nIQKyyJDsRf3Uia4X7A==','Dat','dat.tien@gamil.com','0987654321','Ha Noi',NULL,1,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYXQudGllbkBnYW1pbC5jb20ifQ.9LGmOzuiy55p-cPTCiLKuje0Ca2Tif4wHJdN0-CBAl8Ff6jTln_Xx9dWa36xsyi3yh7SaC93HOHd8AGGDiXPnA',1,'2020-08-19 08:30:17','Đang hoạt động'),(2,'hoanghuy','gUpUCZtf1BHPXEMBE2eOcg==','Huy','huy.hoang@gmail.com','0123456789','Ninh Binh',NULL,1,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXkuaG9hbmdAZ21haWwuY29tIn0.UzWP8JI_4HGV4u_OxsDxH36LuirpEjFbzhQAQwxwjbpxBF-c-oRYmt_-g_jN8mFLt-E6GR6BfocwD0Iu-6HYrA',1,'2020-08-19 08:30:17',NULL),(3,'Lan','EGwrrGV+5lOmQOmCF/Etpw==','Lan','lan.mai@gmail.com','0987123456','Quang Ngai','leader',2,NULL,1,NULL,'Đang hoạt động'),(4,'Hoang','xMRm9/pTUYvLGSAPrl5cuA==','Hoang','hoang.le@gmail.com','0981237465','Nghe An ','employee',2,NULL,2,NULL,'Không hoạt động'),(5,'Dung123','Qi+sBimXcH5F74a5mf71jg==','Dung123','dung.nguyen@gmail.com','0348984171','Ninh Binh','Nhóm trưởng',3,NULL,1,'2020-09-04 08:14:51',NULL),(6,'Manh','PbHHZq9ESVLXS2PQ5WoHWw==','Manh','mang.ba@gmail.com','0912838478','Thua Thien Hue','Thành viên',3,NULL,1,'2020-09-04 08:04:35',NULL),(48,'Okio Sami','v0hwIhjnIsg+evhnf3JdjQ==','Okio Sami','okio.sami@jpexpress.com','0886306122','Mashi.ST, Orochi, Japan','employee',2,NULL,1,NULL,'Không hoạt động'),(66,'ABC ABC ','8cDv9dNtGFXVIHAE8A6YEQ==','ABC ABC ','philip.cha11ney@gmail.com','0912832345','Mashi.ST, Orochi, Japan','Nhóm trưởng',3,NULL,1,'2020-09-04 08:56:25',NULL),(67,'ABC ABC','ZU8LnqwOUoNpIcaPpQZ2VTxw2r9VObJNWk+aC3W2sOA=','ABC ABC00','philip.chaney@gmail.com','0348984167','Hà Nội','leader',3,NULL,1,NULL,'Đang hoạt động');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
