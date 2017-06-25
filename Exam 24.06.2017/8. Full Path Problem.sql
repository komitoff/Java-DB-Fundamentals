#8 FULL PATH
SELECT 
	p.id, CONCAT_WS(' - ', cat.name, c.name, p.name) AS 'full_path'
FROM 
	problems AS p
INNER JOIN 
	contests AS c
ON
	p.contest_id=c.id
INNER JOIN
	categories AS cat
ON
	cat.id = c.category_id
ORDER BY
	p.id;