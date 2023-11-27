CREATE DATABASE  IF NOT EXISTS `moonlight` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `moonlight`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: moonlight
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `itens_produtos`
--

DROP TABLE IF EXISTS `itens_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens_produtos` (
  `ID_ITEM_PRODUTO` int NOT NULL AUTO_INCREMENT,
  `QUANTIDADE` float NOT NULL,
  `ID_PRODUTO` int(10) unsigned zerofill NOT NULL,
  `ID_MATERIA_PRIMA` int NOT NULL,
  `SUBTOTAL` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_ITEM_PRODUTO`),
  UNIQUE KEY `IDX_ITENS_PRODUTOS_001` (`ID_ITEM_PRODUTO`),
  KEY `IND_PRODUTOS_ITENS_PRODUTOS_001` (`ID_MATERIA_PRIMA`),
  KEY `IND_MATERIAS_PRIMAS_ITENS_PRODUTOS_002` (`ID_PRODUTO`),
  CONSTRAINT `FK_MATERIAS_PRIMAS_ITENS_PRODUTOS_002` FOREIGN KEY (`ID_MATERIA_PRIMA`) REFERENCES `materias_primas` (`ID_MATERIA_PRIMA`),
  CONSTRAINT `FK_PRODUTOS_ITENS_PRODUTOS_001` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produtos` (`ID_PRODUTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `materias_primas`
--

DROP TABLE IF EXISTS `materias_primas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materias_primas` (
  `ID_MATERIA_PRIMA` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `DESCRICAO` varchar(200) NOT NULL,
  `VALOR` decimal(10,2) NOT NULL,
  `QUANTIDADE` float NOT NULL,
  `ID_UNIDADE_MEDIDA` int NOT NULL,
  `ID_TIPO_MATERIA_PRIMA` int NOT NULL,
  PRIMARY KEY (`ID_MATERIA_PRIMA`),
  UNIQUE KEY `IDX_MATERIAS_PRIMAS_001` (`ID_MATERIA_PRIMA`),
  UNIQUE KEY `IDX_MATERIAS_PRIMAS_002` (`NOME`),
  KEY `IND_UNIDADES_MEDIDAS_MATERIAS_PRIMAS_001` (`ID_UNIDADE_MEDIDA`),
  KEY `IND_TIPOS_MATERIAS_PRIMAS_MATERIAS_PRIMAS_002` (`ID_TIPO_MATERIA_PRIMA`),
  CONSTRAINT `FK_TIPOS_MATERIAS_PRIMAS_MATERIAS_PRIMAS_002` FOREIGN KEY (`ID_TIPO_MATERIA_PRIMA`) REFERENCES `tipos_materias_primas` (`ID_TIPO_MATERIA_PRIMA`),
  CONSTRAINT `FK_UNIDADES_MEDIDAS_MATERIAS_PRIMAS_001` FOREIGN KEY (`ID_UNIDADE_MEDIDA`) REFERENCES `unidades_medidas` (`ID_UNIDADE_MEDIDA`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `processos`
--

DROP TABLE IF EXISTS `processos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `processos` (
  `ID_PROCESSO` int NOT NULL AUTO_INCREMENT,
  `ETAPA` varchar(150) NOT NULL,
  `CUSTO` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_PROCESSO`),
  UNIQUE KEY `IDX_PROCESSOS_001` (`ID_PROCESSO`),
  UNIQUE KEY `ETAPA_UNIQUE` (`ETAPA`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `ID_PRODUTO` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `DESCRICAO` varchar(200) NOT NULL,
  `ID_VALOR_PRODUTO` int NOT NULL,
  `ID_UNIDADE_MEDIDA` int NOT NULL,
  `ID_TIPO_PRODUTO` int NOT NULL,
  PRIMARY KEY (`ID_PRODUTO`),
  UNIQUE KEY `IDX_PRODUTOS_001` (`ID_PRODUTO`),
  UNIQUE KEY `IDX_PRODUTOS_002` (`NOME`) /*!80000 INVISIBLE */,
  KEY `IND_PRODUTOS_001` (`ID_VALOR_PRODUTO`),
  KEY `fk_PRODUTOS_UNIDADES_MEDIDAS1_idx` (`ID_UNIDADE_MEDIDA`),
  KEY `fk_PRODUTOS_TIPOS_PRODUTOS1_idx` (`ID_TIPO_PRODUTO`),
  CONSTRAINT `fk_PRODUTOS_TIPOS_PRODUTOS1` FOREIGN KEY (`ID_TIPO_PRODUTO`) REFERENCES `tipos_produtos` (`ID_TIPO_PRODUTO`),
  CONSTRAINT `fk_PRODUTOS_UNIDADES_MEDIDAS1` FOREIGN KEY (`ID_UNIDADE_MEDIDA`) REFERENCES `unidades_medidas` (`ID_UNIDADE_MEDIDA`),
  CONSTRAINT `FK_VALORES_PRODUTOS_PRODUTOS` FOREIGN KEY (`ID_VALOR_PRODUTO`) REFERENCES `valores_produtos` (`ID_VALOR_PRODUTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produtos_processos`
--

DROP TABLE IF EXISTS `produtos_processos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos_processos` (
  `ID_PRODUTO_PROCESSO` int NOT NULL AUTO_INCREMENT,
  `ID_PRODUTO` int(10) unsigned zerofill NOT NULL,
  `ID_PROCESSO` int NOT NULL,
  PRIMARY KEY (`ID_PRODUTO_PROCESSO`),
  UNIQUE KEY `IDX_PRODUTOS_PROCESSOS_001` (`ID_PRODUTO_PROCESSO`),
  KEY `IND_PRODUTOS_PROCESSOS_001` (`ID_PROCESSO`),
  KEY `IND_PRODUTOS_PROCESSOS_002` (`ID_PRODUTO`),
  CONSTRAINT `FK_PRODUTOS_PROCESSOS_PROCESSOS` FOREIGN KEY (`ID_PROCESSO`) REFERENCES `processos` (`ID_PROCESSO`),
  CONSTRAINT `FK_PRODUTOS_PROCESSOS_PRODUTOS` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produtos` (`ID_PRODUTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipos_materias_primas`
--

DROP TABLE IF EXISTS `tipos_materias_primas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_materias_primas` (
  `ID_TIPO_MATERIA_PRIMA` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO_MATERIA_PRIMA`),
  UNIQUE KEY `IDX_TIPOS_MATERIAS_PRIMAS_001` (`ID_TIPO_MATERIA_PRIMA`),
  UNIQUE KEY `IDX_TIPOS_MATERIAS_PRIMAS_002` (`NOME`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tipos_produtos`
--

DROP TABLE IF EXISTS `tipos_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_produtos` (
  `ID_TIPO_PRODUTO` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO_PRODUTO`),
  UNIQUE KEY `IDX_TIPOS_PRODUTOS_001` (`ID_TIPO_PRODUTO`),
  UNIQUE KEY `IDX_TIPOS_PRODUTOS_002` (`NOME`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `unidades_medidas`
--

DROP TABLE IF EXISTS `unidades_medidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidades_medidas` (
  `ID_UNIDADE_MEDIDA` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `SIGLA` varchar(3) NOT NULL,
  PRIMARY KEY (`ID_UNIDADE_MEDIDA`),
  UNIQUE KEY `IDX_UNIDADES_MEDIDAS_001` (`ID_UNIDADE_MEDIDA`),
  UNIQUE KEY `IDX_UNIDADES_MEDIDAS_002` (`SIGLA`),
  UNIQUE KEY `IDX_UNIDADES_MEDIDAS_003` (`NOME`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `valores_produtos`
--

DROP TABLE IF EXISTS `valores_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valores_produtos` (
  `ID_VALOR_PRODUTO` int NOT NULL AUTO_INCREMENT,
  `VALOR_RECOMENDADO` decimal(10,2) NOT NULL,
  `VALOR` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID_VALOR_PRODUTO`),
  UNIQUE KEY `IDX_VALORES_PRODUTOS_001` (`ID_VALOR_PRODUTO`) /*!80000 INVISIBLE */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-25 20:46:02
