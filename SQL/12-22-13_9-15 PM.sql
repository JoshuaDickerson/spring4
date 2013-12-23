# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.15)
# Database: test
# Generation Time: 2013-12-23 02:15:49 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table address
# ------------------------------------------------------------

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `address1` varchar(100) NOT NULL DEFAULT '',
  `address2` varchar(100) DEFAULT NULL,
  `state` varchar(60) NOT NULL DEFAULT '',
  `city` varchar(60) NOT NULL DEFAULT '',
  `zip` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;

INSERT INTO `address` (`id`, `address1`, `address2`, `state`, `city`, `zip`)
VALUES
	(1,'test1','apt1','vt','Burlington','05401');

/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table idgen
# ------------------------------------------------------------

DROP TABLE IF EXISTS `idgen`;

CREATE TABLE `idgen` (
  `NEXT` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `idgen` WRITE;
/*!40000 ALTER TABLE `idgen` DISABLE KEYS */;

INSERT INTO `idgen` (`NEXT`)
VALUES
	(0);

/*!40000 ALTER TABLE `idgen` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table metric_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `metric_type`;

CREATE TABLE `metric_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `value_type` int(11) NOT NULL,
  `precision` int(11) DEFAULT '0',
  `name` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table person
# ------------------------------------------------------------

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `birth_year` int(11) DEFAULT NULL,
  `fk_address_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `player_address` (`fk_address_id`),
  CONSTRAINT `player_address` FOREIGN KEY (`fk_address_id`) REFERENCES `address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;

INSERT INTO `person` (`id`, `email`, `first_name`, `last_name`, `birth_year`, `fk_address_id`)
VALUES
	(1,'test1@test.com','test1','one',1981,1);

/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table player
# ------------------------------------------------------------

DROP TABLE IF EXISTS `player`;

CREATE TABLE `player` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fk_person_id` int(11) unsigned NOT NULL,
  `jersey` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_person_id` (`fk_person_id`),
  CONSTRAINT `player_ibfk_1` FOREIGN KEY (`fk_person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;

INSERT INTO `player` (`id`, `fk_person_id`, `jersey`)
VALUES
	(1,1,23);

/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table player_team_map
# ------------------------------------------------------------

DROP TABLE IF EXISTS `player_team_map`;

CREATE TABLE `player_team_map` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fk_player_id` int(11) unsigned NOT NULL,
  `fk_team_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `players` (`fk_player_id`),
  KEY `teams` (`fk_team_id`),
  CONSTRAINT `teams` FOREIGN KEY (`fk_team_id`) REFERENCES `team` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `players` FOREIGN KEY (`fk_player_id`) REFERENCES `player` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `player_team_map` WRITE;
/*!40000 ALTER TABLE `player_team_map` DISABLE KEYS */;

INSERT INTO `player_team_map` (`id`, `fk_player_id`, `fk_team_id`)
VALUES
	(1,1,1);

/*!40000 ALTER TABLE `player_team_map` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table team
# ------------------------------------------------------------

DROP TABLE IF EXISTS `team`;

CREATE TABLE `team` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;

INSERT INTO `team` (`id`, `name`)
VALUES
	(1,'bulldogs');

/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fk_person_id` int(11) unsigned NOT NULL,
  `username` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(30) NOT NULL DEFAULT '',
  `last_login` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `person` (`fk_person_id`),
  CONSTRAINT `person` FOREIGN KEY (`fk_person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `fk_person_id`, `username`, `password`, `last_login`)
VALUES
	(1,1,'joshUSER','joshPASS',NULL);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
