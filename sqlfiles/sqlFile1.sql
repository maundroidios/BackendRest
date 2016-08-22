
--DATOS DE LA BASE DE DATOS
database loreirodb
roottech1234
usuario
phonegap


create database loreirodb;
use loreirodb;

create table usuarios(id int not null, 
nombre varchar(50) default 'NONAME');

insert into usuarios values (1,'usuario1'),(2,'usuario2'),(3,'usuario3');
commit;
select * from usuarios;

create user usuario;
create user phonegap;
