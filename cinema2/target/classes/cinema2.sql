-- MariaDB dump 10.19  Distrib 10.5.12-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cinema2_stg1
-- ------------------------------------------------------
-- Server version	10.5.12-MariaDB-0+deb11u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `director` (
  `DIR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DIR_NAME` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DIR_SURNAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`DIR_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `director`
--

LOCK TABLES `director` WRITE;
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` VALUES (1,'Ivan','Heredia');
/*!40000 ALTER TABLE `director` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `film` (
  `flm_id` int(11) NOT NULL,
  `flm_title` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `flm_synopsis` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flm_cover` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flm_genre` enum('FICCIO','AVENTURES','TERROR','DIBUIXOS') COLLATE utf8_unicode_ci DEFAULT NULL,
  `flm_age_rating` int(11) DEFAULT NULL,
  `flm_date_release` date DEFAULT NULL,
  `flm_premiere` tinyint(1) NOT NULL DEFAULT 0,
  `flm_duration` decimal(10,5) NOT NULL,
  `flm_dir_id` int(11) NOT NULL,
  PRIMARY KEY (`flm_id`),
  UNIQUE KEY `flm_title_UNIQUE` (`flm_title`),
  KEY `flm_dir_fk` (`flm_dir_id`),
  CONSTRAINT `flm_dir_fk` FOREIGN KEY (`flm_dir_id`) REFERENCES `director` (`DIR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Terminator','Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.','terminator.jpg','FICCIO',16,'1995-12-12',0,1.30000,1),(2,'Capitán America','Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.','avengers.jpg','AVENTURES',12,'2019-12-20',0,0.00000,1),(3,'Rey León','Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.','rey-leon.jpg','DIBUIXOS',0,'2019-09-26',1,0.00000,1),(4,'The witcher','Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.','the-witcher.jpg','TERROR',16,'2020-01-05',1,0.00000,1),(5,'Predator','Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.','predator.jpg','TERROR',16,'1998-12-12',0,0.00000,1);
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session` (
  `ses_id_film` int(11) NOT NULL,
  `ses_hour_ini` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `ses_hour_end` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ses_club_armchair` tinyint(1) NOT NULL,
  PRIMARY KEY (`ses_id_film`,`ses_hour_ini`),
  CONSTRAINT `film_session_FK` FOREIGN KEY (`ses_id_film`) REFERENCES `film` (`flm_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES (1,'20:00','',0),(1,'22:00',NULL,1),(1,'24:00',NULL,0),(2,'17:00',NULL,0),(2,'19:00',NULL,1),(2,'21:00',NULL,0);
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-04 13:54:32
