CREATE DATABASE  IF NOT EXISTS `airlines` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `airlines`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: airlines
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `aircraft`
--

DROP TABLE IF EXISTS `aircraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aircraft` (
  `tail_number` varchar(15) NOT NULL,
  `model` varchar(45) NOT NULL,
  `manufacture_date` date NOT NULL,
  `lifetime` int NOT NULL,
  `is_ready` tinyint NOT NULL,
  `commander_personal_number` int NOT NULL,
  PRIMARY KEY (`tail_number`,`commander_personal_number`),
  UNIQUE KEY `tail-number_UNIQUE` (`tail_number`),
  KEY `fk_aircraft_commander1_idx` (`commander_personal_number`),
  CONSTRAINT `fk_aircraft_commander1` FOREIGN KEY (`commander_personal_number`) REFERENCES `commander` (`personal_number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aircraft`
--

LOCK TABLES `aircraft` WRITE;
/*!40000 ALTER TABLE `aircraft` DISABLE KEYS */;
INSERT INTO `aircraft` VALUES ('B101GH','Embraer E190','2019-09-30',6,1,585),('G202IJ','Bombardier CRJ900','2017-02-14',8,1,545),('G456CD','Airbus A320','2018-03-25',10,1,657),('N303KL','Airbus A350','2020-08-21',10,1,875),('N789EF','Boeing 777','2016-11-08',9,1,120);
/*!40000 ALTER TABLE `aircraft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commander`
--

DROP TABLE IF EXISTS `commander`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commander` (
  `personal_number` int NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(11) NOT NULL,
  `flying_hours` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`personal_number`),
  UNIQUE KEY `personal_number_UNIQUE` (`personal_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commander`
--

LOCK TABLES `commander` WRITE;
/*!40000 ALTER TABLE `commander` DISABLE KEYS */;
INSERT INTO `commander` VALUES (120,'Wilson','Jack','New-York, USA','79856451289',1000),(545,'Brown','Emily','Rivertown, USA','79855652512',6000),(585,'Davis','Christopher','Lakeside, USA','79568965412',7000),(657,'Johnson','Michael','Springfield, USA','79829475623',8000),(875,'Wilson','Jessica','Mountainview, USA','79856234521',7850);
/*!40000 ALTER TABLE `commander` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `number` varchar(15) NOT NULL,
  `departure_time` datetime NOT NULL,
  `is_canceled` tinyint NOT NULL,
  `route_number` varchar(20) NOT NULL,
  `aircraft_tail_number` varchar(15) NOT NULL,
  PRIMARY KEY (`number`,`route_number`,`aircraft_tail_number`),
  UNIQUE KEY `number_UNIQUE` (`number`),
  KEY `fk_flight_route_idx` (`route_number`),
  KEY `fk_flight_aircraft1_idx` (`aircraft_tail_number`),
  CONSTRAINT `fk_flight_aircraft1` FOREIGN KEY (`aircraft_tail_number`) REFERENCES `aircraft` (`tail_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_flight_route` FOREIGN KEY (`route_number`) REFERENCES `route` (`number`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('1231','2024-09-09 17:20:00',0,'MOWYORK','G202IJ'),('12312','2024-07-02 13:55:00',0,'TOKLAS','G456CD'),('123312','2024-08-20 10:10:00',0,'PARDUB','N303KL'),('1312','2023-12-15 09:45:00',1,'BEJSHAN','B101GH'),('31411','2023-04-29 12:25:00',1,'SYDAUC','B101GH'),('4321','2024-03-28 11:15:00',1,'DUBLON','G202IJ'),('435432987','2024-05-17 16:40:00',0,'SINSYD','B101GH'),('78965','2024-11-11 08:00:00',0,'TOKLAS','N303KL');
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_has_passenger`
--

DROP TABLE IF EXISTS `flight_has_passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_has_passenger` (
  `passenger_passport` varchar(20) NOT NULL,
  `flight_number` varchar(15) NOT NULL,
  PRIMARY KEY (`passenger_passport`,`flight_number`),
  KEY `fk_flight_has_passenger_passenger1_idx` (`passenger_passport`),
  KEY `fk_flight_has_passenger_flight1_idx` (`flight_number`),
  CONSTRAINT `fk_flight_has_passenger_flight1` FOREIGN KEY (`flight_number`) REFERENCES `flight` (`number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_flight_has_passenger_passenger1` FOREIGN KEY (`passenger_passport`) REFERENCES `passenger` (`passport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_has_passenger`
--

LOCK TABLES `flight_has_passenger` WRITE;
/*!40000 ALTER TABLE `flight_has_passenger` DISABLE KEYS */;
INSERT INTO `flight_has_passenger` VALUES ('0715155235','1231'),('0715162235','1231'),('0715155235','12312'),('0715162235','123312'),('0715155235','435432987'),('0715155235','78965'),('0715162235','78965');
/*!40000 ALTER TABLE `flight_has_passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `passport` varchar(20) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY (`passport`),
  UNIQUE KEY `passport_UNIQUE` (`passport`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES ('0715155235','Simpson','Homer','Springfield, USA','79994561236'),('0715162235','Simpson','Bart','Springfield, USA','79998751291');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `number` varchar(20) NOT NULL,
  `departure` varchar(4) NOT NULL,
  `arrival` varchar(4) NOT NULL,
  `price` double NOT NULL DEFAULT '0',
  `duration` int NOT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `number_UNIQUE` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES ('BEJSHAN','ZBAA','ZSPD',10000,120),('DUBLON','OMDB','EGLL',55000,480),('LONYORK','EGLL','KJFK',100000,460),('MOWYORK','UUEE','KJFK',75000,600),('PARDUB','LFPG','OMDB',42000,370),('SINSYD','WSSS','YSSY',45000,500),('SYDAUC','YSSY','NZAA',35000,180),('TOKLAS','RJJT','KLAX',110000,630);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'airlines'
--

--
-- Dumping routines for database 'airlines'
--
/*!50003 DROP PROCEDURE IF EXISTS `check_flight` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`localhost` PROCEDURE `check_flight`( el varchar(15) )
BEGIN
	IF ((SELECT COUNT(*) FROM flight_has_passenger WHERE flight_number = el) = 0) THEN
		UPDATE flight SET is_canceled = 1 WHERE number = el;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `show_profit` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `show_profit`(YYYY year)
BEGIN

	select
    pr.number as flight_number,
    pr.passenger_count,
    pr.profit
    from (
    
    	select
		ph.route_number as route_number_1,
		concat('Route number: ', ph.route_number) as number,
        concat('Price: ' ,ph.price )as passenger_count,
        " " as profit
	from (
		SELECT 
		flight.route_number as route_number,
        route.price as price
		FROM flight
        LEFT JOIN route ON flight.route_number = route.number
        where year(flight.departure_time) = YYYY
		group by flight.route_number, flight.number
    ) ph
    group by route_number, price
    
    union all
    
        SELECT  
		ph.route_number as route_number_1,
		ph.number,
        ph.passenger_count,
        ph.passenger_count * ph.price as profit
    from (
		SELECT 
		flight.route_number as route_number,
        flight.number as number,
        route.price as price,
        count(flight_has_passenger.passenger_passport) as passenger_count
		FROM flight
        LEFT JOIN route ON flight.route_number = route.number
		left join flight_has_passenger on flight.number = flight_has_passenger.flight_number
        where year(flight.departure_time) = YYYY
		group by flight.route_number, flight.number
    ) as ph
    
    union all
    

    
    	select
		ph.route_number as route_number_1,
		'Total per route: ' as number,
        " " as passenger_count,
        sum(ph.passenger_count) * ph.price as profit
	from (
		SELECT 
		flight.route_number as route_number,
        flight.number as number,
        route.price as price,
        count(flight_has_passenger.passenger_passport) as passenger_count
		FROM flight
        LEFT JOIN route ON flight.route_number = route.number
		left join flight_has_passenger on flight.number = flight_has_passenger.flight_number
        where year(flight.departure_time) = YYYY
		group by flight.route_number, flight.number
    ) ph
    group by route_number, price
    
    order by route_number_1
    
    ) as pr
    
    union all
    
    select 
		"Total profit: " as flight_number,
        " " as passenger_count,
		sum(p.profit_from_route) as profit
    from (
    select
		ph.route_number as route_number_1,
		ph.route_number as number,
        ph.price,
        sum(ph.passenger_count) * ph.price as profit_from_route
	from (
		SELECT 
		flight.route_number as route_number,
        flight.number as number,
        route.price as price,
        count(flight_has_passenger.passenger_passport) as passenger_count
		FROM flight
        LEFT JOIN route ON flight.route_number = route.number
		left join flight_has_passenger on flight.number = flight_has_passenger.flight_number
        where year(flight.departure_time) = YYYY
		group by flight.route_number, flight.number
    ) ph
    group by route_number, price
    ) as p;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-27  0:44:08
