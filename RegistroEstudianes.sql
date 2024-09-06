-- Crear la base de datos
CREATE DATABASE RegistroEstudiantes;

-- Seleccionar la base de datos
USE RegistroEstudiantes;

-- Crear la tabla Materiaesp
CREATE TABLE Materia (
    curso_id INT PRIMARY KEY,
    materia VARCHAR(100) NOT NULL,
    horas INT NOT NULL
);

-- Crear la tabla Alumno
CREATE TABLE Alumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Cedula VARCHAR(10) NOT NULL,
    id_curso INT NOT NULL,
    Contacto VARCHAR(10) NOT NULL,
    FOREIGN KEY (id_curso) REFERENCES Materia(curso_id)
    ON DELETE CASCADE
);

-- Crear la tabla Materia
CREATE TABLE MateriaEsp (
    id_materia INT PRIMARY KEY,
    materia VARCHAR(100) NOT NULL,
    horas INT NOT NULL,
    FOREIGN KEY (id_materia) REFERENCES Alumno(id)
    ON DELETE CASCADE
);
drop database RegistroEstudiantes