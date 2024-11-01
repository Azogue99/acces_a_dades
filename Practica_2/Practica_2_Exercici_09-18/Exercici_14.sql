CREATE OR REPLACE TYPE TelArray AS VARRAY(5) OF VARCHAR2(15);

CREATE TABLE Clients (
    id NUMBER PRIMARY KEY,
    nom VARCHAR2(50),
    telefons TelArray
);

INSERT INTO Clients (id, nom, telefons)
VALUES (
    1,
    'Maria',
    TelArray('123456789', '987654321', '456123789')
);