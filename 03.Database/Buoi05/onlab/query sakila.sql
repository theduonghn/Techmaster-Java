SELECT c.country , c2.city 
FROM country c
INNER JOIN city c2 
ON c.country_id = c2.country_id 

SELECT COUNT(c.city_id)
FROM city c 

SELECT c.country , COUNT(c2.city_id) 
FROM country c 
INNER JOIN city c2 
ON c.country_id = c2.country_id
GROUP BY c.country_id 

SELECT SUM(a.num_cities)
FROM(
	SELECT c.country , COUNT(c2.city_id) AS num_cities
	FROM country c 
	INNER JOIN city c2 
	ON c.country_id = c2.country_id
	GROUP BY c.country_id 
) a

SELECT c.country , c2.city 
FROM country c 
INNER JOIN city c2 
ON c.country_id = c2.country_id 

SELECT JSON_OBJECT('country', country, 'city', city)
FROM(
	SELECT c.country , c2.city 
	FROM country c 
	INNER JOIN city c2 
	ON c.country_id = c2.country_id 
) a

SELECT c.country , JSON_ARRAYAGG(JSON_OBJECT('id', c2.city_id, 'city', c2.city))
FROM country c LEFT JOIN city c2 
ON c.country_id = c2.country_id 
GROUP BY c.country_id 