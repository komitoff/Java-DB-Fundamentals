#12
SELECT name,
DATE_FORMAT(start, '%Y-%m-%d') as start 
FROM games
WHERE YEAR(start)=2011 OR YEAR(start)=2012
ORDER BY start
LIMIT 50;

#13

#14
USE diablo;
SELECT u.user_name, u.ip_address
FROM users AS u
WHERE u.ip_address REGEXP ('(^[0-9]{3}\\.1[0-9].*\\.[0-9].*\\.[0-9]{3}$)')
ORDER BY u.user_name;