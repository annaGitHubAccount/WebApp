CREATE SEQUENCE kunde_seq
    MAXVALUE 99999999999999
    START WITH 100
    INCREMENT BY 1;

CREATE SEQUENCE produkt_stammdaten__seq
    MAXVALUE 99999999999999
    START WITH 100
    INCREMENT BY 1;



create table Kunde
(
    id       long primary key auto_increment not null,
    steuer_id   varchar(50) not null,
    name      varchar(50)  not null,
    nachname  varchar(50)  not null,
    birth_date date not null,
    KUNDE_ART varchar(50)
);

create table Produkt_Stammdaten
(
  id    long primary key auto_increment not null,
  name     varchar(50)  not null,
  preis    decimal(20)  not null,
  isAktiv   boolean not null
);