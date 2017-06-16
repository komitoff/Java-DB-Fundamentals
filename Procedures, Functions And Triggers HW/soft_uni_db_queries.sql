#1
DELIMITER $$ 
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN 
	SELECT e.first_name, e.last_name
	FROM employees AS e
	WHERE e.salary > 35000
	ORDER BY
		e.first_name,
		e.last_name;
END $$

DELIMITER ;

CALL usp_get_employees_salary_above_35000();


#2 Strange Result
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(number DECIMAL)
BEGIN
	SELECT e.first_name, e.last_name
	FROM employees AS e
	WHERE e.salary > number
		OR e.salary = number
	ORDER BY 
		e.first_name,
		e.last_name;
END $$

DELIMITER ;

CALL usp_get_employees_salary_above(2000.);

#3
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(str VARCHAR(255))
BEGIN
	SELECT t.name AS town_name
	FROM towns AS t
	WHERE t.name LIKE CONCAT(str, '%')
	ORDER BY t.name;
END $$
DELIMITER ;

CALL usp_get_towns_starting_with('b');

#4
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(255))
BEGIN
	SELECT e.first_name , e.last_name
	FROM employees AS e
	INNER JOIN addresses AS a
	ON a.address_id = e.address_id
	INNER JOIN towns AS t
	ON a.town_id = t.town_id
	WHERE t.name LIKE town_name
	ORDER BY e.first_name;
END $$
DELIMITER ;

CALL usp_get_employees_from_town('Sofia');

	SELECT e.first_name , e.last_name
	FROM employees AS e
	INNER JOIN addresses AS a
	ON a.address_id = e.address_id
	INNER JOIN towns AS t
	ON a.town_id = t.town_id
	WHERE t.name LIKE 'Sofia'
	ORDER BY e.first_name;

#5
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(10)
BEGIN
	DECLARE salary_level VARCHAR(10);
	IF(salary < 30000.0) THEN
		SET salary_level := 'Low';
	ELSEIF(salary >= 30000 AND salary <= 50000) THEN
		SET salary_level := 'Average';
	ELSE
		SET salary_level := 'High';
	END IF;
	RETURN salary_level;
END; $$
DELIMITER ;

SELECT e.employee_id, e.first_name, ufn_get_salary_level(e.salary)
FROM employees AS e;

#6
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
	IF (salary_level LIKE 'Low') THEN
		SELECT e.first_name, e.last_name
		FROM employees AS e
		WHERE e.salary < 30000
		ORDER BY 
				e.first_name DESC,
				e.last_name DESC;
	ELSEIF (salary_level LIKE 'Average') THEN
		SELECT e.first_name, e.last_name
		FROM employees AS e
		WHERE e.salary >= 30000 
		  AND e.salary <= 50000
		ORDER BY 
				e.first_name DESC,
				e.last_name DESC;
	ELSEIF(salary_level like 'High') THEN
		SELECT e.first_name, e.last_name
		FROM employees AS e
		WHERE e.salary > 50000
		ORDER BY 
				e.first_name DESC,
				e.last_name DESC;
	END IF;
END $$

DELIMITER ;

CALL usp_get_employees_by_salary_level ('high');


SELECT 'Sofia' LIKE '';