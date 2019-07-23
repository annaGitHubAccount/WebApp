
CREATE SEQUENCE kunde_seq
    MAXVALUE 99999999999999
    START WITH 100
    INCREMENT BY 1;

insert into Kunde(id, steuer_id, name, nachname) VALUES (1, '3456', 'Mariusz', 'Pudzian');
insert into Kunde(id, steuer_id, name, nachname) VALUES (2, '4678', 'Kora', 'Jackowska');
insert into Kunde(id, steuer_id, name, nachname) VALUES (3, '2567', 'Maja', 'Morowska');