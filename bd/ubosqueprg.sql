-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.24-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla ubosqueprg.audit
CREATE TABLE IF NOT EXISTS `audit` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userId` int(5) NOT NULL,
  `operation` varchar(30) NOT NULL,
  `tableName` varchar(30) NOT NULL,
  `tableId` int(20) NOT NULL,
  `createDate` datetime NOT NULL,
  `ip` varchar(40) NOT NULL,
  `nameUser` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla ubosqueprg.audit: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;

-- Volcando estructura para tabla ubosqueprg.leftoverbooks
CREATE TABLE IF NOT EXISTS `leftoverbooks` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userId` int(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `edition` int(5) NOT NULL,
  `editorial` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `userName` varchar(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla ubosqueprg.leftoverbooks: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `leftoverbooks` DISABLE KEYS */;
/*!40000 ALTER TABLE `leftoverbooks` ENABLE KEYS */;

-- Volcando estructura para tabla ubosqueprg.parameter
CREATE TABLE IF NOT EXISTS `parameter` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `parameterType` varchar(1) NOT NULL,
  `parameterCode` varchar(10) NOT NULL,
  `descriptionParameter` varchar(60) NOT NULL,
  `textValue` varchar(10) NOT NULL,
  `numberValue` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla ubosqueprg.parameter: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `parameter` DISABLE KEYS */;
INSERT INTO `parameter` (`id`, `parameterType`, `parameterCode`, `descriptionParameter`, `textValue`, `numberValue`) VALUES
	(1, 'U', 'CLAVE', 'CAMBIAR CLAVE', 'ACTIVO', 30);
/*!40000 ALTER TABLE `parameter` ENABLE KEYS */;

-- Volcando estructura para tabla ubosqueprg.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userName` varchar(8) NOT NULL,
  `password` varchar(256) NOT NULL,
  `fullName` varchar(60) NOT NULL,
  `emailAddress` varchar(75) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  `dateLastPassword` date NOT NULL,
  `active` varchar(1) NOT NULL,
  `userType` varchar(12) NOT NULL,
  `attempts` int(1) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla ubosqueprg.user: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `userName`, `password`, `fullName`, `emailAddress`, `phoneNumber`, `dateLastPassword`, `active`, `userType`, `attempts`, `address`) VALUES
	(1, 'admonlib', '725058819589ae98c6613c1f5a6eac5a', 'admon', 'admonlibweb@gmail.com', '0000000000', '2018-05-30', 'A', 'ADMIN', 0, 'No disponible');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
