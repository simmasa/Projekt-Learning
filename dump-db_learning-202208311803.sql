-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: db_learning
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `capitolo`
--

DROP TABLE IF EXISTS `capitolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `capitolo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(255) DEFAULT NULL,
  `numero_capitolo` int NOT NULL,
  `titolo` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `corsi_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cnvaqnlikxmm9ercur9auef0v` (`url`),
  KEY `FKl6jxjwienlstbrcumg6ua6xq4` (`corsi_id`),
  CONSTRAINT `FKl6jxjwienlstbrcumg6ua6xq4` FOREIGN KEY (`corsi_id`) REFERENCES `corsi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capitolo`
--

LOCK TABLES `capitolo` WRITE;
/*!40000 ALTER TABLE `capitolo` DISABLE KEYS */;
INSERT INTO `capitolo` VALUES (1,'Introduzione iniziale al linguaggio Java',1,'Introduzione a Java','',1),(2,'Spiegazione variabili',2,'Variabili',' ',1),(3,'Introduzione ai cicli FOR e WHILE',3,'Operatori Logici','fd',1),(4,'Introduzione agli ingredienti principali',1,'Introduzione alla pasticceria PROFESSIONALE','bsgbfgn',2),(7,'Inizializziamo il forno',2,'Mica solo Pizze!','fdf',2),(8,'Non posso ne scendere e ne salire, rimango qua :(',3,'Tiramisù e Tiramigiu','b',2),(9,'Spiegazione delle basi in ambito amministrativo',1,'Introduzione alla contabilià','fg',3),(10,'Introduzione ai nuovissimi generi musicali',1,'L\'opera','gfd',4);
/*!40000 ALTER TABLE `capitolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jhxjqsb8p08q27wphkvtwg5aq` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorie`
--

LOCK TABLES `categorie` WRITE;
/*!40000 ALTER TABLE `categorie` DISABLE KEYS */;
INSERT INTO `categorie` VALUES (4,'Amministrazione'),(2,'Cucina'),(5,'Industria'),(1,'Informatica'),(6,'Marketing'),(3,'Musica');
/*!40000 ALTER TABLE `categorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corsi`
--

DROP TABLE IF EXISTS `corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corsi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_creazione` date NOT NULL,
  `descrizione` longtext,
  `durata` int DEFAULT NULL,
  `livello_difficolta` int DEFAULT NULL,
  `titolo` varchar(255) NOT NULL,
  `categorie_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_td4smg9k8npofrn5bnlif2n8` (`titolo`),
  KEY `FK8tnkaix2mslajq3xj0r3xuvje` (`categorie_id`),
  CONSTRAINT `FK8tnkaix2mslajq3xj0r3xuvje` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corsi`
--

LOCK TABLES `corsi` WRITE;
/*!40000 ALTER TABLE `corsi` DISABLE KEYS */;
INSERT INTO `corsi` VALUES (1,'2022-08-31','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vel lectus eget est ultrices luctus. Suspendisse id sapien ut libero dapibus facilisis at eget quam. Nullam vulputate laoreet libero ac placerat. In imperdiet urna et velit iaculis, ac fringilla leo vehicula. Mauris efficitur magna lectus, et malesuada sem congue a. Proin accumsan porta mi, ut porta mauris dignissim et. Vivamus volutpat luctus mi, varius lobortis nunc efficitur sit amet. In congue condimentum semper. Quisque finibus sapien a lorem porttitor imperdiet.',350,3,'Java Junior Developer',1),(2,'2012-12-21','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur la tua anima sara mia. eget est ultrices luctus. Suspendisse id sapien ut libero dapibus facilisis at eget quam. Nullam vulputate laoreet libero ac placerat. In imperdiet urna et velit iaculis, ac fringilla leo vehicula. Mauris efficitur magna lectus, et malesuada sem congue a. Proin accumsan porta mi, ut porta mauris dignissim et. Vivamus volutpat luctus mi, varius lobortis nunc efficitur sit amet. In congue condimentum semper. Quisque finibus sapien a lorem porttitor imperdiet.',666,5,'Torte Contorte',2),(3,'2022-04-18','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vel lectus eget est ultrices luctus. Suspendisse id sapien ut libero dapibus facilisis at eget quam. Nullam vulputate laoreet libero ac placerat. In imperdiet urna et velit iaculis, ac fringilla leo vehicula. Mauris efficitur magna lectus, et malesuada sem congue a. Proin accumsan porta mi, ut porta mauris dignissim et. Vivamus volutpat luctus mi, varius lobortis nunc efficitur sit amet. In congue condimentum semper. Quisque finibus sapien a lorem porttitor imperdiet.',45,4,'Fatturazione e Contabilità',4),(4,'1824-05-07','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur vel lectus eget est ultrices luctus. Suspendisse id sapien ut libero dapibus facilisis at eget quam. Nullam vulputate laoreet libero ac placerat. In imperdiet urna et velit iaculis, ac fringilla leo vehicula. Mauris efficitur magna lectus, et malesuada sem congue a. Proin accumsan porta mi, ut porta mauris dignissim et. Vivamus volutpat luctus mi, varius lobortis nunc efficitur sit amet. In congue condimentum semper. Quisque finibus sapien a lorem porttitor imperdiet.',700,4,'Musica contemporanea',3);
/*!40000 ALTER TABLE `corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corsi_tags`
--

DROP TABLE IF EXISTS `corsi_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corsi_tags` (
  `corsi_id` int NOT NULL,
  `tags_id` int NOT NULL,
  KEY `FKdtnfa8mgf4118t4e6ec7ytnbx` (`tags_id`),
  KEY `FK6orind1m5pv3jr1yj2348qlet` (`corsi_id`),
  CONSTRAINT `FK6orind1m5pv3jr1yj2348qlet` FOREIGN KEY (`corsi_id`) REFERENCES `corsi` (`id`),
  CONSTRAINT `FKdtnfa8mgf4118t4e6ec7ytnbx` FOREIGN KEY (`tags_id`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corsi_tags`
--

LOCK TABLES `corsi_tags` WRITE;
/*!40000 ALTER TABLE `corsi_tags` DISABLE KEYS */;
INSERT INTO `corsi_tags` VALUES (1,2),(1,8),(1,6),(2,3),(2,5),(2,6),(3,7),(3,4),(3,1),(4,5),(4,4),(4,7);
/*!40000 ALTER TABLE `corsi_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insegnanti`
--

DROP TABLE IF EXISTS `insegnanti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insegnanti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) NOT NULL,
  `foto` longtext,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insegnanti`
--

LOCK TABLES `insegnanti` WRITE;
/*!40000 ALTER TABLE `insegnanti` DISABLE KEYS */;
INSERT INTO `insegnanti` VALUES (1,'Jobs',NULL,'Steve'),(2,'Massari',NULL,'Iginio'),(3,'De Paperoni',NULL,'Paperon'),(4,'Beethoven',NULL,'Ludwig Van');
/*!40000 ALTER TABLE `insegnanti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insegnanti_corsis`
--

DROP TABLE IF EXISTS `insegnanti_corsis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `insegnanti_corsis` (
  `insegnanti_id` int NOT NULL,
  `corsis_id` int NOT NULL,
  KEY `FKdao4mrqb7t9wsvi3gydbiv5y1` (`corsis_id`),
  KEY `FK6henssiybadltcto5k7x5caod` (`insegnanti_id`),
  CONSTRAINT `FK6henssiybadltcto5k7x5caod` FOREIGN KEY (`insegnanti_id`) REFERENCES `insegnanti` (`id`),
  CONSTRAINT `FKdao4mrqb7t9wsvi3gydbiv5y1` FOREIGN KEY (`corsis_id`) REFERENCES `corsi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insegnanti_corsis`
--

LOCK TABLES `insegnanti_corsis` WRITE;
/*!40000 ALTER TABLE `insegnanti_corsis` DISABLE KEYS */;
INSERT INTO `insegnanti_corsis` VALUES (1,1),(2,2),(3,3),(4,4);
/*!40000 ALTER TABLE `insegnanti_corsis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazioni`
--

DROP TABLE IF EXISTS `prenotazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazioni` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_prenotazione` date NOT NULL,
  `email_prenonato` varchar(255) NOT NULL,
  `slot_orari` varchar(5) NOT NULL,
  `insegnanti_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn2sbpm0ap9qnwrle6ncgp4dqx` (`insegnanti_id`),
  CONSTRAINT `FKn2sbpm0ap9qnwrle6ncgp4dqx` FOREIGN KEY (`insegnanti_id`) REFERENCES `insegnanti` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazioni`
--

LOCK TABLES `prenotazioni` WRITE;
/*!40000 ALTER TABLE `prenotazioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `prenotazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'Per tutti'),(2,'Intermedio'),(3,'Difficile'),(4,'Nuovo'),(5,'Top 10'),(6,'Scontato'),(7,'Veloce'),(8,'Intensivo');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_learning'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-31 18:03:24
