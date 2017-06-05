#12
SELECT name,
DATE_FORMAT(start, '%Y-%m-%d') as start 
FROM games
WHERE YEAR(start)=2011 OR YEAR(start)=2012
ORDER BY start
LIMIT 50;