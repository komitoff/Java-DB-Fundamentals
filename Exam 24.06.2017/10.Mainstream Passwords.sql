#10 mainstream passwords
SELECT 
	u.id, u.username, u.password
FROM
	users AS u
INNER JOIN
	users AS u2
ON
	u.password = u2.password
AND
	u.username <> u2.username
GROUP BY
	u.id
ORDER BY
	u.username,
	u.id;