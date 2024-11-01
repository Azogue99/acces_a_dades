CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

CREATE TABLE autors (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    nacionalitat VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE llibres (
    id INT(11) NOT NULL AUTO_INCREMENT,
    titol VARCHAR(200) NOT NULL,
    any_publicacio INT(4),
    id_autor INT(11),
    PRIMARY KEY (id),
    FOREIGN KEY (id_autor) REFERENCES autors(id) ON DELETE SET NULL
);

CREATE TABLE prestecs (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_llibre INT(11) NOT NULL,
    usuari VARCHAR(100) NOT NULL,
    data_prestec DATE NOT NULL,
    data_devolucio DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_llibre) REFERENCES llibres(id) ON DELETE CASCADE
);
