#5 Age Range
SELECT
	u.nickname, u.gender, u.age 
FROM 
	users AS u
WHERE 
	u.age BETWEEN 22 AND 37;
	
#Messages
SELECT
	m.content, m.sent_on
FROM 
	messages AS m
WHERE 
	m.sent_on > '2014-05-12'
	AND
	m.content LIKE '%just%'
ORDER BY	m.id DESC;