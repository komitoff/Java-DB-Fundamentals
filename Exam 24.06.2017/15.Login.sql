DELIMITER $$
CREATE PROCEDURE udp_login(username VARCHAR(30), password VARCHAR(30))
BEGIN	
	START TRANSACTION;
	
		IF (username NOT IN (SELECT u.username FROM users AS u))THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Username does not exist!'; 
			ROLLBACK;
		END IF;
		
		IF (password NOT IN (SELECT u.password FROM users AS u))
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Password is incorrect!'; 
			ROLLBACK;
		END IF;
		
		IF (username IN (SELECT liu.username FROM logged_in_users AS liu))
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'User is already logged in!'; 
			ROLLBACK;
		END IF;
	
	INSERT INTO logged_in_users 
		(id, username, password, email)
	VALUES 
		((SELECT u.id
		 	 FROM users AS u
		 	 WHERE u.username=username
		 	 AND
		 		u.password = password),
		 username,
		 password,
		 (SELECT u.email
		 	 FROM users AS u
		 	 WHERE u.username=username
		 	 AND
		 		u.password = password));
	
	COMMIT;
END $$
DELIMITER ;


CALL udp_login('doge', 'doge');
SELECT * FROM logged_in_users;
