insert into Kunde(id, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (1, '345676548', 'Mariusz', 'Pudzian', parsedatetime('17.09.2012', 'dd.MM.yyyy'), 'GD');
insert into Kunde(id, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (2, '467887549', 'Kora', 'Jackowska', parsedatetime('06.11.2000', 'dd.MM.yyyy'), 'SB');
insert into Kunde(id, steuer_id, name, nachname, birth_date, KUNDE_ART) VALUES (3, '256787543', 'Maja', 'Morowska', parsedatetime('02.06.2006', 'dd.MM.yyyy'), 'BR');

insert into Produkt_Stammdaten(id, name, preis, is_aktiv) values (1, 'Produkt1', 100, true);
insert into Produkt_Stammdaten(id, name, preis, is_aktiv) values (2, 'Produkt2', 250, true);
insert into Produkt_Stammdaten(id, name, preis, is_aktiv) values (3, 'Produkt3', 500, false);
insert into Produkt_Stammdaten(id, name, preis, is_aktiv) values (4, 'Produkt4', 1000, true);