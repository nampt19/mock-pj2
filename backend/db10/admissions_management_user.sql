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
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `id_group_fk_01_idx` (`id_group`),
  KEY `create_by_id_admin_fk_u_idx` (`create_by_id_admin`),
  CONSTRAINT `create_by_id_admin_fk_u` FOREIGN KEY (`create_by_id_admin`) REFERENCES `user` (`id_user`),
  CONSTRAINT `id_group_fk_01` FOREIGN KEY (`id_group`) REFERENCES `group_user` (`id_group`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tiendat','OO2nIQKyyJDsRf3Uia4X7A==','Dat','dat.tien@gamil.com','0987654321','Ha Noi',NULL,1,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYXQudGllbkBnYW1pbC5jb20ifQ.nY59BNReAwXUxv4Lg4Y9a9wfIG8AE6Yd5Q7t75PDqynmEgBMCOdQY4Yibd3MgP-HGvaqW0jElv8EmnvZGwSWew',1,'2020-08-19 08:30:17'),(2,'hoanghuy','gUpUCZtf1BHPXEMBE2eOcg==','Huy','huy.hoang@gmail.com','0123456789','Ninh Binh',NULL,1,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJodXkuaG9hbmdAZ21haWwuY29tIn0.UzWP8JI_4HGV4u_OxsDxH36LuirpEjFbzhQAQwxwjbpxBF-c-oRYmt_-g_jN8mFLt-E6GR6BfocwD0Iu-6HYrA',1,'2020-08-19 08:30:17'),(3,'lanmai','EGwrrGV+5lOmQOmCF/Etpw==','Lan','lan.mai@gmail.com','0987123456','Quang Ngai','leader',2,'',1,NULL),(4,'lehoang','xMRm9/pTUYvLGSAPrl5cuA==','Hoang','hoang.le@gmail.com','0981237465','Nghe An ','employee',2,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJob2FuZy5sZUBnbWFpbC5jb20ifQ.CYO8R0WkyBt1a1UX7vn8LYqInxgZ2uS7_wqIg7w9Y7_wOH7wzWYNKM7c0vOoi_obrCIuKEuYQ9ZsKzuczrIotw',2,'2020-08-19 08:19:26'),(5,'Dung','Qi+sBimXcH5F74a5mf71jg==','Dung1234','dung.nguyen@gmail.com','0348984171','Ninh Binh','leader',3,NULL,1,NULL),(6,'mangba','PbHHZq9ESVLXS2PQ5WoHWw==','Manh','mang.ba@gmail.com','0912838478','Thua Thien Hue','employee',3,'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYW5nLmJhQGdtYWlsLmNvbSJ9.x2OtIZzGmAKME3j8s8mlCA4U0LqFyPbLdZgxXCOu5y_jmXOJO_mEnU4ZLyBjUDpoQF5vl4KdcwJXhoyH0LA5JQ',1,NULL),(48,'Okio Saminoob','v0hwIhjnIsg+evhnf3JdjQ==','Okio Sami','okio.sami@jpexpress.com','0886306122','Mashi.ST, Orochi, Japan','employee',2,NULL,1,'2020-08-26 22:21:49');
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

-- Dump completed on 2020-09-01 11:56:41
