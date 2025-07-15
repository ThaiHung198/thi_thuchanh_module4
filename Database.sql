-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: db_module4_exam
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `loai_san_pham`
--

DROP TABLE IF EXISTS `loai_san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_san_pham` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_san_pham`
--

LOCK TABLES `loai_san_pham` WRITE;
/*!40000 ALTER TABLE `loai_san_pham` DISABLE KEYS */;
INSERT INTO `loai_san_pham` VALUES (1,'Đồ Gốm Cổ'),(2,'Đồ Đồng Cổ'),(3,'Long Bào'),(4,'Ngọc'),(5,'Ấn Vua');
/*!40000 ALTER TABLE `loai_san_pham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `san_pham`
--

DROP TABLE IF EXISTS `san_pham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `san_pham` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `id_loai_sp` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6fra0vn2q1m7738np4022gy61` (`id_loai_sp`),
  CONSTRAINT `FK6fra0vn2q1m7738np4022gy61` FOREIGN KEY (`id_loai_sp`) REFERENCES `loai_san_pham` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `san_pham`
--

LOCK TABLES `san_pham` WRITE;
/*!40000 ALTER TABLE `san_pham` DISABLE KEYS */;
INSERT INTO `san_pham` VALUES (4,'Bình Gốm Nhà Thanh',550000000,'Đang Đấu giá',1),(5,'Áo Càng Long',10000000000,'Đã chốt',3),(6,'Ấn Chỉ Càng Long',1500000000,'Đã chốt',5),(7,'Áo Từ Hy Thái Hậu',5000000,'Đã chốt',3),(8,'Bát Gốm Nhà Hán',2000000,'Sứt mẻ phần đáy, đang chờ để kiểm tra lại',1),(9,'Áo Giáp Nhà Thục',50000000,'Han rỉ Phần vai',2);
/*!40000 ALTER TABLE `san_pham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-15 10:57:51
