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
	
#4
SELECT 
	wd.deposit_group AS deposit_group,
FROM wizzard_deposits AS wd
GROUP BY wd.magic_wand_size
ORDER BY AVG(wd.magic_wand_size)
LIMIT 1;
