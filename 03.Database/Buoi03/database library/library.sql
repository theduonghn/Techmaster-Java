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
    return_date DATE NOT NULL,

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
