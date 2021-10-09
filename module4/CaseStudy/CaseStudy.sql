-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: model4casestudy
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
-- Table structure for table `attach_service`
--

DROP TABLE IF EXISTS `attach_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attach_service` (
  `attach_service_id` int NOT NULL AUTO_INCREMENT,
  `attch_service_name` varchar(255) DEFAULT NULL,
  `cost` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`attach_service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=335 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attach_service`
--

LOCK TABLES `attach_service` WRITE;
/*!40000 ALTER TABLE `attach_service` DISABLE KEYS */;
INSERT INTO `attach_service` VALUES (330,'massage',10,'tôt','lần'),(331,'karaoke',20,'tôt','tiếng'),(332,'thức ăn',30,'tôt','món'),(333,'nước uống',40,'tôt','chai'),(334,'thuê xe',50,'tôt','chiếc');
/*!40000 ALTER TABLE `attach_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `contract_id` int NOT NULL AUTO_INCREMENT,
  `deposit` double NOT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `total_money` double NOT NULL,
  `customer_id` varchar(255) DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  KEY `FKq28qogy68douoc4gkgcy3ow9p` (`customer_id`),
  KEY `FKr2iw6grixlkbx43q2svdrhbb9` (`employee_id`),
  KEY `FK38oaxtv1vfg7g4pclrar2adxq` (`service_id`),
  CONSTRAINT `FK38oaxtv1vfg7g4pclrar2adxq` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`),
  CONSTRAINT `FKq28qogy68douoc4gkgcy3ow9p` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FKr2iw6grixlkbx43q2svdrhbb9` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=444 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (440,1000000,'2021-07-16 00:00:00.000000','2021-07-16 00:00:00.000000',1500000,'114',1,100),(441,1000000,'2021-07-17 00:00:00.000000','2021-02-16 00:00:00.000000',1500000,'116',5,102),(442,1000000,'2021-07-18 00:00:00.000000','2021-03-17 00:00:00.000000',1500000,'114',2,100);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract_detail`
--

DROP TABLE IF EXISTS `contract_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract_detail` (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `attach_service_id` int DEFAULT NULL,
  `contract_id` int DEFAULT NULL,
  PRIMARY KEY (`detail_id`),
  KEY `FK7cbwupicl8f762x3kulehjhf8` (`attach_service_id`),
  KEY `FKh3a73928bh54b95v82kwthjrk` (`contract_id`),
  CONSTRAINT `FK7cbwupicl8f762x3kulehjhf8` FOREIGN KEY (`attach_service_id`) REFERENCES `attach_service` (`attach_service_id`),
  CONSTRAINT `FKh3a73928bh54b95v82kwthjrk` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`contract_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract_detail`
--

LOCK TABLES `contract_detail` WRITE;
/*!40000 ALTER TABLE `contract_detail` DISABLE KEYS */;
INSERT INTO `contract_detail` VALUES (1,3,330,440),(2,3,332,440),(3,5,331,441),(4,6,333,442);
/*!40000 ALTER TABLE `contract_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int NOT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `customer_type_id` int DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FKn8vf9jf3m29plqn6rx45p2pl7` (`customer_type_id`),
  CONSTRAINT `FKn8vf9jf3m29plqn6rx45p2pl7` FOREIGN KEY (`customer_type_id`) REFERENCES `customer_type` (`customer_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('110','Đà nẵng','1985-02-05 00:00:00.000000','nguyen van ti','vanti@gmail.com',1,'123456789','01654840040',1),('111','Quảng Ngãi','1995-05-12 00:00:00.000000','nguyen thi thuy','thuy@gmail.com',0,'128956789','01654877040',5),('112','Vũng tàu','1998-12-10 00:00:00.000000','tran dieu nhi','nhitran@gmail.com',0,'773456789','01654848840',3),('113','Quảng trị','2000-02-21 00:00:00.000000','nguyen bich tien','tien@gmail.com',0,'121156789','01654848980',2),('114','Quảng Bình','2003-05-25 00:00:00.000000','le huu ha','ha@gmail.com',1,'123456229','01654847740',1),('115','Đà lạt','2005-02-05 00:00:00.000000','nguyen dang hoa thien','thien@gmail.com',1,'127756789','0165856040',3),('116','Sapa','2004-02-05 00:00:00.000000','nguyen y nhu','nhu@gmail.com',0,'123776789','01664840040',1),('117','Paris','2005-02-05 00:00:00.000000','nguyen dai phat','phat@gmail.com',1,'123886789','01777840040',4),('118','Đà nẵng','1985-02-05 00:00:00.000000','nguyen van ti','vanti@gmail.com',1,'123456789','01654840040',2),('kh-2929','Lộ 7 , tịnh đông ,sơn tịnh, quảng ngãi','2021-10-29 07:00:00.000000','Nguyễn thị thu uyên','nguyenuyen552000@gmail.com',1,'123456','0332001769',2);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_type`
--

DROP TABLE IF EXISTS `customer_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_type` (
  `customer_type_id` int NOT NULL AUTO_INCREMENT,
  `customer_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_type`
--

LOCK TABLES `customer_type` WRITE;
/*!40000 ALTER TABLE `customer_type` DISABLE KEYS */;
INSERT INTO `customer_type` VALUES (1,'Diamond'),(2,'Platinum'),(3,'Gold'),(4,'Sliver'),(5,'Member');
/*!40000 ALTER TABLE `customer_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `division` (
  `division_id` int NOT NULL,
  `division_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`division_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'Sale - Marketing'),(2,'Hành Chính'),(3,'Phục vụ'),(4,'Quản lý');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education` (
  `education_degree_id` int NOT NULL,
  `education_degree_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`education_degree_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (1,'Trung Cấp'),(2,'Cao Đẳng'),(3,'Đại Học'),(4,'Sau Đại Học');
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL,
  `employee_address` varchar(255) DEFAULT NULL,
  `employee_birthday` datetime(6) DEFAULT NULL,
  `employee_email` varchar(255) DEFAULT NULL,
  `employee_id_card` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `employee_phone` varchar(255) DEFAULT NULL,
  `employee_salary` double DEFAULT NULL,
  `division_id` int DEFAULT NULL,
  `eduction_id` int DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKoxlp1b4xvwyjgb7hh4wd54jy4` (`division_id`),
  KEY `FKmypkcs6lmlqtb1g9dqff8sx47` (`eduction_id`),
  KEY `FKbc8rdko9o9n1ri9bpdyxv3x7i` (`position_id`),
  KEY `FK467lpiaoknw8aojq6e6k0a0cy` (`username`),
  CONSTRAINT `FK467lpiaoknw8aojq6e6k0a0cy` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  CONSTRAINT `FKbc8rdko9o9n1ri9bpdyxv3x7i` FOREIGN KEY (`position_id`) REFERENCES `position` (`position_id`),
  CONSTRAINT `FKmypkcs6lmlqtb1g9dqff8sx47` FOREIGN KEY (`eduction_id`) REFERENCES `education` (`education_degree_id`),
  CONSTRAINT `FKoxlp1b4xvwyjgb7hh4wd54jy4` FOREIGN KEY (`division_id`) REFERENCES `division` (`division_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,NULL,'1995-05-02 00:00:00.000000','thang@gmaiiil.com','756565265','Thang','33025694',5000000,2,2,4,NULL),(2,NULL,'1955-05-02 00:00:00.000000','chinh@gmaiiil.com','757865265','Chinh','37925694',5500000,4,3,3,NULL),(3,NULL,'2000-05-02 00:00:00.000000','hang@gmaiiil.com','756566965','Hang','33027894',6000000,1,2,1,NULL),(4,NULL,'2000-05-05 00:00:00.000000','uyen@gmaiiil.com','966565265','Uyen','38725694',10000000,4,3,6,NULL),(5,NULL,'1985-05-02 00:00:00.000000','kha@gmaiiil.com','756565895','Kha','33027794',7000000,4,3,5,NULL),(6,NULL,'2003-05-02 00:00:00.000000','tam@gmaiiil.com','776565265','Tam','33775694',5000000,2,3,4,NULL),(7,NULL,'1995-05-02 00:00:00.000000','hang@gmaiiil.com','756565265','ha','33025694',5000000,2,2,2,NULL),(8,NULL,'1998-05-02 00:00:00.000000','nhu@gmaiiil.com','756585265','Nhu','13025694',5500000,2,2,4,NULL),(9,NULL,'1995-05-02 00:00:00.000000','quyen@gmaiiil.com','756565265','Quyen','33025694',5000000,2,2,3,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `position_id` int NOT NULL,
  `position_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Lễ tân'),(2,'Phục vụ'),(3,'Chuyên Viên'),(4,'Giám Sát'),(5,'Quản Lí'),(6,'Giám Đốc');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent_type`
--

DROP TABLE IF EXISTS `rent_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent_type` (
  `rent_type_id` int NOT NULL,
  `rent_type_cost` double NOT NULL,
  `rent_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rent_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent_type`
--

LOCK TABLES `rent_type` WRITE;
/*!40000 ALTER TABLE `rent_type` DISABLE KEYS */;
INSERT INTO `rent_type` VALUES (1,1000000,'year'),(2,700000,'month'),(3,500000,'day'),(4,200000,'hour');
/*!40000 ALTER TABLE `rent_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `service_id` int NOT NULL AUTO_INCREMENT,
  `description_other` varchar(255) DEFAULT NULL,
  `max_people` int NOT NULL,
  `name_service` varchar(255) DEFAULT NULL,
  `number_floors` int NOT NULL,
  `pool_area` double NOT NULL,
  `service_area` int NOT NULL,
  `service_cost` double NOT NULL,
  `standard_room` varchar(255) DEFAULT NULL,
  `rent_type_id` int DEFAULT NULL,
  `service_rent_type_id` int DEFAULT NULL,
  `service_type_id` int DEFAULT NULL,
  PRIMARY KEY (`service_id`),
  KEY `FKiynq5okirstjw1oge1sc2xwom` (`rent_type_id`),
  KEY `FKb6jju91ax4f8k2iv14jol6e5w` (`service_rent_type_id`),
  KEY `FK8e4s0klc1xdmf3dwoy16k7fmi` (`service_type_id`),
  CONSTRAINT `FK8e4s0klc1xdmf3dwoy16k7fmi` FOREIGN KEY (`service_type_id`) REFERENCES `service_type` (`service_type_id`),
  CONSTRAINT `FKb6jju91ax4f8k2iv14jol6e5w` FOREIGN KEY (`service_rent_type_id`) REFERENCES `service_type` (`service_type_id`),
  CONSTRAINT `FKiynq5okirstjw1oge1sc2xwom` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`rent_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (100,'dep',2,'room',3,100,1000,1500000,'2',1,221,NULL),(101,'dep',2,'service',3,100,1000,1200000,'2',1,220,NULL),(102,'dep',2,'villa',3,100,1000,1500000,'2',1,222,NULL),(103,'dep',2,'room',3,100,1000,1500000,'3',1,221,NULL),(104,'dep',2,'room',3,100,1000,1500000,'1',1,221,NULL);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type`
--

DROP TABLE IF EXISTS `service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service_type` (
  `service_type_id` int NOT NULL AUTO_INCREMENT,
  `service_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`service_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type`
--

LOCK TABLES `service_type` WRITE;
/*!40000 ALTER TABLE `service_type` DISABLE KEYS */;
INSERT INTO `service_type` VALUES (220,'Villa'),(221,'Room'),(222,'House');
/*!40000 ALTER TABLE `service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `username` varchar(255) NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`username`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FKnircs1pyebpo0eucojumm0aed` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-08 14:49:13
