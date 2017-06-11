#12
SELECT name,
DATE_FORMAT(start, '%Y-%m-%d') as start 
FROM games
WHERE YEAR(start)=2011 OR YEAR(start)=2012
ORDER BY start
LIMIT 50;

#13
SELECT u.user_name, SUBSTRING(u.email, POSITION('@' IN u.email) + 1, CHAR_LENGTH(u.email)) AS 'Email Provider'
FROM users AS u
ORDER BY 
	`Email Provider`,
	u.user_name;

#14
USE diablo;
SELECT u.user_name, u.ip_address
FROM users AS u
WHERE u.ip_address like ('___.1%.%.___')
ORDER BY u.user_name;

#15
