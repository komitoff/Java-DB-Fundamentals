#4 queries
#05 Age Range
SELECT u.nickname, u.gender, u.age
FROM users AS u
WHERE u.age BETWEEN 22 AND 37
ORDER BY u.id;

#6 Messages
SELECT m.content, m.sent_on
FROM messages AS m
WHERE 
	date(m.sent_on) > '2014-05-12'
	AND
	m.content LIKE '%just%'
ORDER BY 
	m.id DESC;
	
#7 All Chats
SELECT c.title, c.is_active
FROM chats AS c
WHERE 
	c.is_active = 0
	AND
	CHAR_LENGTH(c.title) < 5
	OR
	c.title LIKE '__tl%'
ORDER BY 
	c.title DESC;
	
#8
SELECT c.id, c.title, m.id
FROM chats AS c
INNER JOIN messages AS m
ON c.id = m.chat_id
WHERE 
	date(m.sent_on) < '2012-03-26'
	AND
	RIGHT(c.title, 1) LIKE 'x'
ORDER BY
	c.id,
	m.id;
	
#9
SELECT c.id, COUNT(m.chat_id) AS 'total_messages' 
FROM chats AS c
INNER JOIN messages AS m
ON c.id = m.chat_id
AND m.id < 90
WHERE c.id = m.chat_id
GROUP BY c.id
ORDER BY total_messages DESC, c.id 
LIMIT 5;

#10
SELECT u.nickname, c.email, c.password
FROM credentials AS c
INNER JOIN users AS u
ON c.id = u.credential_id
WHERE RIGHT(c.email, 5) LIKE 'co.uk'
ORDER BY 
	c.email;
	
#11 Locations
SELECT u.id, u.nickname, u.age
FROM users AS u
LEFT OUTER JOIN locations AS l
ON l.id = u.location_id
WHERE 
	l.latitude IS NULL
	OR
	l.longitude IS NULL
ORDER BY u.id;

#12 -------------------
SELECT m.id AS 'message_id', c.id AS 'chat_id', u.id AS 'user_id'
FROM 
	users AS u
INNER JOIN 	
	users_chats AS uc
ON 
	uc.user_id=u.id
INNER JOIN 
	chats AS c
ON
	c.id=uc.chat_id
AND
	c.id = 17
INNER JOIN
	messages AS m
ON
	m.chat_id=c.id;
SELECT 
	m.id,m.chat_id,m.user_id 
FROM 
	messages as m
INNER JOIN 
	users as u 
ON 
	u.id=m.user_id
INNER JOIN
	chats as c 
ON 
	c.id=m.chat_id 
WHERE 
	c.id=17 
AND NOT
	u.id in
		(select users_chats.user_id 
			from users_chats 
			where users_chats.chat_id=17 
			AND users_chats.user_id=u.id)
ORDER BY
	m.id DESC;











#13 USERS IN BULGARIA
SELECT u.nickname, c.title, l.latitude, l.longitude
FROM users AS u
INNER JOIN users_chats AS uc
ON u.id = uc.user_id
INNER JOIN chats AS c
ON uc.chat_id=c.id
INNER JOIN locations AS l
ON u.location_id = l.id
WHERE
	l.latitude BETWEEN 41.139999 AND 44.129999
	AND
	l.longitude BETWEEN 22.209999 AND 28.359999
ORDER BY c.title;

#14 - LAST CHAT  6/10
SELECT
	c.title, m.content
FROM 
	(SELECT c.is_active, c.id, c.title FROM chats AS c ORDER BY date(c.start_date) DESC LIMIT 1) AS c
LEFT OUTER JOIN 
	messages AS m
ON
	m.chat_id = c.id
WHERE
	c.is_active=0
ORDER BY 
	m.sent_on DESC,
	m.id;
