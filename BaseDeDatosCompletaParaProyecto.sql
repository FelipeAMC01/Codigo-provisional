CREATE DATABASE IF NOT EXISTS RegistroEstudiantes;
USE RegistroEstudiantes;

SELECT * FROM curso;
SELECT * FROM alumno;
SELECT * FROM materias;
SELECT * FROM alumno_materias;
SELECT * FROM curso_materias;

CREATE TABLE IF NOT EXISTS curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS alumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cedula VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100),
    curso INT NOT NULL,
    contacto VARCHAR(100),
    FOREIGN KEY (curso) REFERENCES curso(id) ON DELETE CASCADE
    );


CREATE TABLE IF NOT EXISTS materias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    horas INT NULL
);


CREATE TABLE IF NOT EXISTS alumno_materias (
    id_alumno INT,
    id_materia INT,
    PRIMARY KEY (id_alumno, id_materia),
    FOREIGN KEY (id_alumno) REFERENCES alumno(id) ON DELETE CASCADE,
    FOREIGN KEY (id_materia) REFERENCES materias(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS curso_materias (
    id_curso INT,
    id_materia INT,
    horas INT NOT NULL,
    PRIMARY KEY (id_curso, id_materia),
    FOREIGN KEY (id_curso) REFERENCES curso(id) ON DELETE CASCADE,
    FOREIGN KEY (id_materia) REFERENCES materias(id) ON DELETE CASCADE
);


ALTER TABLE alumno ADD COLUMN id_materia INT;
ALTER TABLE alumno_materias ADD COLUMN horas INT;


