#21
SELECT `p`.`peak_name` 
	FROM `peaks` AS `p`
	ORDER BY `p`.`peak_name`;
	
#22
SELECT `c`.`country_name`, `c`.`population` 
	FROM `countries` AS `c`
	WHERE `c`.`continent_code` LIKE 'EU'
	ORDER BY 
		`c`.`population` DESC,
		`c`.`country_name`
	LIMIT 30;
	
#23
SELECT `c`.`country_name`, `c`.`country_code`, `c`.`currency`
	FROM `countries` AS `c`
	REPLACE(`c`.`currency`, 'NOT '
	