CREATE DATABASE the_nerd_herd;

CREATE TABLE locations(
	id INT(13) PRIMARY KEY AUTO_INCREMENT,
	latitude FLOAT,
	longitude FLOAT
);

CREATE TABLE credentials(
	id INT(13) PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(30) NOT NULL,
	password VARCHAR(20) NOT NULL
);

CREATE TABLE users(
	id INT(13) PRIMARY KEY AUTO_INCREMENT,
	nickname VARCHAR(25) NOT NULL,
	gender CHAR(1),
	age INT(13),
	location_id INT(13),
	credential_id INT(13) UNIQUE,
	CONSTRAINT fk_user_location
	FOREIGN KEY (location_id) REFERENCES locations(id),
	CONSTRAINT fk_user_credential
	FOREIGN KEY (credential_id) REFERENCES credentials(id)
);

CREATE TABLE chats(
	id INT(13) PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(32),
	start_date DATE,
	is_active BIT
);

CREATE TABLE messages(
	id INT(13) PRIMARY KEY AUTO_INCREMENT,
	content VARCHAR(200) NOT NULL,
	sent_on DATE, 
	chat_id INT(13) NOT NULL,
	user_id INT(13) NOT NULL,
	CONSTRAINT fk_message_chat
	FOREIGN KEY (chat_id) REFERENCES chats(id),
	CONSTRAINT fk_message_user
	FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE users_chats(
	user_id INT(13) NOT NULL,
	chat_id INT(13) NOT NULL,
	CONSTRAINT fk_user_chats_users
	FOREIGN KEY (user_id) REFERENCES users(id),
	CONSTRAINT fk_user_chats_chats
	FOREIGN KEY (chat_id) REFERENCES chats(id),
	CONSTRAINT pk_user_chats 
	PRIMARY KEY(user_id, chat_id)
);

DROP DATABASE the_nerd_herd;