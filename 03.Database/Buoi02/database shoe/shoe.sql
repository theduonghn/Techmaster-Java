-- Create database shoe
CREATE DATABASE shoe


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
    id_category INT,
    id_brand INT,
    status TEXT NOT NULL,
    id_gender INT,
    quantity INT NOT NULL,

    FOREIGN KEY(id_category) REFERENCES category(id),
    FOREIGN KEY(id_brand) REFERENCES brand(id),
    FOREIGN KEY(id_gender) REFERENCES gender(id)
);


-- Create table price
CREATE TABLE price(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_item INT,
    price BIGINT NOT NULL,
    date DATE,

    FOREIGN KEY(id_item) REFERENCES item(id)
);


-- Create table material
CREATE TABLE material(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);


-- Create table item_material
CREATE TABLE item_material(
    id_item INT,
    id_material INT,

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
    id_item INT,
    id_size INT,

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
    id_item INT,
    id_color INT,

    PRIMARY KEY(id_item, id_color),

    FOREIGN KEY(id_item) REFERENCES item(id),
    FOREIGN KEY(id_color) REFERENCES color(id)
);


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
);


-- Insert into category
INSERT INTO category(id, name)
VALUES(1, 'Xăng đan');
INSERT INTO category(id, name)
VALUES(2, 'Sneaker');
INSERT INTO category(id, name)
VALUES(3, 'Giày thể thao');
INSERT INTO category(id, name)
VALUES(4, 'Giày đi học');
INSERT INTO category(id, name)
VALUES(5, 'Dép quai ngang');
INSERT INTO category(id, name)
VALUES(6, 'Giày thời trang');
INSERT INTO category(id, name)
VALUES(7, 'Giày lười');


-- Insert into brand
INSERT INTO brand(id, name)
VALUES(1, 'Kappa');
INSERT INTO brand(id, name)
VALUES(2, 'Ecko Unltd');
INSERT INTO brand(id, name)
VALUES(3, 'Superga');


-- Insert into material
INSERT INTO material(id, name)
VALUES(1, 'PVC');
INSERT INTO material(id, name)
VALUES(2, 'Polyester');
INSERT INTO material(id, name)
VALUES(3, 'Cao su');
INSERT INTO material(id, name)
VALUES(4, 'Vải canvas');
INSERT INTO material(id, name)
VALUES(5, 'Cotton');
INSERT INTO material(id, name)
VALUES(6, 'PU/MESH');
INSERT INTO material(id, name)
VALUES(7, 'EVA/TPR');
INSERT INTO material(id, name)
VALUES(8, 'PU');
INSERT INTO material(id, name)
VALUES(9, 'PE');


-- Insert into color
INSERT INTO color(id, name)
VALUES(1, 'Xám');
INSERT INTO color(id, name)
VALUES(2, 'Đen');
INSERT INTO color(id, name)
VALUES(3, 'Xanh lá cây');
INSERT INTO color(id, name)
VALUES(4, 'Đỏ');
INSERT INTO color(id, name)
VALUES(5, 'Hồng');
INSERT INTO color(id, name)
VALUES(6, 'Trắng');
INSERT INTO color(id, name)
VALUES(7, 'Xanh nước biển');
INSERT INTO color(id, name)
VALUES(8, 'Xanh lơ');


-- Insert into size
INSERT INTO size(id, size)
VALUES(30, 30);
INSERT INTO size(id, size)
VALUES(31, 31);
INSERT INTO size(id, size)
VALUES(32, 32);
INSERT INTO size(id, size)
VALUES(33, 33);
INSERT INTO size(id, size)
VALUES(34, 34);
INSERT INTO size(id, size)
VALUES(35, 35);
INSERT INTO size(id, size)
VALUES(36, 36);
INSERT INTO size(id, size)
VALUES(37, 37);
INSERT INTO size(id, size)
VALUES(38, 38);
INSERT INTO size(id, size)
VALUES(39, 39);
INSERT INTO size(id, size)
VALUES(40, 40);
INSERT INTO size(id, size)
VALUES(41, 41);
INSERT INTO size(id, size)
VALUES(42, 42);
INSERT INTO size(id, size)
VALUES(43, 43);
INSERT INTO size(id, size)
VALUES(44, 44);
INSERT INTO size(id, size)
VALUES(45, 45);
INSERT INTO size(id, size)
VALUES(46, 46);
INSERT INTO size(id, size)
VALUES(47, 47);
INSERT INTO size(id, size)
VALUES(48, 48);
INSERT INTO size(id, size)
VALUES(49, 49);
INSERT INTO size(id, size)
VALUES(50, 50);


-- Insert into gender
INSERT INTO gender(id, name)
VALUES(1, 'Nam');
INSERT INTO gender(id, name)
VALUES(2, 'Nữ');
INSERT INTO gender(id, name)
VALUES(3, 'Unisex');
INSERT INTO gender(id, name)
VALUES(4, 'Trẻ em');


-- Insert into item and relational tables
-- Item 1
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    1,
    -- name
    'Kappa xăng đan nam 361511W A12',
    -- description
    'XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY ôm chân, êm ái, năng động
XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY mang thiết kế basic, các chữ cái Kappa in nổi bật trên thân giày. Sản phẩm nhẹ, mềm, êm ái, dễ dàng di chuyển và lại rất thời trang, có thể phối cùng nhiều trang phục khác nhau.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    1,
    -- id_brand
    1,
    -- status
    'Còn hàng',
    -- id_gender
    1,
    -- quantity
    35
);
INSERT INTO price(id_item, price, date)
VALUES (1, 580650, '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(1, 1);
INSERT INTO item_material(id_item, id_material)
VALUES(1, 2);
INSERT INTO item_size(id_item, id_size)
VALUES(1, 39);
INSERT INTO item_size(id_item, id_size)
VALUES(1, 40);
INSERT INTO item_size(id_item, id_size)
VALUES(1, 41);
INSERT INTO item_size(id_item, id_size)
VALUES(1, 42);
INSERT INTO item_size(id_item, id_size)
VALUES(1, 43);
INSERT INTO item_color(id_item, id_color)
VALUES(1, 1);
INSERT INTO item_color(id_item, id_color)
VALUES(1, 2);
INSERT INTO item_color(id_item, id_color)
VALUES(1, 3);

-- Item 2
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    2,
    -- name
    'Ecko Unltd giày sneakers nam/nữ OF21-28008 RED',
    -- description
    'Sản phẩm phù hợp cho cả Nam và Nữ',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    2,
    -- id_brand
    2,
    -- status
    'Còn hàng',
    -- id_gender
    3,
    -- quantity
    91
);
INSERT INTO price(id_item, price, date)
VALUES (2, 409640, '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(2, 3);
INSERT INTO item_size(id_item, id_size)
VALUES(2, 40);
INSERT INTO item_size(id_item, id_size)
VALUES(2, 41);
INSERT INTO item_size(id_item, id_size)
VALUES(2, 42);
INSERT INTO item_size(id_item, id_size)
VALUES(2, 43);
INSERT INTO item_size(id_item, id_size)
VALUES(2, 44);
INSERT INTO item_color(id_item, id_color)
VALUES(2, 4);
INSERT INTO item_color(id_item, id_color)
VALUES(2, 6);

-- Item 3
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    3,
    -- name
    'Ecko Unltd giày thể thao nữ OF21-24021 PINK',
    -- description
    'Thuộc bộ sưu tập giày Thu Đông 2021 mới nhất của ECKO UNLTD.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/o/f/of21-24021_fw21_pink_9-1.jpg',
    -- id_category
    3,
    -- id_brand
    2,
    -- status
    'Hết hàng',
    -- id_gender
    2,
    -- quantity
    74
);
INSERT INTO price(id_item, price, date)
VALUES (3, 786800, '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(3, 6);
INSERT INTO item_material(id_item, id_material)
VALUES(3, 7);
INSERT INTO item_size(id_item, id_size)
VALUES(3, 36);
INSERT INTO item_size(id_item, id_size)
VALUES(3, 37);
INSERT INTO item_size(id_item, id_size)
VALUES(3, 38);
INSERT INTO item_size(id_item, id_size)
VALUES(3, 39);
INSERT INTO item_color(id_item, id_color)
VALUES(3, 5);
INSERT INTO item_color(id_item, id_color)
VALUES(3, 6);
INSERT INTO item_color(id_item, id_color)
VALUES(3, 2);

-- Item 4
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    4,
    -- name
    'Kappa xăng đan nam 361511W A12',
    -- description
    'XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY ôm chân, êm ái, năng động
XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY mang thiết kế basic, các chữ cái Kappa in nổi bật trên thân giày. Sản phẩm nhẹ, mềm, êm ái, dễ dàng di chuyển và lại rất thời trang, có thể phối cùng nhiều trang phục khác nhau.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    1,
    -- id_brand
    1,
    -- status
    'Còn hàng',
    -- id_gender
    1,
    -- quantity
    35
);
INSERT INTO price(id_item, price, date)
VALUES (4, , '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(4, );
INSERT INTO item_size(id_item, id_size)
VALUES(4, );
INSERT INTO item_color(id_item, id_color)
VALUES(4, );

-- Item 5
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    5,
    -- name
    'Kappa xăng đan nam 361511W A12',
    -- description
    'XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY ôm chân, êm ái, năng động
XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY mang thiết kế basic, các chữ cái Kappa in nổi bật trên thân giày. Sản phẩm nhẹ, mềm, êm ái, dễ dàng di chuyển và lại rất thời trang, có thể phối cùng nhiều trang phục khác nhau.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    1,
    -- id_brand
    1,
    -- status
    'Còn hàng',
    -- id_gender
    1,
    -- quantity
    35
);
INSERT INTO price(id_item, price, date)
VALUES (5, , '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(5, );
INSERT INTO item_size(id_item, id_size)
VALUES(5, );
INSERT INTO item_color(id_item, id_color)
VALUES(5, );

-- Item 6
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    6,
    -- name
    'Kappa xăng đan nam 361511W A12',
    -- description
    'XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY ôm chân, êm ái, năng động
XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY mang thiết kế basic, các chữ cái Kappa in nổi bật trên thân giày. Sản phẩm nhẹ, mềm, êm ái, dễ dàng di chuyển và lại rất thời trang, có thể phối cùng nhiều trang phục khác nhau.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    1,
    -- id_brand
    1,
    -- status
    'Còn hàng',
    -- id_gender
    1,
    -- quantity
    35
);
INSERT INTO price(id_item, price, date)
VALUES (6, , '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(6, );
INSERT INTO item_size(id_item, id_size)
VALUES(6, );
INSERT INTO item_color(id_item, id_color)
VALUES(6, );

-- Item 7
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    7,
    -- name
    'Kappa xăng đan nam 361511W A12',
    -- description
    'XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY ôm chân, êm ái, năng động
XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY mang thiết kế basic, các chữ cái Kappa in nổi bật trên thân giày. Sản phẩm nhẹ, mềm, êm ái, dễ dàng di chuyển và lại rất thời trang, có thể phối cùng nhiều trang phục khác nhau.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    1,
    -- id_brand
    1,
    -- status
    'Còn hàng',
    -- id_gender
    1,
    -- quantity
    35
);
INSERT INTO price(id_item, price, date)
VALUES (7, , '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(7, );
INSERT INTO item_size(id_item, id_size)
VALUES(7, );
INSERT INTO item_color(id_item, id_color)
VALUES(7, );

-- Item 8
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    8,
    -- name
    'Kappa xăng đan nam 361511W A12',
    -- description
    'XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY ôm chân, êm ái, năng động
XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY mang thiết kế basic, các chữ cái Kappa in nổi bật trên thân giày. Sản phẩm nhẹ, mềm, êm ái, dễ dàng di chuyển và lại rất thời trang, có thể phối cùng nhiều trang phục khác nhau.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    1,
    -- id_brand
    1,
    -- status
    'Còn hàng',
    -- id_gender
    1,
    -- quantity
    35
);
INSERT INTO price(id_item, price, date)
VALUES (8, , '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(8, );
INSERT INTO item_size(id_item, id_size)
VALUES(8, );
INSERT INTO item_color(id_item, id_color)
VALUES(8, );

-- Item 9
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    9,
    -- name
    'Kappa xăng đan nam 361511W A12',
    -- description
    'XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY ôm chân, êm ái, năng động
XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY mang thiết kế basic, các chữ cái Kappa in nổi bật trên thân giày. Sản phẩm nhẹ, mềm, êm ái, dễ dàng di chuyển và lại rất thời trang, có thể phối cùng nhiều trang phục khác nhau.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    1,
    -- id_brand
    1,
    -- status
    'Còn hàng',
    -- id_gender
    1,
    -- quantity
    35
);
INSERT INTO price(id_item, price, date)
VALUES (9, , '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(9, );
INSERT INTO item_size(id_item, id_size)
VALUES(9, );
INSERT INTO item_color(id_item, id_color)
VALUES(9, );

-- Item 10
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    10,
    -- name
    'Kappa xăng đan nam 361511W A12',
    -- description
    'XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY ôm chân, êm ái, năng động
XĂNG ĐAN NAM KAPPA 361511W A12 XANH NAVY mang thiết kế basic, các chữ cái Kappa in nổi bật trên thân giày. Sản phẩm nhẹ, mềm, êm ái, dễ dàng di chuyển và lại rất thời trang, có thể phối cùng nhiều trang phục khác nhau.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    1,
    -- id_brand
    1,
    -- status
    'Còn hàng',
    -- id_gender
    1,
    -- quantity
    35
);
INSERT INTO price(id_item, price, date)
VALUES (10, , '2022-02-18');
INSERT INTO item_material(id_item, id_material)
VALUES(10, );
INSERT INTO item_size(id_item, id_size)
VALUES(10, );
INSERT INTO item_color(id_item, id_color)
VALUES(10, );


-- Insert into users
