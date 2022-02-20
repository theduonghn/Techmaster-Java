-- Create database shoe2
CREATE DATABASE shoe2


-- Create table category
CREATE TABLE category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);


-- Create table brand
CREATE TABLE brand(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);


-- Create table gender
CREATE TABLE gender(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);


-- Create table item
CREATE TABLE item(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    description TEXT,
    image TEXT,
    id_category INT NOT NULL,
    id_brand INT NOT NULL,
    status TEXT NOT NULL,
    id_gender INT NOT NULL,
    quantity INT NOT NULL,

    FOREIGN KEY(id_category) REFERENCES category(id),
    FOREIGN KEY(id_brand) REFERENCES brand(id),
    FOREIGN KEY(id_gender) REFERENCES gender(id)
);


-- Create table price
CREATE TABLE price(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_item INT NOT NULL,
    price BIGINT NOT NULL,
    date DATE NOT NULL,

    FOREIGN KEY(id_item) REFERENCES item(id)
);


-- Create table material
CREATE TABLE material(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);


-- Create table item_material
CREATE TABLE item_material(
    id_item INT NOT NULL,
    id_material INT NOT NULL,

    PRIMARY KEY(id_item, id_material),

    FOREIGN KEY(id_item) REFERENCES item(id),
    FOREIGN KEY(id_material) REFERENCES material(id)
);


-- Create table size
CREATE TABLE size(
    id INT PRIMARY KEY AUTO_INCREMENT,
    size INT NOT NULL
);


-- Create table item_size
CREATE TABLE item_size(
    id_item INT NOT NULL,
    id_size INT NOT NULL,

    PRIMARY KEY(id_item, id_size),

    FOREIGN KEY(id_item) REFERENCES item(id),
    FOREIGN KEY(id_size) REFERENCES size(id)
);


-- Create table color
CREATE TABLE color(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);


-- Create table item_color
CREATE TABLE item_color(
    id_item INT NOT NULL,
    id_color INT NOT NULL,

    PRIMARY KEY(id_item, id_color),

    FOREIGN KEY(id_item) REFERENCES item(id),
    FOREIGN KEY(id_color) REFERENCES color(id)
);


-- Create table user
CREATE TABLE user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    username TEXT NOT NULL,
    password TEXT NOT NULL,
    email TEXT NOT NULL,
    mobile TEXT NOT NULL,
    id_gender INT NOT NULL,
    dob DATE NOT NULL,
    start_at DATE,
    status TEXT NOT NULL,
    role INT NOT NULL,

    FOREIGN KEY(id_gender) REFERENCES gender(id)
);


-- Create table address
CREATE TABLE address(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,
    type ENUM('Nhà riêng', 'Cơ quan', 'Khác') NOT NULL,
    address TEXT NOT NULL,

    FOREIGN KEY(id_user) REFERENCES user(id)
);


-- Create table cart
CREATE TABLE cart(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT NOT NULL,

    FOREIGN KEY(id_user) REFERENCES user(id)
);


-- Create table cart_item
CREATE TABLE cart_item(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cart INT NOT NULL,
    id_item INT NOT NULL,
    quantity INT NOT NULL,

    FOREIGN KEY(id_cart) REFERENCES cart(id),
    FOREIGN KEY(id_item) REFERENCES item(id)
);


-- Create table branch
CREATE TABLE branch(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    address TEXT NOT NULL,
    id_admin INT NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    account TEXT NOT NULL,

    FOREIGN KEY(id_admin) REFERENCES user(id)
);


-- Create table orders
CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_branch INT NOT NULL,
    id_seller INT NOT NULL,
    id_client INT NOT NULL,
    create_at DATE NOT NULL,
    status TEXT NOT NULL,
    payment_method ENUM('Chuyển khoản', 'COD') NOT NULL,

    FOREIGN KEY(id_branch) REFERENCES branch(id),
    FOREIGN KEY(id_seller) REFERENCES user(id),
    FOREIGN KEY(id_client) REFERENCES user(id)
);


-- Create table orders_item
CREATE TABLE orders_item(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_orders INT NOT NULL,
    id_item INT NOT NULL,
    quantity INT NOT NULL,

    FOREIGN KEY(id_orders) REFERENCES orders(id),
    FOREIGN KEY(id_item) REFERENCES item(id)
);
