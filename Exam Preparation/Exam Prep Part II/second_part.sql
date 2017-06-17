#INSERT
INSERT INTO 
	messages(content, sent_on, chat_id, user_id)
		SELECT DISTINCT
		CONCAT_WS('-', u.age, u.gender, l.latitude, l.longitude) AS content,
		'2016-12-15' AS sent_on,
		CASE 
			WHEN u.gender LIKE 'f' THEN
				CEIL(SQRT(u.age * 2))
			WHEN u.gender LIKE 'm' THEN
				CEIL(POW(u.age / 18, 3))
		END AS 'chat_id',
		u.id AS user_id
	FROM users AS u
	INNER JOIN locations AS l
	ON u.location_id = l.id
	INNER JOIN users_chats AS uc
	ON u.id = uc.user_id
	INNER JOIN chats AS c
	ON c.id = uc.chat_id
	WHERE u.id BETWEEN 10 AND 20;

	
SELECT DISTINCT
	u.id,
	CONCAT_WS('-', u.age, u.gender, l.latitude, l.longitude) AS content,
	'2016-12-15' AS sent_on,
	CASE 
		WHEN u.gender LIKE 'f' THEN
			CEIL(SQRT(u.age * 2))
		WHEN u.gender LIKE 'm' THEN
			CEIL(POW(u.age / 18, 3))
	END AS 'chat_id',
	u.id AS user_id
FROM users AS u
INNER JOIN locations AS l
ON u.location_id = l.id
INNER JOIN users_chats AS uc
ON u.id = uc.user_id
INNER JOIN chats AS c
ON c.id = uc.chat_id
WHERE u.id BETWEEN 10 AND 20;

SELECT 
	CASE 
		WHEN u.gender LIKE 'f' THEN
			FLOOR(SQRT(u.age * 2))
		WHEN u.gender LIKE 'm' THEN
			FLOOR(POW(u.age / 18, 3))
	END AS 'age',
FROM chats AS c
INNER JOIN users_chats AS uc
ON uc.chat_id = c.id
INNER JOIN users AS u
ON u.id = uc.user_id;

