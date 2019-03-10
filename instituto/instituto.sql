DROP TABLE alumnos;
DROP TABLE carreras;
DROP TABLE usuarios;
DROP TABLE profesores;
DROP TABLE profesores_materias;
DROP TABLE alumnos_carreras;
DROP TABLE respuestas;
CALL sp_buscar_profesor_username('jojojo');
CREATE TABLE usuarios(
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    ap_paterno VARCHAR(30) NOT NULL,
    ap_materno VARCHAR(30),
    email VARCHAR(30) NOT NULL UNIQUE,
    username VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    usuario_tipo INT NOT NULL,
    FOREIGN KEY(usuario_tipo) REFERENCES usuario_tipos(usuario_tipo_id) 
on UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO usuarios(nombre, ap_paterno, ap_materno, email, username, password, usuario_tipo) 
    VALUES('Jo', 'Jo', 'Jo', 'jo@gmail.com', 'jo', 'jo', 1);
SELECT * FROM usuarios;
CALL sp_crear_usuario('Jo', 'Jo', 'Jo', 'jojojo@gmail.com', 'jojojo', 'jo', 2, '2016630020');

CREATE TABLE usuario_tipos(
    usuario_tipo_id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(30) NOT NULL
);
INSERT INTO usuario_tipos(tipo) VALUES('ALUMNO'),('PROFESOR');

CREATE TABLE alumnos(
    boleta VARCHAR(30) PRIMARY KEY,
    carrera_id INT,
    usuario_id INT NOT NULL,
    FOREIGN KEY(carrera_id) REFERENCES carreras(carrera_id) 
    ON UPDATE CASCADE,
    FOREIGN KEY(usuario_id) REFERENCES usuarios(usuario_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);
SELECT u.usuario_id, u.usuario_tipo, u.nombre, u.ap_materno, u.ap_paterno, u.email, 
    u.username, u.password, a.boleta, a.carrera_id 
    from usuarios as u left JOIN alumnos as a on u.usuario_id=a.usuario_id 
    where u.username='jo' and u.usuario_tipo=1;
SELECT LAST_INSERT_ID();
INSERT INTO alumnos(boleta, usuario_id) VALUES('201663002', 5);

CREATE TABLE profesores(
    profesor_num VARCHAR(30) PRIMARY KEY,
    usuario_id INT NOT NULL,
    FOREIGN KEY(usuario_id) REFERENCES usuarios(usuario_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE carreras(
    carrera_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(100),
    duracion INT NOT NULL
);
INSERT INTO carreras(nombre, descripcion, duracion) VALUES('ISC', 'Es chida', 7);

/*CREATE TABLE alumnos_carreras(
    alumno_boleta VARCHAR(30) NOT NULL,
    carrera_id INT NOT NULL,
    PRIMARY KEY(alumno_boleta, carrera_id),
    FOREIGN KEY(alumno_boleta) REFERENCES alumnos(boleta) 
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(carrera_id) REFERENCES carreras(carrera_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);*/

CREATE TABLE materias(
    materia_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(30),
    carrera_id INT NOT NULL,
    profesor_num VARCHAR(30),
    FOREIGN KEY(carrera_id) REFERENCES carreras(carrera_id) 
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(profesor_num) REFERENCES profesores(profesor_num) 
    ON UPDATE CASCADE
);
ALTER TABLE materias ADD COLUMN profesor_num VARCHAR(30);
ALTER TABLE materias ADD FOREIGN KEY(profesor_num) REFERENCES profesores(profesor_num) 
    ON UPDATE CASCADE;
SELECT * FROM profesores;
INSERT INTO materias(nombre, descripcion, carrera_id, profesor_num) 
    VALUES('Algoritmos Geneticos', 'Es Chida', 1, '20122012');

CREATE TABLE profesores_materias(
    materia_id INT NOT NULL,
    profesor_num VARCHAR(30) NOT NULL,
    PRIMARY KEY(materia_id, profesor_num),
    FOREIGN KEY(materia_id) REFERENCES materias(materia_id) 
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(profesor_num) REFERENCES profesores(profesor_num) 
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE examenes(
    examen_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(30),
    fecha DATE NOT NULL,
    materia_id INT NOT NULL,
    FOREIGN KEY(materia_id) REFERENCES materias(materia_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE evaluaciones(
    evaluacion_id INT AUTO_INCREMENT PRIMARY KEY,
    calificacion INT,
    alumno_boleta VARCHAR(30) NOT NULL,
    examen_id INT NOT NULL,
    FOREIGN KEY(alumno_boleta) REFERENCES alumnos(boleta) 
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(examen_id) REFERENCES examenes(examen_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE preguntas(
    pregunta_id INT AUTO_INCREMENT PRIMARY KEY,
    enunciado VARCHAR(100) NOT NULL,
    opcion_uno VARCHAR(50) NOT NULL,
    opcion_dos VARCHAR(50) NOT NULL,
    opcion_tres VARCHAR(50) NOT NULL,
    opcion_cuatro VARCHAR(50) NOT NULL,
    respuesta_correcta INT NOT NULL,
    examen_id INT NOT NULL,
    FOREIGN KEY(examen_id) REFERENCES examenes(examen_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE respuestas(
    pregunta_id INT NOT NULL,
    evaluacion_id INT NOT NULL,
    opcion_elegida INT NOT NULL,
    PRIMARY KEY(pregunta_id, evaluacion_id),
    FOREIGN KEY(pregunta_id) REFERENCES preguntas(examen_id) 
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(evaluacion_id) REFERENCES evaluaciones(evaluacion_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);

CALL sp_get_data();
