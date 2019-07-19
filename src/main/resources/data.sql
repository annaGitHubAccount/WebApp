
CREATE SEQUENCE person_seq
    MAXVALUE 99999999999999
    START WITH 100
    INCREMENT BY 1;

insert into Person(id, name, nachname) VALUES (1, 'Mariusz', 'Pudzian');
insert into Person(id, name, nachname) VALUES (2, 'Kora', 'Jackowska');
insert into Person(id, name, nachname) VALUES (3, 'Maja', 'Morowska');