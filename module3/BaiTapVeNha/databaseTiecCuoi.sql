-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: dethi
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvu` (
  `id_dich_vu` int NOT NULL AUTO_INCREMENT,
  `tenDichVu` varchar(255) DEFAULT NULL,
  `don_gia` int DEFAULT NULL,
  PRIMARY KEY (`id_dich_vu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (1,'Múa lân',200000),(2,'sexy dance',3000000),(3,'Múa quạt',200000);
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongtintieccuoi`
--

DROP TABLE IF EXISTS `thongtintieccuoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thongtintieccuoi` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `ngayTochuc` date DEFAULT NULL,
  `tenCoDau` varchar(255) DEFAULT NULL,
  `tenChuRe` varchar(255) DEFAULT NULL,
  `SoluongBan` int DEFAULT NULL,
  `DonGia` int DEFAULT NULL,
  `DichVuDiKiem` int DEFAULT NULL,
  `tienNoDatCoc` int DEFAULT NULL,
  `TienNoThanhToan` int DEFAULT NULL,
  `NgayDatCoc` date DEFAULT NULL,
  `NgayThanhToan` date DEFAULT NULL,
  `ghichu` varchar(255) DEFAULT NULL,
  `TrangThai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongtintieccuoi`
--

LOCK TABLES `thongtintieccuoi` WRITE;
/*!40000 ALTER TABLE `thongtintieccuoi` DISABLE KEYS */;
INSERT INTO `thongtintieccuoi` VALUES (1,'2021-07-24','Uyen Thu','Huu Dat',55,9999,2,222,1111,'2021-08-17','2021-08-15','22224dddd','yyy'),(4,'2021-08-09','Thị nở','Chí Phèo',55,3342,3,343,1111,'2021-08-26','2021-08-01','22224dddd','yyyrrrrrrr');
/*!40000 ALTER TABLE `thongtintieccuoi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-28  9:43:52
