CREATE TABLE LogTable (
    event VARCHAR2(50),
    description VARCHAR2(255)
);

CREATE OR REPLACE TRIGGER LogInsert
AFTER INSERT ON Persones
FOR EACH ROW
BEGIN
    INSERT INTO LogTable (event, description)
    VALUES ('INSERT', 'Nova persona afegida amb ID: ' || :NEW.id);
END;