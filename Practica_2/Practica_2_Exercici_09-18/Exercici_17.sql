CREATE TABLE Dispositius (
    id NUMBER PRIMARY KEY,
    estat NUMBER(1) -- 0 per apagat, 1 per ences
);

-- Inserir exemples
INSERT INTO Dispositius (id, estat) VALUES (1, 1); -- Ences
INSERT INTO Dispositius (id, estat) VALUES (2, 0); -- Apagat
