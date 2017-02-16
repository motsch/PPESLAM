drop database if exists ppeleger;
Create database ppeleger;
use ppeleger;


Create table saison
(
IDsaison int(1) NOT NULL,
nomSaison varchar(10) NOT NULL,
PRIMARY KEY(IDsaison)
);

create table representant
(
IDRepre int(9) NOT NULL,
NomRepre varchar(30) NOT NULL,
PrenomRepre varchar(30) NOT NULL,
TelRepre varchar(13) NOT NULL,
MailRepre varchar(50) NOT NULL,
ContratsDemar varchar(30) NOT NULL,
ContratDemarDebut date,
ContratDemarFin date,
PRIMARY KEY(IDRepre)
);

Create table propri
(
IDPropri int(9) NOT NULL,
nomPropri varchar(30) NOT NULL,
prenomPropri varchar(30) NOT NULL,
adresPropri varchar(30) NOT NULL,
CPropri int(5) NOT NULL,
villPropri varchar(25) NOT NULL,
telPropri varchar(13) NOT NULL,
mailPropri varchar(50) NOT NULL,
PRIMARY KEY(IDPropri)
);

create table contratlocation
(
IDContratLoc int(9) NOT NULL,
DebutContratLoc date,
FinContratLoc date,
PRIMARY KEY(IDContratLoc)
);

Create table Lieu
(
IDLieu int(6) NOT NULL,
DescripLieu varchar(200),
prixMin int(6),
prixMax int(6),
PRIMARY KEY(IDLieu)
);


Create table appartement
(
IDAppart int(6) NOT NULL,
nomAppartement varchar(30),
numImmeuble varchar(5),
adresAppart varchar(20) NOT NULL,
CPAppart int(5) NOT NULL,
villAppart varchar(20) NOT NULL,
dispoDebut date,
dispoFin date,
type char(2) NOT NULL,
prix int(6) NOT NULL,
/*photo varbinary(max) NOT NULL,     Le type pour les photos?*/ 
PRIMARY KEY(IDAppart)
);


Create table Client
(
IDClient int(6) NOT NULL,
civilite enum (‘madame’, ‘monsieur’),
nomClient varchar(30) NOT NULL,
prenomClient varchar(30) NOT NULL,
adresClient varchar(20) NOT NULL,
CPClient int(5) NOT NULL,
telClient varchar(10) NOT NULL,
mail varchar(50) NOT NULL,
PRIMARY KEY(IDClient)
);

Create table SousLoc
(
IDContratSousLoc int(6) NOT NULL,
SousLocDebut date,
SousLocFin date,
PRIMARY KEY(IDContratSousLoc)
);

Create table Equipement
(
IDEquip int(6) NOT NULL,
nomEquip varchar(30) NOT NULL,
descripEquip varchar(250) NOT NULL,
tarif float(4) NOT NULL,
IDClient int(6) NOT NULL,
PRIMARY KEY(IDEquip),
FOREIGN KEY(IDClient) references Client(IDClient)
);



Create table Reservation
(
descripReserv varchar(20),
IDReserv int(9) NOT NULL,
dateDebutReserv date,
dateFinReserv date,
montant float(9),
payee boolean,
bloquee boolean
);



Create table majorer
(
IDsaison int(1) NOT NULL,
IDAppart int(6) NOT NULL,
majoPrix float(2),
PRIMARY KEY(IDSaison, IDAppart),
FOREIGN KEY(IDSaison) references saison(IDSaison),
FOREIGN KEY(IDAppart) references appartement(IDAppart)
);



Create table appartenir
(
IDPropri int(9) NOT NULL,
IDAppart int(6) NOT NULL,
PRIMARY KEY(IDPropri, IDAppart),
FOREIGN KEY(IDPropri) references propri(IDPropri),
FOREIGN KEY(IDAppart) references appartement(IDAppart)
);

Create table reserver le
(
dateDebutReserv date,
dateFinReserv date,
PRIMARY KEY(DateDebutReserv, DateFinReserv),
FOREIGN KEY(DateDebutReserv) references reservation(DateDebutReserv),
FOREIGN KEY(DateFinReserv) references reservation(DateFinReserv)
);