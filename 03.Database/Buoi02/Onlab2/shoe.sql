-- Create database shoe
CREATE DATABASE shoe

-- Create table category
CREATE TABLE category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
)

-- Create table brand
CREATE TABLE brand(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
)

-- Create table gender
CREATE TABLE gender(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
)

-- Create table item
CREATE TABLE item(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    description TEXT,
    image TEXT,
    id_category INT,
    id_brand INT,
    status TEXT NOT NULL,
    id_gender INT,
    quantity INT NOT NULL,

    FOREIGN KEY(id_category) REFERENCES category(id),
    FOREIGN KEY(id_brand) REFERENCES brand(id),
    FOREIGN KEY(id_gender) REFERENCES gender(id)
)

-- Create table price
CREATE TABLE price(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_item INT,
    price BIGINT NOT NULL,
    date DATE,

    FOREIGN KEY(id_item) REFERENCES item(id)
)

-- Create table size
CREATE TABLE size(
    id INT PRIMARY KEY AUTO_INCREMENT,
    size INT NOT NULL
)

-- Create table item_size
CREATE TABLE item_size(
    id_item INT,
    id_size INT,

    PRIMARY KEY(id_item, id_size),

    FOREIGN KEY(id_item) REFERENCES item(id),
    FOREIGN KEY(id_size) REFERENCES size(id)
)

-- Create table color
CREATE TABLE color(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
)

-- Create table item_color
CREATE TABLE item_color(
    id_item INT,
    id_color INT,

    PRIMARY KEY(id_item, id_color),

    FOREIGN KEY(id_item) REFERENCES item(id),
    FOREIGN KEY(id_color) REFERENCES color(id)
)

-- Create table users
CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL,
    email TEXT NOT NULL,
    mobile TEXT NOT NULL,
    id_gender INT,
    dob DATE NOT NULL,
    start_at DATE,
    status TEXT NOT NULL,
    address TEXT NOT NULL,
    role TEXT NOT NULL,

    FOREIGN KEY(id_gender) REFERENCES gender(id)
)

-- Insert into category
INSERT INTO category(id, name)
VALUES(1, 'Sport Inspired');
INSERT INTO category(id, name)
VALUES(2, 'Chạy');
INSERT INTO category(id, name)
VALUES(3, 'Sportswear');
INSERT INTO category(id, name)
VALUES(3, 'Sportswear');
INSERT INTO category(id, name)
VALUES(4, 'Originals');

-- Insert into brand

-- Insert into gender

-- Insert into item
INSERT INTO item(name, description, image, )
VALUES ()
