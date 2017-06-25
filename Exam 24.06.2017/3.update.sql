#3 - Update task
UPDATE 
	problems AS p
INNER JOIN
	contests AS c
ON
	p.contest_id=c.id
INNER JOIN
	categories AS cat
ON
	cat.id = c.category_id
INNER JOIN
	submissions AS s
ON
	s.problem_id=p.id
SET tests = 
	CASE 
		WHEN 
			(p.id % 3 = 0) THEN 
				CHAR_LENGTH(cat.name)
		WHEN
			(p.id % 3 = 1) THEN
				(SELECT summed.sum 
				FROM
				(SELECT SUM(s.id) AS 'sum', s.problem_id AS prob_id
				FROM submissions AS s
				GROUP BY s.problem_id) AS summed
				WHERE p.id=summed.prob_id)
		WHEN
			(p.id % 3 = 2) THEN
				CHAR_LENGTH(c.name)
		END
WHERE 	
	p.tests = 0;	


SELECT SUM(s.id)
FROM submissions AS s
GROUP BY s.problem_id
WHERE p;
