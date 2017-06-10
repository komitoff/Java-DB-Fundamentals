CREATE DATABASE university_database;

CREATE TABLE majors(
	major_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

CREATE TABLE students(
	student_id INT PRIMARY KEY AUTO_INCREMENT,
	student_number VARCHAR(12) NOT NULL,
	student_name VARCHAR(50) NOT NULL,
	major_id INT NOT NULL,
	CONSTRAINT fk_students_majors
	FOREIGN KEY (major_id) REFERENCES majors(major_id)
);

CREATE TABLE payments(
	payment_id INT PRIMARY KEY AUTO_INCREMENT,
	payment_date DATE NOT NULL,
	payment_amount DECIMAL(8,2) NOT NULL,
	student_id INT NOT NULL UNIQUE,
	CONSTRAINT fk_payment_student
	FOREIGN KEY (student_id) REFERENCES students(student_id)
);

CREATE TABLE subjects(
	subject_id INT PRIMARY KEY AUTO_INCREMENT,
	subject_name VARCHAR(50) NOT NULL
);

CREATE TABLE agenda(
	student_id INT NOT NULL,
	subject_id INT NOT NULL,
	CONSTRAINT fk_agenda_student
	FOREIGN KEY (student_id) REFERENCES students(student_id),
	CONSTRAINT fk_agenda_subject
	FOREIGN KEY (subject_id) REFERENCES subjects(subject_id),
	CONSTRAINT pk_agenda
	PRIMARY KEY (student_id, subject_id)
);

