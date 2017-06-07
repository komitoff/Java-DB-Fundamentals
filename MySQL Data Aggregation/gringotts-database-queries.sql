#1
SELECT wd.id AS count
FROM wizzard_deposits AS wd
ORDER BY wd.id DESC
LIMIT 1;

#2
SELECT MAX(wd.magic_wand_size) AS longest_magic_wand
FROM wizzard_deposits AS wd
ORDER BY longest_magic_wand
LIMIT 1;

#3
SELECT 
	wd.deposit_group AS deposit_group,
	MAX(wd.magic_wand_size) AS longest_magic_wand
FROM wizzard_deposits AS wd
GROUP BY wd.deposit_group
ORDER BY 
	longest_magic_wand,
	deposit_group;
	
#4 NOT FINISHED
SELECT 
	wd.deposit_group AS deposit_group,
FROM wizzard_deposits AS wd
GROUP BY deposit_group
ORDER BY wd.magic_wand_size
LIMIT 1;

#5 and 6
SELECT
	 wd.deposit_group, 
	 SUM(wd.deposit_amount) AS total_sum
FROM 
	wizzard_deposits AS wd
GROUP BY wd.deposit_group
ORDER BY total_sum;

#7
SELECT
	 wd.deposit_group, 
	 SUM(wd.deposit_amount) AS total_sum
FROM 
	wizzard_deposits AS wd
WHERE wd.magic_wand_creator LIKE 'Ollivander family'
GROUP BY wd.deposit_group
HAVING total_sum < 150000
ORDER BY total_sum DESC;

#8 NOT FINISHED
SELECT
	wd.deposit_group,
	wd.magic_wand_creator,
	MIN(wd.deposit_charge) as min_deposit_charge 
FROM
	wizzard_deposits AS wd
GROUP BY
	wd.magic_wand_creator
ORDER BY 
	wd.magic_wand_creator,
	wd.deposit_group;
	
#10
SELECT SUBSTRING(wd.first_name, 1, 1) AS first_letter
FROM wizzard_deposits AS wd
WHERE wd.deposit_group LIKE 'Troll Chest'
GROUP BY wd.first_name
ORDER BY wd.first_name;
