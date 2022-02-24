SELECT b.title, p.name
FROM book b INNER JOIN publisher p
ON b.id_publisher = p.id;

SELECT b.title, p.name
FROM book b LEFT JOIN publisher p 
ON b.id_publisher = p.id;

SELECT b.title, p.name
FROM book b RIGHT JOIN publisher p
ON b.id_publisher = p.id;

SELECT b.title, p.name
FROM book b RIGHT JOIN publisher p 
ON b.id_publisher = p.id;

SELECT b.title, p.name
FROM book b LEFT JOIN publisher p 
ON b.id_publisher = p.id
UNION
SELECT b.title, p.name
FROM book b RIGHT JOIN publisher p
ON b.id_publisher = p.id;

SELECT b.title, a.full_name 
FROM book b
INNER JOIN book_author ba
ON b.id = ba.id_book
INNER JOIN author a 
ON ba.id_author = a.id

SELECT b.title AS 'book title' , c.name AS 'category'
FROM book b 
INNER JOIN book_category bc 
ON b.id = bc.id_book 
INNER JOIN category c 
ON c.id = bc.id_category ;

SELECT b.title AS 'book title' , c.name AS 'category'
FROM book b 
INNER JOIN book_category bc 
ON b.id = bc.id_book 
INNER JOIN category c 
ON c.id = bc.id_category
WHERE c.name = 'Drama';

SELECT b.title, a.full_name 
FROM book b
RIGHT JOIN book_author ba
ON b.id = ba.id_book
RIGHT JOIN author a 
ON ba.id_author = a.id

SELECT b.title, a.full_name 
FROM book b
RIGHT JOIN book_author ba
ON b.id = ba.id_book
RIGHT JOIN author a 
ON ba.id_author = a.id
WHERE a.full_name = 'Mort Mewitt';

SELECT id 
FROM category c 
WHERE name = 'Drama'

SELECT b.title 
FROM book b 
INNER JOIN book_category bc ON b.id = bc.id_book 
WHERE bc.id_category = (
	SELECT id 
	FROM category c 
	WHERE name = 'Drama'
)

SELECT id
FROM publisher p 
WHERE p.name = 'Wyman LLC'

SELECT b.title
FROM book b
WHERE b.id_publisher = (
	SELECT p.id
	FROM publisher p 
	WHERE p.name = 'Wyman LLC'
)

SELECT p.name 
FROM publisher p 

SELECT p.name, b.title  
FROM publisher p 
INNER JOIN book b ON p.id = b.id_publisher ;

SELECT p.name , COUNT(b.id) 
FROM publisher p 
INNER JOIN book b ON p.id = b.id_publisher 
GROUP BY p.id 

SELECT r.full_name , bbi.id_book , b.title , bbi.amount , bbi.amount_return , bb.return_date 
FROM reader r 
INNER JOIN borrow_back bb ON r.id = bb.id_reader 
INNER JOIN borrow_back_item bbi ON bb.id = bbi.id_borrow 
INNER JOIN book b ON b.id = bbi.id_book 
WHERE bb.status = 'incomplete'
AND bbi.status = 'incomplete'
AND bb.return_date < CURDATE() 