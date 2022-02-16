CREATE DATABASE blog

CREATE TABLE tag(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
)

CREATE TABLE author(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    mobile TEXT,
    password TEXT NOT NULL,
    avatar TEXT
)

CREATE TABLE user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    mobile TEXT,
    password TEXT NOT NULL,
    avatar TEXT
)

CREATE TABLE post(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    description TEXT,
    author_id INT,
    thumbnail TEXT NOT NULL,
    status TEXT NOT NULL,
    create_at DATE NOT NULL,
    published_at DATE,
    view_count INT,
    vote_score INT,
    post_type TEXT NOT NULL,
    FOREIGN KEY(author_id) REFERENCES author(id)
)

CREATE TABLE post_tag(
    post_id INT,
    tag_id INT,
    PRIMARY KEY(post_id, tag_id),
    FOREIGN KEY(post_id) REFERENCES post(id),
    FOREIGN KEY(tag_id) REFERENCES tag(id)
)

CREATE TABLE discuss(
    id INT PRIMARY KEY AUTO_INCREMENT,
    post_id INT,
    author_id INT,
    text TEXT NOT NULL,
    is_public BIT NOT NULL,
    create_at DATE NOT NULL,
    FOREIGN KEY(post_id) REFERENCES post(id),
    FOREIGN KEY(author_id) REFERENCES author(id)
)
