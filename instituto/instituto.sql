DROP TABLE alumno;
DROP TABLE carrera;
DROP TABLE usuario;

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

CREATE TABLE usuario_tipos(
    usuario_tipo_id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(30) NOT NULL
);

CREATE TABLE alumnos(
    boleta VARCHAR(30) PRIMARY KEY,
    usuario_id INT NOT NULL,
    FOREIGN KEY(usuario_id) REFERENCES usuarios(usuario_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE profesores(
    profesor_id INT AUTO_INCREMENT PRIMARY KEY,
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

CREATE TABLE alumnos_carreras(
    alumno_boleta VARCHAR(30) NOT NULL,
    carrera_id INT NOT NULL,
    PRIMARY KEY(alumno_boleta, carrera_id),
    FOREIGN KEY(alumno_boleta) REFERENCES alumnos(boleta) 
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(carrera_id) REFERENCES carreras(carrera_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE materias(
    materia_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(30),
    carrera_id INT NOT NULL,
    FOREIGN KEY(carrera_id) REFERENCES carreras(carrera_id) 
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE profesores_materias(
    materia_id INT NOT NULL,
    profesor_id INT NOT NULL,
    PRIMARY KEY(materia_id, profesor_id),
    FOREIGN KEY(materia_id) REFERENCES materias(materia_id) 
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(profesor_id) REFERENCES profesores(profesor_id) 
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
    FOREIGN KEY(pregunta_id) REFERENCES preguntas(examen_id) 
    ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(evaluacion_id) REFERENCES evaluaciones(evaluacion_id) 
    ON UPDATE CASCADE ON DELETE CASCADE
);


