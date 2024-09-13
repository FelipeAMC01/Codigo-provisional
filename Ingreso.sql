INSERT INTO curso (nombre) VALUES ('Curso 1'), ('Curso 2'), ('Curso 3');

INSERT INTO alumno (cedula, nombre, apellido, curso, Contacto) VALUES
('1709231532', 'Juan', 'Pérez', 1, 'juan.perez@gmail.com'),
('1750553784', 'María', 'López', 2, 'maria.lopez@hotmail.com');

INSERT INTO materias (nombre, horas) VALUES
('Matemáticas', null),
('Historia', null),
('Ciencias', null),
('Inglés', null),
('Filosofía', null),
('Física', null),
('Educación F.', null),
('Contabilidad', null);

ALTER TABLE curso_materias MODIFY COLUMN horas INT NULL;
ALTER TABLE materias
MODIFY COLUMN horas INT NULL;