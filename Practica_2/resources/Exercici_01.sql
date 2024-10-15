CREATE TABLE categories (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE productes (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    preu DECIMAL(10,2) NOT NULL,
    id_categoria INT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_categoria) REFERENCES categories(id)
);

CREATE TABLE clients (
    id INT(11) NOT NULL AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    correu VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE comandes (
    id INT(11) NOT NULL AUTO_INCREMENT,
    id_client INT(11) NOT NULL,
    data TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_client) REFERENCES clients(id)
);

CREATE TABLE detalls_comanda (
    id_comanda INT(11) NOT NULL,
    id_producte INT(11) NOT NULL,
    quantitat INT(11) NOT NULL,
    PRIMARY KEY (id_comanda, id_producte),
    FOREIGN KEY (id_comanda) REFERENCES comandes(id),
    FOREIGN KEY (id_producte) REFERENCES productes(id)
);
