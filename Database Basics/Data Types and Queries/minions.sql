CREATE TABLE minions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250),
    age INT
);

CREATE TABLE towns (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(250)
);

ALTER TABLE minions
ADD town_id INT,
ADD FOREIGN KEY (town_id) REFERENCES towns(id);

INSERT INTO towns(name) VALUES ('Sofia');
INSERT INTO towns(name) VALUES ('Plovidv');
INSERT INTO towns(name) VALUES ('Varna');


INSERT INTO minions(name, age, town_id) VALUES ('Kevin', 22, 1);
INSERT INTO minions(name, age, town_id) VALUES ('Bob', 15, 3);
INSERT INTO minions(name, town_id) VALUES ('Steward', 2);