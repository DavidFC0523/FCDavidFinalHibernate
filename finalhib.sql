CREATE DATABASE  IF NOT EXISTS `finalhib2022` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `finalhib2022`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: finalhib2022
-- ------------------------------------------------------
-- Server version	5.7.37-log

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
-- Table structure for table `administradores`
--

DROP TABLE IF EXISTS `administradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administradores` (
  `ModoDios` tinyint(1) DEFAULT '0',
  `IdUsuario` int(11) NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  CONSTRAINT `FK_usuario_administrador` FOREIGN KEY (`IdUsuario`) REFERENCES `usuarios` (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administradores`
--

LOCK TABLES `administradores` WRITE;
/*!40000 ALTER TABLE `administradores` DISABLE KEYS */;
INSERT INTO `administradores` VALUES (0,1);
/*!40000 ALTER TABLE `administradores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `fechaNacimiento` date DEFAULT NULL,
  `genero` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `IdCiclo` varchar(7) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `FKaje5gwut0uhjw0d3qkgiekkt7` (`IdCiclo`),
  CONSTRAINT `FK_usuario_alumnos` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`IdUsuario`),
  CONSTRAINT `FKaje5gwut0uhjw0d3qkgiekkt7` FOREIGN KEY (`IdCiclo`) REFERENCES `ciclos` (`IdCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES ('2013-10-08','Mujer',93,'ADG1-10'),('2022-07-14','Mujer',94,'ADG1-10');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciclos`
--

DROP TABLE IF EXISTS `ciclos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciclos` (
  `IdCiclo` varchar(7) COLLATE utf8_spanish_ci NOT NULL,
  `Abreviatura` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`IdCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclos`
--

LOCK TABLES `ciclos` WRITE;
/*!40000 ALTER TABLE `ciclos` DISABLE KEYS */;
INSERT INTO `ciclos` VALUES ('ADG1-10','SAD','Servicios Administrativos'),('ADG2-1','GAD','Gestión Administrativa'),('ADG3-1','AFI','Administración y Finanzas'),('ADG3-2','ADI','Asistencia a la Dirección'),('COM2-1','ACOM','Actividades Comerciales'),('COM3-1','COI','Comercio Internacional'),('IFC2-1','SMR','Sistemas Microinformáticos y Redes'),('IFC3-1','ASIR','Administración de Sistemas Informáticos en Red'),('IFC3-3','DAW','Desarrollo de Aplicaciones Web');
/*!40000 ALTER TABLE `ciclos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciclosmodulos`
--

DROP TABLE IF EXISTS `ciclosmodulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciclosmodulos` (
  `IdCiclo` varchar(7) COLLATE utf8_spanish_ci NOT NULL,
  `IdModulo` smallint(6) NOT NULL,
  KEY `FK_ciclosmodulos_modulos` (`IdModulo`),
  KEY `FK_ciclosmodulos_ciclos` (`IdCiclo`),
  CONSTRAINT `FK_ciclosmodulos_ciclos` FOREIGN KEY (`IdCiclo`) REFERENCES `ciclos` (`IdCiclo`),
  CONSTRAINT `FK_ciclosmodulos_modulos` FOREIGN KEY (`IdModulo`) REFERENCES `modulos` (`IdModulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclosmodulos`
--

LOCK TABLES `ciclosmodulos` WRITE;
/*!40000 ALTER TABLE `ciclosmodulos` DISABLE KEYS */;
INSERT INTO `ciclosmodulos` VALUES ('ADG1-10',1),('ADG1-10',2),('ADG1-10',3),('ADG1-10',4),('ADG1-10',5),('ADG1-10',6),('ADG1-10',7),('ADG1-10',8),('ADG1-10',9),('ADG1-10',10),('ADG1-10',11),('ADG1-10',12),('ADG1-10',13),('ADG2-1',14),('ADG2-1',15),('ADG2-1',16),('ADG2-1',17),('ADG2-1',18),('ADG2-1',19),('ADG2-1',20),('ADG2-1',21),('ADG2-1',22),('ADG2-1',23),('ADG2-1',24),('ADG2-1',25),('ADG2-1',26),('ADG3-1',15),('ADG3-1',26),('ADG3-1',27),('ADG3-1',28),('ADG3-1',29),('ADG3-1',30),('ADG3-1',31),('ADG3-1',32),('ADG3-1',33),('ADG3-1',34),('ADG3-1',35),('ADG3-1',36),('ADG3-1',37),('ADG3-1',38),('ADG3-2',15),('ADG3-2',26),('ADG3-2',27),('ADG3-2',28),('ADG3-2',29),('ADG3-2',30),('ADG3-2',31),('ADG3-2',32),('ADG3-2',37),('ADG3-2',39),('ADG3-2',40),('ADG3-2',41),('ADG3-2',42),('COM2-1',15),('COM2-1',26),('COM2-1',43),('COM2-1',44),('COM2-1',45),('COM2-1',46),('COM2-1',47),('COM2-1',48),('COM2-1',49),('COM2-1',50),('COM2-1',51),('COM2-1',52),('COM2-1',53),('COM2-1',54),('COM3-1',15),('COM3-1',26),('COM3-1',29),('COM3-1',37),('COM3-1',55),('COM3-1',56),('COM3-1',57),('COM3-1',58),('COM3-1',59),('COM3-1',60),('COM3-1',61),('COM3-1',62),('COM3-1',63),('COM3-1',64),('COM3-1',65),('IFC3-1',15),('IFC3-1',26),('IFC3-1',37),('IFC3-1',66),('IFC3-1',67),('IFC3-1',68),('IFC3-1',69),('IFC3-1',70),('IFC3-1',71),('IFC3-1',72),('IFC3-1',73),('IFC3-1',74),('IFC3-1',75),('IFC3-1',76),('IFC3-3',15),('IFC3-3',26),('IFC3-3',37),('IFC3-3',73),('IFC3-3',77),('IFC3-3',78),('IFC3-3',79),('IFC3-3',80),('IFC3-3',81),('IFC3-3',82),('IFC3-3',83),('IFC3-3',84),('IFC3-3',69),('IFC2-1',86),('IFC2-1',92),('IFC2-1',26),('IFC2-1',15),('IFC2-1',89),('IFC2-1',87),('IFC2-1',88),('IFC2-1',91),('IFC2-1',90),('IFC2-1',85);
/*!40000 ALTER TABLE `ciclosmodulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familias`
--

DROP TABLE IF EXISTS `familias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `familias` (
  `IdFamilia` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `Denominacion` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`IdFamilia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familias`
--

LOCK TABLES `familias` WRITE;
/*!40000 ALTER TABLE `familias` DISABLE KEYS */;
INSERT INTO `familias` VALUES ('ADG','Administración y Gestión'),('COM','Comercio y Márketing'),('IFC','Informática y Comunicaciones');
/*!40000 ALTER TABLE `familias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulos`
--

DROP TABLE IF EXISTS `modulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modulos` (
  `IdModulo` smallint(6) NOT NULL AUTO_INCREMENT,
  `Abreviatura` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `Curso` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `Familia` varchar(4) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Nombre` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `Horas` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`IdModulo`),
  KEY `FKmb5byyce7uo0wi4qrk84uxndl` (`Familia`),
  CONSTRAINT `FKmb5byyce7uo0wi4qrk84uxndl` FOREIGN KEY (`Familia`) REFERENCES `familias` (`IdFamilia`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulos`
--

LOCK TABLES `modulos` WRITE;
/*!40000 ALTER TABLE `modulos` DISABLE KEYS */;
INSERT INTO `modulos` VALUES (1,'APLIC','1','ADG','Aplicaciones básicas de ofimática',192),(2,'TECNI','1','ADG','Técnicas administrativas básicas',224),(3,'ARCHI','1','ADG','Archivo y comunicación',128),(4,'CCAP1','1','ADG','Ciencias Aplicadas I',160),(5,'LCCS1','1','ADG','Lengua castellana y ciencias sociales I',160),(6,'IEX1','1','ADG','Idioma extranjero I',64),(7,'TRATA','2','ADG','Tratamiento informático de datos',266),(8,'ATENC','2','ADG','Atención al cliente',112),(9,'PREPA','2','ADG','Preparación de pedidos y venta de productos',112),(10,'CCAP2','2','ADG','Ciencias Aplicadas II',150),(11,'LCCS2','2','ADG','Lengua castellana y ciencias sociales II',150),(12,'IEX2','2','ADG','Idioma extranjero II',60),(13,'FCT','2',NULL,'Formación en centros de trabajo (130 horas)',130),(14,'CEAC','1','ADG','Comunicación empresarial y atención al cliente',192),(15,'FOL','1',NULL,'Formación y orientación laboral',96),(16,'INGI','1',NULL,'Inglés I',64),(17,'OACV','1','ADG','Operaciones adminstrativas de compra-venta',192),(18,'TEC','1','ADG','Técnica contable',128),(19,'TII','1','ADG','Tratamiento informático de la información',288),(20,'EMEAU','2','ADG','Empresa en el aula',120),(21,'EMYAD','2','ADG','Empresa y adminstración',100),(22,'INGII','2',NULL,'Inglés II',60),(23,'OADRH','2','ADG','Operaciones adminstrativas de recursos humanos',120),(24,'OADGT','2','ADG','Operaciones auxiliares de gestión de tesorería',140),(25,'TRDCO','2','ADG','Tratamiento de la documentación contable',80),(26,'FCT','2',NULL,'Formación en centros de trabajo (400 horas)',400),(27,'CYAC','1','ADG','Comunicación y atención al cliente',128),(28,'GDJE','1','ADG','Gestión de la documentación jurídica y empresarial',96),(29,'ING','1',NULL,'Inglés',128),(30,'OYPI','1','ADG','Ofimática y proceso de la información',256),(31,'PIAC','1','ADG','Proceso integral de la actividad comercial',192),(32,'RHRSC','1','ADG','Recursos humanos y responsabilidad social corporativa',64),(33,'CFI','2','ADG','Contabilidad y fiscalidad',160),(34,'GRH','2','ADG','Gestión de recursos humanos',60),(35,'GFI','2','ADG','Gestión financiera',160),(36,'GESTI','2','ADG','Gestión logística y comercial',100),(37,'PROFC','2',NULL,'Proyecto',40),(38,'SIMUL','2','ADG','Simulación empresarial',120),(39,'GAI','2','ADG','Gestión avanzada de la información',140),(40,'OEE','2','ADG','Organización de eventos empresariales',180),(41,'PROTO','2','ADG','Protocolo empresarial',160),(42,'SLE','2','ADG','Segunda lengua extranjera',120),(43,'AIC','1','COM','Aplicaciones informáticas para el comercio',160),(44,'DPV','1','COM','Dinamización del punto de venta',192),(45,'GECO','1','COM','Gestión de compras',96),(46,'ING','1',NULL,'Inglés(96 horas)',96),(47,'MAC','1','COM','Márqueting en la actividad comercial',160),(48,'PRV','1','COM','Procesos de venta',160),(49,'COMER','2','COM','Comercio electrónico',80),(50,'GESTI','2','COM','Gestión de un pequeño comercio',160),(51,'ING','2',NULL,'Inglés(40 horas)',40),(52,'SAC','2','COM','Servicios de atención comercial',80),(53,'TECNI','2','COM','Técnicas de almacén',120),(54,'VENTA','2','COM','Venta técnica',120),(55,'GCI','1','COM','Gestión administrativa del comercio internacional',224),(56,'GEFE','1','COM','Gestión económica y financiera de la empresa',192),(57,'LOGIS','1','COM','Logística de almacenamiento',128),(58,'TIM','1','COM','Transporte internacional de mercancías',192),(59,'CDI','2','COM','Comercio digital internacional',60),(60,'EII','2','COM','Ex. Inglés I',40),(61,'FI','2','COM','Financiación internacional',120),(62,'MI','2','COM','Márketing internacional',140),(63,'MPI','2','COM','Métodos de pago internacionales',80),(64,'NI','2','COM','Negociación internacional',80),(65,'SIM','2','COM','Sistema de información de mercados',80),(66,'FHW','1','IFC','Fundamentos del hardware',96),(67,'GBD','1','IFC','Gestión de bases de datos',192),(68,'ISO','1','IFC','Implementación de sistemas operativos',224),(69,'LMSGI','1','IFC','Lenguajes de marcas y sistemas de gestión de información',128),(70,'PARE','1','IFC','Planificación y administración de redes',224),(71,'ASGBD','2','IFC','Administración de sistemas gestores de bases de datos',80),(72,'ASSOO','2','IFC','Administración de sistemas operativos',160),(73,'EMINI','2',NULL,'Empresa e iniciativa emprendedora',60),(74,'IAPLW','2','IFC','Implantación de aplicaciones web',100),(75,'SGALD','2','IFC','Seguridad y alta disponibilidad',80),(76,'SREIN','2','IFC','Servicios de red e Internet',120),(77,'BBDD','1','IFC','Bases de datos',192),(78,'ENTDL','1','IFC','Entornos de desarrollo',128),(79,'PGRMC','1','IFC','Programación',224),(80,'SSINF','1','IFC','Sistemas informáticos',192),(81,'DWENC','2','IFC','Desarrollo web en entorno cliente',140),(82,'DWESV','2','IFC','Desarrollo web en entorno servidor',160),(83,'DEAPW','2','IFC','Despliegue de aplicaciones web',100),(84,'DINW','2','IFC','Diseño de interfaces web',140),(85,'SOM','1','IFC','Sistemas Operativos Monopuesto',160),(86,'AAOO','1','IFC','Aplicaciones Ofimáticas',288),(87,'RL','1','IFC','Redes Locales',224),(88,'SI','1','IFC','Seguridad Informática',192),(89,'MME','2','IFC','Montaje y Mantenimiento de Equipos',170),(90,'SOR','2','IFC','Sistemas Operativos en Red',130),(91,'SER','2','IFC','Servicios en Red',150),(92,'APW','2','IFC','Aplicaciones Web',130);
/*!40000 ALTER TABLE `modulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notas`
--

DROP TABLE IF EXISTS `notas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notas` (
  `idNota` int(11) NOT NULL AUTO_INCREMENT,
  `notas` smallint(6) DEFAULT NULL,
  `idDeUsuario` int(11) DEFAULT NULL,
  `idModulo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idNota`),
  KEY `FK_Usuario_Notas` (`idDeUsuario`),
  CONSTRAINT `FK_Usuario_Notas` FOREIGN KEY (`idDeUsuario`) REFERENCES `alumnos` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=470 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notas`
--

LOCK TABLES `notas` WRITE;
/*!40000 ALTER TABLE `notas` DISABLE KEYS */;
INSERT INTO `notas` VALUES (444,1,93,5),(445,1,93,1),(446,1,93,11),(447,1,93,13),(448,1,93,9),(449,1,93,6),(450,1,93,4),(451,1,93,8),(452,1,93,12),(453,1,93,7),(454,1,93,2),(455,1,93,3),(456,1,93,10),(457,1,94,10),(458,1,94,4),(459,1,94,6),(460,1,94,9),(461,1,94,12),(462,1,94,13),(463,1,94,11),(464,1,94,5),(465,1,94,8),(466,1,94,3),(467,1,94,2),(468,1,94,7),(469,1,94,1);
/*!40000 ALTER TABLE `notas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutores`
--

DROP TABLE IF EXISTS `tutores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutores` (
  `idUsuario` int(11) NOT NULL,
  `IdCiclo` varchar(7) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `FKnurbjvn6vs9du0xbyex82qsjh` (`IdCiclo`),
  CONSTRAINT `FK_usuario_tutor` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`IdUsuario`),
  CONSTRAINT `FKnurbjvn6vs9du0xbyex82qsjh` FOREIGN KEY (`IdCiclo`) REFERENCES `ciclos` (`IdCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutores`
--

LOCK TABLES `tutores` WRITE;
/*!40000 ALTER TABLE `tutores` DISABLE KEYS */;
INSERT INTO `tutores` VALUES (58,'ADG1-10'),(62,'COM2-1');
/*!40000 ALTER TABLE `tutores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Apellidos` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Avatar` varchar(40) COLLATE utf8_spanish_ci DEFAULT 'avatar.png',
  `DNI` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Email` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Password` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Rol` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `ultimoAcceso` date DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,NULL,'avatar.png',NULL,'finalhib@gmail.com','Admin','202CB962AC59075B964B07152D234B70','ADMIN','2022-07-14'),(58,'asd','avatar.png','asd','tutor1@gmai.co','tutor1','202CB962AC59075B964B07152D234B70','TUTOR','2022-07-14'),(62,'asd','avatar.png','asd','asd2asd@asd.c2','asd','202CB962AC59075B964B07152D234B70','TUTOR','2022-07-14'),(91,'dasd','avatar.png','asd','asd','asd','202CB962AC59075B964B07152D234B70','ALUMNO','2022-03-17'),(92,'asd','avatar.png','asd','asd','asd','202CB962AC59075B964B07152D234B70','ALUMNO','2022-03-18'),(93,'Alumno1','avatar.png','092241231','alumno1@gmail.com','Alumno1','202cb962ac59075b964b07152d234b70','ALUMNO','2022-07-14'),(94,NULL,'avatar.png',NULL,'alumno2@gmail.com',NULL,'202cb962ac59075b964b07152d234b70','ALUMNO',NULL);
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

-- Dump completed on 2022-07-14 23:48:37
