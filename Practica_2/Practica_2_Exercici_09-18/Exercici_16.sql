-- Ciutats úniques
SELECT DISTINCT p.direccio.ciutat
FROM Persones p;

-- Noms que comencen amb "M"
SELECT p.nom
FROM Persones p
WHERE p.nom LIKE 'M%';