-- Crea la taula 'Dispositius' amb un identificador i un estat binari
CREATE TABLE Dispositius (
    id NUMBER PRIMARY KEY, -- Identificador únic del dispositiu
    estat NUMBER(1) -- 0 apagat, 1 ences
);

-- Inserta exemples de dispositius amb els seus estats
INSERT INTO Dispositius (id, estat) VALUES (1, 1); -- Ences
INSERT INTO Dispositius (id, estat) VALUES (2, 0); -- Apagat
