#9
SELECT m.mountain_range, p.peak_name, p.elevation AS peak_elevation
FROM mountains as m
JOIN peaks as p ON m.id = p.mountain_id
WHERE m.mountain_range LIKE 'Rila'
ORDER BY peak_elevation DESC;