DROP DATABASE minions;

CREATE DATABASE minions;

CREATE TABLE countries (
	country_id INT PRIMARY KEY AUTO_INCREMENT,
	country_name VARCHAR(150)
);

CREATE TABLE towns (
	town_id INT PRIMARY KEY AUTO_INCREMENT,
	town_name VARCHAR(100) NOT NULL,
	country_id INT,
	CONSTRAINT fk_towns_countries
	FOREIGN KEY (country_id) REFERENCES countries(country_id)
);

CREATE TABLE minions(
	minion_id INT PRIMARY KEY AUTO_INCREMENT,
	minion_name VARCHAR(50) NOT NULL,
	minion_age INT(3) NOT NULL,
	town_id INT NOT NULL,
	CONSTRAINT fk_minions_towns
	FOREIGN KEY (town_id) REFERENCES towns(town_id)
);

CREATE TABLE villains (
	villain_id INT PRIMARY KEY AUTO_INCREMENT,
	villain_name VARCHAR(50) NOT NULL,
	evilness_factor VARCHAR(10) 
	CHECK( evilness_factor = 'good' OR evilness_factor = 'bad' OR evilness_factor = 'evil' OR evilness_factor = 'super evil')
);

CREATE TABLE villains_minions (
	villain_id INT NOT NULL,
	minion_id INT NOT NULL,
	CONSTRAINT fk_villains_minions_minions
	FOREIGN KEY (minion_id) REFERENCES minions(minion_id),
	CONSTRAINT fk_villains_minions_villains
	FOREIGN KEY (villain_id) REFERENCES villains(villain_id),
	CONSTRAINT pk_villains_minions
	PRIMARY KEY(villain_id, minion_id)
);