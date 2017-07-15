INSERT INTO 
	countries(country_id, country_name)
VALUES 
	(1, 'Bulgaria'),
	(2, 'Serbia'),
	(3, 'Russia'),
	(4, 'Greece'),
	(5, 'Romania');
	
INSERT INTO 
	towns(town_id, town_name, country_id)
VALUES 
	(1,'Sofia', 1),
	(2,'Belgrade', 2),
	(3,'Moscow', 3),
	(4,'Athens', 4),
	(5,'Bucharest', 5);
	
INSERT INTO 
	minions(minion_id, minion_name, minion_age, town_id) 
VALUES
	(1, 'Pesho', 44, 1),
	(2, 'Lepa Brena', 12, 2),
	(3, 'Ivan', 7, 3),
	(4, 'Papadopulis', 65, 4),
	(5, 'Drakula', 1, 5);
	
INSERT INTO 
	villains(villain_id, villain_name, evilness_factor)
VALUES
	(1, 'Kolio Mamata', 'good'),
	(2, 'Zlatko Baretata', 'evil'),
	(3, 'Joro Iliev', 'bad'),
	(4, 'Boiko Borisov','good'),
	(5, 'Putin', 'super evil');
	
INSERT INTO
	villains_minions(villain_id, minion_id)
VALUES
	(1, 2),
	(1, 1),
	(2, 2),
	(5, 2),
	(3, 5),
	(4, 4);