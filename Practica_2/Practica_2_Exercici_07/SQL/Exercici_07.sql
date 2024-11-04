-- Crea la base de dades 'botiga_senzilla' si no existeix i la selecciona per treballar-hi
CREATE DATABASE IF NOT EXISTS botiga_senzilla;
USE botiga_senzilla;

-- Crea la taula 'usuaris' amb identificador, nom i correu electrònic
CREATE TABLE usuaris (
    id INT(11) NOT NULL AUTO_INCREMENT, -- Identificador únic de cada usuari, auto-incrementat
    nom VARCHAR(100) NOT NULL,
    correu VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Crea la taula 'comandes' amb informació sobre cada comanda realitzada
CREATE TABLE comandes (
    id INT(11) NOT NULL AUTO_INCREMENT, -- Identificador únic de la comanda, auto-incrementat
    id_usuari INT(11) NOT NULL,
    producte VARCHAR(100) NOT NULL,
    preu DECIMAL(10,2) NOT NULL,
    data TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Marca la hora actual de quan es crea la comanda
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuari) REFERENCES usuaris(id) ON DELETE CASCADE -- Elimina les comandes de un usuari quan aquest usuari es eliminat
);
