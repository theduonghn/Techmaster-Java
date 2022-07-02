SELECT b.id, b.title, b.slug, b.description , b.thumbnail,
DATE_FORMAT(b.published_at, '%d/%m/%y') as published_at,  
JSON_OBJECT('id', u.id, "name", u.name) as author,
COUNT(c.id) as count_comment
FROM blog b
LEFT JOIN `user` u 
ON b.user_id = u.id
LEFT JOIN comment c 
ON b.id = c.blog_id 
WHERE b.status = 1
GROUP BY b.id 
ORDER BY b.published_at DESC 
LIMIT 5
OFFSET 0

SELECT b.id ,b.title ,b.slug ,DATE_FORMAT(b.published_at, '%d/%m/%y') as published_at ,
count(c.id) as count_comment
FROM blog b 
LEFT JOIN comment c 
ON b.id = c.blog_id 
WHERE b.status = 1
GROUP BY b.id 
ORDER BY count_comment DESC 
LIMIT 3

SELECT b.id, b.title, b.slug  , b.thumbnail,
DATE_FORMAT(b.published_at, '%d/%m/%y') as published_at,  
JSON_OBJECT('id', u.id, "name", u.name) as author,
COUNT(c.id) as count_comment
FROM blog b
LEFT JOIN `user` u 
ON b.user_id = u.id
LEFT JOIN comment c 
ON b.id = c.blog_id 
LEFT JOIN blog_categories bc 
ON b.id = bc.blog_id 
WHERE b.status = 1 AND bc.categories_id = 12
GROUP BY b.id 
ORDER BY b.published_at DESC 

SELECT JSON_OBJECT('id', u.id, "name", u.name)
FROM `user` u 
INNER JOIN blog b 
ON u.id = b.user_id 
WHERE b.id = '0L6'
-- WHERE b.id = 3

SELECT b.id, b.title, b.slug  , b.thumbnail,
DATE_FORMAT(b.published_at, '%d/%m/%y') as published_at,  
JSON_OBJECT('id', u.id, "name", u.name) as author,
COUNT(c.id) as count_comment
FROM blog b
LEFT JOIN `user` u 
ON b.user_id = u.id
LEFT JOIN comment c 
ON b.id = c.blog_id 
WHERE u.id = 70
GROUP BY b.id 

SELECT c.id, u.name, u.avatar, c.created_at , c.content 
FROM comment c 
LEFT JOIN blog b 
ON c.blog_id = b.id 
LEFT JOIN `user` u 
ON c.user_id = u.id
WHERE b.id = '0L6'
ORDER BY created_at DESC

SELECT b.id, b.title, b.slug ,b.description ,b.content  , b.thumbnail,
DATE_FORMAT(b.published_at, '%d/%m/%y') as published_at,  
JSON_OBJECT('id', u.id, "name", u.name) as author,
COUNT(c.id) as count_comment
FROM blog b
LEFT JOIN `user` u 
ON b.user_id = u.id
LEFT JOIN comment c 
ON b.id = c.blog_id 
WHERE b.id = '0L6'
GROUP BY b.id 

SELECT b.id, b.title, b.slug ,b.description ,b.content  , b.thumbnail,
DATE_FORMAT(b.published_at, '%d/%m/%y') as published_at,  
JSON_OBJECT('id', u.id, "name", u.name) as author,
(
	SELECT 
	JSON_ARRAYAGG(
		JSON_OBJECT('id', c.id, 'name', u2.name, 'avatar', u2.avatar, 'created_at', c.created_at, 'content', c.content)
	)
	FROM comment c
	LEFT JOIN blog b 
	ON c.blog_id = b.id 
	LEFT JOIN `user` u2 
	ON c.user_id = u2.id
)
FROM blog b
LEFT JOIN `user` u 
ON b.user_id = u.id
WHERE b.id = '0L6'
GROUP BY b.id 