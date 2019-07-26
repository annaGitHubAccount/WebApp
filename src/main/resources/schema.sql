create table Kunde
(
    id       long primary key auto_increment not null,
    steuer_id   varchar(50) not null,
    name      varchar(50)  not null,
    nachname  varchar(50)  not null,
    birth_date date not null
);

CREATE SEQUENCE kunde_seq
    MAXVALUE 99999999999999
    START WITH 100
    INCREMENT BY 1;