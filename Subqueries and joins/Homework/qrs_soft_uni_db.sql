USE soft_uni;

#1
SELECT e.employee_id, e.job_title, e.address_id, a.address_text
FROM employees AS e
INNER JOIN addresses AS a
ON a.address_id = e.address_id
ORDER BY a.address_id
LIMIT 5;

#2
SELECT e.employee_id, e.first_name, e.last_name, d.name
FROM employees AS e
INNER JOIN departments AS d
ON e.department_id = d.department_id
WHERE d.name LIKE 'Sales'
ORDER BY e.employee_id DESC;

#4
SELECT e.employee_id, e.first_name, e.salary, d.name
FROM employees AS e
INNER JOIN departments AS d
ON d.department_id = e.department_id
WHERE e.salary > 15000 
ORDER BY e.department_id DESC
LIMIT 5;

#5 NOT FINISHED
SELECT e.employee_id, e.first_name
FROM employees AS e
INNER JOIN employees_projects AS ep
ON ep.employee_id = e.employee_id
INNER JOIN projects AS p
ON ep.project_id = p.project_id
WHERE ;

#6
SELECT e.first_name, e.last_name, e.hire_date, d.name AS dept_name
FROM employees AS e
INNER JOIN departments AS d
ON d.department_id = e.department_id
WHERE DATE(e.hire_date) > '1999/1/1'
  AND d.name IN ('Finance', 'Sales')
ORDER BY e.hire_date;

#7
SELECT e.employee_id, e.first_name, p.name AS project_name 
FROM employees AS e
INNER JOIN employees_projects AS ep
ON ep.employee_id = e.employee_id
INNER JOIN projects AS p
ON ep.project_id = p.project_id
WHERE DATE(p.start_date) > '2002-08-13' 
  AND p.end_date IS NULL 
ORDER BY 
		e.first_name,
		p.name
LIMIT 5;

#8 not finished
SELECT e.employee_id, e.first_name, 
CASE
	WHEN date(p.start_date) > '2005/01/01'
		THEN null
	ELSE p.name
	A
FROM employees AS e
INNER JOIN employees_projects AS ep
ON ep.employee_id = e.employee_id
INNER JOIN projects AS p
ON ep.project_id = p.project_id

#9
UPDATE projects AS pr 
	SET pr.start_date = IF(pr.start_date > '2005-31-12', null, pr.name);
	
	
SELECT e.employee_id, e.first_name, p.name
FROM employees AS e
INNER JOIN employees_projects AS ep
ON e.employee_id = ep.employee_id 
AND e.employee_id = 24
LEFT OUTER JOIN projects AS p
ON ep.project_id = p.project_id 
AND YEAR(p.start_date) < 2005
ORDER BY p.name;
  
  
#9
SELECT e.employee_id, e.first_name, 
FROM employees AS e
INNER JOIN employees AS m
ON m.employee_id = e.manager_id;




