CREATE DATABASE IF NOT EXISTS botiga_senzilla;

USE botiga_senzilla;

-- Creació de la taula usuaris
CREATE TABLE usuaris (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    correu VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Creació de la taula comandes
CREATE TABLE comandes (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_usuari INT(11) NOT NULL,
    producte VARCHAR(100) NOT NULL,
    preu DECIMAL(10,2) NOT NULL,
    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuari) REFERENCES usuaris(id) ON DELETE CASCADE
);
