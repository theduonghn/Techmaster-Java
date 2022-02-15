CREATE TABLE category(
    id INT PRIMARY KEY,
    name TEXT NOT NULL
)

CREATE TABLE tag(
    id INT PRIMARY KEY,
    name TEXT NOT NULL
)

CREATE TABLE author(
    id INT PRIMARY KEY,
    name TEXT NOT NULL,
    year_of_birth INT,
    year_of_death INT,
    address TEXT
)

CREATE TABLE post(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title TEXT NOT NULL,
    content TEXT NOT NULL,
    description TEXT NOT NULL,
    status TEXT NOT NULL,
    img TEXT,
    id_category INT,
    id_author INT,
    FOREIGN KEY(id_category) REFERENCES category(id),
    FOREIGN KEY(id_author) REFERENCES author(id)
)

CREATE TABLE post_tag(
    id_post INT,
    id_tag INT,
    PRIMARY KEY(id_post, id_tag),
    FOREIGN KEY(id_post) REFERENCES post(id),
    FOREIGN KEY(id_tag) REFERENCES tag(id)
)