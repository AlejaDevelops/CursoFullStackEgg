create database IF NOT EXISTS usuarios;

USE usuarios; 

create table  IF NOT EXISTS usuarios(
  id bigint auto_increment primary key,
  nombre varchar(50) NOT NULL,
  apellido varchar(50) NOT NULL,
  email varchar(255) DEFAULT NULL,
  telefono varchar(20) DEFAULT NULL,
  contrasena varchar(255) default NULL
);

insert into usuarios (nombre, apellido, email, telefono, contrasena) values('Alejandra', 'Orjuela', 'orjuela.alejandrap@gmail.com', '302 5144232', '123456789');
insert into usuarios (nombre, apellido, email, telefono, contrasena) values('Juan', 'Rios', 'rios@gmail.com', '302 123456', '123456789');
insert into usuarios (nombre, apellido, email, telefono, contrasena) values('Alessandro', 'Rios', 'alessandro@gmail.com', '302 987654', '123456789');
insert into usuarios (nombre, apellido, email, telefono, contrasena) values('David', 'Rios', 'david@gmail.com', '302 654321', '123456789');
insert into usuarios (nombre, apellido, email, telefono, contrasena) values('Pepito', 'Perez', 'pepito@gmail.com', '302 852369', '12345678910');
insert into usuarios (nombre, apellido, email, telefono, contrasena) values('Plim', 'Plim', 'plinplin@gmail.com', '302 369852', '12345678911');

select * from usuarios;
