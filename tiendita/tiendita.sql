create table categorias(
	categoria_id serial primary key,
	nombre varchar(30) not null,
	descripcion varchar(100) not null
);
create table productos(
	producto_id serial primary key,
	nombre varchar(30) not null,
	descripcion varchar(50) not null,
	precio money,
	existencia integer,
	categoria_id integer not null,
	foreign key(categoria_id) references categorias(categoria_id) 
	on update cascade on delete cascade
);

create table usuario(
	usuario_id serial primary key,
	username varchar(20) not null,
	clave varchar(20) not null,
	email varchar(50) not null,
	nombre varchar(30) not null,
	ap_paterno varchar(30) not null,
	ap_materno varchar(30) not null
);

insert into categorias values
(1,'Electrónica', 'Articulos para el hogar'),
(2,'Computación', 'Articulos para el hogar'),
(3,'Línea Blanca', 'Articulos para el hogar');

insert into productos(producto_id, nombre, descripcion, existencia, precio, categoria_id) values
(1,'Televisor LG','Articulo para la familia',100,250.50,1),
(2,'Televisor XY','Articulo para la familia',100,250.50,1),
(3,'Televisor ZZ','Articulo para la familia',100,250.50,1),
(4,'Impresora','Impresora',100,250.50,2),
(5,'Impresora zzzz','Impresora',100,250.50,2),
(6,'Refrigerador','Impresora',100,250.50,3);
