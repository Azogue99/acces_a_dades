-- Selecciona les ciutats úniques de les adreces de la taula 'Persones'
SELECT DISTINCT p.direccio.ciutat
FROM Persones p;

-- Selecciona els noms de la taula 'Persones' que comencen amb la lletra "M"
SELECT p.nom
FROM Persones p
WHERE p.nom LIKE 'M%';
