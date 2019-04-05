create table categoria(
    categoria_id serial primary key,
    nombre varchar(30) not null,
    descripcion varchar(100) not null
);
create table producto(
    producto_id serial primary key,
    nombre varchar(30) not null,
    descripcion varchar(50) not null,
    precio numeric,
    existencia integer,
    categoria_id integer not null,
    foreign key(categoria_id) references categoria(categoria_id) 
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

insert into categoria(nombre, descripcion) values('Electrónica', 'Articulos para el hogar'),
('Computación', 'Articulos para el hogar'),
('Línea Blanca', 'Articulos para el hogar');

insert into producto(nombre, descripcion, existencia, precio, categoria_id) values
('Televisor LG','Articulo para la familia',100,250.50,1),
('Televisor XY','Articulo para la familia',100,250.50,1),
('Televisor ZZ','Articulo para la familia',100,250.50,1),
('Impresora','Impresora',100,250.50,2),
('Impresora zzzz','Impresora',100,250.50,2),
('Refrigerador','Impresora',100,250.50,3);

drop table usuario;
drop table producto;
drop table categoria;

select c.nombre, count(p.producto_id) as "cantidad"
from categoria as c left join producto as p on c.categoria_id=p.categoria_id 
group by c.nombre;

call sp_get_data();

