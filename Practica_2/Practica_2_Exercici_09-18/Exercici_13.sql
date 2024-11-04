-- Crea o, si ja existeix, reemplaça el tipus d'objecte 'Vehicle' amb atributs per emmagatzemar informació bàsica d'un vehicle
CREATE OR REPLACE TYPE Vehicle AS OBJECT (
    marca VARCHAR2(50), -- Marca del vehicle, màxim 50 caràcters
    model VARCHAR2(50) -- Model del vehicle, màxim 50 caràcters
);

-- Crea o si ja existeix reemplaça el tipus d'objecte 'Cotxe' que hereta de 'Vehicle' i afegeix un atribut addicional
CREATE OR REPLACE TYPE Cotxe UNDER Vehicle (
    nombre_de_portes NUMBER -- Nombre de portes del cotxe
);
