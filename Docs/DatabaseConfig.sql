CREATE DATABASE  IF NOT EXISTS `moonlight` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `moonlight`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: moonlight
-- ------------------------------------------------------
-- Server version	8.0.26

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
 1 AS `TIPO_PRODUTO`,
 1 AS `UNIDADE_MEDIDA_PRODUTO`,
 1 AS `MATERIA_PRIMA_NECESSÁRIA`,
 1 AS `DESCRIÇÃO_MATERIA_PRIMA`,
 1 AS `TIPO_MATERIA_PRIMA`,
 1 AS `VALOR_MATERIA_PRIMA`,
 1 AS `QUANTIDADE_NECESSARIA_MATERIA_PRIMA`,
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
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
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
/*!50001 VIEW `vw_verprocessosproduto` AS select `p`.`NOME` AS `NOME`,`p`.`DESCRICAO` AS `DESCRICAO`,`pro`.`ETAPA` AS `ETAPA`,`pro`.`CUSTO` AS `CUSTO` from (((`produtos_processos` `pp` join `produtos` `p` on((`p`.`ID_PRODUTO` = `pp`.`ID_PRODUTO`))) join `processos` `pro` on((`pro`.`ID_PROCESSO` = `pp`.`ID_PROCESSO`))) join `valores_produtos` `vp` on((`vp`.`ID_VALOR_PRODUTO` = `p`.`ID_VALOR_PRODUTO`))) */;
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
/*!50001 VIEW `vw_verprodutositens` AS select `p`.`NOME` AS `PRODUTO`,`p`.`DESCRICAO` AS `DESCRICAO`,`tpr`.`NOME` AS `TIPO_PRODUTO`,`um`.`NOME` AS `UNIDADE_MEDIDA_PRODUTO`,`mp`.`NOME` AS `MATERIA_PRIMA_NECESSÁRIA`,`mp`.`DESCRICAO` AS `DESCRIÇÃO_MATERIA_PRIMA`,`tmp`.`NOME` AS `TIPO_MATERIA_PRIMA`,`mp`.`VALOR` AS `VALOR_MATERIA_PRIMA`,`ip`.`QUANTIDADE` AS `QUANTIDADE_NECESSARIA_MATERIA_PRIMA`,`ip`.`SUBTOTAL` AS `SUBTOTAL` from (((((`itens_produtos` `ip` join `materias_primas` `mp` on((`mp`.`ID_MATERIA_PRIMA` = `ip`.`ID_MATERIA_PRIMA`))) join `produtos` `p` on((`p`.`ID_PRODUTO` = `ip`.`ID_PRODUTO`))) join `tipos_materias_primas` `tmp` on((`tmp`.`ID_TIPO_MATERIA_PRIMA` = `mp`.`ID_TIPO_MATERIA_PRIMA`))) join `unidades_medidas` `um` on((`um`.`ID_UNIDADE_MEDIDA` = `mp`.`ID_UNIDADE_MEDIDA`))) join `tipos_produtos` `tpr` on((`tpr`.`ID_TIPO_PRODUTO` = `p`.`ID_TIPO_PRODUTO`))) */;
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

-- Dump completed on 2023-11-24 14:27:43
