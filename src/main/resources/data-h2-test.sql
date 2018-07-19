SET NAMES utf8;

DROP TABLE IF EXISTS abf_stand_hausm;
CREATE TABLE abf_stand_hausm (
  anrede varchar(255) DEFAULT NULL,
  aufgabe varchar(255) DEFAULT NULL,
  bemerkung varchar(255) DEFAULT NULL,
  fax varchar(255) DEFAULT NULL,
  intern int(11) DEFAULT NULL,
  nachname varchar(255) DEFAULT NULL,
  nr varchar(255) DEFAULT NULL,
  ort varchar(255) DEFAULT NULL,
  plz int(11) DEFAULT NULL,
  standort varchar(255) DEFAULT NULL,
  strasse varchar(255) DEFAULT NULL,
  tel_festnetz varchar(255) DEFAULT NULL,
  tel_mobil varchar(255) DEFAULT NULL,
  tel_privat varchar(255) DEFAULT NULL,
  tel_sek varchar(255) DEFAULT NULL,
  tel_sek1 varchar(255) DEFAULT NULL,
  vorname varchar(255) DEFAULT NULL,
  id int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);

INSERT INTO abf_stand_hausm (anrede, aufgabe, bemerkung, fax, intern, nachname, nr, ort, plz, standort, strasse, tel_festnetz, tel_mobil, tel_privat, tel_sek, tel_sek1, vorname, id) VALUES
('Herr',	'Hausmeister',	NULL,	NULL,	40,	'Dittmar',	'2',	'KernStadt',	00000,	'Kreishaus KernStadt',	'Südring',	NULL,	'0105/1331234',	NULL,	'01234/1331234',	NULL,	'Rainer',	15),
('Herr',	'Hausmeister',	NULL,	'033/870',	115,	'Emde',	'28',	'Nebensee',	00000,	'MPS Somedorf',	'Someberg',	NULL,	'0101/987654321',	NULL,	'0503/864',	NULL,	'Torsten',	16),
('Herr',	'Schließdienst',	NULL,	'033/870',	115,	'Emde',	'28',	'Nebensee',	00000,	'MPS Somedorf',	'Someberg',	NULL,	'0101/54632145',	NULL,	'0503/864',	NULL,	'Torsten',	17);