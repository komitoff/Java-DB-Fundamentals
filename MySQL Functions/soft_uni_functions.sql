#1
SELECT 
	`e`.`first_name`, `e`.`last_name` 
FROM 
	`employees` AS `e`
WHERE 
	`e`.`first_name` LIKE 'SA%';
	
#2
SELECT 
	`e`.`first_name`, `e`.`last_name` 
FROM 
	`employees` AS `e`
WHERE 
	`e`.`last_name` LIKE '%ei%';
	
#3
SELECT 
	`e`.`first_name`
FROM 
	`employees` AS `e`
WHERE 
	`e`.`department_id` IN (3, 10)
	AND
	EXTRACT(year FROM `e`.`hire_date`) BETWEEN 1995 AND 2005;
	
#4
SELECT 
	`e`.`first_name`, `e`.`last_name` 
FROM 
	`employees` AS `e`
WHERE 
	`e`.`last_name` NOT REGEXP '[Ee]ngineer';
	
#5
SELECT `t`.`name` 
FROM `towns` AS `t`
WHERE
	CHAR_LENGTH(`t`.`name`) BETWEEN 5 and 6
	ORDER BY `t`.`name`;

#6
SELECT * FROM `towns` AS `t`
WHERE `t`.`name` REGEXP '^[^rbdRBD]'
ORDER BY `t`.`name`;

#7
CREATE VIEW v_employees_hired_after_2000 AS
	SELECT `e`.`first_name`, `e`.`last_name`
	FROM `employees` AS `e`
	WHERE EXTRACT(year FROM `e`.`hire_date`) > 2000;
	
#&
SELECT `e`.`first_name`, `e`.`last_name`
FROM `employees` AS `e`
WHERE CHAR_LENGTH(`e`.`last_name`) LIKE 5;