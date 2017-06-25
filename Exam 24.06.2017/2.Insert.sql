#2 - Data Insertion
INSERT INTO 
	submissions(passed_tests, problem_id, user_id)
SELECT 
	CEIL(SQRT(POW(CHAR_LENGTH(p.name), 3)) - CHAR_LENGTH(p.name)) AS 'passed_tests',
	p.id,
	CEIL((p.id * 3) / 2) AS 'user_id'
FROM
	 problems AS p
	WHERE 
	p.id BETWEEN 1 AND 10

SELECT 
	CEIL(SQRT(POW(CHAR_LENGTH(p.name), 3)) - CHAR_LENGTH(p.name)) AS 'passed_tests',
	p.id,
	CEIL((p.id * 3) / 2) AS 'user_id'
FROM
	 problems AS p
WHERE 
	p.id BETWEEN 1 AND 10