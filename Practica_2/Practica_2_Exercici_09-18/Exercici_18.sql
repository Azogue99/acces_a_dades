-- Crea o, si ja existeix, reemplaça el tipus d'objecte 'Persona' amb atributs per emmagatzemar informació d'una persona
CREATE OR REPLACE TYPE Persona AS OBJECT (
    nom VARCHAR2(50), -- Nom de la persona, màxim 50 caràcters
    cognom VARCHAR2(50) -- Cognom de la persona, màxim 50 caràcters
);

-- Crea o, si ja existeix, reemplaça el tipus d'objecte 'Professor' que hereta de 'Persona' i afegeix un atribut addicional
CREATE OR REPLACE TYPE Professor UNDER Persona (
    departament VARCHAR2(50) -- Departament del professor, màxim 50 caràcters
);
