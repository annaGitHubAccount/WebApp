create table Kunde
(
    id       long primary key auto_increment not null,
    steuer_id   varchar(50) not null,
    name      varchar(50)  not null,
    nachname  varchar(50)  not null
);