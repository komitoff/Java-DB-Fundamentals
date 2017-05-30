#1
SELECT `department_id`, `name`, `manager_id` FROM `departments`; 

#2
SELECT `d`.`name` as 'name' FROM `departments` as d;

#3
SELECT `e`.`first_name`, `e`.`last_name`, `e`.`salary` FROM `employees` AS `e`;

#4
SELECT `e`.`first_name`, `e`.`middle_name`, `e`.`last_name` FROM `employees` AS `e`;

#5
SELECT CONCAT(`e`.`first_name`, '.', `e`.`last_name`, '@softuni.bg') as 'full_email_address' FROM `employees` AS `e`;

#6
SELECT DISTINCT `e`.`salary` AS 'Salary' FROM `employees` AS `e` ORDER BY `e`.`salary` ASC;

#7
SELECT * FROM `employees` AS `e`
WHERE `e`.`job_title` = 'Sales Representative';

#8
SELECT `e`.`first_name`, `e`.`last_name`, `e`.`job_title` AS 'Job Title' FROM `employees` AS `e`
WHERE `e`.`salary` BETWEEN 20000 AND 30000;

#9
SELECT CONCAT_WS(' ', `e`.`first_name`, `e`.`middle_name`, `e`.`last_name`) AS 'Full Name' 
FROM `employees` AS `e`
WHERE `e`.`salary` IN (25000, 14000, 12500, 23600);

#10
SELECT `e`.`first_name`, `e`.`last_name` FROM `employees` AS `e` 
WHERE `e`.`manager_id` IS NULL;

#11
SELECT `e`.`first_name`, `e`.`last_name`, `e`.`salary` FROM `employees` AS `e` 
WHERE `e`.`salary` > 50000 ORDER BY `e`.`salary` DESC;

#12
SELECT `e`.`first_name`, `e`.`last_name` FROM `employees` AS `e` 
ORDER BY `e`.`salary` DESC
LIMIT 5;

#13
SELECT `e`.`first_name`, `e`.`last_name` FROM `employees` AS `e`
WHERE `e`.`department_id` NOT LIKE 4;

#14
SELECT * FROM `employees` AS `e`
ORDER BY `e`.`salary` DESC,
	`e`.`first_name`,
	`e`.`last_name` DESC,
	`e`.`middle_name`;
	
#15 NOT FINISHED
CREATE VIEW `v_employees_salaries` 
	SELECT `e`.`first_name`, `e`.`last_name`, `e`.`salary` FROM `employees` AS `e` ; 
