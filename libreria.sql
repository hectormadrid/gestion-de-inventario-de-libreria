create database libreria ;
use libreria ;


create table provedor(
rut varchar (9) primary key,
nombre varchar (30),
apellido varchar (30),
fono int (9),
correo_electronico varchar(50)
);

create table articulo (
id int auto_increment primary key, 
nombre varchar (30),
cantidad varchar (30),
precio int (10),
rut_provedor varchar (9),
foreign key (rut_provedor) references provedor(rut)
);

create table  cliente (
rut varchar (9) primary key,
nombre varchar (30),
apellido varchar (30),
boleta int (3)
);

create table trabajador (
rut varchar (30),
nombre varchar (30),
apellido varchar (30),
entrada datetime,
salida datetime 
);

create table pago(
id_pago int  (1) primary key,
tipo_de_pago varchar (30)
);

create table boleta (
id int auto_increment primary key,
rut_cliente varchar (9),
articulos int ,
fecha datetime ,
total int (10),
forma_de_pago int (1),
foreign key (forma_de_pago) references pago(id_pago),
foreign key (rut_cliente) references cliente(rut),
foreign key (articulos) references articulo (id)
);

insert into trabajador values  ("5555-5","fernando","flores","2020-11-12 08:00:00","2020-11-12 15:00:00");

insert into pago values (1,"efectivo"),(2,"credito");

insert into provedor values ("444-4","carlos","cucarachin",3333333,"carloscucarachin@gmail.com");

insert into articulo values (null,"cuaderno de lenguaje",10,1000,"444-4"),(null,"lapiz grafito",50,200,null),(null,"goma",30,100,null);

insert into cliente values ("111-1","hector", "madrid",1);

insert into boleta values (null,"111-1",1,now(),1200,1);

create table histo_articulo(
id int auto_increment primary key ,
articulo_id int , 
precio int (10),
fecha datetime,
foreign key (articulo_id) references articulo(id)
);


delimiter //
create trigger histo_articulo before update on articulo for each row
begin
	insert into histo_articulo values (null,old.id,old.precio,now());
    end//
delimiter ;
