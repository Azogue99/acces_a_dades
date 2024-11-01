CREATE OR REPLACE TYPE Vehicle AS OBJECT (
    marca VARCHAR2(50),
    model VARCHAR2(50)
);

CREATE OR REPLACE TYPE Cotxe UNDER Vehicle (
    nombre_de_portes NUMBER
);