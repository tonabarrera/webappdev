CREATE TABLE carrera(
	carrera_id int PRIMARY KEY AUTO_INCREMENT,
	nombre varchar(50) not NULL,
	descripcion varchar(100) not NULL,
	duracion int not NULL
);

CREATE TABLE alumno(
	boleta BIGINT PRIMARY KEY,
	nombre varchar(50) NOT NULL,
	ap_paterno varchar(50) NOT NULL,
	ap_materno varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	carrera_id integer not null,
	foreign key(carrera_id) references carrera(carrera_id) 
	on update cascade on delete cascade
);

CREATE TABLE usuario(
	usuario_id INT AUTO_INCREMENT PRIMARY KEY,
	nombre varchar(50) NOT NULL,
	clave varchar(50) NOT NULL,
	tipo INT NOT NULL
);

INSERT INTO alumno(boleta, nombre, ap_paterno, ap_materno, email, carrera_id) 
VALUES(7779042, 'carlos', 'barrera', 'perez', 'email@email.com', 1);

SELECT COUNT(a.boleta) AS 'alumnos', c.nombre as 'carrera' from carrera as c 
LEFT JOIN alumno AS a ON c.carrera_id=a.carrera_id GROUP BY c.carrera_id;

select * from usuario;
CALL sp_get_data();

CALL sp_crear_usuario('moy@gmail.com', '123', 1);
CALL sp_existe_by_nombre_clave('moy@gmail.com', '123');
call sp_existe_by_nombre('my@gmail.com');
CALL sp_get_usuario('carlostonatihu@gmail.com');

SELECT COUNT(*) as 'existe' FROM usuario AS u WHERE u.nombre='moy@gmail.com' AND u.clave='123';





