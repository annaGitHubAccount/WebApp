insert into Kunde(id, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (1, '345676548', 'Mariusz', 'Pudzian', parsedatetime('17.09.2012', 'dd.MM.yyyy'), 'GD');
insert into Kunde(id, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (2, '467887549', 'Kora', 'Jackowska', parsedatetime('06.11.2000', 'dd.MM.yyyy'), 'SB');
insert into Kunde(id, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (3, '256787543', 'Maja', 'Morowska', parsedatetime('02.06.2006', 'dd.MM.yyyy'), 'BR');

insert into Produkt_Stammdaten(id, name, preis, is_aktiv, PRODUKT_ART) values (1, 'Produkt1', 100, true, 'L');
insert into Produkt_Stammdaten(id, name, preis, is_aktiv, PRODUKT_ART) values (2, 'Produkt2', 250, true, 'S');
insert into Produkt_Stammdaten(id, name, preis, is_aktiv,PRODUKT_ART) values (3, 'Produkt3', 500, false, 'M');
insert into Produkt_Stammdaten(id, name, preis, is_aktiv, PRODUKT_ART) values (4, 'Produkt4', 1000, true, 'L');

insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(1, 'Polska' ,'Warszawa', 'Solidarnosci', '54a', 'MA', 1);
insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(2, 'Polska','Rzeszow', 'Siemiradzkiego', '76', 'PA', 1);

insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(3, 'Deutschland', 'Nürnberg', 'Lange Str.', '11b', 'MA', 2);
insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(4, 'Deutschland', 'München', 'Kurze Str.', '13', 'PA', 2);

insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(5, 'Polska', 'Warszawa', 'Wojska Polskiego', '11', 'MA', 3);
insert into Adresse(ID, LAND, ORT, STRASSE, HAUS_NR, ADRESSE_ART, KUNDE_ID) VALUES(6, 'Polska', 'Krakow', 'Nowotki', '13', 'PA', 3);