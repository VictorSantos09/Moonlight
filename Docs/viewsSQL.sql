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

-- Dump completed on 2023-11-25 20:45:52
