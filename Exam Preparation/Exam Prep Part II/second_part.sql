#INSERT 100 / 100
INSERT INTO 
	messages(content, sent_on, chat_id, user_id)
		SELECT
		CONCAT_WS('-', u.age, u.gender, l.latitude, l.longitude) AS content,
		'2016-12-15' AS sent_on,
		CASE 
			WHEN u.gender LIKE 'F' THEN
				CEIL(SQRT(u.age * 2))
			WHEN u.gender LIKE 'M' THEN
				CEIL(POW(u.age / 18, 3))
		END AS 'chat_id',
		u.id AS user_id
	FROM users AS u
	INNER JOIN locations AS l
	ON u.location_id = l.id
	AND u.id BETWEEN 10 AND 20;


#update
UPDATE chats AS c
INNER JOIN 
	messages AS m
ON 
	c.id=m.chat_id
SET c.start_date=m.sent_on
WHERE
	date(c.start_date) > date(m.sent_on);

SELECT c.id, c.start_date, m.id, m.sent_on 
FROM 
	messages AS m
INNER JOIN 
	chats AS c
ON 
	c.id=m.chat_id
AND 
	date(c.start_date) > date(m.sent_on);

#4 Delete
SELECT l.id, l.latitude, l.longitude, u.location_id
FROM 
	locations AS l
LEFT OUTER JOIN
	users AS u
ON
	u.location_id = l.id;
