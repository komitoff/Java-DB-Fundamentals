#SECTION 3 - QUERYING
#5 TICKETS
SELECT t.ticket_id, t.price, t.class, t.seat
FROM tickets AS t
ORDER BY t.ticket_id;

#6 Customers
SELECT 
	c.customer_id, 
	CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name',
	c.gender
FROM customers AS c
ORDER BY 
	full_name,
	c.customer_id;
	
#7 FLIGHTS
SELECT
	f.flight_id, f.departure_time, f.arrival_time
FROM 
	flights AS f
WHERE 
	f.`status` LIKE 'Delayed'
ORDER BY 
	f.flight_id;
	
#8 Airlines
SELECT DISTINCT
	a.airline_id, a.airline_name, a.nationality, a.rating
FROM 
	airlines AS a
INNER JOIN flights AS f
ON f.airline_id=a.airline_id
ORDER BY 
	a.rating DESC,
	a.airline_id
LIMIT 5;	

#9 First class tickets ----------- NOT FINISHED Incorrect result
SELECT ti.ticket_id, a.airport_name, CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name'
FROM 
	tickets AS ti
INNER JOIN flights AS f
ON 
	f.flight_id = ti.flight_id
INNER JOIN 
	airports AS a
ON 
	a.airport_id=f.destination_airport_id
INNER JOIN 
	customers AS c
ON 
	c.customer_id=ti.customer_id
WHERE
	ti.price < 5000
	AND
	ti.class LIKE 'First'
ORDER BY
	ti.ticket_id;

#10 Home town customers
SELECT DISTINCT 
	c.customer_id, 
	CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name',
	tw.town_name
FROM 
	customers AS c
INNER JOIN 
	towns AS tw
ON 
	tw.town_id=c.home_town_id
INNER JOIN 
	tickets AS t
ON
   c.customer_id=t.customer_id
INNER JOIN 
	flights AS f
ON 
	t.flight_id=f.flight_id
AND 
	f.`status` LIKE 'Departing'
INNER JOIN 
	airports AS a
ON 
	a.airport_id=f.origin_airport_id
AND 
	c.home_town_id=a.town_id
ORDER BY 
	c.customer_id;
	
#11
SELECT DISTINCT
	c.customer_id, 
	CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name', 
	(SELECT 2016 - YEAR(c.date_of_birth)) AS 'age'
FROM
	customers AS c
INNER JOIN 
	tickets AS t
ON 
	t.customer_id=c.customer_id
INNER JOIN
	flights AS f
ON 
	f.flight_id=t.flight_id	
AND
	f.`status` LIKE 'Departing'
ORDER BY
	age,
	c.customer_id;

#12
SELECT 
	c.customer_id,
	CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name',
	t.price AS 'ticket_price',
	a.airport_name AS 'destination'
FROM 
	customers AS c
INNER JOIN
	tickets as t
ON
	t.customer_id=c.customer_id
INNER JOIN
	flights AS f
ON 
	t.flight_id=f.flight_id
AND
	f.`status` LIKE 'Delayed'
INNER JOIN
	airports AS a
ON 
	f.destination_airport_id=a.airport_id
ORDER BY
	ticket_price DESC,
	c.customer_id
LIMIT 3;

#13 ----------------------
SELECT f.flight_id, f.departure_time, f.arrival_time, ao.airport_name AS 'origin', ad.airport_name AS 'destination'
FROM 
			(SELECT *
			FROM 
				flights AS f
			WHERE 
				f.`status` LIKE 'Departing'
			ORDER BY
				f.departure_time DESC
			LIMIT 5) AS f
INNER JOIN
	airports AS ao
ON 
	ao.airport_id=f.origin_airport_id
INNER JOIN 
	airports AS ad
ON
	ad.airport_id=f.destination_airport_id
ORDER BY
	f.departure_time, 
	f.flight_id
LIMIT 
	5;

SELECT
	f.flight_id, f.departure_time, f.arrival_time
FROM 
	flights AS f
WHERE 
	f.`status` LIKE 'Departing'
ORDER BY
	f.departure_time DESC
LIMIT 5;


#14
SELECT DISTINCT
	c.customer_id, 
	CONCAT_WS(' ', c.first_name, c.last_name) AS 'full_name', 
	(SELECT 2016 - YEAR(c.date_of_birth)) AS 'age'
FROM
	customers AS c
INNER JOIN 
	tickets AS t
ON 
	t.customer_id=c.customer_id
INNER JOIN
	flights AS f
ON 
	f.flight_id=t.flight_id	
AND
	f.`status` LIKE 'Arrived'
HAVING 
	age < 21
ORDER BY
	age DESC,
	c.customer_id;
	
	
#!5 Airports And Passangers
SELECT a.airport_id, a.airport_name, COUNT(c.customer_id) AS 'passangers'
FROM 
	airports AS a
INNER JOIN 
	flights AS f
ON
	f.origin_airport_id
AND 
	f.`status` LIKE 'Departing'
INNER JOIN 
	tickets AS t
ON 
	t.flight_id = f.flight_id
INNER JOIN
	customers AS c
ON	
	c.customer_id=t.customer_id
GROUP BY 
	a.airport_id;

	