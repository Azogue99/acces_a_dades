-- Crea la base de dades si no existeix i selecciona-la
CREATE DATABASE IF NOT EXISTS botiga;
USE botiga;

-- Taula per a les categories de productes
CREATE TABLE categories (
    id INT(11) NOT NULL AUTO_INCREMENT, -- Auto Increment
    nom VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Taula per a emmagatzemar els productes
CREATE TABLE productes (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    preu DECIMAL(10,2) NOT NULL,
    id_categoria INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_categoria) REFERENCES categories(id) -- Clau forana que refereix a la taula categories
);

-- Taula per a emmagatzemar informació dels clients
CREATE TABLE clients (
    id INT(11) NOT NULL AUTO_INCREMENT,  -- Auto Increment
    nom VARCHAR(100) NOT NULL,
    correu VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Taula per a registrar les comandes
CREATE TABLE comandes (
    id INT(11) NOT NULL AUTO_INCREMENT,  -- Auto Increment
    id_client INT(11) NOT NULL,
    data TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_client) REFERENCES clients(id) -- Clau forana que refereix a la taula clients
);

-- Taula per als detalls de cada comanda
CREATE TABLE detalls_comanda (
    id_comanda INT(11) NOT NULL,
    id_producte INT(11) NOT NULL,
    quantitat INT(11) NOT NULL,
    PRIMARY KEY (id_comanda, id_producte),
    FOREIGN KEY (id_comanda) REFERENCES comandes(id), -- Clau forana que refereix a la taula comandes
    FOREIGN KEY (id_producte) REFERENCES productes(id) -- Clau forana que refereix a la taula productes
);
