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
VALUES(1, 'X??ng ??an');
INSERT INTO category(id, name)
VALUES(2, 'Sneaker');
INSERT INTO category(id, name)
VALUES(3, 'Gi??y th??? thao');
INSERT INTO category(id, name)
VALUES(4, 'Gi??y ??i h???c');
INSERT INTO category(id, name)
VALUES(5, 'D??p quai ngang');
INSERT INTO category(id, name)
VALUES(6, 'Gi??y th???i trang');
INSERT INTO category(id, name)
VALUES(7, 'Gi??y l?????i');


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
VALUES(4, 'V???i canvas');
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
VALUES(1, 'X??m');
INSERT INTO color(id, name)
VALUES(2, '??en');
INSERT INTO color(id, name)
VALUES(3, 'Xanh l?? c??y');
INSERT INTO color(id, name)
VALUES(4, '?????');
INSERT INTO color(id, name)
VALUES(5, 'H???ng');
INSERT INTO color(id, name)
VALUES(6, 'Tr???ng');
INSERT INTO color(id, name)
VALUES(7, 'Xanh n?????c bi???n');
INSERT INTO color(id, name)
VALUES(8, 'Xanh l??');


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
VALUES(2, 'N???');
INSERT INTO gender(id, name)
VALUES(3, 'Unisex');
INSERT INTO gender(id, name)
VALUES(4, 'Tr??? em');


-- Insert into item and relational tables
-- Item 1
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    1,
    -- name
    'Kappa x??ng ??an nam 361511W A12',
    -- description
    'X??NG ??AN NAM KAPPA 361511W A12 XANH NAVY ??m ch??n, ??m ??i, n??ng ?????ng
X??NG ??AN NAM KAPPA 361511W A12 XANH NAVY mang thi???t k??? basic, c??c ch??? c??i Kappa in n???i b???t tr??n th??n gi??y. S???n ph???m nh???, m???m, ??m ??i, d??? d??ng di chuy???n v?? l???i r???t th???i trang, c?? th??? ph???i c??ng nhi???u trang ph???c kh??c nhau.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    1,
    -- id_brand
    1,
    -- status
    'C??n h??ng',
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
    'Ecko Unltd gi??y sneakers nam/n??? OF21-28008 RED',
    -- description
    'S???n ph???m ph?? h???p cho c??? Nam v?? N???',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/6/361511w-a12-1.jpg',
    -- id_category
    2,
    -- id_brand
    2,
    -- status
    'C??n h??ng',
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
    'Ecko Unltd gi??y th??? thao n??? OF21-24021 PINK',
    -- description
    'Thu???c b??? s??u t???p gi??y Thu ????ng 2021 m???i nh???t c???a ECKO UNLTD.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/o/f/of21-24021_fw21_pink_9-1.jpg',
    -- id_category
    3,
    -- id_brand
    2,
    -- status
    'H???t h??ng',
    -- id_gender
    2,
    -- quantity
    0
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
    'Kappa Gi??y ??i h???c tr??? em 6-12 tu???i 304WMI0 XANH NAVY',
    -- description
    'Sneakers Back To School tr??? em, gi??y ??i h???c gi?? r??? th???i trang, cho b?? trai v?? b?? g??i.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/0/304u310-a00-20.jpg',
    -- id_category
    2,
    -- id_brand
    1,
    -- status
    'C??n h??ng',
    -- id_gender
    4,
    -- quantity
    17
);
INSERT INTO price(id_item, price, date)
VALUES (4, 443450, '2022-02-19');
INSERT INTO item_material(id_item, id_material)
VALUES(4, 8);
INSERT INTO item_size(id_item, id_size)
VALUES(4, 31);
INSERT INTO item_size(id_item, id_size)
VALUES(4, 32);
INSERT INTO item_size(id_item, id_size)
VALUES(4, 33);
INSERT INTO item_size(id_item, id_size)
VALUES(4, 34);
INSERT INTO item_size(id_item, id_size)
VALUES(4, 35);
INSERT INTO item_color(id_item, id_color)
VALUES(4, 7);
INSERT INTO item_color(id_item, id_color)
VALUES(4, 2);
INSERT INTO item_color(id_item, id_color)
VALUES(4, 6);

-- Item 5
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    5,
    -- name
    'Kappa Gi??y ??i h???c tr??? em 6-12 tu???i 304WMI0 TR???NG',
    -- description
    'Sneakers Back To School tr??? em th???i trang, cho b?? trai v?? b?? g??i.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/0/304wmi0_001-6.jpg',
    -- id_category
    4,
    -- id_brand
    1,
    -- status
    'H???t h??ng',
    -- id_gender
    4,
    -- quantity
    0
);
INSERT INTO price(id_item, price, date)
VALUES (5, 443450, '2022-02-19');
INSERT INTO item_material(id_item, id_material)
VALUES(5, 8);
INSERT INTO item_size(id_item, id_size)
VALUES(5, 31);
INSERT INTO item_size(id_item, id_size)
VALUES(5, 32);
INSERT INTO item_size(id_item, id_size)
VALUES(5, 33);
INSERT INTO item_size(id_item, id_size)
VALUES(5, 34);
INSERT INTO item_size(id_item, id_size)
VALUES(5, 35);
INSERT INTO item_color(id_item, id_color)
VALUES(5, 6);
INSERT INTO item_color(id_item, id_color)
VALUES(5, 2);
INSERT INTO item_color(id_item, id_color)
VALUES(5, 7);

-- Item 6
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    6,
    -- name
    'Superga gi??y l?????i n??? 221SSWS_S00GJB0 F83',
    -- description
    'Thi???t k???: V???i thi???t k??? thanh l???ch, form d??ng ?????c tr??ng c???a phong c??ch gi??y Superga c??ng v???i logo Superga v???i in tinh t??? ???????c g???n v??o th??n gi??y ???? tr??? th??nh ??i???m nh???n d???ng kinh ??i???n cho th????ng hi???u ?? h??n 100 n??m.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/2/2/221ssws_s00gjb0_f83_1.jpg',
    -- id_category
    7,
    -- id_brand
    3,
    -- status
    'Li??n h???',
    -- id_gender
    2,
    -- quantity
    0
);
INSERT INTO price(id_item, price, date)
VALUES (6, 512050, '2022-02-19');
INSERT INTO item_material(id_item, id_material)
VALUES(6, 3);
INSERT INTO item_material(id_item, id_material)
VALUES(6, 5);
INSERT INTO item_size(id_item, id_size)
VALUES(6, 35);
INSERT INTO item_size(id_item, id_size)
VALUES(6, 36);
INSERT INTO item_size(id_item, id_size)
VALUES(6, 37);
INSERT INTO item_size(id_item, id_size)
VALUES(6, 38);
INSERT INTO item_size(id_item, id_size)
VALUES(6, 39);
INSERT INTO item_color(id_item, id_color)
VALUES(6, 2);
INSERT INTO item_color(id_item, id_color)
VALUES(6, 6);

-- Item 7
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    7,
    -- name
    'Kappa d??p quai ngang nam/n??? 304JPP0 A0W',
    -- description
    'D??P QUAI NGANG NAM/ N??? KAPPA 304JPP0 A0W ??EN-V??NG gi?? m???m, ??m ch??n, th???i trang
    D??P QUAI NGANG NAM/ N??? KAPPA 304JPP0 A0W ??EN-V??NG mang thi???t k??? basic, v???i d???i banda in n???i b???t tr??n quai d??p. S???n ph???m nh???, m???m, v?? c??ng ??m ??i, d??? d??ng di chuy???nv?? l???i r???t th???i trang.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/0/304jpp0-a0w-1.jpg',
    -- id_category
    5,
    -- id_brand
    1,
    -- status
    'C??n h??ng',
    -- id_gender
    3,
    -- quantity
    95
);
INSERT INTO price(id_item, price, date)
VALUES (7, 271600, '2022-02-19');
INSERT INTO item_material(id_item, id_material)
VALUES(7, 1);
INSERT INTO item_material(id_item, id_material)
VALUES(7, 9);
INSERT INTO item_size(id_item, id_size)
VALUES(7, 42);
INSERT INTO item_color(id_item, id_color)
VALUES(7, 7);
INSERT INTO item_color(id_item, id_color)
VALUES(7, 8);

-- Item 8
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    8,
    -- name
    'Kappa d??p quai ngang nam/n??? 304JPU0_CQ1 A0Y',
    -- description
    'D??P QUAI NGANG NAM/ N??? KAPPA 304JPU0_CQ1 A0Y X??M-??EN gi?? m???m, ??m ch??n, th???i trang
    D??P QUAI NGANG NAM/ N??? KAPPA 304JPU0_CQ1 A0Y X??M-??EN mang thi???t k??? basic, v???i d???i banda in n???i b???t tr??n th??n d??p. S???n ph???m nh???, m???m, v?? c??ng ??m ??i, d??? d??ng di chuy???nv?? l???i r???t th???i trang.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/3/0/304jpu0_cq1-a0y-1.jpg',
    -- id_category
    5,
    -- id_brand
    1,
    -- status
    'H???t h??ng',
    -- id_gender
    3,
    -- quantity
    0
);
INSERT INTO price(id_item, price, date)
VALUES (8, 271600, '2022-02-19');
INSERT INTO item_material(id_item, id_material)
VALUES(8, 1);
INSERT INTO item_material(id_item, id_material)
VALUES(8, 9);
INSERT INTO item_size(id_item, id_size)
VALUES(8, 39);
INSERT INTO item_color(id_item, id_color)
VALUES(8, 6);
INSERT INTO item_color(id_item, id_color)
VALUES(8, 2);
INSERT INTO item_color(id_item, id_color)
VALUES(8, 7);

-- Item 9
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    9,
    -- name
    'Superga gi??y th???i trang c??? th???p unisex 219SSU3_S00GS90 XPR',
    -- description
    'Gi??y ????? cao su n??? gi?? r??? th???i trang Unisex Superga c??? th???p, v???i ch???t li???u ????? l??m t??? cao su t??? nhi??n ch???ng tr??n tr?????t t???t, h???n ch??? m??i m??n, c??ng di chuy???n c??ng ????n h???i, b???n b??? theo th???i gian. Thi???t k??? thanh l???ch, form d??ng ?????c tr??ng c???a phong c??ch gi??y Superga c??ng logo Superga v???i in tinh t??? ???????c g???n v??o th??n gi??y ???? tr??? th??nh ??i???m nh???n d???ng kinh ??i???n cho th????ng hi???u ?? h??n 100 n??m, k???t h???p m??u s???c trung t??nh, d??? ph???i ?????. D??nh cho c??c b???n tr??? y??u th??ch phong ????i gi??y ????? cao su nam gi?? r??? n??ng ?????ng, m???i l???, nh??ng kh??ng k??m ph???n tr??? trung, c?? t??nh.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/2/1/219ssu3_s00gs90-xpr-1_ljz9-41.jpg',
    -- id_category
    6,
    -- id_brand
    3,
    -- status
    'Li??n h???',
    -- id_gender
    2,
    -- quantity
    0
);
INSERT INTO price(id_item, price, date)
VALUES (9, 580650, '2022-02-19');
INSERT INTO item_material(id_item, id_material)
VALUES(9, 3);
INSERT INTO item_size(id_item, id_size)
VALUES(9, 39);
INSERT INTO item_color(id_item, id_color)
VALUES(9, 1);
INSERT INTO item_color(id_item, id_color)
VALUES(9, 2);

-- Item 10
INSERT INTO item(id, name, description, image, id_category, id_brand, status, id_gender, quantity)
VALUES (
    -- id
    10,
    -- name
    'Superga gi??y l?????i n??? 221SSWS_S00GJB0 901',
    -- description
    '??? B??? s??u t???p: 2750
??? Ch???t li???u: ????? ngo??i: 100% Cao su; B??? m???t: 100% Cotton; L???p l??t: 100% Cotton. V???i b??ng tinh khi???t, tho??ng kh?? c??ng ????? ngo??i cao su t??? nhi??n l??u h??a b???n b???, ch???ng tr??n tr?????t t???t.
??? Thi???t k???: V???i thi???t k??? thanh l???ch, form d??ng ?????c tr??ng c???a phong c??ch gi??y Superga c??ng v???i logo Superga v???i in tinh t??? ???????c g???n v??o th??n gi??y ???? tr??? th??nh ??i???m nh???n d???ng kinh ??i???n cho th????ng hi???u ?? h??n 100 n??m.
??? ????? cao: 2 cm
??? S???n xu???t t???i: Vi???t Nam.
??? Xu???t x??? th????ng hi???u: Italia.',
    -- image
    'https://cdn.hoang-phuc.com/media/catalog/product/cache/911a4dad289f521f5a511212882e4276/2/2/221ssws_s00gjb0_901_5.jpg',
    -- id_category
    7,
    -- id_brand
    3,
    -- status
    'C??n h??ng',
    -- id_gender
    2,
    -- quantity
    108
);
INSERT INTO price(id_item, price, date)
VALUES (10, 512050, '2022-02-19');
INSERT INTO item_material(id_item, id_material)
VALUES(10, 3);
INSERT INTO item_material(id_item, id_material)
VALUES(10, 5);
INSERT INTO item_size(id_item, id_size)
VALUES(10, 35);
INSERT INTO item_size(id_item, id_size)
VALUES(10, 36);
INSERT INTO item_size(id_item, id_size)
VALUES(10, 37);
INSERT INTO item_size(id_item, id_size)
VALUES(10, 38);
INSERT INTO item_size(id_item, id_size)
VALUES(10, 39);
INSERT INTO item_color(id_item, id_color)
VALUES(10, 6);
INSERT INTO item_color(id_item, id_color)
VALUES(10, 2);


-- Insert into users
INSERT INTO users(id, name, username, password, email, mobile, id_gender, dob, start_at, status, address, role)
VALUES(
    -- id
    1,
    -- name
    'D????ng',
    -- username
    'duongphamhn97',
    -- password
    '123',
    -- email
    'duongphamhn97@gmail.com',
    -- mobile
    '0847138967',
    -- id_gender
    1,
    -- dob
    '1997-09-19',
    -- start_at
    NULL,
    -- status
    'Ch??a mua h??ng',
    -- address
    'H?? N???i',
    -- role
    'Kh??ch h??ng'
);

INSERT INTO users(id, name, username, password, email, mobile, id_gender, dob, start_at, status, address, role)
VALUES(
    -- id
    2,
    -- name
    'San',
    -- username
    'sannl',
    -- password
    '123',
    -- email
    'sannl@shoe.com',
    -- mobile
    '0123456789',
    -- id_gender
    2,
    -- dob
    '1998-03-15',
    -- start_at
    '2022-02-19',
    -- status
    '??ang l??m vi???c',
    -- address
    'H?? N???i',
    -- role
    'Nh??n vi??n'
);
