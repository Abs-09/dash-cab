-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: dash_cab
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(54) NOT NULL,
  `name` varchar(54) NOT NULL,
  `address` varchar(54) NOT NULL,
  `email` varchar(54) NOT NULL,
  `contact` varchar(54) NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `type` int NOT NULL,
  `license_number` varchar(54) DEFAULT NULL,
  `availability` tinyint(1) DEFAULT NULL,
  `enabled` int NOT NULL,
  `created_by` varchar(54) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `license_number_UNIQUE` (`license_number`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'password','Absal','Male','absal@live.com','752342',1,1,'dom',0,1,'Absal','2023-07-11 19:00:00','2023-07-11 19:00:00',NULL),(2,'password1','Ahzam','hamle','ahzam@live.com','712616',1,2,'undefined',0,1,'Absal',NULL,'2023-10-11 20:41:16',NULL),(3,'password2','Affan','Hmale','affaan@live.com','792131',1,3,NULL,NULL,1,'Absal','2023-07-11 19:00:00','2023-10-27 04:36:05',NULL),(4,'password','Raj','Maldi','Raj@live.com','754321',NULL,2,'A232211',0,1,'Absal','2023-10-09 18:05:08','2023-10-09 18:05:08',NULL),(5,'password','Aswaaru','Male','aswaaru@live.com','7666677',NULL,3,NULL,NULL,1,'Absal','2023-10-13 22:51:02','2023-10-13 22:51:02',NULL),(6,'123','Ali Naaif','Roasvaadhee','naaif@live.com','8797944',NULL,3,NULL,NULL,1,'Absal','2023-10-14 22:47:39','2023-10-14 22:47:58',NULL),(7,'1234','Ibrahim Mohamed','ISsege ge','ibbe@live.com','9855252',NULL,2,'A0985951',0,0,'Absal','2023-10-14 22:48:58','2023-10-14 22:51:22','2023-10-25 20:02:59'),(8,'password','danil ahmed','vaadhee','danil@live.com','7849562',NULL,2,'788787',0,1,'Absal','2023-10-14 23:13:13','2023-10-14 23:15:27',NULL),(9,'1234','cusin ahmed','geege','cusi@live.com','7898485',NULL,3,NULL,NULL,1,'Absal','2023-10-14 23:15:01','2023-10-14 23:15:01',NULL),(10,'password','Test','Hmale','test@live.com','7564643',NULL,3,NULL,NULL,0,'Absal','2023-10-15 17:54:40','2023-10-15 17:54:40','2023-10-25 20:08:34'),(11,'password','testdriver','Hmale','testdriver@live.com','7543150',NULL,2,'A2131212',0,0,'Absal','2023-10-15 17:55:29','2023-10-15 17:55:29','2023-10-25 20:07:07'),(12,'123','Adhan','new one','a@live.com','985252',NULL,2,'989889a',0,1,'Absal','2023-10-15 18:24:39','2023-10-15 18:24:56',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-28 12:18:05
