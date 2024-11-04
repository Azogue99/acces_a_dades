-- Crea la base de dades 'biblioteca' si no existeix i la selecciona
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- Crea la taula 'autors' amb informació sobre els autors dels llibres
CREATE TABLE autors (
    id INT(11) NOT NULL AUTO_INCREMENT, -- Identificador únic de l'autor, auto-incrementat
    nom VARCHAR(100) NOT NULL,
    nacionalitat VARCHAR(100),
    PRIMARY KEY (id)
);

-- Crea la taula 'llibres' amb informació sobre els llibres
CREATE TABLE llibres (
    id INT(11) NOT NULL AUTO_INCREMENT, -- Identificador únic del llibre, auto-incrementat
    titol VARCHAR(200) NOT NULL,
    any_publicacio INT(4),
    id_autor INT(11),
    PRIMARY KEY (id),
    FOREIGN KEY (id_autor) REFERENCES autors(id) ON DELETE SET NULL -- Clau foraena que estableix a NULL si l'autor s'elimina
);

-- Crea la taula 'prestecs' per gestionar els préstecs de llibres
CREATE TABLE prestecs (
    id INT(11) NOT NULL AUTO_INCREMENT, -- Identificador únic del préstec, auto-incrementat
    id_llibre INT(11) NOT NULL,
    usuari VARCHAR(100) NOT NULL,
    data_prestec DATE NOT NULL,
    data_devolucio DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_llibre) REFERENCES llibres(id) ON DELETE CASCADE -- Clau foraena que elimina els préstecs si un llibre s'elimina
);
