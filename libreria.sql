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
cantidad int (3),
precio int (10),
rut_provedor varchar (9),
activo bit (1),
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
contra varchar (50),
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
cantidad_articulos int,
fecha datetime ,
total int (10),
forma_de_pago int (1),
foreign key (forma_de_pago) references pago(id_pago),
foreign key (rut_cliente) references cliente(rut),
foreign key (articulos) references articulo (id)
);
insert into trabajador values  ("5555-5","fernando","flores","2020-11-12 08:00:00","2020-11-12 15:00:00");
insert into pago values (1,"efectivo"),
						(2,"credito"),
						(3,"debito");
insert into provedor values ("444-4","carlos","cucarachin",3333333,"carloscucarachin@gmail.com"),
							("555-5","el pepe","grillo",2365151,"pepecucarachin@gmail.com");
insert into articulo values (null,"cuaderno de lenguaje",10,1000,"444-4",1),
							(null,"lapiz grafito",50,200,null,1),
							(null,"goma",30,100,null,0);
insert into cliente values ("111-1","hector", "madrid",1),
						   ("222-2","carlos","vacalao",3),
                           ("333-3","fernando","tuetue",2);
insert into boleta values (null,"111-1",1,1,now(),1200,1);



create table histo_articulo(
id int auto_increment primary key ,
articulo_id int , 
precio int (10),
fecha datetime,
foreign key (articulo_id) references articulo(id)
);

-- Almacenamiento precio anterior

delimiter //
create trigger histo_articulo before update on articulo for each row
begin
	insert into histo_articulo values (null,old.id,old.precio,now());
    end//
delimiter ;

update articulo set precio = 100 where id = 3; 


create table histo_provedor (
id int auto_increment primary key,
rut_provedor varchar (9),
apellido varchar (30),
fono int (9),
correo_electronico varchar (50)
);

-- Almacenamiento proveedor anterior

delimiter //
create trigger histo_provedor before delete on provedor for each row
begin
	insert into histo_provedor values (old.rut,old.nombre,old.apellido,old.fono,old.correo_electronico);
    end//
delimiter ;

-- Activacion de Productos

DELIMITER //
create procedure activar_producto (IN _id int(10) )
BEGIN
    DECLARE _activador INT;

    SET _activador = (SELECT COUNT(*) from articulo WHERE id = _id);

    IF _activador = 1 THEN 
			update articulo set activo = 1 where id = _id ;
            select 'se a activado el producto' as 'alerta';
			else
            select 'no se a encontrado el producto ' as 'alerta';
        END IF;
        
END //
DELIMITER ;

-- Desactivacion de productos

DELIMITER //
create procedure desactivar_producto (IN _id int(10) )
BEGIN
    DECLARE _desactivar INT;

    SET _desactivar = (SELECT COUNT(*) from articulo WHERE id = _id);

    IF _desactivar = 1 THEN 
			update articulo set activo = 0 where id = _id ;
SELECT 'se a desactivado el producto' AS 'alerta';
			else
            select 'no se a encontrado el producto ' as 'alerta';
        END IF;
        
END //
DELIMITER ;

					   
