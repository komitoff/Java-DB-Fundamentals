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

#3
SELECT e.employee_id, e.first_name, e.salary, d.name
FROM employees AS e
INNER JOIN departments AS d
ON d.department_id = e.department_id
WHERE e.salary > 15000 
ORDER BY e.department_id DESC
LIMIT 5;

#4
SELECT *
FROM employees AS e
LEFT OUTER JOIN employees_projects AS ep
ON ep.employee_id = e.employee_id;