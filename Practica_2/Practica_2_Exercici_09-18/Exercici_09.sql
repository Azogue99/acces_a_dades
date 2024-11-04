-- Crea o reemplaça el tipus d'objecte 'Llibre' amb atributs per emmagatzemar informació d'un llibre
CREATE OR REPLACE TYPE Llibre AS OBJECT (
    titol VARCHAR2(100), -- Títol del llibre, màxim 100 caràcters
    autor VARCHAR2(100), -- Autor del llibre, màxim 100 caràcters
    ISBN VARCHAR2(20) -- ISBN del llibre, màxim 20 caràcters
);
