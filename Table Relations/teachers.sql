CREATE DATABASE self_referencing;

CREATE TABLE teachers(
	teacher_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	manager_id INT NULL,
	CONSTRAINT fk_teacher_manager_id 
	FOREIGN KEY (manager_id) REFERENCES teachers(teacher_id)
);


INSERT INTO 
	teachers(teacher_id, name, manager_id)
VALUES 
	(101, 'John', null),
	(106, 'Greta', 101),
	(105, 'Mark', 101),
	(104, 'Ted', 105),
	(103, 'Silvia', 106),
	(102, 'Maya', 106);

SELECT * FROM teachers;
DROP DATABASE self_referencing;