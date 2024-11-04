-- Crea la taula 'LogTable' per emmagatzemar esdeveniments de registre
CREATE TABLE LogTable ( -- Com que es tracta d'una base de dades d'Oracle, no podem fer servir "IF NOT EXISTS"
    event VARCHAR2(50), -- Tipus d'esdeveniment, màxim 50 caràcters
    description VARCHAR2(255) -- Descripció de l'esdeveniment, màxim 255 caràcters
);

-- Crea o reemplaça el trigger 'LogInsert' que s'activa després d'una inserció a la taula 'Persones'
CREATE OR REPLACE TRIGGER LogInsert
AFTER INSERT ON Persones
FOR EACH ROW
BEGIN
    -- Inserta un registre a 'LogTable' quan es crea una nova persona
    INSERT INTO LogTable (event, description)
    VALUES ('INSERT', 'Nova persona afegida amb ID: ' || :NEW.id); -- Insereix una entrada a 'LogTable' amb l'esdeveniment 'INSERT' i una descripció que inclou l'ID de la nova persona
                                                                    -- :NEW s'utilitza per accedir als valors de les columnes del nou registre dins d'un trigger AFTER INSERT
END;

-- Així, quan s'executa el trigger, afegeix el text "Nova persona afegida amb ID: X", on X és l'ID de la persona.
