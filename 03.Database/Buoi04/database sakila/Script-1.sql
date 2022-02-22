SELECT title, length, rating
FROM film f 
WHERE length > 100
AND rating = 'PG';

SELECT title, description, rating, rental_rate 
FROM film f 
WHERE (rating = 'G' OR rating = 'PG')
-- WHERE rating IN ('G', 'PG')
AND rental_rate = 0.99;

SELECT COUNT(film_id)
FROM film f 
WHERE rating = 'G';

SELECT title, `length`, special_features, rating 
FROM film f 
WHERE special_features = 'Trailers'
AND `length` < 100
AND rating = 'G';

SELECT f.title, f.length
FROM film f 
WHERE f.`length` < 50

SELECT COUNT(film_id) 
FROM film f 
WHERE f.`length` < 50

SELECT JSON_ARRAYAGG(JSON_OBJECT('title', title, 'length', length)),
COUNT(film_id)
FROM film f 
WHERE `length` < 50;

SELECT title, rating 
FROM film f 
WHERE rating != 'PG';

SELECT title, rating 
FROM film f 
WHERE rating NOT IN ('PG');

SELECT title, rating 
FROM film f 
WHERE rating NOT LIKE ('PG');

SELECT title, rating 
FROM film f 
WHERE rating NOT LIKE 'PG';

SELECT MAX(`length`) as '?? dài phim l?n nh?t' 
FROM film f;

SELECT MIN(`length`) as '?? dài phim nh? nh?t' 
FROM film f;

SELECT MIN(a.num_film)
FROM(
	SELECT rating, count(film_id) as num_film
	FROM film
	GROUP BY rating
-- 	ORDER BY count(film_id)
) a

SELECT rating, count(film_id) as num_film
FROM film
GROUP BY rating
