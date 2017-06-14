#task 1
SELECT t.ticket_id, t.price, t.class, t.seat
FROM tickets AS t
ORDER BY t.ticket_id;

#task 2
SELECT c.customer_id, CONCAT_WS(' ', c.first_name, c.last_name) AS full_name, c.gender
FROM customers AS c
ORDER BY
	full_name,
	c.customer_id;
	
#task 3
SELECT f.flight_id, f.departure_time, f.arrival_time
FROM flights AS f
WHERE f.`status` LIKE 'Delayed'
ORDER BY f.flight_id;

#task 4
SELECT DISTINCT a.airline_id, a.airline_name, a.nationality, a.rating FROM airlines AS a
INNER JOIN flights AS f
ON a.airline_id = f.airline_id
ORDER BY
	a.rating DESC, 
	a.airline_id
LIMIT 5;

#task 5
SELECT t.ticket_id, a.airport_name AS destination, CONCAT_WS(' ', c.first_name, c.last_name) AS customer_name
FROM tickets AS t
INNER JOIN customers AS c
ON t.customer_id = c.customer_id
INNER JOIN flights AS f
ON t.flight_id = f.flight_id
INNER JOIN airports AS a
ON f.destination_airport_id = a.airport_id
WHERE t.price < 5000
	AND
		t.class LIKE 'first'
ORDER BY t.ticket_id;

#task 6 NOT FINISHED
SELECT DISTINCT c.customer_id, CONCAT_WS(' ', c.first_name, c.last_name) AS full_name, t.town_name AS home_town
	FROM 
		customers AS c
	INNER JOIN 
		towns AS t
	ON 
		c.home_town_id = t.town_id
	INNER JOIN 
		airports AS a
	ON 
		a.town_id = t.town_id
	INNER JOIN 
		flights AS f
	ON 
		f.destination_airport_id =a.airport_id
	WHERE 
		f.`status` LIKE 'departing'
	AND
		a.town_id=c.home_town_id;



