#9 LEAF CATEGORIES
SELECT cat.id, cat.name
FROM 
	categories AS cat
WHERE
	cat.id NOT IN (SELECT 
			cat.parent_id
		FROM 
			categories AS cat
		WHERE 
			cat.parent_id IS NOT NULL)
ORDER BY
	cat.name,
	cat.id; 

SELECT * FROM categories AS c
where c.parent_id = 3;