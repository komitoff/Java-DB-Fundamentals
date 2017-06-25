#14 Contestant Submissions
SELECT
	c.id, c.name, cnt_sub.subs AS 'submissions'
FROM 
	problems AS p
INNER JOIN
	(SELECT COUNT(s.id) AS 'subs', s.problem_id, s.user_id
								FROM
									submissions AS s
								WHERE 
									s.user_id IN (SELECT DISTINCT uc.user_id FROM users_contests AS uc)
								GROUP BY
									s.problem_id) AS 'cnt_sub'
ON
	cnt_sub.problem_id=p.id;
					

	
	
	
	
	
	
	
	
	
SELECT COUNT(s.id) 'subs'
FROM
	submissions AS s
WHERE 
	s.user_id IN (SELECT DISTINCT uc.user_id FROM users_contests AS uc)
GROUP BY
	s.user_id;