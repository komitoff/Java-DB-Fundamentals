DELETE FROM l
	USING locations AS l
LEFT OUTER JOIN
		users AS u
	ON
		u.location_id = l.id
	WHERE
		u.location_id IS null;
			
DELETE FROM locations
WHERE locations.id = 1;