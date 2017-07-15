#2 
SELECT 
	v.villain_name, COUNT(m.minion_id) AS cnt
FROM 
	villains AS v
INNER JOIN 
	villains_minions AS vm
ON
	v.villain_id=vm.villain_id
INNER JOIN
	minions AS m
ON
	vm.minion_id=m.minion_id
GROUP BY
	v.villain_id
ORDER BY 
	cnt DESC;


#3
SELECT 
	v.villain_name, m.minion_id, m.minion_name, m.
FROM 
	villains AS v
INNER JOIN 
	villains_minions AS vm
ON
	v.villain_id=vm.villain_id
INNER JOIN
	minions AS m
ON
	vm.minion_id=m.minion_id;