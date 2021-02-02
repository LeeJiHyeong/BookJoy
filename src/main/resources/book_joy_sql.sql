CREATE TABLE user (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_email VARCHAR(70) NOT NULL UNIQUE,
    user_nickname VARCHAR(30),
    user_picture VARCHAR(1000),
    user_role VARCHAR(10),
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Book (
    item_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(30) NOT NULL UNIQUE,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    description VARCHAR(2000),
    pub_date VARCHAR(30),
    cover_small_url VARCHAR(100),
    cover_large_url VARCHAR(100),
    category_name VARCHAR(10),
    category_id VARCHAR(10),
    ranking INTEGER
);