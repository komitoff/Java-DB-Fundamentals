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
	LOWER(`e`.`last_name`) NOT LIKE '%engineer%';
	
