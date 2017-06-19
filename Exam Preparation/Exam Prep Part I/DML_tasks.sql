#SECOND PART DML ---------------------
#TASK 1 - INSERT
INSERT INTO flights 
	(departure_time, arrival_time, status, origin_airport_id, destination_airport_id, airline_id)
	SELECT 
	'2017-06-19 14:00:00' AS departure_time,
	'2017-06-21 11:00:00' AS arrival_time,
	CASE 
		WHEN (a.airline_id % 4) = 0
			THEN 'Departing'
		WHEN (a.airline_id % 4) = 1
			THEN 'Delayed'
		WHEN (a.airline_id % 4) = 2
			THEN 'Arrived' 
		WHEN (a.airline_id % 4) = 3
			THEN 'Canceled'
	END AS 'status',
	CEIL(SQRT(CHAR_LENGTH(a.airline_name))) AS 'origin_airport_id',
	CEIL(SQRT(CHAR_LENGTH(a.nationality))) AS 'destination_airport_id',
	a.airline_id
FROM airlines AS a
WHERE a.airline_id BETWEEN 1 AND 10;




# THE SELECTION FOR THE INSERT QUERY
SELECT 
	'2017-06-19 14:00:00' AS departure_time,
	'2017-06-21 11:00:00' AS arrival_time,
	CASE 
		WHEN (a.airline_id % 4) = 0
			THEN 'Departing'
		WHEN (a.airline_id % 4) = 1
			THEN 'Delayed'
		WHEN (a.airline_id % 4) = 2
			THEN 'Arrived' 
		WHEN (a.airline_id % 4) = 3
			THEN 'Canceled'
	END AS 'status',
	CEIL(SQRT(CHAR_LENGTH(a.airline_name))) AS 'origin_airport_id',
	CEIL(SQRT(CHAR_LENGTH(a.nationality))) AS 'destination_airport_id',
	a.airline_id
FROM airlines AS a
WHERE a.airline_id BETWEEN 1 AND 10;





#UPDATE ALL ARRIVED FLIGHTS
UPDATE flights
SET flights.airline_id = 1
WHERE flights.`status` LIKE 'Arrived';


#UPDATE THE HIGHEST RATE AIRLINE
UPDATE tickets AS t
SET t.price = t.price * 1.5
	WHERE t.ticket_id = (SELECT 
			t.ticket_id
	FROM flights AS f
	INNER JOIN tickets AS t
	ON f.flight_id=t.flight_id
	INNER JOIN airlines AS a
	ON f.airline_id=a.airline_id
	WHERE a.rating = (SELECT 
			MAX(a.rating) AS max_rate
			FROM airlines AS a
			));

#SELECTION
SELECT 
		t.ticket_id
FROM flights AS f
INNER JOIN tickets AS t
ON f.flight_id=t.flight_id
INNER JOIN airlines AS a
ON f.airline_id=a.airline_id
WHERE a.rating = (SELECT 
		MAX(a.rating) AS max_rate
		FROM airlines AS a
		);









