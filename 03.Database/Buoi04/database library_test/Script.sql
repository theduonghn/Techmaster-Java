-- SELECT title, year_of_publication
-- FROM book
-- WHERE year_of_publication >= 1900
-- ORDER BY year_of_publication;
-- 
-- SELECT COUNT(id) AS count_book
-- FROM book b
-- WHERE b.page_number BETWEEN 50 AND 100;
-- 
-- SELECT AVG(page_number) as avg
-- FROM book b
-- WHERE b.page_number BETWEEN 50 and 100;
-- 
-- SELECT b.title, b.id_publisher, b.page_number, (b.page_number*b.id_publisher) AS thanh_tien
-- FROM book b;

-- SELECT JSON_OBJECT('t�n s�ch', title, 'm� t?', description, 'n?m xu?t b?n', year_of_publication)
-- FROM book b;

SELECT JSON_ARRAYAGG(JSON_OBJECT('t�n s�ch', title, 'm� t?', description, 'n?m xu?t b?n', year_of_publication))
-- COUNT(title) AS S?_quy?n
FROM book b
WHERE year_of_publication >= 2000;

SELECT count(id) FROM book WHERE year_of_publication >= 2000;

SELECT JSON_ARRAYAGG(JSON_OBJECT('t�n s�ch', title, 'm� t?', description, 'n?m xu?t b?n', year_of_publication)) AS Th�ng_tin_s�ch,
COUNT(id) AS 'S? quy?n'
FROM book b
WHERE year_of_publication >= 2000;
