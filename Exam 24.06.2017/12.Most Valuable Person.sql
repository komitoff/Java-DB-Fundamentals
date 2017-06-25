#12
SELECT s.id, u.username, p.name, CONCAT_WS(' / ', s.passed_tests, p.tests) AS 'result'
FROM 
	submissions AS s
INNER JOIN
	problems AS p
ON
	s.problem_id = p.id
INNER JOIN
	users AS u
ON
	s.user_id=u.id
WHERE
	s.user_id = 29
ORDER BY
	s.id DESC;
	
SELECT COUNT(*) AS 'cnt', uc.user_id
FROM users_contests AS uc
GROUP BY uc.contest_id
ORDER BY cnt DESC