create database libreria ;
use libreria ;



create table articulo (
id int auto_increment primary key, 
nombre varchar (30),
cantidad varchar (30),
precio int (10)
);


create table  cliente (
rut int (9) primary key,
nombre varchar (30),
apellido varchar (30),
boleta int (3)

);

create table boleta (
id int auto_increment primary key,
rut_cliente int (9),
articulos varchar (30),
total int (10),
foreign key (rut_cliente) references cliente(rut)
);
