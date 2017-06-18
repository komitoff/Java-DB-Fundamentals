#1
SELECT wd.id AS count
FROM wizzard_deposits AS wd
ORDER BY wd.id DESC
LIMIT 1;

#2
SELECT MAX(wd.magic_wand_size) AS longest_magic_wand
FROM wizzard_deposits AS wd
ORDER BY longest_magic_wand
LIMIT 1;

#3
SELECT 
	wd.deposit_group AS deposit_group,
	MAX(wd.magic_wand_size) AS longest_magic_wand
FROM wizzard_deposits AS wd
GROUP BY wd.deposit_group
ORDER BY 
	longest_magic_wand,
	deposit_group;
	
#4 NOT FINISHED
SELECT 
	wd.deposit_group AS deposit_group,
FROM wizzard_deposits AS wd
GROUP BY deposit_group
ORDER BY wd.magic_wand_size
LIMIT 1;

#5 and 6
SELECT
	 wd.deposit_group, 
	 SUM(wd.deposit_amount) AS total_sum
FROM 
	wizzard_deposits AS wd
GROUP BY wd.deposit_group
ORDER BY total_sum;

#7
SELECT
	 wd.deposit_group, 
	 SUM(wd.deposit_amount) AS total_sum
FROM 
	wizzard_deposits AS wd
WHERE wd.magic_wand_creator LIKE 'Ollivander family'
GROUP BY wd.deposit_group
HAVING total_sum < 150000
ORDER BY total_sum DESC;

#8 NOT FINISHED
SELECT
	wd.deposit_group,
	wd.magic_wand_creator,
	MIN(wd.deposit_charge) as min_deposit_charge 
FROM
	wizzard_deposits AS wd
GROUP BY
	wd.magic_wand_creator
ORDER BY 
	wd.magic_wand_creator,
	wd.deposit_group;
	
#9
USE gringotts;
SELECT
	CASE
		WHEN age BETWEEN 0 AND 10 THEN '[0-10]'
		WHEN age BETWEEN 11 AND 20 THEN '[11-20]'
		WHEN age BETWEEN 21 AND 30 THEN '[21-30]'
		WHEN age BETWEEN 31 AND 40 THEN '[31-40]'
		WHEN age BETWEEN 41 AND 50 THEN '[41-50]'
		WHEN age BETWEEN 51 AND 60 THEN '[51-60]'
		WHEN age BETWEEN 61 AND 10000 THEN '[61+]'
	END AS age_group, COUNT(wd.first_name) AS wizzard_count
FROM wizzard_deposits AS wd
GROUP BY age_group
ORDER BY age_group;
	
#10
SELECT SUBSTRING(wd.first_name, 1, 1) AS first_letter
FROM wizzard_deposits AS wd
WHERE wd.deposit_group LIKE 'Troll Chest'
GROUP BY wd.first_name
ORDER BY wd.first_name;


#18 ***
use soft_uni;

SELECT em.first_name, em.last_name, em.department_id
FROM employees AS em
INNER JOIN (SELECT e.department_id AS department_id, avg(e.salary) AS avg_salary
							 FROM employees AS e
							 GROUP BY e.department_id) AS avg_salary_by_dept
ON em.department_id = avg_salary_by_dept.department_id
		 WHERE em.salary > avg_salary_by_dept.avg_salary
ORDER BY em.department_id
LIMIT 10;