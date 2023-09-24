DROP DATABASE IF EXISTS pokemon;
CREATE DATABASE pokemon;

USE pokemon;

CREATE TABLE pokemon (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    tipo1 VARCHAR(255) NOT NULL,
    tipo2 VARCHAR(255),
    altura DECIMAL(5, 2) NOT NULL,
    peso DECIMAL(5, 2) NOT NULL
);

-- Insertar Pikachu
INSERT INTO pokemon (nombre, tipo1, tipo2, altura, peso)
VALUES ('Pikachu', 'Eléctrico', NULL, 0.40, 6.0);

-- Insertar Charizard
INSERT INTO pokemon (nombre, tipo1, tipo2, altura, peso)
VALUES ('Charizard', 'Fuego', 'Volador', 1.70, 90.5);

-- Insertar Bulbasaur
INSERT INTO pokemon (nombre, tipo1, tipo2, altura, peso)
VALUES ('Bulbasaur', 'Planta', 'Veneno', 0.70, 6.9);

-- Insertar Gengar
INSERT INTO pokemon (nombre, tipo1, tipo2, altura, peso)
VALUES ('Gengar', 'Fantasma', 'Veneno', 1.50, 40.5);

-- Insertar Vaporeon
INSERT INTO pokemon (nombre, tipo1, tipo2, altura, peso)
VALUES ('Vaporeon', 'Agua', NULL, 0.99, 29.0);
