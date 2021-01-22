CREATE TABLE user (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_email VARCHAR(70) NOT NULL UNIQUE,
    user_password VARCHAR(70) NOT NULL,
    user_nickname VARCHAR(30) NOT NULL UNIQUE,
    create_date DATETIME
);