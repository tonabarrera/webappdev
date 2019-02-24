create table categorias(
	categoria_id serial primary key,
	nombre varchar(30) not null,
	descripcion varchar(100) not null
);
/*drop table categorias;*/
create table articulos(
	clave char(6) not null primary key,
	nombre varchar(30) not null,
	descripcion varchar(50) not null,
	precio money,
	existencia integer,
	categoria_id integer not null,
	foreign key(categoria_id) references categorias(categoria_id) 
	on update cascade on delete cascade
);
select * from categorias;
insert into categorias(nombre, descripcion) values('Tacos', 'Los tacos son comida'); 

