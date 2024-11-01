SELECT b.llibre.titol, b.llibre.autor
FROM Biblioteca b
WHERE b.llibre.ISBN LIKE '978%';