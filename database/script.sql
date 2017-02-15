CREATE DATABASE  IF NOT EXISTS `db_gerenciamento_tarefa` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
 USE `db_gerenciamento_tarefa`;
-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: springbootdb
-- ------------------------------------------------------
-- Server version	5.7.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `tarefa`;
DROP TABLE IF EXISTS `usuario`;
DROP TABLE IF EXISTS `sub_tarefa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarefa` (
  `tarefaId` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomeTarefa` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  `descricaoTarefa` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  `categoriaTarefa` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  `prioridadeTarefa` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `statusTarefa` boolean,
  PRIMARY KEY (`tarefaId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `usuario` (
  `usuarioId` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  `emailUsuario` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  `linkGitHubUsuario` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`usuarioId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `sub_tarefa` (
  `subTarefaId` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomeSubTarefa` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`subTarefaId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-06 20:27:53

INSERT INTO tarefa (id, nomeTarefa, descricaoTarefa, categoriaTarefa, prioridadeTarefa, statusTarefa) VALUES (NULL, 'Aprender StringBoot', 'Estudar sobre o funcionamento do Spring Boot', 'Estudo', 'media', '0'),
(NULL, 'Atividade de lógica', 'Fazer a lista de exercício de lógica', 'Trabalho', 'Alta', '0');
(NULL, 'Inventar a roda', 'Fazer um projeto de roda revolucionária', 'Estudo', 'Baixa', '0');
INSERT INTO usuario (usuarioId, nomeUsuario, emailUsuario, linkGitHubUsuario) VALUES (NULL, 'Ana Paula Barros', 'barros.anapaulas@gmail.com', 'https://github.com/anapaulabarros');
