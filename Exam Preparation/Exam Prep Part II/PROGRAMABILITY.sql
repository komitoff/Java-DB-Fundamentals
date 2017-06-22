#15 Radians
DELIMITER $$
CREATE FUNCTION udf_get_radians(degrees FLOAT)
RETURNS FLOAT
BEGIN
	DECLARE radians FLOAT;
	SET radians := ((PI() * degrees) / 180);
	RETURN radians;
END; $$
DELIMITER ;

SELECT udf_get_radians(22.12);

#16 New Password
DELIMITER $$
CREATE PROCEDURE udp_change_password(email VARCHAR(30), new_password VARCHAR(20))
BEGIN
	IF (email LIKE (SELECT c.email FROM credentials AS c)) THEN
		UPDATE credentials AS c
		SET c.password = new_password
		WHERE email = c.email;
	ELSE
		SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'There is no chat with that user!';
   END IF;
END $$
DELIMITER ;

CALL udp_change_password('abarnes0@UHSADHASDUHASD.com', 'new_pass');

SELECT c.email
FROM credentials AS c
WHERE c.password LIKE 'new_pass'

#17 Send Message
DELIMITER $$ 
CREATE PROCEDURE udp_send_message(user_id INT(11), chat_id INT(11), content VARCHAR(200))
BEGIN
	START TRANSACTION;
	IF(user_id NOT IN (SELECT user_id FROM users_chats AS uc WHERE uc.chat_id=chat_id))
		THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'There is no chat with that user!';
		ROLLBACK;
	END IF;
		
	INSERT INTO 
			messages(content, sent_on, chat_id, user_id)
	VALUES
			(content, date('2016-12-15'), chat_id, user_id);
END $$
DELIMITER ;

CALL udp_send_message(19, 17, 'awesome');

SELECT *
FROM messages 
WHERE messages.content LIKE 'awesome';

#18 lOG MESSAGES
DELIMITER $$
CREATE TRIGGER tr_message_logger
AFTER DELETE
ON messages
FOR EACH ROW
BEGIN
	INSERT INTO messages_log (id, content, sent_on, chat_id, user_id)
		VALUES
			(old.id, old.content, old.sent_on, old.chat_id, old.user_id);
END $$
DELIMITER ;











