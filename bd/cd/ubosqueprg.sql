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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla ubosqueprg.audit: ~17 rows (aproximadamente)
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
INSERT INTO `audit` (`id`, `userId`, `operation`, `tableName`, `tableId`, `createDate`, `ip`, `nameUser`) VALUES
	(1, 2, 'Registro', 'user', 0, '2018-05-30 01:58:46', '192.168.1.82', 'danibepe'),
	(2, 2, 'CambioCon', 'user', 2, '2018-05-30 02:00:23', '192.168.1.82', 'danibepe'),
	(3, 2, 'AgregoLibro', 'leftOverBook', 0, '2018-05-30 02:01:03', '192.168.1.82', 'danibepe'),
	(4, 2, 'AgregoLibro', 'leftOverBook', 0, '2018-05-30 02:01:52', '192.168.1.82', 'danibepe'),
	(5, 2, 'AgregoLibro', 'leftOverBook', 0, '2018-05-30 02:02:30', '192.168.1.82', 'danibepe'),
	(6, 2, 'ModificoLibro', 'leftOverBook', 0, '2018-05-30 02:02:46', '192.168.1.82', 'danibepe'),
	(7, 2, 'Modificó', 'user', 0, '2018-05-30 02:03:15', '192.168.1.82', 'danibepe'),
	(8, 3, 'Registro', 'user', 0, '2018-05-30 02:04:53', '192.168.1.82', 'scorreav'),
	(9, 3, 'CambioCon', 'user', 3, '2018-05-30 02:07:33', '192.168.1.82', 'scorreav'),
	(10, 3, 'AgregoLibro', 'leftOverBook', 0, '2018-05-30 02:07:58', '192.168.1.82', 'scorreav'),
	(11, 3, 'ModificoLibro', 'leftOverBook', 0, '2018-05-30 02:08:06', '192.168.1.82', 'scorreav'),
	(12, 3, 'eliminoLibro', 'leftOverBook', 0, '2018-05-30 02:08:12', '192.168.1.82', 'scorreav'),
	(13, 3, 'AgregoLibro', 'leftOverBook', 0, '2018-05-30 02:08:45', '192.168.1.82', 'scorreav'),
	(14, 3, 'AgregoLibro', 'leftOverBook', 0, '2018-05-30 02:09:17', '192.168.1.82', 'scorreav'),
	(15, 3, 'EnvCorreo', 'user', 3, '2018-05-30 02:09:32', '192.168.1.82', 'scorreav'),
	(16, 4, 'Registro', 'user', 0, '2018-05-30 02:11:33', '192.168.1.82', 'oscartoo'),
	(17, 4, 'SolCambioContra', 'user', 4, '2018-05-30 02:11:44', '192.168.1.82', 'oscartoo');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla ubosqueprg.leftoverbooks: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `leftoverbooks` DISABLE KEYS */;
INSERT INTO `leftoverbooks` (`id`, `userId`, `name`, `author`, `edition`, `editorial`, `date`, `userName`) VALUES
	(1, 2, 'Divergente', 'Veronica Roth', 2, 'RBA', '2018-05-30 02:02:46.367', 'danibepe'),
	(2, 2, 'Narnia', 'C.S. Lewis', 6, 'Panamericana', '2018-05-30 02:01:05.455', 'danibepe'),
	(3, 2, 'Wonder', 'R.J. Palacio', 1, 'Nube de Tinta', '2018-05-30 02:01:54.601', 'danibepe'),
	(5, 3, 'Fundamentos', 'Wilson & Mario', 1, 'Universidad el Bosque', '2018-05-30 02:08:15.213', 'scorreav'),
	(6, 3, 'Hamlet', 'Shakespeare', 3, 'Panamericana', '2018-05-30 02:08:48.171', 'scorreav');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla ubosqueprg.user: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `userName`, `password`, `fullName`, `emailAddress`, `phoneNumber`, `dateLastPassword`, `active`, `userType`, `attempts`, `address`) VALUES
	(1, 'admonlib', '725058819589ae98c6613c1f5a6eac5a', 'admon', 'admonlibweb@gmail.com', '0000000000', '2018-05-30', 'A', 'ADMIN', 0, 'No disponible'),
	(2, 'danibepe', '90427a7c34f5c69f96fb2437973afbf1', 'Daniel Beltrán Penagos', 'beltranpenagos@gmail.com', '3144801215', '2018-05-30', 'A', 'NORMAL', 0, 'No disponible'),
	(3, 'scorreav', '67dc5d010d6c2897a1f8681c1ebc2d99', 'Santiago Correa', 'danielbeltrandaniel@gmail.com', '3134081685', '2018-05-30', 'A', 'NORMAL', 0, 'No disponible'),
	(4, 'oscartoo', '2896e32da34c09aa0ff28d05d7de1f1d', 'Oscar Too', 'santi_correa27@hotmail.com', '3502401496', '2018-05-30', 'A', 'NUEVO', 0, 'No disponible');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
