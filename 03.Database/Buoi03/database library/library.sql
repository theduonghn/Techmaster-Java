-- Create database library
CREATE DATABASE library;

-- Create table shelf
CREATE TABLE shelf(
    id INT PRIMARY KEY AUTO_INCREMENT,
    number INT NOT NULL
);

-- Create table publishing_company
CREATE TABLE publishing_company(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    address TEXT NOT NULL,
    phone TEXT
);

-- Create table document
CREATE TABLE document(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    id_publishing_company INT NOT NULL,
    pages TEXT NOT NULL,
    year TEXT NOT NULL,
    price BIGINT NOT NULL,
    quantity INT NOT NULL,
    id_shelf INT NOT NULL,

    FOREIGN KEY(id_publishing_company) REFERENCES publishing_company(id),
    FOREIGN KEY(id_shelf) REFERENCES shelf(id)
);

-- Create table category
CREATE TABLE category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL
);

-- Create table document_category
CREATE TABLE document_category(
    id_document INT,
    id_category INT,

    PRIMARY KEY(id_document, id_category),

    FOREIGN KEY(id_document) REFERENCES document(id),
    FOREIGN KEY(id_category) REFERENCES category(id)
);

-- Create table author
CREATE TABLE author(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    gender ENUM('Male', 'Female') NOT NULL,
    address TEXT,
    email TEXT,
    mobile TEXT,
    year_of_birth INT,
    year_of_death INT
);

-- Create table document_author
CREATE TABLE document_author(
    id_document INT,
    id_author INT,

    PRIMARY KEY(id_document, id_author),

    FOREIGN KEY(id_document) REFERENCES document(id),
    FOREIGN KEY(id_author) REFERENCES author(id)
);

-- Create table employee
CREATE TABLE employee(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    gender ENUM('Male', 'Female') NOT NULL,
    address TEXT NOT NULL,
    email TEXT NOT NULL,
    mobile TEXT NOT NULL,
    date_of_birth DATE NOT NULL,
    status ENUM('Working', 'Leaved', 'Leaving temporarily', 'Retired') NOT NULL,
    start_at DATE NOT NULL,
    salary BIGINT NOT NULL,
    role INT NOT NULL -- 1: admin, 2: manager, 3: librarian
);

-- Create table reader
CREATE TABLE reader(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    gender ENUM('Male', 'Female') NOT NULL,
    address TEXT NOT NULL,
    email TEXT NOT NULL,
    mobile TEXT NOT NULL,
    date_of_birth DATE NOT NULL,
    status ENUM('Normal', 'Banned from the library', 'Banned from borrow documents home') NOT NULL
);

-- Create table reader_document
CREATE TABLE reader_document(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_reader INT NOT NULL,
    id_document INT NOT NULL,
    borrow_quantity INT NOT NULL,
    return_quantity INT NOT NULL,
    borrow_date DATE NOT NULL,

    FOREIGN KEY(id_reader) REFERENCES reader(id),
    FOREIGN KEY(id_document) REFERENCES document(id)
);

-- Create table borrow_slip
CREATE TABLE borrow_slip(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_employee INT NOT NULL,
    id_reader INT NOT NULL,
    type ENUM('At place', 'Bring home'),
    borrow_date DATE NOT NULL,
    last_date_to_return DATE NOT NULL,

    FOREIGN KEY(id_employee) REFERENCES employee(id),
    FOREIGN KEY(id_reader) REFERENCES reader(id)
);

-- Create table borrow_slip_document
CREATE TABLE borrow_slip_document(
    id_borrow_slip INT,
    id_document INT,
    quantity INT NOT NULL,

    PRIMARY KEY(id_borrow_slip, id_document),

    FOREIGN KEY(id_borrow_slip) REFERENCES borrow_slip(id),
    FOREIGN KEY(id_document) REFERENCES document(id)
);

-- Create table return_slip
CREATE TABLE return_slip(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_employee INT NOT NULL,
    id_reader INT NOT NULL,
    borrow_date DATE NOT NULL,
    return_date DATE NOT NULL,

    FOREIGN KEY(id_employee) REFERENCES employee(id),
    FOREIGN KEY(id_reader) REFERENCES reader(id)
);

-- Create table return_slip_document
CREATE TABLE return_slip_document(
    id_return_slip INT,
    id_document INT,
    quantity INT NOT NULL,

    PRIMARY KEY(id_return_slip, id_document),

    FOREIGN KEY(id_return_slip) REFERENCES return_slip(id),
    FOREIGN KEY(id_document) REFERENCES document(id)
);

-- Create table fine
CREATE TABLE fine(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_employee INT NOT NULL,
    id_reader INT NOT NULL,
    date DATE NOT NULL,
    reason TEXT NOT NULL,
    type ENUM('Pay documents', 'Pay money', 'Ban') NOT NULL,

    FOREIGN KEY(id_employee) REFERENCES employee(id),
    FOREIGN KEY(id_reader) REFERENCES reader(id)
);

-- Create table fine_document
CREATE TABLE fine_document(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_fine INT NOT NULL,
    id_document INT NOT NULL,
    quantity INT NOT NULL,

    FOREIGN KEY(id_fine) REFERENCES fine(id),
    FOREIGN KEY(id_document) REFERENCES document(id)
);

-- Create table fine_money
CREATE TABLE fine_money(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_fine INT NOT NULL,
    amount BIGINT NOT NULL,

    FOREIGN KEY(id_fine) REFERENCES fine(id)
);

-- Create table fine_ban
CREATE TABLE fine_ban(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_fine INT NOT NULL,
    type ENUM('Ban from the library', 'Ban from borrow documents home'),
    days INT NOT NULL,

    FOREIGN KEY(id_fine) REFERENCES fine(id)
);


-- Insert into shelf
INSERT INTO shelf(number) VALUES(1); -- id: 1
INSERT INTO shelf(number) VALUES(2); -- id: 2
INSERT INTO shelf(number) VALUES(3); -- id: 3

-- Insert into publishing_company
INSERT INTO publishing_company(name, address, phone) -- id: 1
VALUES('Nhà Xuất Bản Thế Giới', '46 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội', '024 3825 3841');
INSERT INTO publishing_company(name, address, phone) -- id: 2
VALUES('Nhà Xuất Bản Thanh Niên', '64 Bà Triệu, Hoàn Kiếm, Hà Nội', '090 455 83 69');

-- Insert into document
INSERT INTO document(name, id_publishing_company, pages, year, price, quantity, id_shelf) -- id: 1
VALUES('Kỷ Luật Tự Giác', 1, 216, 2020, 57000, 11, 1);
INSERT INTO document(name, id_publishing_company, pages, year, price, quantity, id_shelf) -- id: 2
VALUES('Ám Ảnh Sợ Xã Hội - Chạy Trốn Hay Đối Mặt', 2, 304, 2021, 88900, 12, 2);
INSERT INTO document(name, id_publishing_company, pages, year, price, quantity, id_shelf) -- id: 3
VALUES('1 Ngày Bằng 48 Giờ - Sổ tay Quản Lí Thời Gian Hiệu Quả', 2, 208, 2021, 54000, 2, 3);

-- Insert into category
INSERT INTO category(name) VALUES('Sách Tiếng Việt'); -- id: 1
INSERT INTO category(name) VALUES('Sách kĩ năng sống'); -- id: 2
INSERT INTO category(name) VALUES('Sách tư duy'); -- id: 3
INSERT INTO category(name) VALUES('Sách quản lý thời gian'); -- id: 4
INSERT INTO category(name) VALUES('Sách tâm lý'); -- id: 5

-- Insert into document_category
INSERT INTO document_category(id_document, id_category) VALUES(1, 1);
INSERT INTO document_category(id_document, id_category) VALUES(1, 2);
INSERT INTO document_category(id_document, id_category) VALUES(1, 3);
INSERT INTO document_category(id_document, id_category) VALUES(2, 1);
INSERT INTO document_category(id_document, id_category) VALUES(2, 2);
INSERT INTO document_category(id_document, id_category) VALUES(2, 5);
INSERT INTO document_category(id_document, id_category) VALUES(3, 1);
INSERT INTO document_category(id_document, id_category) VALUES(3, 2);
INSERT INTO document_category(id_document, id_category) VALUES(3, 4);

-- Insert into author
INSERT INTO author(name, gender, address, email, mobile, year_of_birth, year_of_death)
VALUES('Tiểu Dã', 'Female', 'Trung Quốc', 'xiao@gmail.com', NULL, 1990, NULL);
INSERT INTO author(name, gender, address, email, mobile, year_of_birth, year_of_death)
VALUES('Lý Thế Cường', 'Male', 'Việt Nam', 'cuong@gmail.com', '01234567841', 1985, NULL);
INSERT INTO author(name, gender, address, email, mobile, year_of_birth, year_of_death)
VALUES('Instant Research Institude', 'Male', 'Hoa Kì', 'iri@gmail.com', NULL, 1974, NULL);

-- Insert into document_author
INSERT INTO document_author(id_document, id_author) VALUES(1, 1);
INSERT INTO document_author(id_document, id_author) VALUES(2, 2);
INSERT INTO document_author(id_document, id_author) VALUES(3, 3);

-- Insert into employee
INSERT INTO employee(name, gender, address, email, mobile, date_of_birth, status, start_at, salary, role)
VALUES('Linh', 'Female', 'Hà Nội', 'linh@gmail.com', '0123548964', '1999-08-13', 'Working', '2021-02-21', 8000000, 3);
INSERT INTO employee(name, gender, address, email, mobile, date_of_birth, status, start_at, salary, role)
VALUES('Nam', 'Male', 'Hải Phòng', 'nam@gmail.com', '0215493154', '1986-07-14', 'Leaved', '2013-01-19', 15000000, 1);
INSERT INTO employee(name, gender, address, email, mobile, date_of_birth, status, start_at, salary, role)
VALUES('Nga', 'Female', 'Bắc Ninh', 'nga@gmail.com', '0216523987', '1955-09-04', 'Retired', '1995-07-09', 13500000, 2);

-- Insert into reader
INSERT INTO reader(name, gender, address, email, mobile, date_of_birth, status)
VALUES('Vu', 'Male', 'Thanh Hoá', 'vu@gmail.com', '01323597415', '1997-05-17', 'Banned from the library');
INSERT INTO reader(name, gender, address, email, mobile, date_of_birth, status)
VALUES('Trang', 'Female', 'Nam Định', 'trang@gmail.com', '0132527841', '1995-09-21', 'Normal');

-- Insert into reader_document
INSERT INTO reader_document(id_reader, id_document, borrow_quantity, return_quantity, borrow_date)
VALUES(1, 1, 2, 0, '2021-09-15');
INSERT INTO reader_document(id_reader, id_document, borrow_quantity, return_quantity, borrow_date)
VALUES(2, 2, 1, 1, '2022-01-02');
INSERT INTO reader_document(id_reader, id_document, borrow_quantity, return_quantity, borrow_date)
VALUES(2, 3, 1, 0, '2022-02-12');

-- Insert into borrow_slip
INSERT INTO borrow_slip(id_employee, id_reader, type, borrow_date, last_date_to_return)
VALUES(1, 1, 'Bring home', '2021-09-15', '2021-09-29');
INSERT INTO borrow_slip(id_employee, id_reader, type, borrow_date, last_date_to_return)
VALUES(1, 2, 'At place', '2022-01-02', '2022-01-02');
INSERT INTO borrow_slip(id_employee, id_reader, type, borrow_date, last_date_to_return)
VALUES(1, 2, 'Bring home', '2022-012-12', '2022-02-24');

-- Insert into borrow_slip_document
INSERT INTO borrow_slip_document(id_borrow_slip, id_document, quantity)
VALUES(1, 1, 2);
INSERT INTO borrow_slip_document(id_borrow_slip, id_document, quantity)
VALUES(2, 2, 1);
INSERT INTO borrow_slip_document(id_borrow_slip, id_document, quantity)
VALUES(3, 3, 1);

-- Insert into return_slip
INSERT INTO return_slip(id_employee, id_reader, borrow_date, return_date)
VALUES(1, 2, '2022-01-02', '2022-01-02');

-- Insert into return_slip_document
INSERT INTO return_slip_document(id_return_slip, id_document, quantity)
VALUES(1, 2, 1);

-- Insert into fine
INSERT INTO fine(id_employee, id_reader, date, reason, type) -- id: 1
VALUES(1, 1, '2021-09-29', 'Làm mất sách', 'Pay documents');
INSERT INTO fine(id_employee, id_reader, date, reason, type) -- id: 2
VALUES(1, 1, '2021-09-29', 'Làm mất sách', 'Pay money');
INSERT INTO fine(id_employee, id_reader, date, reason, type) -- id: 3
VALUES(1, 1, '2021-10-18', 'Phá hoại tài sản thư viện', 'Ban');

-- Insert into fine_document
INSERT INTO fine_document(id_fine, id_document, quantity)
VALUES(1, 1, 1);

-- Insert into fine_money
INSERT INTO fine_money(id_fine, amount)
VALUES(2, 57000);

-- Insert into fine_ban
INSERT INTO fine_ban(id_fine, type, days)
VALUES(3, 'Ban from the library', 365);
