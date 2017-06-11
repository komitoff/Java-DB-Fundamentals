#10 NOT FINISHED
SELECT c.country_name, c.iso_code
FROM countries AS c
WHERE c.country_name NOT REGEXP('[Aa]{0,3}')
ORDER BY c.iso_code;

#11
USE geography;
SELECT p.peak_name, r.river_name, LOWER(CONCAT(p.peak_name, SUBSTRING(r.river_name, 2, CHAR_LENGTH(r.river_name)))) AS mix
FROM peaks AS p, rivers AS r
WHERE right(p.peak_name, 1) = LEFT(r.river_name, 1)
ORDER BY mix;
