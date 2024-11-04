SELECT b.llibre.titol, b.llibre.autor -- Selecciona el títol i l'autor
FROM Biblioteca b -- dels llibres de la taula 'Biblioteca'
WHERE b.llibre.ISBN LIKE '978%'; -- on l'ISBN comença per '978'
