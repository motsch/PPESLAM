-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 21 déc. 2017 à 13:57
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  dbNS
--
DROP DATABASE IF EXISTS dbNS;
CREATE DATABASE dbNS;
use dbNS;
-- --------------------------------------------------------

--
-- Structure de la table appartement
--

DROP TABLE IF EXISTS appartement;
CREATE TABLE IF NOT EXISTS appartement (
  idAppart int(6) NOT NULL AUTO_INCREMENT,
  nomAppartement varchar(30) DEFAULT NULL,
  numImmeuble varchar(5) DEFAULT NULL,
  adresAppart varchar(20) NOT NULL,
  CPAppart int(5) NOT NULL,
  villAppart varchar(20) NOT NULL,
  dispoDebut date DEFAULT NULL,
  dispoFin date DEFAULT NULL,
  type char(2) NOT NULL,
  prix int(6) NOT NULL,
  PRIMARY KEY (idAppart)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table appartement
--

INSERT INTO appartement (idAppart, nomAppartement, numImmeuble, adresAppart, CPAppart, villAppart, dispoDebut, dispoFin, type, prix) VALUES
(1, 'lesmolines', '245', '25 place napoleon', 5350, 'molines-en-queyras', '2016-08-31', '2017-08-31', 'as', 700),
(2, 'leChateauvielleville', '246', '25 place napoleon', 5350, 'chateau-vile-vielle', '2016-08-31', '2017-08-31', 'ad', 700),
(3, 'lesceillac', '247', '25 place napoleon', 5350, 'ceillac', '2016-08-31', '2017-08-31', 'ad', 700),
(4, 'leristolas', '248', '25 place napoleon', 5350, 'ristolas', '2016-08-31', '2017-08-31', 'as', 700),
(5, 'lesabries', '248', '25 place napoleon', 5350, 'abries', '2016-08-31', '2017-08-31', 'as', 700);

-- --------------------------------------------------------

--
-- Structure de la table contratlocation
--

DROP TABLE IF EXISTS contratlocation;
CREATE TABLE IF NOT EXISTS contratlocation (
  IDContratLoc int(9) NOT NULL AUTO_INCREMENT,
  DebutContratLoc date DEFAULT NULL,
  FinContratLoc date DEFAULT NULL,
  idAppart int(6) NOT NULL,
  idPro int(9) NOT NULL,
  PRIMARY KEY (IDContratLoc),
  KEY idAppart (idAppart), 
  KEY idPro (idPro)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table contratlocation
--

INSERT INTO contratlocation (IDContratLoc, DebutContratLoc, FinContratLoc, idAppart, idPro) VALUES
(1, '2018-03-22', '2018-10-05', 1, 1),
(2, '2018-01-02', '2018-12-01', 2, 1),
(3, '2018-06-10', '2018-12-02', 3, 2),
(4, '2018-04-10', '2018-09-16', 4, 3),
(5, '2018-02-18', '2018-11-16', 5, 3);

-- --------------------------------------------------------

--
-- Structure de la table equipement
--

DROP TABLE IF EXISTS equipement;
CREATE TABLE IF NOT EXISTS equipement (
  IDEquip int(6) NOT NULL AUTO_INCREMENT,
  nomEquip varchar(30) NOT NULL,
  descripEquip varchar(250) NOT NULL,
  tarif float NOT NULL,
  IDClient int(6) NOT NULL,
  PRIMARY KEY (IDEquip),
  KEY IDClient (IDClient)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table lieu
--

DROP TABLE IF EXISTS lieu;
CREATE TABLE IF NOT EXISTS lieu (
  IDLieu int(6) NOT NULL AUTO_INCREMENT,
  DescripLieu varchar(200) DEFAULT NULL,
  prixMin int(6) DEFAULT NULL,
  prixMax int(6) DEFAULT NULL,
  PRIMARY KEY (IDLieu)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table lieu
--

INSERT INTO lieu (IDLieu, DescripLieu, prixMin, prixMax) VALUES
(1, 'local', 320, 480),
(2, 'studio', 210, 560),
(3, 'commune', 340, 670),
(4, 'local', 100, 400),
(5, 'studio', 200, 500);

-- --------------------------------------------------------

--
-- Structure de la table majorer
--

DROP TABLE IF EXISTS majorer;
CREATE TABLE IF NOT EXISTS majorer (
  IDsaison int(1) NOT NULL,
  IDAppart int(6) NOT NULL,
  majoPrix float DEFAULT NULL,
  PRIMARY KEY (IDsaison,idAppart),
  KEY idAppart (idAppart)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table membre
--

DROP TABLE IF EXISTS membre;
CREATE TABLE IF NOT EXISTS membre (
  id int(10) NOT NULL AUTO_INCREMENT,
  nom varchar(255) NOT NULL,
  prenom varchar(255) NOT NULL,
  mail varchar(255) NOT NULL,
  telephone varchar(13) NOT NULL,
  motdepasse text NOT NULL,
  adresse varchar(20) DEFAULT NULL,
  CP int(5) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table proprietaire
--

DROP TABLE IF EXISTS proprietaire;
CREATE TABLE IF NOT EXISTS proprietaire (
  idPro int(9) NOT NULL AUTO_INCREMENT,
  nomPro varchar(30) NOT NULL,
  prenomPro varchar(30) NOT NULL,
  adressPro varchar(30) DEFAULT NULL,
  cpPro int(5) DEFAULT NULL,
  villePro varchar(25) DEFAULT NULL,
  telephonePro varchar(13) NOT NULL,
  mailPro varchar(50) NOT NULL,
  motdepassePro text NOT NULL,
  IDRepre int(9) NOT NULL,
  PRIMARY KEY (idPro),
  KEY IDRepre (IDRepre)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table proprietaire
--

INSERT INTO proprietaire (idPro, nomPro, prenomPro, telephonePro, mailPro, adressPro, cpPro, villePro, motdepassePro, IDRepre) VALUES
(1, 'deBatz', 'Charles', '0715975364', 'charles.debatz@gmail.com', 'Chateau de Lupiac', '33000', 'Lupiac', 'aaaa', 1),
(2, 'deSilègue', 'Armand', '0715535317', 'armand.desilegue@gmail.com', 'Chateau de La Feyre', '33000', 'La Feyre', 'bbbb', 2),
(3, 'Aramitz', 'Henri', '077145698', 'henri.daramitz@gmail.com', 'Gendarmie Nationale, Aramitz', '33000', 'Aramitz', 'cccc', 3),
(4, 'dePorthau', 'Isaac', '0714796382', 'isaac.deporthau@gmail.com', 'Chateau de Porthau', '33000', 'Porthau', 'cccc', 2),
(5, 'test', 'test', '0715975364', 'charles.debatz@gmail.com', 'test', '33000', 'test', 'aaaa', 1);

-- --------------------------------------------------------

--
-- Structure de la table representant
--

DROP TABLE IF EXISTS representant;
CREATE TABLE IF NOT EXISTS representant (
  IDRepre int(9) NOT NULL AUTO_INCREMENT,
  NomRepre varchar(30) NOT NULL,
  PrenomRepre varchar(30) NOT NULL,
  TelRepre varchar(13) NOT NULL,
  MailRepre varchar(50) NOT NULL,
  mdprepre text NOT NULL,
  ContratDemarDebut date DEFAULT NULL,
  ContratDemarFin date DEFAULT NULL,
  PRIMARY KEY (IDRepre)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table representant
--

INSERT INTO representant (IDRepre, NomRepre, PrenomRepre, TelRepre, MailRepre, mdprepre, ContratDemarDebut, ContratDemarFin) VALUES
(1, 'London', 'Jack', '0725684523', 'jack.london@gmail.com', 'bbbbb', '2014-07-05', '2020-08-15'),
(2, 'Dupont', 'Henri', '0746783425', 'henri.dupont@gmail.com', 'ccccc', '2014-03-27', '2020-11-02'),
(3, 'Arles', 'Robert', '0745678932', 'robert.arles@gmail.com', 'ddddd', '2011-03-22', '2017-04-15'),
(4, 'Charles', 'Pierre', '0756794312', 'pierre.charles@gmail.com', 'eeeee', '2010-12-23', '2020-10-28'),
(5, 'Xavier', 'Charles', '0734786521', 'charles.xavier@gmail.com', 'fffff', '2010-09-14', '2020-11-03');

-- --------------------------------------------------------

--
-- Structure de la table reservation
--

DROP TABLE IF EXISTS reservation;
CREATE TABLE IF NOT EXISTS reservation (
  IDResa int(9) NOT NULL AUTO_INCREMENT,
  descripReserv varchar(20) DEFAULT NULL,
  montant float DEFAULT NULL,
  payee tinyint(1) DEFAULT NULL,
  idAppart int(6) DEFAULT NULL,
  id int(10) NOT NULL,
  PRIMARY KEY (IDResa),
  KEY idAppart (idAppart),
  KEY id (id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table reservationmateriel
--

DROP TABLE IF EXISTS reservationmateriel;
CREATE TABLE IF NOT EXISTS reservationmateriel (
  IDResaMat int(9) NOT NULL AUTO_INCREMENT,
  date_reservation date DEFAULT NULL,
  date_fin_reservation date DEFAULT NULL,
  IDEquip int(6) NOT NULL,
  PRIMARY KEY (IDResaMat,IDEquip),
  KEY IDEquip (IDEquip)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table saison
--

DROP TABLE IF EXISTS saison;
CREATE TABLE IF NOT EXISTS saison (
  IDsaison int(1) NOT NULL,
  PRIMARY KEY (IDsaison)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table saison
--

INSERT INTO saison (IDsaison) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Structure de la table sousloc
--

DROP TABLE IF EXISTS sousloc;
CREATE TABLE IF NOT EXISTS sousloc (
  IDContratSousLoc int(6) NOT NULL AUTO_INCREMENT,
  SousLocDebut date DEFAULT NULL,
  SousLocFin date DEFAULT NULL,
  idAppart int(6) DEFAULT NULL,
  PRIMARY KEY (IDContratSousLoc),
  KEY idAppart (idAppart)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table sousloc
--

INSERT INTO sousloc (IDContratSousLoc, SousLocDebut, SousLocFin, idAppart) VALUES
(1, '2015-03-10', '2016-06-24', 1),
(2, '2016-02-10', '2016-12-29', 2),
(3, '2015-10-11', '2016-08-15', 3),
(4, '2015-02-20', '2016-06-30', 4),
(5, '2016-02-28', '2016-10-30', 5);
COMMIT;

--------------------------------------------------------
 -- Idees vues:
 
 -- Afficher tous les appartements déja réservés jusqu'à dans 1 mois?
 -- Afficher toutes les propriétés d'un même endroit par CP?
 -- Afficher tous les utilisateurs ayant actuellement reservé un appartement ?
 
 -- Vues
 --
 --Structure de la vue Appart_OQP_Mois
 --
CREATE VIEW Appart_OQP AS 
SELECT nomAppartement,
  numImmeuble,
  adresAppart,
  CPAppart,
  villAppart,
  dispoDebut,
  dispoFin
FROM appartement a, sousloc s 
WHERE a.idAppart = s.idAppart 
	AND (DATEDIFF(s.SousLocDebut, CURDATE()) 
	NOT BETWEEN 0 AND 30)
	AND (DATEDIFF(s.SousLocFin, CURDATE()) 
	< 30)
	AND (DATEDIFF(a.dispoDebut, CURDATE()) 
	NOT BETWEEN 0 AND 30)
	AND (DATEDIFF(a.dispoFin, CURDATE()) 
	< 30)
; 
 
 --
 --Structure de la vue Renego_Prochaine
 --
CREATE VIEW Renego_Prochaine AS 
SELECT nomAppartement,
  numImmeuble,
  adresAppart,
  CPAppart,
  villAppart,
  nomPro,
  prenomPro,
  telephonePro,
  mailPro,
  NomRepre,
  PrenomRepre 
FROM appartement, proprietaire, representant, contratlocation 
WHERE appartement.idAppart = contratlocation.idAppart 
	AND contratlocation.idPro = proprietaire.idPro 
	AND representant.IDRepre = proprietaire.IDRepre 
	AND (DATEDIFF(contratlocation.FinContratLoc, CURDATE()) 
	BETWEEN 0 AND 30)
;

 --
 --Structure de la vue Proprio_Par_Repre
 --
CREATE VIEW Proprio_Par_Repre AS 
SELECT 
  nomPro,
  prenomPro,
  telephonePro,
  mailPro,
  NomRepre,
  PrenomRepre 
FROM proprietaire, representant 
WHERE representant.IDRepre = proprietaire.IDRepre 
GROUP BY representant.IDRepre;
;

 --
 --Structure de la vue User_Resa
 --
CREATE VIEW User_Resa AS 
SELECT 
  nom,
  prenom,
  mail,
  telephone,
FROM membre, reservation 
WHERE membre.id = reservation.id
AND IDResa NOT NULL
GROUP BY id
;

 --
 --Structure de la vue FinSousLoc
 --
CREATE VIEW FinSousLoc AS 
SELECT 
  nom,
  prenom,
  mail,
  telephone,
  nomAppartement,
  numImmeuble,
  adresAppart,
  CPAppart,
  villAppart 
FROM membre, reservation, appartement 
WHERE membre.id = reservation.id 
	AND reservation.idAppart = appartement.idAppart 
AND IDResa IS NOT NULL 
GROUP BY membre.id
;

--------------------------------------------------------
-- Idees triggers:

-- Vérifier qu'un même utilisateur ne réserve pas deux appartements différents sur la même période
-- Vérifier qu'un utilisateur ne peut pas réserver un appartement déja réservé
-- 

---
---Structure du trigger Coherence_SousLoc
---
drop trigger if exists Coherence_SousLoc; 
DELIMITER // 
create trigger Coherence_SousLoc 
before insert on sousloc 
for each row 
begin 
	if new.idAppart = idAppart 
	then 
		  if new.SousLocDebut between SousLocDebut AND SousLocFin 
			or new.SousLocFin between SousLocDebut AND SousLocFin 
			or SousLocDebut  between new.SousLocDebut AND SousLocFin 
			or SousLocFin between SousLocDebut AND new.SousLocFin 
						then 
							signal SQLstate '42001' 
							set message_text= 'Déja réservé sur une partie du séjour!'; 
						End if; 
	End if;
end // 
DELIMITER ; 
;

---
---Structure du trigger Membre_Unique
---
drop trigger if exists Membre_Unique; 
DELIMITER // 
create trigger Membre_Unique 
before insert on membre 
for each row 
begin 
	if new.mail = mail 
	then 
		signal SQLstate '42002' 
							set message_text= 'Email Déja utilisé'; 
						 End if; 
end // 
DELIMITER ; 
;

---
---Structure du trigger UnRepParPro
---
drop trigger if exists UnRepParPro; 
DELIMITER // 
create trigger UnRepParPro 
before insert on proprietaire 
for each row 
begin 
	if new.nomPro = nomPro 
	then 
		if new.prenomPro = prenomPro 
		then 
		signal SQLstate '42002' 
							set message_text= 'Propriétaire déja existant'; 
						 End if; 
					end if; 
end // 
DELIMITER ; 
;

---
---Structure du trigger Coherence_Prix
---
drop trigger if exists Coherence_Prix; 
DELIMITER // 
create trigger Coherence_Prix 
before insert on appartement 
for each row 
begin 
	if new.nomPro = nomPro 
	then 
		if new.prenomPro = prenomPro 
		then 
		signal SQLstate '42003' 
							set message_text= 'Propriétaire déja existant'; 
						 End if; 
					end if; 
end // 
DELIMITER ; 
;
---------------------------------------------------------

--
--Procedure Meilleure Propriete
--

DELIMITER // 

DROP PROCEDURE IF EXISTS MeilleurAppart // 

CREATE PROCEDURE MeilleurAppart() 
BEGIN 
SELECT nomAppartement FROM appartement, sousloc 
where appartement.idAppart=sousloc.idAppart 
order by count(sousloc.idAppart) desc; 
END // 

DELIMITER ; 



CALL MeilleurAppart; 

---------------------------------------------------------

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
