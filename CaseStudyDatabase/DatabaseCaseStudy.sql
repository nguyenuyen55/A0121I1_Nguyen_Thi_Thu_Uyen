-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: quan_ly_khu_nghi_duong_furama
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
-- Table structure for table `bophan`
--

DROP TABLE IF EXISTS `bophan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bophan` (
  `IDBoPhan` int NOT NULL,
  `TenBoPhan` varchar(45) NOT NULL,
  PRIMARY KEY (`IDBoPhan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bophan`
--

LOCK TABLES `bophan` WRITE;
/*!40000 ALTER TABLE `bophan` DISABLE KEYS */;
INSERT INTO `bophan` VALUES (1,'Sale - Marketing'),(2,'Hành Chính'),(3,'Phục vụ'),(4,'Quản lý');
/*!40000 ALTER TABLE `bophan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvu`
--

DROP TABLE IF EXISTS `dichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvu` (
  `IDDichVu` int NOT NULL,
  `TenDichVu` varchar(45) DEFAULT NULL,
  `DienTich` int DEFAULT NULL,
  `SoTang` int DEFAULT NULL,
  `SoNguoiToiDa` varchar(45) DEFAULT NULL,
  `ChiPhiThue` varchar(45) DEFAULT NULL,
  `IDKieuThue` int NOT NULL,
  `IDLoaiDichVu` int DEFAULT NULL,
  `TrangThai` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDDichVu`),
  KEY `IDKieuThue` (`IDKieuThue`),
  KEY `IDLoaiDichVu` (`IDLoaiDichVu`),
  CONSTRAINT `dichvu_ibfk_1` FOREIGN KEY (`IDKieuThue`) REFERENCES `kieuthue` (`IDKieuThue`),
  CONSTRAINT `dichvu_ibfk_2` FOREIGN KEY (`IDLoaiDichVu`) REFERENCES `loaidichvu` (`IDLoaiDichVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvu`
--

LOCK TABLES `dichvu` WRITE;
/*!40000 ALTER TABLE `dichvu` DISABLE KEYS */;
INSERT INTO `dichvu` VALUES (100,'room',100,2,'4','1500000',3,221,'đã đặt'),(101,'house',100,2,'4','1600000',2,222,'đã huỷ'),(102,'villa',100,2,'7','2500000',3,220,'đã đặt'),(103,'house',100,2,'4','3500000',3,221,'đã đặt'),(104,'room',100,2,'4','1500000',3,222,'đã đặt'),(105,'room',100,2,'4','4500000',3,221,'đã đặt');
/*!40000 ALTER TABLE `dichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dichvudikem`
--

DROP TABLE IF EXISTS `dichvudikem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dichvudikem` (
  `IDDichVuDiKem` int NOT NULL,
  `TenDichVuDiKem` varchar(45) DEFAULT NULL,
  `gia` int DEFAULT NULL,
  `DonVi` varchar(75) DEFAULT NULL,
  `TrangThaiKhaDung` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDDichVuDiKem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dichvudikem`
--

LOCK TABLES `dichvudikem` WRITE;
/*!40000 ALTER TABLE `dichvudikem` DISABLE KEYS */;
INSERT INTO `dichvudikem` VALUES (330,'massage',100,'giờ','tôt'),(331,'karaoke',200,'giờ','tôt'),(332,'thức ăn',300,'món','tôt'),(333,'nước uống',40,'chai','tôt'),(334,'thuê xe',50,'chiếc','tôt');
/*!40000 ALTER TABLE `dichvudikem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hopdong`
--

DROP TABLE IF EXISTS `hopdong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hopdong` (
  `IDHopDong` int NOT NULL,
  `IDNhanVien` int DEFAULT NULL,
  `IDKhachHang` int DEFAULT NULL,
  `IDDichVu` int DEFAULT NULL,
  `NgayLamHopDong` date DEFAULT NULL,
  `NgayKetThuc` date DEFAULT NULL,
  `TienDatCoc` int DEFAULT NULL,
  `TongTien` int DEFAULT NULL,
  PRIMARY KEY (`IDHopDong`),
  KEY `IDNhanVien` (`IDNhanVien`),
  KEY `IDKhachHang` (`IDKhachHang`),
  KEY `IDDichVu` (`IDDichVu`),
  CONSTRAINT `hopdong_ibfk_1` FOREIGN KEY (`IDNhanVien`) REFERENCES `nhanvien` (`IDNhanVien`),
  CONSTRAINT `hopdong_ibfk_2` FOREIGN KEY (`IDKhachHang`) REFERENCES `khachhang` (`IDKhachHang`),
  CONSTRAINT `hopdong_ibfk_3` FOREIGN KEY (`IDDichVu`) REFERENCES `dichvu` (`IDDichVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hopdong`
--

LOCK TABLES `hopdong` WRITE;
/*!40000 ALTER TABLE `hopdong` DISABLE KEYS */;
INSERT INTO `hopdong` VALUES (440,1,114,100,'2018-07-16','2018-07-17',1000000,1500000),(441,5,116,102,'2019-02-16','2021-07-17',1000000,1500000),(442,2,114,100,'2019-03-17','2019-07-18',1000000,1500000),(443,5,117,105,'2018-07-18','2021-07-18',1500000,2500000),(444,2,115,100,'2019-01-16','2019-07-17',1000000,1500000),(445,3,115,104,'2018-07-16','2021-07-17',1000000,1500000),(446,1,111,101,'2018-07-16','2021-07-17',1200000,1500000),(447,4,999,103,'2019-01-16','2019-01-20',1300000,17000000),(448,4,110,102,'2015-11-16','2015-11-20',2500000,50000000),(449,1,113,104,'2019-11-08','2019-11-20',1000000,2000000),(450,3,115,104,'2019-10-20','2019-10-29',1500000,3600000),(451,6,111,100,'2021-07-23','2021-07-30',2500000,35100000);
/*!40000 ALTER TABLE `hopdong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hopdongchitiet`
--

DROP TABLE IF EXISTS `hopdongchitiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hopdongchitiet` (
  `IDHopDongChiTiet` int NOT NULL,
  `IDHopDong` int DEFAULT NULL,
  `IDDichVuDiKem` int DEFAULT NULL,
  `SoLuong` int DEFAULT NULL,
  PRIMARY KEY (`IDHopDongChiTiet`),
  KEY `IDDichVuDiKem` (`IDDichVuDiKem`),
  KEY `IDHopDong` (`IDHopDong`),
  CONSTRAINT `hopdongchitiet_ibfk_1` FOREIGN KEY (`IDDichVuDiKem`) REFERENCES `dichvudikem` (`IDDichVuDiKem`),
  CONSTRAINT `hopdongchitiet_ibfk_2` FOREIGN KEY (`IDHopDong`) REFERENCES `hopdong` (`IDHopDong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hopdongchitiet`
--

LOCK TABLES `hopdongchitiet` WRITE;
/*!40000 ALTER TABLE `hopdongchitiet` DISABLE KEYS */;
INSERT INTO `hopdongchitiet` VALUES (1,440,330,3),(2,440,332,3),(3,441,331,5),(4,442,333,6),(5,443,330,7),(6,444,332,1),(7,442,332,6),(8,448,331,2),(9,449,331,6),(10,449,330,2);
/*!40000 ALTER TABLE `hopdongchitiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `IDKhachHang` int NOT NULL,
  `IDLoaiKhach` int NOT NULL,
  `HoTen` varchar(45) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `SoCMTND` varchar(45) DEFAULT NULL,
  `SDT` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDKhachHang`),
  KEY `IDLoaiKhach` (`IDLoaiKhach`),
  CONSTRAINT `khachhang_ibfk_1` FOREIGN KEY (`IDLoaiKhach`) REFERENCES `loaikhach` (`IDLoaiKhach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (110,1,'nguyen van ti','1985-02-05','123456789','01654840040','vanti@gmail.com','Đà nẵng'),(111,1,'nguyen thi thuy','1995-05-12','128956789','01654877040','thuy@gmail.com','Quảng Ngãi'),(112,3,'tran dieu nhi','1998-12-10','773456789','01654848840','nhitran@gmail.com','Vũng tàu'),(113,2,'nguyen bich tien','2000-02-21','121156789','01654848980','tien@gmail.com','Quảng trị'),(114,1,'le huu ha','2003-05-25','123456229','01654847740','ha@gmail.com','Quảng Ngãi'),(115,1,'nguyen dang hoa thien','2005-02-05','127756789','0165856040','thien@gmail.com','Vinh'),(116,1,'nguyen y nhu','2004-02-05','123776789','01664840040','nhu@gmail.com','Sapa'),(117,4,'nguyen dai phat','2005-02-05','123886789','01777840040','phat@gmail.com','Paris'),(118,2,'nguyen van ti','1985-02-05','123456789','01654840040','vanti@gmail.com','Đà nẵng'),(999,1,'nguyen uyen','1985-02-05','123456789','01654840040','vanti@gmail.com','Đà nẵng');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kieuthue`
--

DROP TABLE IF EXISTS `kieuthue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kieuthue` (
  `IDKieuThue` int NOT NULL,
  `TenKieuThue` varchar(45) DEFAULT NULL,
  `gia` int DEFAULT NULL,
  PRIMARY KEY (`IDKieuThue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kieuthue`
--

LOCK TABLES `kieuthue` WRITE;
/*!40000 ALTER TABLE `kieuthue` DISABLE KEYS */;
INSERT INTO `kieuthue` VALUES (1,'year',1000000),(2,'month',700000),(3,'day',500000),(4,'hour',200000);
/*!40000 ALTER TABLE `kieuthue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaidichvu`
--

DROP TABLE IF EXISTS `loaidichvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaidichvu` (
  `IDLoaiDichVu` int NOT NULL,
  `TenLoaiDichVu` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDLoaiDichVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaidichvu`
--

LOCK TABLES `loaidichvu` WRITE;
/*!40000 ALTER TABLE `loaidichvu` DISABLE KEYS */;
INSERT INTO `loaidichvu` VALUES (220,'Villa'),(221,'Room'),(222,'House');
/*!40000 ALTER TABLE `loaidichvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaikhach`
--

DROP TABLE IF EXISTS `loaikhach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaikhach` (
  `IDLoaiKhach` int NOT NULL,
  `TenLoaiKhach` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDLoaiKhach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaikhach`
--

LOCK TABLES `loaikhach` WRITE;
/*!40000 ALTER TABLE `loaikhach` DISABLE KEYS */;
INSERT INTO `loaikhach` VALUES (1,'Diamond'),(2,'Platinum'),(3,'Gold'),(4,'Sliver'),(5,'Member');
/*!40000 ALTER TABLE `loaikhach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `IDNhanVien` int NOT NULL,
  `HoTen` varchar(45) DEFAULT NULL,
  `IDViTri` int NOT NULL,
  `IDTrinhDo` int NOT NULL,
  `IDBoPhan` int NOT NULL,
  `NgaySinh` date DEFAULT NULL,
  `SoCMTND` varchar(45) DEFAULT NULL,
  `Luong` varchar(45) DEFAULT NULL,
  `SDT` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDNhanVien`),
  KEY `IDViTri` (`IDViTri`),
  KEY `IDTrinhDo` (`IDTrinhDo`),
  KEY `IDBoPhan` (`IDBoPhan`),
  CONSTRAINT `nhanvien_ibfk_1` FOREIGN KEY (`IDViTri`) REFERENCES `vitri` (`IDViTri`),
  CONSTRAINT `nhanvien_ibfk_2` FOREIGN KEY (`IDTrinhDo`) REFERENCES `trinhdo` (`IDTrinhDo`),
  CONSTRAINT `nhanvien_ibfk_3` FOREIGN KEY (`IDBoPhan`) REFERENCES `bophan` (`IDBoPhan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Thang',4,2,2,'1995-05-02','756565265','5000000','33025694','thang@gmaiiil.com',NULL),(2,'Chinh',3,3,4,'1955-05-02','757865265','5500000','37925694','chinh@gmaiiil.com',NULL),(3,'Hang',1,2,1,'2000-05-02','756566965','6000000','33027894','hang@gmaiiil.com',NULL),(4,'Uyen',6,3,4,'2000-05-05','966565265','10000000','38725694','uyen@gmaiiil.com',NULL),(5,'Kha',5,3,4,'1985-05-02','756565895','7000000','33027794','kha@gmaiiil.com',NULL),(6,'Tam',4,3,2,'2003-05-02','776565265','5000000','33775694','tam@gmaiiil.com',NULL),(7,'hahahahahahahaha',2,2,2,'1995-05-02','756565265','5000000','33025694','hang@gmaiiil.com',NULL),(8,'Nhu',4,2,2,'1998-05-02','756585265','5500000','13025694','nhu@gmaiiil.com',NULL),(9,'Quyen',3,2,2,'1995-05-02','756565265','5000000','33025694','quyen@gmaiiil.com',NULL);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trinhdo`
--

DROP TABLE IF EXISTS `trinhdo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trinhdo` (
  `IDTrinhDo` int NOT NULL,
  `TrinhDo` varchar(45) NOT NULL,
  PRIMARY KEY (`IDTrinhDo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trinhdo`
--

LOCK TABLES `trinhdo` WRITE;
/*!40000 ALTER TABLE `trinhdo` DISABLE KEYS */;
INSERT INTO `trinhdo` VALUES (1,'Trung Cấp'),(2,'Cao Đẳng'),(3,'Đại Học'),(4,'Sau Đại Học');
/*!40000 ALTER TABLE `trinhdo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vitri`
--

DROP TABLE IF EXISTS `vitri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vitri` (
  `IDViTri` int NOT NULL,
  `TenViTri` varchar(45) NOT NULL,
  PRIMARY KEY (`IDViTri`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vitri`
--

LOCK TABLES `vitri` WRITE;
/*!40000 ALTER TABLE `vitri` DISABLE KEYS */;
INSERT INTO `vitri` VALUES (1,'Lễ tân'),(2,'Phục vụ'),(3,'Chuyên Viên'),(4,'Giám Sát'),(5,'Quản Lí'),(6,'Giám Đốc');
/*!40000 ALTER TABLE `vitri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-25 14:55:26
