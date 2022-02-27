SELECT a.name , COUNT(p.id)
FROM author a LEFT JOIN post p ON a.id = p.id_author 
GROUP BY a.id 

SELECT d.comment , a.name AS dicusser
FROM discuss d INNER JOIN author a ON d.id_author = a.id

SELECT a.id AS id , a.name , COUNT(p.id) AS num_post
FROM author a INNER JOIN post p ON a.id = p.id_author 
GROUP BY a.id 



-- SELECT p.title , 
-- p.create_at , 
-- JSON_ARRAYAGG(t.name) AS 'tags', 
-- p.content , 
-- a.id AS 'author id' ,
-- a.name AS 'author name', 
-- JSON_ARRAYAGG(count_post.num_post), 
-- JSON_ARRAYAGG(JSON_OBJECT('comment' , da.comment , 'discusser' , da.dicusser , 'comment_create_at' , da.comment_create_at))
-- FROM post p INNER JOIN post_tag pt ON p.id = pt.id_post 
-- INNER JOIN tag t ON t.id = pt.id_tag 
-- INNER JOIN author a ON a.id = p.id_author 
-- INNER JOIN(
-- 	SELECT a.id AS id , a.name , COUNT(p.id) AS num_post
-- 	FROM author a LEFT JOIN post p ON a.id = p.id_author 
-- 	GROUP BY id
-- ) count_post ON p.id_author = count_post.id 
-- GROUP BY p.id 
-- UNION 
-- SELECT d.id_post as id_post, d.comment AS comment , a.name AS dicusser , d.create_at AS comment_create_at 
-- FROM discuss d INNER JOIN author a ON d.id_author = a.id 
-- GROUP BY p.id

SELECT p.title , 
p.create_at , 
JSON_ARRAYAGG( t.name) AS 'tags', 
p.content , 
a.id AS 'author id' ,
a.name AS 'author name', 
JSON_ARRAYAGG(count_post.num_post), 
JSON_ARRAYAGG(JSON_OBJECT('comment' , da.comment , 'discusser' , da.dicusser , 'comment_create_at' , da.comment_create_at))
FROM post p INNER JOIN post_tag pt ON p.id = pt.id_post 
INNER JOIN tag t ON t.id = pt.id_tag 
INNER JOIN author a ON a.id = p.id_author 
INNER JOIN(
	SELECT a.id AS id , a.name , COUNT(p.id) AS num_post
	FROM author a LEFT JOIN post p ON a.id = p.id_author 
	GROUP BY id
) count_post ON p.id_author = count_post.id 
INNER JOIN (
	SELECT d.id_post as id_post, d.comment AS comment , a.name AS dicusser , d.create_at AS comment_create_at 
	FROM discuss d INNER JOIN author a ON d.id_author = a.id 
) da ON p.id = da.id_post  
GROUP BY p.id
WHERE p.id = 1