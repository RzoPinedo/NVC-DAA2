CREATE DATABASE  IF NOT EXISTS `nvconsulting` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `nvconsulting`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: nvconsulting
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `alumno_cursos`
--

DROP TABLE IF EXISTS `alumno_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno_cursos` (
  `ID_ALUMNO_CURSOS` int NOT NULL AUTO_INCREMENT,
  `ID_CURSOS` int NOT NULL,
  `ID_ALUMNO` int NOT NULL,
  `ESTADO` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID_ALUMNO_CURSOS`),
  UNIQUE KEY `XPKALUMNO_CURSOS` (`ID_ALUMNO_CURSOS`),
  KEY `XIF1ALUMNO_CURSOS` (`ID_CURSOS`),
  KEY `XIF2ALUMNO_CURSOS` (`ID_ALUMNO`),
  CONSTRAINT `alumno_cursos_ibfk_1` FOREIGN KEY (`ID_CURSOS`) REFERENCES `cursos` (`ID_CURSOS`),
  CONSTRAINT `alumno_cursos_ibfk_2` FOREIGN KEY (`ID_ALUMNO`) REFERENCES `alumnos` (`ID_ALUMNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_cursos`
--

LOCK TABLES `alumno_cursos` WRITE;
/*!40000 ALTER TABLE `alumno_cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `ID_ALUMNO` int NOT NULL AUTO_INCREMENT,
  `NOMBRES` varchar(50) DEFAULT NULL,
  `APELLIDOS` varchar(50) DEFAULT NULL,
  `DNI` char(8) DEFAULT NULL,
  `CORREO` varchar(50) DEFAULT NULL,
  `TELEFONO` char(9) DEFAULT NULL,
  `DIRECCION` varchar(50) DEFAULT NULL,
  `ESTADO` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID_ALUMNO`),
  UNIQUE KEY `XPKALUMNOS` (`ID_ALUMNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `ID_CARGO` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `ESTADO` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID_CARGO`),
  UNIQUE KEY `XPKCARGO` (`ID_CARGO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'ADMINISTRADOR',1);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `ID_CURSOS` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(100) DEFAULT NULL,
  `NRO_HORAS` int DEFAULT NULL,
  `FECHA_INICIO` datetime DEFAULT NULL,
  `PRECIO_CURSO` decimal(10,2) DEFAULT NULL,
  `FECHA_FIN` datetime DEFAULT NULL,
  `ESTADO` tinyint(1) NOT NULL,
  `ID_EMPLEADOS` int NOT NULL,
  PRIMARY KEY (`ID_CURSOS`),
  UNIQUE KEY `XPKCURSOS` (`ID_CURSOS`),
  KEY `XIF1CURSOS` (`ID_EMPLEADOS`),
  CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`ID_EMPLEADOS`) REFERENCES `empleados` (`ID_EMPLEADOS`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'ASEGURAMIENTO DE CALIDAD DE RESULTADOS DE ENSAYO SEGÚN LA NORMA ISOIEC ',150,'2022-01-20 00:00:00',250.00,'2022-02-20 00:00:00',1,1),(6,'GESTIÓN DE LA MEJORA CONTINUA',150,'2022-05-12 00:00:00',250.00,'2022-06-12 00:00:00',1,1),(7,'CONTROL Y MONITOREO DE VARIABLES POR GRÁFICOS DE CONTROL UNIVARIADOS',150,'2022-02-15 00:00:00',250.00,'2022-03-20 00:00:00',1,1),(8,'DETERMINACIÓN DE LÍMITES DE DETECCIÓN Y CUANTIFICACIÓN DE MÉTODOS DE ENSAYO FÍSICO QUÍMICO',150,'2022-04-12 00:00:00',250.00,'2022-05-12 00:00:00',1,1),(9,'GESTIÓN DE LA CALIDAD POR INDICADORES EN UN LABORATORIO DE ENSAYO',150,'2022-06-15 00:00:00',250.00,'2022-07-15 00:00:00',1,1),(10,'GESTIÓN DE RIESGO EN LABORATORIO DE ENSAYO',150,'2022-03-11 00:00:00',250.00,'2022-04-11 00:00:00',1,1),(11,'MEDICIÓN DE LA SATISFACCIÓN DEL CLIENTE',150,'2022-04-25 00:00:00',250.00,'2022-05-25 00:00:00',1,1),(12,'VALIDACIÓN D MÉTODOS DE ENSAYO CUALITATIVOS',150,'2022-03-12 00:00:00',250.00,'2022-04-14 00:00:00',1,1);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `ID_EMPLEADOS` int NOT NULL AUTO_INCREMENT,
  `NOMBRES` varchar(50) DEFAULT NULL,
  `APELLIDOS` varchar(50) DEFAULT NULL,
  `DNI` char(8) DEFAULT NULL,
  `CORREO` varchar(50) DEFAULT NULL,
  `TELEFONO` char(9) DEFAULT NULL,
  `DIRECCION` varchar(50) DEFAULT NULL,
  `ESTADO` tinyint(1) NOT NULL,
  `ID_CARGO` int NOT NULL,
  PRIMARY KEY (`ID_EMPLEADOS`),
  UNIQUE KEY `XPKPROFESORES` (`ID_EMPLEADOS`),
  KEY `XIF1PROFESORES` (`ID_CARGO`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`ID_CARGO`) REFERENCES `cargo` (`ID_CARGO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'MARILIN','QUISPE',NULL,NULL,NULL,NULL,1,1),(2,'LEO','PINEDO',NULL,NULL,NULL,NULL,1,1);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `ID_PAGO` int NOT NULL AUTO_INCREMENT,
  `FORMA_PAGO` varchar(50) DEFAULT NULL,
  `ENTIDAD_FINANCIERA` varchar(50) DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `HORA` datetime DEFAULT NULL,
  `ESTADO` tinyint(1) NOT NULL,
  `ID_CURSOS` int NOT NULL,
  `OBSERVACION` varchar(50) DEFAULT NULL,
  `ID_ALUMNO` int NOT NULL,
  PRIMARY KEY (`ID_PAGO`),
  UNIQUE KEY `XPKPAGO` (`ID_PAGO`),
  KEY `XIF1PAGO` (`ID_CURSOS`),
  KEY `XIF2PAGO` (`ID_ALUMNO`),
  CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`ID_CURSOS`) REFERENCES `cursos` (`ID_CURSOS`),
  CONSTRAINT `pago_ibfk_2` FOREIGN KEY (`ID_ALUMNO`) REFERENCES `alumnos` (`ID_ALUMNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `ID_ROL` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `ESTADO` tinyint(1) NOT NULL,
  PRIMARY KEY (`ID_ROL`),
  UNIQUE KEY `XPKROL` (`ID_ROL`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ADMINISTRADOR',1);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `ID_USUARIOS` int NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `ID_EMPLEADOS` int DEFAULT NULL,
  `ID_ALUMNO` int DEFAULT NULL,
  `ID_ROL` int DEFAULT NULL,
  `ESTADO` tinyint(1) NOT NULL,
  `OBSERVACION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIOS`),
  UNIQUE KEY `XPKUSUARIOS` (`ID_USUARIOS`),
  KEY `XIF1USUARIOS` (`ID_EMPLEADOS`),
  KEY `XIF2USUARIOS` (`ID_ALUMNO`),
  KEY `XIF3USUARIOS` (`ID_ROL`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`ID_EMPLEADOS`) REFERENCES `empleados` (`ID_EMPLEADOS`),
  CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`ID_ALUMNO`) REFERENCES `alumnos` (`ID_ALUMNO`),
  CONSTRAINT `usuarios_ibfk_3` FOREIGN KEY (`ID_ROL`) REFERENCES `rol` (`ID_ROL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'LEO','LEO',2,NULL,1,1,NULL),(2,'MARILIN','MARILIN',1,NULL,1,1,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 13:12:56
