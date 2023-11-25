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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias_primas`
--

LOCK TABLES `materias_primas` WRITE;
/*!40000 ALTER TABLE `materias_primas` DISABLE KEYS */;
INSERT INTO `materias_primas` VALUES (1,'Morango','Morango fresco',5.99,500,6,1),(2,'Tomate','Tomate maduro',3.49,600,4,1),(3,'Carne de Frango','Peito de frango',10.99,800,1,4),(4,'Farinha de Trigo','Farinha de trigo refinada',2.99,1000,4,11),(5,'Azeite de Oliva','Azeite de oliva extra virgem',15.99,500,1,24),(6,'Chocolate Amargo','Chocolate amargo 70%',8.99,200,4,28),(7,'Feijão Preto','Feijão preto',4.99,750,4,11),(8,'Queijo Parmesão','Queijo parmesão ralado',7.99,250,1,38),(9,'Leite Condensado','Leite condensado',3.49,400,6,8),(10,'Leite','Leite integral',3.99,1000,6,8),(11,'Creme de Leite','Creme de leite',2.99,500,6,8),(12,'Ovo','Ovo branco',0.99,30,6,23),(13,'Manteiga','Manteiga sem sal',5.99,500,1,23),(14,'Açúcar','Açúcar refinado',2.99,1000,4,16),(15,'Sal','Sal refinado',1.99,1000,4,25),(16,'Pimenta do Reino','Pimenta do reino moída',3.99,100,4,25),(17,'Café','Café torrado e moído',5.99,500,6,27),(18,'Cebolinha','Cebolinha fresca',1.99,100,6,26),(19,'Salsinha','Salsinha fresca',1.99,100,6,26),(20,'Alho','Alho fresco',2.99,100,6,26),(21,'Cebola','Cebola roxa',1.99,100,6,2),(22,'Alface','Alface americana',1.99,100,6,2),(23,'Pimentão','Pimentão verde',1.99,100,6,2),(24,'Cenoura','Cenoura',1.99,100,6,3),(25,'Batata','Batata inglesa',1.99,100,6,3),(26,'Abobrinha','Abobrinha italiana',1.99,100,6,3),(27,'Abacaxi','Abacaxi pérola',1.99,100,6,1),(28,'Banana','Banana prata',1.99,100,6,1),(29,'Arroz Integral','Arroz integral',3.29,1000,4,11),(30,'Atum em Lata','Atum em água enlatado',9.99,150,6,5),(31,'Açaí','Polpa de açaí congelada',12.99,500,5,1),(32,'Batata Doce','Batata doce média',2.49,400,4,3),(33,'Mel','Mel puro',7.99,250,1,17),(34,'Sal Marinho','Sal marinho grosso',2.29,500,4,26),(35,'Salmão Fresco','Filé de salmão fresco',15.99,300,1,5);
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
  PRIMARY KEY (`ID_PROCESSO`),
  UNIQUE KEY `IDX_PROCESSOS_001` (`ID_PROCESSO`),
  UNIQUE KEY `ETAPA_UNIQUE` (`ETAPA`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `processos`
--

LOCK TABLES `processos` WRITE;
/*!40000 ALTER TABLE `processos` DISABLE KEYS */;
INSERT INTO `processos` VALUES (1,'PREPARO',50.00),(2,'COZIMENTO',45.75),(3,'FINALIZAÇÃO',88.50),(4,'LIMPEZA',9.00),(5,'HIGIENIZAÇÃO',12.00),(6,'SELEÇÃO',5.75),(7,'SEPARAÇÃO',3.25),(8,'DESCASCAMENTO',2.15),(9,'CORTE',3.00),(10,'TRITURAÇÃO',5.50),(11,'MOAGEM',7.00),(12,'PENEIRAÇÃO',1.00),(13,'MISTURA',2.00),(14,'FERMENTAÇÃO',12.85),(15,'COAGULAÇÃO',45.20),(16,'FILTRAÇÃO',4.20),(17,'PASTEURIZAÇÃO',3.35),(18,'EMBALAGEM',12.68),(19,'TRANSPORTE',68.80),(20,'ARMAZENAMENTO',43.70),(21,'DESCONGELAMENTO',7.75),(22,'MARINAÇÃO',12.20),(23,'EMULSIFICAÇÃO',8.00);
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
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `produtos_processos`
--

LOCK TABLES `produtos_processos` WRITE;
/*!40000 ALTER TABLE `produtos_processos` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtos_processos` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_materias_primas`
--

LOCK TABLES `tipos_materias_primas` WRITE;
/*!40000 ALTER TABLE `tipos_materias_primas` DISABLE KEYS */;
INSERT INTO `tipos_materias_primas` VALUES (16,'AÇÚCARES'),(34,'ÁGUAS'),(42,'APERITIVOS'),(9,'BEBIDAS'),(39,'CACHAÇAS'),(30,'CAFÉS'),(4,'CARNES'),(14,'CEREAIS'),(35,'CERVEJAS'),(31,'CHÁS'),(29,'CHOCOLATES'),(10,'CONDIMENTOS'),(20,'CREMES'),(43,'ENERGÉTICOS'),(28,'ERVAS'),(13,'FARINHAS'),(7,'FRIOS'),(1,'FRUTAS'),(6,'FRUTOS DO MAR'),(18,'GELEIAS'),(41,'GINS'),(12,'GRÃOS'),(8,'LATICÍNIOS'),(3,'LEGUMES'),(21,'LEITES'),(23,'MARGARINAS'),(17,'MEL'),(19,'MOLHOS'),(15,'OLEAGINOSAS'),(24,'ÓLEOS'),(22,'OVOS'),(5,'PEIXES'),(27,'PIMENTAS'),(32,'REFRIGERANTES'),(26,'SAL'),(33,'SUCOS'),(45,'SUCOS DETOX'),(46,'SUCOS FUNCIONAIS'),(44,'SUCOS NATURAIS'),(11,'TEMPEROS'),(40,'TEQUILAS'),(2,'VERDURAS'),(25,'VINAGRES'),(36,'VINHOS'),(38,'VODKAS'),(37,'WHISKYS');
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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_produtos`
--

LOCK TABLES `tipos_produtos` WRITE;
/*!40000 ALTER TABLE `tipos_produtos` DISABLE KEYS */;
INSERT INTO `tipos_produtos` VALUES (23,'APERITIVOS'),(36,'ARROZ'),(35,'BATATAS'),(2,'BEBIDAS'),(43,'BISCOITOS'),(13,'BOLOS'),(20,'CACHAÇAS'),(24,'CAFÉS'),(29,'CALDOS'),(4,'CARNES'),(17,'CERVEJAS'),(25,'CHÁS'),(44,'CHOCOLATES'),(26,'CREMES'),(1,'DOCES'),(41,'EMBUTIDOS'),(37,'FEIJÃO'),(31,'FRUTOS DO MAR'),(22,'GINS'),(34,'HAMBÚRGUERES'),(42,'IOGURTES'),(11,'LANCHES'),(38,'LEGUMINOSAS'),(5,'MASSAS'),(10,'MOLHOS'),(39,'PÃES'),(30,'PEIXES'),(28,'PETISCOS'),(12,'PIZZAS'),(40,'QUEIJOS'),(32,'SALADAS'),(6,'SALGADOS'),(33,'SANDUÍCHES'),(3,'SHAKES'),(9,'SOBREMESAS'),(8,'SOPAS'),(27,'SORVETES'),(15,'SUCOS'),(21,'TEQUILAS'),(14,'TORTAS'),(7,'VEGETARIANOS'),(16,'VINHOS'),(19,'VODKAS'),(18,'WHISKYS');
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidades_medidas`
--

LOCK TABLES `unidades_medidas` WRITE;
/*!40000 ALTER TABLE `unidades_medidas` DISABLE KEYS */;
INSERT INTO `unidades_medidas` VALUES (1,'QUILOGRAMA','KG'),(2,'LITRO','LT'),(3,'COLHER DE SOPA','CS'),(4,'GRAMAS','GR'),(5,'MILIGRAMA','MG'),(6,'MILILITRO','ML'),(7,'UNIDADE','UN'),(8,'COLHER DE CHÁ','CT'),(9,'COPO','CP'),(10,'PACOTE','PC'),(11,'XÍCARA','XC'),(12,'GARRAFA','GF'),(13,'FOLHA','FL'),(14,'FATIA','FT'),(15,'POTE','PT'),(16,'BANDEJA','BD'),(17,'PACOTE PEQUENO','PP'),(18,'PACOTE GRANDE','PG'),(19,'GALÃO','GL'),(20,'BARRA','BR');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valores_produtos`
--

LOCK TABLES `valores_produtos` WRITE;
/*!40000 ALTER TABLE `valores_produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `valores_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_relatorio`
--

DROP TABLE IF EXISTS `vw_relatorio`;
/*!50001 DROP VIEW IF EXISTS `vw_relatorio`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_relatorio` AS SELECT 
 1 AS `NOME`,
 1 AS `TIPO`,
 1 AS `VALOR`,
 1 AS `VALOR_RECOMENDADO`,
 1 AS `SUBTOTAL`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_valortotal_itensproduto`
--

DROP TABLE IF EXISTS `vw_valortotal_itensproduto`;
/*!50001 DROP VIEW IF EXISTS `vw_valortotal_itensproduto`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_valortotal_itensproduto` AS SELECT 
 1 AS `PRODUTO`,
 1 AS `VALOR_VENDA_PRODUTO`,
 1 AS `NOME_MATERIA_PRIMA`,
 1 AS `VALOR_MATERIA_PRIMA`,
 1 AS `QUANTIDADE_UTILIZADA`,
 1 AS `SUBTOTAL`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_valortotal_processosproduto`
--

DROP TABLE IF EXISTS `vw_valortotal_processosproduto`;
/*!50001 DROP VIEW IF EXISTS `vw_valortotal_processosproduto`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_valortotal_processosproduto` AS SELECT 
 1 AS `NOME`,
 1 AS `DESCRICAO`,
 1 AS `VALOR`,
 1 AS `SUBTOTAL`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_verinformacoesproduto`
--

DROP TABLE IF EXISTS `vw_verinformacoesproduto`;
/*!50001 DROP VIEW IF EXISTS `vw_verinformacoesproduto`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_verinformacoesproduto` AS SELECT 
 1 AS `NOME`,
 1 AS `DESCRICAO`,
 1 AS `NOME UNIDADE MEDIDA`,
 1 AS `SIGLA UNIDADE MEDIDA`,
 1 AS `TIPO`,
 1 AS `VALOR`,
 1 AS `VALOR RECOMENDADO`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_verprocessosproduto`
--

DROP TABLE IF EXISTS `vw_verprocessosproduto`;
/*!50001 DROP VIEW IF EXISTS `vw_verprocessosproduto`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_verprocessosproduto` AS SELECT 
 1 AS `NOME`,
 1 AS `DESCRICAO`,
 1 AS `VALOR`,
 1 AS `VALOR_RECOMENDADO`,
 1 AS `ETAPA`,
 1 AS `CUSTO`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_verprodutositens`
--

DROP TABLE IF EXISTS `vw_verprodutositens`;
/*!50001 DROP VIEW IF EXISTS `vw_verprodutositens`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_verprodutositens` AS SELECT 
 1 AS `PRODUTO`,
 1 AS `DESCRICAO`,
 1 AS `TIPO PRODUTO`,
 1 AS `UNIDADE MEDIDA PRODUTO`,
 1 AS `MATÉRIA PRIMA NECESSÁRIA`,
 1 AS `DESCRIÇÃO MATÉRIA PRIMA`,
 1 AS `TIPO MATÉRIA PRIMA`,
 1 AS `VALOR MATÉRIA PRIMA`,
 1 AS `QUANTIDADE NECESSÁRIA MATÉRIA PRIMA`,
 1 AS `SUBTOTAL`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'moonlight'
--
/*!50003 DROP PROCEDURE IF EXISTS `spAtualizarProduto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAtualizarProduto`(idProduto INT, nome VARCHAR(45), descricao VARCHAR(200), valorRecomendado DOUBLE, valor DOUBLE, idUnidadeMedida INT, idTipoProduto INT)
BEGIN
	DECLARE idValorProduto INT;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		ROLLBACK;
    END;
    
    START TRANSACTION;
		SELECT ID_VALOR_PRODUTO FROM produtos WHERE ID_PRODUTO = idProduto INTO idValorProduto;
        
		CALL spAtualizarProdutoValores(valorRecomendado, valor, idValorProduto);
		
        UPDATE produtos SET
        NOME = UPPER(nome),
        DESCRICAO = UPPER(descricao),
        ID_UNIDADE_MEDIDA = idUnidadeMedida,
        ID_TIPO_PRODUTO = idTipoProduto
        WHERE ID_PRODUTO = idProduto;
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spAtualizarProdutoItens` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAtualizarProdutoItens`(quantidade INT, idproduto INT, idMateriaPrima INT, subtotal DOUBLE, idItemProduto INT)
BEGIN
	UPDATE itens_produtos SET 
    QUANTIDADE = quantidade,
    ID_PRODUTO = idProduto,
    ID_MATERIA_PRIMA = idMateriaPrima,
    SUBTOTAL = subtotal
    WHERE ID_ITEM_PRODUTO = idItemProduto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spAtualizarProdutoProcesso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAtualizarProdutoProcesso`(idProduto INT, idProcesso INT, idProdutoProcesso INT)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
		ROLLBACK;
    END;
    
    START TRANSACTION;
		UPDATE produtos_processos SET
        ID_PROCESSO = idProcesso
        WHERE ID_PRODUTO_PROCESSO = idProdutoProcesso;
    COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spAtualizarProdutoValores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAtualizarProdutoValores`(valorRecomendado DOUBLE, valor DOUBLE, idValorProduto INT)
BEGIN
	UPDATE VALORES_PRODUTOS SET
    VALOR_RECOMENDADO = valorRecomendado,
    VALOR = valor
    WHERE ID_VALOR_PRODUTO = idValorProduto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spBuscarProdutoPorNome` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb3 */ ;
/*!50003 SET character_set_results = utf8mb3 */ ;
/*!50003 SET collation_connection  = utf8mb3_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spBuscarProdutoPorNome`(nomeProduto VARCHAR(45))
BEGIN
	SELECT * FROM produtos WHERE NOME = nomeProduto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spCriarItensProduto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spCriarItensProduto`(idProduto INT, idMateriaPrima INT, quantidade INT, subTotal DOUBLE)
BEGIN
	INSERT INTO itens_produtos (ID_PRODUTO, ID_MATERIA_PRIMA, QUANTIDADE, SUBTOTAL) VALUES
    (idProduto, idMateriaPrima, quantidade, subTotal);
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `spCriarProduto`(nome VARCHAR(45), descricao VARCHAR(200), valorRecomendado DOUBLE, valor DOUBLE, idUnidadeMedida INT, idTipoProduto INT)
BEGIN
	DECLARE idValorProduto INT;
	
    CALL spCriarValoresProdutos(valorRecomendado, valor);
    
    SELECT MAX(ID_VALOR_PRODUTO) FROM valores_produtos INTO idValorProduto;
    
    INSERT INTO produtos (NOME, DESCRICAO, ID_VALOR_PRODUTO, ID_UNIDADE_MEDIDA, ID_TIPO_PRODUTO) VALUES
    (UPPER(nome),
    UPPER(descricao),
    idValorProduto,
    idUnidadeMedida,
    idTipoProduto);
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
/*!50003 DROP PROCEDURE IF EXISTS `spDeletarProdutoEDetalhes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDeletarProdutoEDetalhes`(nome VARCHAR(45))
BEGIN
	DECLARE idProduto SMALLINT;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;

    START TRANSACTION;
		SELECT ID_PRODUTO FROM produtos WHERE NOME = UPPER(nome) INTO idProduto;
        
        IF idProduto IS NOT NULL THEN
			DELETE FROM itens_produtos WHERE ID_PRODUTO = idProduto;
			DELETE FROM produtos_processos WHERE ID_PRODUTO = idProduto;
			DELETE FROM produtos WHERE ID_PRODUTO = idProduto;
		ELSE
			ROLLBACK;
		END IF;
    COMMIT;
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

--
-- Final view structure for view `vw_relatorio`
--

/*!50001 DROP VIEW IF EXISTS `vw_relatorio`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_relatorio` AS select `p`.`NOME` AS `NOME`,`tp`.`NOME` AS `TIPO`,`vp`.`VALOR` AS `VALOR`,`vp`.`VALOR_RECOMENDADO` AS `VALOR_RECOMENDADO`,`ip`.`SUBTOTAL` AS `SUBTOTAL` from (((`itens_produtos` `ip` join `produtos` `p` on((`p`.`ID_PRODUTO` = `ip`.`ID_PRODUTO`))) join `valores_produtos` `vp` on((`vp`.`ID_VALOR_PRODUTO` = `p`.`ID_VALOR_PRODUTO`))) join `tipos_produtos` `tp` on((`tp`.`ID_TIPO_PRODUTO` = `p`.`ID_TIPO_PRODUTO`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_valortotal_itensproduto`
--

/*!50001 DROP VIEW IF EXISTS `vw_valortotal_itensproduto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_valortotal_itensproduto` AS select `pr`.`NOME` AS `PRODUTO`,`vp`.`VALOR` AS `VALOR_VENDA_PRODUTO`,`mp`.`NOME` AS `NOME_MATERIA_PRIMA`,`mp`.`VALOR` AS `VALOR_MATERIA_PRIMA`,sum(`ip`.`QUANTIDADE`) AS `QUANTIDADE_UTILIZADA`,sum(`ip`.`SUBTOTAL`) AS `SUBTOTAL` from (((`itens_produtos` `ip` join `materias_primas` `mp` on((`mp`.`ID_MATERIA_PRIMA` = `ip`.`ID_MATERIA_PRIMA`))) join `produtos` `pr` on((`pr`.`ID_PRODUTO` = `ip`.`ID_PRODUTO`))) join `valores_produtos` `vp` on((`vp`.`ID_VALOR_PRODUTO` = `pr`.`ID_VALOR_PRODUTO`))) group by `pr`.`NOME` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_valortotal_processosproduto`
--

/*!50001 DROP VIEW IF EXISTS `vw_valortotal_processosproduto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_valortotal_processosproduto` AS select `p`.`NOME` AS `NOME`,`p`.`DESCRICAO` AS `DESCRICAO`,`vp`.`VALOR` AS `VALOR`,sum(`pr`.`CUSTO`) AS `SUBTOTAL` from (((`produtos_processos` `pp` join `produtos` `p` on((`p`.`ID_PRODUTO` = `pp`.`ID_PRODUTO`))) join `valores_produtos` `vp` on((`vp`.`ID_VALOR_PRODUTO` = `p`.`ID_VALOR_PRODUTO`))) join `processos` `pr` on((`pr`.`ID_PROCESSO` = `pp`.`ID_PROCESSO`))) group by `p`.`NOME` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_verinformacoesproduto`
--

/*!50001 DROP VIEW IF EXISTS `vw_verinformacoesproduto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_verinformacoesproduto` AS select `p`.`NOME` AS `NOME`,`p`.`DESCRICAO` AS `DESCRICAO`,`um`.`NOME` AS `NOME UNIDADE MEDIDA`,`um`.`SIGLA` AS `SIGLA UNIDADE MEDIDA`,`tp`.`NOME` AS `TIPO`,`vp`.`VALOR` AS `VALOR`,`vp`.`VALOR_RECOMENDADO` AS `VALOR RECOMENDADO` from (((`produtos` `p` join `unidades_medidas` `um` on((`um`.`ID_UNIDADE_MEDIDA` = `p`.`ID_UNIDADE_MEDIDA`))) join `tipos_produtos` `tp` on((`tp`.`ID_TIPO_PRODUTO` = `p`.`ID_TIPO_PRODUTO`))) join `valores_produtos` `vp` on((`vp`.`ID_VALOR_PRODUTO` = `p`.`ID_VALOR_PRODUTO`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_verprocessosproduto`
--

/*!50001 DROP VIEW IF EXISTS `vw_verprocessosproduto`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_verprocessosproduto` AS select `p`.`NOME` AS `NOME`,`p`.`DESCRICAO` AS `DESCRICAO`,`vp`.`VALOR` AS `VALOR`,`vp`.`VALOR_RECOMENDADO` AS `VALOR_RECOMENDADO`,`pro`.`ETAPA` AS `ETAPA`,`pro`.`CUSTO` AS `CUSTO` from (((`produtos_processos` `pp` join `produtos` `p` on((`p`.`ID_PRODUTO` = `pp`.`ID_PRODUTO`))) join `processos` `pro` on((`pro`.`ID_PROCESSO` = `pp`.`ID_PROCESSO`))) join `valores_produtos` `vp` on((`vp`.`ID_VALOR_PRODUTO` = `p`.`ID_VALOR_PRODUTO`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_verprodutositens`
--

/*!50001 DROP VIEW IF EXISTS `vw_verprodutositens`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_verprodutositens` AS select `p`.`NOME` AS `PRODUTO`,`p`.`DESCRICAO` AS `DESCRICAO`,`tpr`.`NOME` AS `TIPO PRODUTO`,`um`.`NOME` AS `UNIDADE MEDIDA PRODUTO`,`mp`.`NOME` AS `MATÉRIA PRIMA NECESSÁRIA`,`mp`.`DESCRICAO` AS `DESCRIÇÃO MATÉRIA PRIMA`,`tmp`.`NOME` AS `TIPO MATÉRIA PRIMA`,`mp`.`VALOR` AS `VALOR MATÉRIA PRIMA`,`ip`.`QUANTIDADE` AS `QUANTIDADE NECESSÁRIA MATÉRIA PRIMA`,`ip`.`SUBTOTAL` AS `SUBTOTAL` from (((((`itens_produtos` `ip` join `materias_primas` `mp` on((`mp`.`ID_MATERIA_PRIMA` = `ip`.`ID_MATERIA_PRIMA`))) join `produtos` `p` on((`p`.`ID_PRODUTO` = `ip`.`ID_PRODUTO`))) join `tipos_materias_primas` `tmp` on((`tmp`.`ID_TIPO_MATERIA_PRIMA` = `mp`.`ID_TIPO_MATERIA_PRIMA`))) join `unidades_medidas` `um` on((`um`.`ID_UNIDADE_MEDIDA` = `mp`.`ID_UNIDADE_MEDIDA`))) join `tipos_produtos` `tpr` on((`tpr`.`ID_TIPO_PRODUTO` = `p`.`ID_TIPO_PRODUTO`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-25 20:45:24
