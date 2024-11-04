-- Crea o si ja existeix, reemplaça el tipus VARRAY 'TelArray' per emmagatzemar fins a 5 números de telèfon
CREATE OR REPLACE TYPE TelArray AS VARRAY(5) OF VARCHAR2(15);

-- Crea la taula 'Clients' amb una columna 'telefons' que utilitza el tipus VARRAY 'TelArray'
CREATE TABLE Clients (
    id NUMBER PRIMARY KEY, -- Identificador únic del client
    nom VARCHAR2(50), -- Nom del client, màxim 50 caràcters
    telefons TelArray -- Columna que emmagatzema una llista de telèfons
);

-- Inserta el registre a la taula 'Clients' amb un array de telèfons
INSERT INTO Clients (id, nom, telefons)
VALUES (1, 'Maria', TelArray('123456789', '987654321', '456123789'));