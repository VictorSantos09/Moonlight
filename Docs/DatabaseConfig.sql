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
-- Dumping data for table `itens_produtos`
--

LOCK TABLES `itens_produtos` WRITE;
/*!40000 ALTER TABLE `itens_produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_produtos` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias_primas`
--

LOCK TABLES `materias_primas` WRITE;
/*!40000 ALTER TABLE `materias_primas` DISABLE KEYS */;
/*!40000 ALTER TABLE `materias_primas` ENABLE KEYS */;
UNLOCK TABLES;

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
  `ID_PRODUTO` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`ID_PROCESSO`),
  UNIQUE KEY `IDX_PROCESSOS_001` (`ID_PROCESSO`),
  KEY `IND_PROCESSOS_PRODUTOS_001` (`ID_PRODUTO`),
  CONSTRAINT `FK_PRODUTOS_PROCESSOS_001` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produtos` (`ID_PRODUTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processos`
--

LOCK TABLES `processos` WRITE;
/*!40000 ALTER TABLE `processos` DISABLE KEYS */;
/*!40000 ALTER TABLE `processos` ENABLE KEYS */;
UNLOCK TABLES;

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
  PRIMARY KEY (`ID_PRODUTO`),
  UNIQUE KEY `IDX_PRODUTOS_001` (`ID_PRODUTO`),
  UNIQUE KEY `IDX_PRODUTOS_002` (`NOME`) /*!80000 INVISIBLE */,
  KEY `IND_PRODUTOS_001` (`ID_VALOR_PRODUTO`),
  CONSTRAINT `FK_VALORES_PRODUTOS_PRODUTOS` FOREIGN KEY (`ID_VALOR_PRODUTO`) REFERENCES `valores_produtos` (`ID_VALOR_PRODUTO`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (0000000008,'BOLO DE MORANGO','MT BOM',1),(0000000009,'BOLO DE UVA','MT BOM',7);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos_medidas`
--

DROP TABLE IF EXISTS `produtos_medidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos_medidas` (
  `ID_PRODUTO_MEDIDA` int NOT NULL AUTO_INCREMENT,
  `ID_UNIDADE_MEDIDA` int NOT NULL,
  `ID_PRODUTO` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`ID_PRODUTO_MEDIDA`),
  UNIQUE KEY `IDX_PRODUTOS_MEDIDAS_001` (`ID_PRODUTO_MEDIDA`),
  KEY `IND_UNIDADES_MEDIDAS_PRODUTOS_MEDIDAS_001` (`ID_PRODUTO`),
  KEY `IND__PRODUTOS_PRODUTOS_MEDIDAS_002` (`ID_UNIDADE_MEDIDA`),
  CONSTRAINT `FK_PRODUTOS_PRODUTOS_MEDIDAS_002` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produtos` (`ID_PRODUTO`),
  CONSTRAINT `FK_UNIDADES_MEDIDAS_PRODUTOS_MEDIDAS_001` FOREIGN KEY (`ID_UNIDADE_MEDIDA`) REFERENCES `unidades_medidas` (`ID_UNIDADE_MEDIDA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos_medidas`
--

LOCK TABLES `produtos_medidas` WRITE;
/*!40000 ALTER TABLE `produtos_medidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtos_medidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos_tipos`
--

DROP TABLE IF EXISTS `produtos_tipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos_tipos` (
  `ID_PRODUTO_TIPO` int NOT NULL AUTO_INCREMENT,
  `ID_PRODUTO` int(10) unsigned zerofill NOT NULL,
  `ID_TIPO_PRODUTO` int NOT NULL,
  PRIMARY KEY (`ID_PRODUTO_TIPO`),
  UNIQUE KEY `IDX_PRODUTOS_TIPOS_001` (`ID_PRODUTO_TIPO`),
  KEY `IND_PRODUTOS_TIPOS_PRODUTOS_001` (`ID_TIPO_PRODUTO`),
  KEY `IND_PRODUTOS_TIPOS_PRODUTOS_002` (`ID_PRODUTO`),
  CONSTRAINT `FK_PRODUTOS_PRODUTOS_TIPOS_001` FOREIGN KEY (`ID_PRODUTO`) REFERENCES `produtos` (`ID_PRODUTO`),
  CONSTRAINT `FK_TIPOS_PRODUTOS_PRODUTOS_TIPOS_002` FOREIGN KEY (`ID_TIPO_PRODUTO`) REFERENCES `tipos_produtos` (`ID_TIPO_PRODUTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos_tipos`
--

LOCK TABLES `produtos_tipos` WRITE;
/*!40000 ALTER TABLE `produtos_tipos` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtos_tipos` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_materias_primas`
--

LOCK TABLES `tipos_materias_primas` WRITE;
/*!40000 ALTER TABLE `tipos_materias_primas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos_materias_primas` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_produtos`
--

LOCK TABLES `tipos_produtos` WRITE;
/*!40000 ALTER TABLE `tipos_produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipos_produtos` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidades_medidas`
--

LOCK TABLES `unidades_medidas` WRITE;
/*!40000 ALTER TABLE `unidades_medidas` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidades_medidas` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valores_produtos`
--

LOCK TABLES `valores_produtos` WRITE;
/*!40000 ALTER TABLE `valores_produtos` DISABLE KEYS */;
INSERT INTO `valores_produtos` VALUES (1,200.00,100.00),(2,200.00,100.00),(3,200.00,100.00),(4,200.00,100.00),(5,200.00,100.00),(6,200.00,100.00),(7,500.00,250.00);
/*!40000 ALTER TABLE `valores_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'moonlight'
--
/*!50003 DROP PROCEDURE IF EXISTS `spAtualizarValoresProdutos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAtualizarValoresProdutos`(valorRecomendado double, valor double)
BEGIN
	UPDATE VALORES_PRODUTOS SET
    VALOR_RECOMENDADO = valorRecomendado,
    VALOR = valor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spCriarProduto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spCriarProduto`(nome varchar(45), descricao varchar(200), valorRecomendado double, valor double)
BEGIN
	DECLARE idValorProduto INT;
	
    CALL spCriarValoresProdutos(valorRecomendado, valor);
    
    SELECT MAX(ID_VALOR_PRODUTO) FROM valores_produtos INTO idValorProduto;
    
    INSERT INTO produtos (NOME, DESCRICAO, ID_VALOR_PRODUTO) VALUES
    (UPPER(nome),
    UPPER(descricao),
    idValorProduto);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spCriarValoresProdutos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spCriarValoresProdutos`(valorRecomendado double, valor double)
BEGIN
	INSERT INTO VALORES_PRODUTOS (VALOR_RECOMENDADO, VALOR) VALUES
	(valorRecomendado, valor);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeletarValoresProdutos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletarValoresProdutos`(id int)
BEGIN
	DELETE FROM VALORES_PRODUTOS
    WHERE ID_VALOR_PRODUTO = id;
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

-- Dump completed on 2023-11-12 13:56:13
