-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: database-1.clsz0i80puo2.ap-south-1.rds.amazonaws.com    Database: book_my_band
-- ------------------------------------------------------
-- Server version	8.0.26

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `hours` int NOT NULL,
  `city` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `band_id` int NOT NULL,
  `cust_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `band_fk_idx` (`band_id`),
  KEY `cust_fk_idx` (`cust_id`),
  CONSTRAINT `band_fk` FOREIGN KEY (`band_id`) REFERENCES `band` (`id`),
  CONSTRAINT `cust_fk` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,'2021-10-11',4,'tpt','approved',1,1),(2,'2021-10-28',10,'Tirupathi','rejected',1,4),(3,'2021-10-27',5,'Tirupathi','approved',1,4),(4,'2021-11-11',5,'Tirupathi','rejected',1,1),(5,'2021-12-25',5,'Bangalore','approved',1,4),(6,'2021-12-30',4,'Hyderbad','approved',1,4),(7,'2021-10-22',2,'Chennai','approved',1,4),(8,'2021-12-30',5,'Kochi','pending',1,12),(9,'2021-10-24',4,'Mumbai','approved',14,4),(10,'2021-11-28',12,'Gwalior','pending',14,12),(11,'2021-10-31',1,'Thrivendram','pending',14,12),(12,'2021-12-31',5,'Ravindra Bharathi, Hyderbad','approved',1,4),(13,'2021-10-26',4,'Mahathi,Tirupathi.','rejected',16,4);
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-26 19:36:51
