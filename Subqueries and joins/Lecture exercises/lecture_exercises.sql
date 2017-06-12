#Select from 2 tables
SELECT 
	d.name, e.employee_id, e.first_name
FROM 
	departments AS d, employees AS e
WHERE 
	d.department_id=e.department_id
ORDER BY 
	e.employee_id DESC;
	
#Example 2 - from homework
SELECT 
	e.first_name, e.last_name, t.name AS 'town', a.address_text
FROM 
	addresses AS a
INNER JOIN 
	employees AS e
ON 
	a.address_id=e.address_id
INNER JOIN 
	towns AS t
ON 
	a.town_id=t.town_id
ORDER BY 
	e.first_name,
	e.last_name
LIMIT 5;