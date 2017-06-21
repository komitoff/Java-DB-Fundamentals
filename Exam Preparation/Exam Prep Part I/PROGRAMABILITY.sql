#16
DELIMITER $$
CREATE PROCEDURE udp_submit_review(customer_id INT, review_content VARCHAR(255), review_grade INT, airline_name VARCHAR(30))
BEGIN
	DECLARE review_id INT;
	DECLARE airline_id INT;
	SET review_id := (SELECT COUNT(*) FROM customer_reviews) + 1;
	SET airline_id := (SELECT a.airline_id FROM airlines AS a WHERE a.airline_name LIKE airline_name);
	
	START TRANSACTION;
	
	INSERT INTO 
		customer_reviews(
			review_id,
			review_content,
			review_grade,
			airline_id,
			customer_id
		)
	VALUES (
		review_id,
		review_content,
		review_grade,
		airline_id,
		customer_id
	);
	
	IF (airline_name NOT IN (SELECT a.airline_name FROM airlines AS a)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Airline does not exist.'; 
		ROLLBACK;
	END IF;
	COMMIT;
END $$
DELIMITER ;


#17 Register ticket
DELIMITER $$
CREATE PROCEDURE udp_purchase_ticket(
		customer_id INT(11), flight_id INT(11), 
		ticket_price DECIMAL(8,2),class VARCHAR(6), seat VARCHAR(5))
BEGIN
	START TRANSACTION;
	
	IF (ticket_price > (SELECT cba.balance FROM customer_bank_accounts AS cba WHERE cba.customer_id = customer_id)) THEN
		SIGNAL SQLSTATE '45000' 
		SET MESSAGE_TEXT = 'Insufficient bank account balance for ticket purchase.';
		ROLLBACK;
	END IF;
	
	INSERT INTO tickets (
		price,
		class,
		seat,
		customer_id,
		flight_id
	)
	VALUES (
		ticket_price, 
		class,
		seat,
		customer_id,
		flight_id
	);
		
	UPDATE customer_bank_accounts
	SET customer_bank_accounts.balance = customer_bank_accounts.balance - ticket_price
	WHERE customer_bank_accounts.customer_id = customer_id;
	COMMIT;
END $$
DELIMITER ;