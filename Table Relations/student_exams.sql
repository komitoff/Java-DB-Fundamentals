CREATE DATABASE many_to_many_relations;

CREATE TABLE students(
	student_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL
);

CREATE TABLE exams (
	exam_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL
);

CREATE TABLE students_exams (
	student_id INT NOT NULL,
	exam_id INT NOT NULL,
	CONSTRAINT fk_students_students_exam
	FOREIGN KEY(student_id) REFERENCES students(student_id),
	CONSTRAINT fk_exams_student_exams
	FOREIGN KEY(exam_id) REFERENCES exams(exam_id),
	CONSTRAINT pk_students_exams
	PRIMARY KEY (student_id, exam_id)
);

INSERT INTO 
	students(name)
VALUES
	('Mila'),
	('Toni'),
	('Ron');
	
INSERT INTO 
	exams(exam_id, name)
VALUES
	(101, 'Spring MVC'),
	(102, 'Neo4j'),
	(103, 'Oracle 11g');
	
INSERT INTO
	students_exams(student_id, exam_id)
VALUES
	(1, 101),
	(1, 102),
	(2, 101),
	(3, 103),
	(2, 102),
	(2, 103);

DROP DATABASE many_to_many_relations;