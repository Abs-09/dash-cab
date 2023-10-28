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
-- Table structure for table `booking_requests`
--

DROP TABLE IF EXISTS `booking_requests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_requests` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `pick_up_address` varchar(255) NOT NULL,
  `destination_address` varchar(255) NOT NULL,
  `scheduled_date_time` datetime NOT NULL,
  `status` int NOT NULL,
  `created_at` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=664 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_requests`
--

LOCK TABLES `booking_requests` WRITE;
/*!40000 ALTER TABLE `booking_requests` DISABLE KEYS */;
INSERT INTO `booking_requests` VALUES (626,3,'4.215,73.541','4.215,73.541','2023-10-01 22:06:00',3,'2023-10-06 17:01:20'),(627,3,'4.215,73.541','4.215,73.541','2023-10-02 22:06:00',3,'2023-10-06 17:01:58'),(628,3,'4.216,73.541','4.217,73.539','2023-10-18 00:33:00',3,'2023-10-06 19:29:05'),(629,3,'4.215,73.542','4.214,73.541','2023-10-06 19:30:00',3,'2023-10-07 14:29:14'),(630,3,'4.215,73.541','4.214,73.541','2023-10-10 20:32:00',3,'2023-10-07 14:32:07'),(631,3,'4.216,73.541','4.215,73.541','2023-10-12 19:34:00',3,'2023-10-07 14:34:58'),(632,3,'4.216,73.541','4.215,73.541','2023-10-12 19:34:00',2,'2023-10-07 14:38:54'),(633,3,'4.214,73.541','4.215,73.541','2023-10-06 19:45:00',2,'2023-10-07 14:44:24'),(634,3,'4.214,73.541','4.215,73.541','2023-10-06 19:45:00',2,'2023-10-07 14:44:44'),(635,3,'4.214,73.541','4.215,73.541','2023-10-06 19:45:00',2,'2023-10-07 14:45:51'),(636,3,'4.215,73.542','4.215,73.541','2023-10-11 20:24:00',1,'2023-10-07 15:23:22'),(637,3,'4.214,73.542','4.213,73.538','2023-10-12 22:53:00',1,'2023-10-07 15:51:14'),(638,3,'4.215,73.542','4.215,73.540','2023-10-25 18:41:00',1,'2023-10-08 13:38:36'),(639,3,'4.174,73.511','4.169,73.509','2023-10-31 18:45:00',1,'2023-10-08 13:40:36'),(640,3,'4.215,73.541','4.217,73.543','2023-10-24 18:50:00',1,'2023-10-08 13:46:10'),(641,3,'4.215,73.541','4.215,73.540','2023-10-18 20:08:00',1,'2023-10-09 13:08:53'),(642,3,'4.215,73.541','4.217,73.542','2024-06-11 12:31:00',2,'2023-10-14 17:31:14'),(643,6,'4.218,73.541','4.213,73.541','2023-10-17 12:52:00',3,'2023-10-14 17:52:42'),(644,6,'4.216,73.542','4.213,73.539','2023-10-12 12:56:00',2,'2023-10-14 17:56:39'),(645,9,'4.218,73.540','4.215,73.541','2023-10-20 13:16:00',2,'2023-10-14 18:16:28'),(646,3,'4.215,73.541','4.214,73.541','2023-10-18 21:44:00',2,'2023-10-15 12:44:23'),(647,3,'4.218,73.541','4.214,73.542','2023-10-16 20:26:00',1,'2023-10-15 13:26:37'),(648,3,'4.217,73.541','4.211,73.541','2023-10-16 23:26:00',2,'2023-10-15 13:27:04'),(649,3,'4.216,73.541','4.176,73.516','2023-10-17 22:50:00',1,'2023-10-15 14:50:27'),(650,5,'4.217,73.542','4.215,73.541','2023-10-17 19:00:00',2,'2023-10-17 11:42:42'),(651,5,'4.217,73.542','4.215,73.541','2023-10-17 19:54:00',2,'2023-10-17 11:44:05'),(652,5,'4.216,73.542','4.214,73.541','2023-10-17 18:03:00',1,'2023-10-17 11:45:40'),(653,5,'4.215,73.541','4.216,73.542','2023-10-17 17:46:00',2,'2023-10-17 11:46:43'),(654,5,'4.215,73.541','4.216,73.542','2023-10-17 20:36:00',1,'2023-10-17 11:47:07'),(655,3,'4.216,73.541','4.215,73.541','2023-10-25 00:33:00',1,'2023-10-26 05:33:28'),(656,3,'4.217,73.541','4.217,73.540','2023-10-27 01:45:00',3,'2023-10-26 05:45:11'),(657,3,'4.216,73.542','4.217,73.543','2023-10-25 10:52:00',3,'2023-10-26 05:48:24'),(658,3,'4.216,73.542','4.215,73.541','2023-10-27 00:50:00',2,'2023-10-26 05:50:14'),(659,3,'4.216,73.542','4.215,73.543','2023-10-25 02:55:00',2,'2023-10-26 06:55:04'),(660,3,'4.215,73.542','4.215,73.542','2023-10-23 02:58:00',2,'2023-10-26 06:58:12'),(661,3,'4.216,73.543','4.178,73.510','2023-10-25 20:23:00',1,'2023-10-27 14:23:33'),(662,3,'4.211,73.539','4.175,73.509','2023-10-27 23:25:00',1,'2023-10-27 17:25:04'),(663,3,'4.189,73.527','4.220,73.544','2023-10-28 22:29:00',2,'2023-10-27 17:29:08');
/*!40000 ALTER TABLE `booking_requests` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-28 12:18:06
