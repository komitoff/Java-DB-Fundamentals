SELECT 
	*
FROM 
	users AS u
LEFT OUTER JOIN
	users_contests AS uc
ON
	u.id=uc.user_id
LEFT OUTER JOIN
	contests AS c
ON
	c.id=uc.contest_id
WHERE 
	uc.contest_id IS NULL;
	
DELETE FROM u
	USING users AS u
LEFT OUTER JOIN
	users_contests AS uc
ON
	u.id=uc.user_id
LEFT OUTER JOIN
	contests AS c
ON
	c.id=uc.contest_id
WHERE 
	uc.contest_id IS NULL;		
	
SELECT * FROM users_contests AS uc
INNER JOIN
	users AS u
ON
	uc.user_id = u.id