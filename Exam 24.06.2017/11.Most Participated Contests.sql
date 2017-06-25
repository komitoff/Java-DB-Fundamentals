#11 Most Participated Contests
SELECT 
	c.id, c.name, counter.top5 AS 'contestants'
FROM 
	contests AS c
INNER JOIN
	(SELECT COUNT(uc.contest_id) AS 'top5', c.id
			FROM contests AS c
			LEFT OUTER JOIN
				users_contests AS uc
			ON
				c.id = uc.contest_id
			GROUP BY
				c.id
			ORDER BY 
				top5 DESC
			LIMIT 5) AS counter
ON
	c.id=counter.id
ORDER BY
	contestants,
	c.id;

	
	
SELECT COUNT(c.id) AS 'top5'
FROM contests AS c
INNER JOIN
	users_contests AS uc
ON
	c.id = uc.contest_id
INNER JOIN 
	users AS u
ON
	uc.user_id=u.id
GROUP BY
	c.id
ORDER BY 
	top5 DESC
LIMIT 5