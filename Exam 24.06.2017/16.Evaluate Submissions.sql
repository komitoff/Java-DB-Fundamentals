DELIMITER $$
CREATE PROCEDURE udp_evaluate(id INT)
BEGIN	
	DECLARE problem_name VARCHAR(100);
	DECLARE result INT;
	DECLARE username VARCHAR(30);
	SET problem_name := (SELECT p.name FROM problems AS p INNER JOIN submissions AS s ON s.problem_id = p.id WHERE s.id = id);
	SET result := (SELECT CEIL((p.points / p.tests ) * s.passed_tests) AS 'result' FROM problems AS p INNER JOIN submissions AS s ON s.problem_id = p.id WHERE s.id = id);
	SET username := (SELECT u.username FROM submissions AS s INNER JOIN users AS u ON u.id=s.user_id WHERE s.id=id);
	
	START TRANSACTION;
		
		IF (id NOT IN (SELECT s.id FROM submissions AS s))
		THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Submission does not exist!'; 
			ROLLBACK;
		END IF;
		
		INSERT INTO 
			evaluated_submissions(id, problem, user, result)
		VALUES
			(id,
			 problem_name,
			 username,
			 result);
	COMMIT;
END $$
DELIMITER ;

CALL udp_evaluate(1);

SELECT CEIL((p.points / p.tests ) * s.passed_tests) AS 'result' FROM problems AS p INNER JOIN submissions AS s ON s.problem_id = p.id

