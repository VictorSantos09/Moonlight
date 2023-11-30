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
-- Dumping data for table `itens_produtos`
--

LOCK TABLES `itens_produtos` WRITE;
/*!40000 ALTER TABLE `itens_produtos` DISABLE KEYS */;
INSERT INTO `itens_produtos` VALUES (5,1,0000000002,1,5.99),(6,1,0000000002,9,3.49),(7,0.25,0000000002,10,1.00),(8,1,0000000002,11,2.99),(9,4,0000000002,12,3.96),(10,0.1,0000000002,19,0.20),(11,1,0000000001,6,8.99),(12,0.5,0000000001,9,1.75),(13,1.5,0000000001,1,8.99),(14,1,0000000001,10,3.99);
/*!40000 ALTER TABLE `itens_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `materias_primas`
--

LOCK TABLES `materias_primas` WRITE;
/*!40000 ALTER TABLE `materias_primas` DISABLE KEYS */;
INSERT INTO `materias_primas` VALUES (1,'Morango','Morango fresco',5.99,500,1,1),(2,'Tomate','Tomate maduro',3.49,600,1,1),(3,'Carne de Frango','Peito de frango',10.99,800,1,4),(4,'Farinha de Trigo','Farinha de trigo refinada',2.99,1000,1,11),(5,'Azeite de Oliva','Azeite de oliva extra virgem',15.99,500,2,24),(6,'Chocolate Amargo','Chocolate amargo 70%',8.99,200,1,28),(7,'Feijão Preto','Feijão preto',4.99,750,1,11),(8,'Queijo Parmesão','Queijo parmesão ralado',7.99,250,1,38),(9,'Leite Condensado','Leite condensado',3.49,400,6,8),(10,'Leite','Leite integral',3.99,1000,2,8),(11,'Creme de Leite','Creme de leite',2.99,500,6,8),(12,'Ovo','Ovo branco',0.99,30,3,23),(13,'Manteiga','Manteiga sem sal',5.99,500,1,23),(14,'Açúcar','Açúcar refinado',2.99,1000,1,16),(15,'Sal','Sal refinado',1.99,1000,1,25),(16,'Pimenta do Reino','Pimenta do reino moída',3.99,100,1,25),(17,'Café','Café torrado e moído',5.99,500,1,27),(18,'Cebolinha','Cebolinha fresca',1.99,100,1,26),(19,'Salsinha','Salsinha fresca',1.99,100,1,26),(20,'Alho','Alho fresco',2.99,100,1,26),(21,'Cebola','Cebola roxa',1.99,100,1,2),(22,'Alface','Alface americana',1.99,100,1,2),(23,'Pimentão','Pimentão verde',1.99,100,1,2);
/*!40000 ALTER TABLE `materias_primas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `processos`
--

LOCK TABLES `processos` WRITE;
/*!40000 ALTER TABLE `processos` DISABLE KEYS */;
INSERT INTO `processos` VALUES (1,'PREPARO',50.00),(2,'COZIMENTO',45.75),(3,'FINALIZAÇÃO',88.50),(4,'LIMPEZA',9.00),(5,'HIGIENIZAÇÃO',12.00),(6,'SELEÇÃO',5.75),(7,'SEPARAÇÃO',3.25),(8,'DESCASCAMENTO',2.15),(9,'CORTE',3.00),(10,'TRITURAÇÃO',5.50),(11,'MOAGEM',7.00),(12,'PENEIRAÇÃO',1.00),(13,'MISTURA',2.00),(14,'FERMENTAÇÃO',12.85),(15,'COAGULAÇÃO',45.20),(16,'FILTRAÇÃO',4.20),(17,'PASTEURIZAÇÃO',3.35),(18,'EMBALAGEM',12.68),(19,'TRANSPORTE',68.80),(20,'ARMAZENAMENTO',43.70),(21,'DESCONGELAMENTO',7.75),(22,'MARINAÇÃO',12.20),(23,'EMULSIFICAÇÃO',8.00);
/*!40000 ALTER TABLE `processos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (0000000001,'BOLO DE CHOCOLATE AMARGO','FEITO COM CHOCOLATE',1,3,13),(0000000002,'BOLO DE MORANGO','DOCE',2,3,13);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `produtos_processos`
--

LOCK TABLES `produtos_processos` WRITE;
/*!40000 ALTER TABLE `produtos_processos` DISABLE KEYS */;
INSERT INTO `produtos_processos` VALUES (1,0000000001,1),(2,0000000001,17),(3,0000000001,18),(4,0000000002,1),(5,0000000002,2),(6,0000000002,4),(7,0000000002,5),(8,0000000002,13);
/*!40000 ALTER TABLE `produtos_processos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tipos_materias_primas`
--

LOCK TABLES `tipos_materias_primas` WRITE;
/*!40000 ALTER TABLE `tipos_materias_primas` DISABLE KEYS */;
INSERT INTO `tipos_materias_primas` VALUES (16,'AÇÚCARES'),(34,'ÁGUAS'),(42,'APERITIVOS'),(9,'BEBIDAS'),(39,'CACHAÇAS'),(30,'CAFÉS'),(4,'CARNES'),(14,'CEREAIS'),(35,'CERVEJAS'),(31,'CHÁS'),(29,'CHOCOLATES'),(10,'CONDIMENTOS'),(20,'CREMES'),(43,'ENERGÉTICOS'),(28,'ERVAS'),(13,'FARINHAS'),(7,'FRIOS'),(1,'FRUTAS'),(6,'FRUTOS DO MAR'),(18,'GELEIAS'),(41,'GINS'),(12,'GRÃOS'),(8,'LATICÍNIOS'),(3,'LEGUMES'),(21,'LEITES'),(23,'MARGARINAS'),(17,'MEL'),(19,'MOLHOS'),(15,'OLEAGINOSAS'),(24,'ÓLEOS'),(22,'OVOS'),(5,'PEIXES'),(27,'PIMENTAS'),(32,'REFRIGERANTES'),(26,'SAL'),(33,'SUCOS'),(45,'SUCOS DETOX'),(46,'SUCOS FUNCIONAIS'),(44,'SUCOS NATURAIS'),(11,'TEMPEROS'),(40,'TEQUILAS'),(2,'VERDURAS'),(25,'VINAGRES'),(36,'VINHOS'),(38,'VODKAS'),(37,'WHISKYS');
/*!40000 ALTER TABLE `tipos_materias_primas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tipos_produtos`
--

LOCK TABLES `tipos_produtos` WRITE;
/*!40000 ALTER TABLE `tipos_produtos` DISABLE KEYS */;
INSERT INTO `tipos_produtos` VALUES (23,'APERITIVOS'),(36,'ARROZ'),(35,'BATATAS'),(2,'BEBIDAS'),(43,'BISCOITOS'),(13,'BOLOS'),(20,'CACHAÇAS'),(24,'CAFÉS'),(29,'CALDOS'),(4,'CARNES'),(17,'CERVEJAS'),(25,'CHÁS'),(44,'CHOCOLATES'),(26,'CREMES'),(1,'DOCES'),(41,'EMBUTIDOS'),(37,'FEIJÃO'),(31,'FRUTOS DO MAR'),(22,'GINS'),(34,'HAMBÚRGUERES'),(42,'IOGURTES'),(11,'LANCHES'),(38,'LEGUMINOSAS'),(5,'MASSAS'),(10,'MOLHOS'),(39,'PÃES'),(30,'PEIXES'),(28,'PETISCOS'),(12,'PIZZAS'),(40,'QUEIJOS'),(32,'SALADAS'),(6,'SALGADOS'),(33,'SANDUÍCHES'),(3,'SHAKES'),(9,'SOBREMESAS'),(8,'SOPAS'),(27,'SORVETES'),(15,'SUCOS'),(21,'TEQUILAS'),(14,'TORTAS'),(7,'VEGETARIANOS'),(16,'VINHOS'),(19,'VODKAS'),(18,'WHISKYS');
/*!40000 ALTER TABLE `tipos_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `unidades_medidas`
--

LOCK TABLES `unidades_medidas` WRITE;
/*!40000 ALTER TABLE `unidades_medidas` DISABLE KEYS */;
INSERT INTO `unidades_medidas` VALUES (1,'QUILOGRAMA','KG'),(2,'LITRO','LT'),(3,'UNIDADE','UN'),(4,'PACOTE PEQUENO','PE'),(5,'PACOTE GRANDE','PG'),(6,'CAIXA','CX'),(7,'BARRA','BR');
/*!40000 ALTER TABLE `unidades_medidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `valores_produtos`
--

LOCK TABLES `valores_produtos` WRITE;
/*!40000 ALTER TABLE `valores_produtos` DISABLE KEYS */;
INSERT INTO `valores_produtos` VALUES (1,125.25,80.00),(2,192.73,200.00);
/*!40000 ALTER TABLE `valores_produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-27 14:41:04
