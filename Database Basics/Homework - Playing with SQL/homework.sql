CREATE TABLE `minions` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT NULL,
	`age` INT(11) NULL DEFAULT NULL
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

INSERT INTO minions(name, age) VALUES ('Ivan', 23);

INSERT INTO minions(name, age) VALUES ('Kiro', 24);

INSERT INTO minions(age) VALUES (14);

UPDATE homework.minions SET minions.name='Nqkoj' WHERE minions.age=14;

SELECT minions.name FROM minions ORDER BY minions.age ASC;

CREATE TABLE `towns` (
	`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT NUll 
);

INSERT INTO towns(name) VALUES ('Amsterdam');
INSERT INTO towns(name) VALUES ('Berlin');

ALTER TABLE minions
ADD town_id INT(11) NULL DEFAULT NULL;

UPDATE homework.minions SET minions.town_id=1 WHERE minions.name='Ivan';
UPDATE homework.minions SET minions.town_id=2 WHERE minions.name='Nqkoj';
UPDATE homework.minions SET minions.town_id=1 WHERE minions.name='Kiro';