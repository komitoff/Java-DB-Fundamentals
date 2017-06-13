USE october_exam;
CREATE TABLE flights(
	flight_id INT PRIMARY KEY,
	departure_time DATETIME NOT NULL,
	arrival_time DATETIME NOT NULL,
	status VARCHAR(9) CHECK (status='Departing' OR status='Delayed' OR status='Arrived' OR status='Cancelled'),
	origin_airport_id INT,
	destination_airport_id INT,
	airline_id INT,
	CONSTRAINT fk_flights_airports_from
	FOREIGN KEY (origin_airport_id) REFERENCES airports(airport_id),
	CONSTRAINT fk_flights_airports_to
	FOREIGN KEY (destination_airport_id) REFERENCES airports(airport_id),
	CONSTRAINT fk_flights_airlines
	FOREIGN KEY (airline_id) REFERENCES airlines(airline_id)
);

USE october_exam;
CREATE TABLE tickets(
	ticket_id INT PRIMARY KEY,
	price DECIMAL(8,2) NOT NULL,
	class VARCHAR(6) CHECK(class='first' OR class='second' OR class='third'),
	seat VARCHAR(5) NOT NULL,
	customer_id INT,
	flight_id INT,
	CONSTRAINT fk_tickets_customers
	FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
	CONSTRAINT fk_tickets_flights
	FOREIGN KEY (flight_id) REFERENCES flights(flight_id)
);

INSERT INTO 
	flights(flight_id, departure_time, arrival_time, status, origin_airport_id, destination_airport_id, airline_id)
VALUES 
	(1, '2016-10-13 06:00','2016-10-13 10:00', 'Delayed', 1, 4, 1),
	(2, '2016-10-12 00:00', '2016-10-12 00:01', 'Departing', 1, 3, 2),
	(3, '2016-10-14 15:00', '2016-10-20 04:00', 'Delayed', 4, 2, 4),
	(4, '2016-10-12 13:24', '2016-10-12 16:31', 'Departing', 3, 1, 3),
	(5, '2016-10-12 08:11', '2016-10-12 23:22', 'Departing', 4, 1, 1),
	(6, '1995-06-21 00:30', '1995-06-22 20:30', 'Arrived', 2, 3, 5),
	(7, '2016-10-12 23:34', '2016-10-13 03:00', 'Departing', 2, 4, 2),
	(8, '2016-11-11 13:00', '2016-11-12 22:00', 'Delayed', 4, 3, 1),
	(9, '2015-10-01 12:00', '2015-12-01 01:00', 'Arrived', 1, 2, 1),
	(10, '2016-10-12 19:30', '2016-10-13 00:30', 'Departing', 2, 1, 7);
	
INSERT INTO 
	tickets(ticket_id, price, class, seat, customer_id, flight_id)
VALUES 
	(1, 3000.00, 'First', '233-A', 3, 8),
	(2, 1799.90, 'Second', '123-D', 1, 1),
	(3, 1200.50, 'Second', '12-Z', 2, 5),
	(4, 410.68, 'Third', '45-Q', 2, 8),
	(5, 560.00, 'Third', '201-R', 4, 6),
	(6, 2100.00, 'Second', '13-T', 1, 9),
	(7, 5500.00, 'First', '98-O', 2, 7);
	
UPDATE flights
SET flights.airline_id = 1
WHERE flights.status LIKE 'Arrived';

UPDATE tickets AS t
SET t.price * 2
WHERE t.ticket_id = (SELECT MAX(al.rating) AS rate
	FROM tickets AS ti
	INNER JOIN flights AS fl
	ON fl.flight_id=ti.flight_id
	INNER JOIN airlines AS al
	ON al.airline_id=fl.airline_id;);

SELECT ti.ticket_id AS Rate
	FROM tickets AS ti
	INNER JOIN flights AS fl
	ON fl.flight_id=ti.flight_id
	INNER JOIN airlines AS al
	ON al.airline_id=fl.airline_id
	WHERE al.rating = (SELECT MAX(a.rating) FROM airlines AS a);