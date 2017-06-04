#10
SELECT `c`.`country_name`, `c`.`iso_code`
FROM `countries` AS `c`
WHERE `c`.`country_name` REGEXP '(\\w*([Aa])\\w*\\w*([Aa])\\w*\\w*([Aa])\\w*)'
ORDER BY `c`.`iso_code`;