SELECT q.question 
FROM question q 

SELECT q.id , q.question , a.answer , a.`check` 
FROM question q INNER JOIN answer a ON q.id = a.id_question 

SELECT q.id , q.question , a.answer , a.`check` 
FROM question q INNER JOIN answer a ON q.id = a.id_question 
WHERE a.`check` = 1

SELECT q.question , q.id
FROM question q 
ORDER BY RAND()
LIMIT 1

INSERT INTO answer (id_question, answer , `check`)
VALUES (1, 'test' , TRUE)

INSERT INTO answer (id_question, answer , `check`)
VALUES (1, 'test2' , FALSE)

SELECT q.id, JSON_ARRAYAGG(JSON_OBJECT('answer', a.answer))
FROM question q INNER JOIN answer a ON q.id = a.id_question 
GROUP BY q.id 

SELECT JSON_OBJECT('question id' , q.id, 'answers' , JSON_ARRAYAGG(a.answer))
FROM question q INNER JOIN answer a ON q.id = a.id_question 
GROUP BY q.id 

-- SELECT JSON_ARRAYAGG(JSON_OBJECT('question id' , q.id, 'answers' , JSON_ARRAYAGG(a.answer)))
-- FROM question q INNER JOIN answer a ON q.id = a.id_question 
-- GROUP BY q.id 

SELECT JSON_ARRAYAGG(JSON_OBJECT('answer', a.answer))
FROM question q INNER JOIN answer a ON q.id = a.id_question 

-- SELECT JSON_OBJECT('question id' , q.id, 'answers' , JSON_ARRAYAGG(a.answer))
-- FROM question q INNER JOIN answer a ON q.id = a.id_question

SELECT JSON_ARRAYAGG(JSON_OBJECT('question id' , q.id, 'answers' , a.answer))
FROM question q INNER JOIN answer a ON q.id = a.id_question 