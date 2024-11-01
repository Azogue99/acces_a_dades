CREATE OR REPLACE TYPE Persona AS OBJECT (
    nom VARCHAR2(50),
    cognom VARCHAR2(50)
);

CREATE OR REPLACE TYPE Professor UNDER Persona (
    departament VARCHAR2(50)
);