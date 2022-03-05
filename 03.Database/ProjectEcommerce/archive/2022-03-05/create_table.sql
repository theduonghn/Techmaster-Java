CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	username TEXT NOT NULL,
	email TEXT ,
	mobile TEXT,
	password TEXT NOT NULL,
	full_name TEXT NOT NULL,
	gender ENUM('male', 'female'),
	dob DATE,
	create_at DATE,
	status ENUM('normal', 'locked') NOT NULL
)

DROP TABLE IF EXISTS role

CREATE TABLE role(
	id INT PRIMARY KEY AUTO_INCREMENT,
	role INT NOT NULL
)

DROP TABLE IF EXISTS users_role

CREATE TABLE users_role(
	id_users INT,
	id_role INT,
	PRIMARY KEY (id_users, id_role),
	FOREIGN KEY (id_users) REFERENCES users (id) ON DELETE CASCADE,
	FOREIGN KEY (id_role) REFERENCES role (id) ON DELETE CASCADE
)

DROP TABLE IF EXISTS address 

CREATE TABLE address(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	id_users INT NOT NULL,
	FOREIGN KEY (id_users) REFERENCES users (id) ON DELETE CASCADE ,
	address TEXT NOT NULL
)

CREATE TABLE manufacturer(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	name TEXT NOT NULL
)

CREATE TABLE country(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	name TEXT NOT NULL
)

CREATE TABLE category(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	name TEXT NOT NULL
)

CREATE TABLE tag(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	name TEXT NOT NULL
)

DROP TABLE IF EXISTS shop

CREATE TABLE shop(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	id_owner INT NOT NULL,
	FOREIGN KEY(id_owner) REFERENCES users (id),
	name TEXT NOT NULL,
	address TEXT NOT NULL,
	create_at DATE,
	status ENUM('normal', 'locked') NOT NULL
)

DROP TABLE IF EXISTS product 

CREATE TABLE product(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	name TEXT NOT NULL,
	description TEXT NOT NULL,
	id_shop INT NOT NULL,
	FOREIGN KEY (id_shop) REFERENCES shop (id),
	id_category INT NOT NULL,
	FOREIGN KEY (id_category) REFERENCES category (id),
	id_manufacturer INT NOT NULL,
	FOREIGN KEY (id_manufacturer) REFERENCES manufacturer (id),
	id_country INT NOT NULL,
	FOREIGN KEY (id_country) REFERENCES country (id)
)

DROP TABLE IF EXISTS discuss 

CREATE TABLE discuss(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	id_users INT NOT NULL,
	FOREIGN KEY (id_users) REFERENCES users (id),
	id_product INT NOT NULL,
	FOREIGN KEY (id_product) REFERENCES product (id) ON DELETE CASCADE ,
	discuss TEXT NOT NULL
)

DROP TABLE IF EXISTS rating 

CREATE TABLE rating(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	id_users INT NOT NULL,
	FOREIGN KEY (id_users) REFERENCES users (id),
	id_product INT NOT NULL,
	FOREIGN KEY (id_product) REFERENCES product (id) ON DELETE CASCADE ,
	rating INT NOT NULL
)

CREATE TABLE cart(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	id_users INT NOT NULL ,
	FOREIGN KEY (id_users) REFERENCES users (id) ON DELETE CASCADE 
)

DROP TABLE IF EXISTS cart_product

CREATE TABLE cart_product(
	id_cart INT,
	id_product INT ,
	PRIMARY KEY (id_cart, id_product),
	FOREIGN KEY (id_cart) REFERENCES cart (id) ON DELETE CASCADE,
	FOREIGN KEY (id_product) REFERENCES product (id)
)

DROP TABLE IF EXISTS product_tag 

CREATE TABLE product_tag(
	id_product INT,
	id_tag INT ,
	PRIMARY KEY (id_product, id_tag),
	FOREIGN KEY (id_product) REFERENCES product (id) ON DELETE CASCADE,
	FOREIGN KEY (id_tag) REFERENCES tag (id) ON DELETE CASCADE
)

CREATE TABLE orders(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	id_users INT NOT NULL,
	FOREIGN KEY (id_users) REFERENCES users (id) ,
	date DATE,
	payment_method ENUM('debit/credit', 'cod') NOT NULL,
	status TEXT
)

DROP TABLE IF EXISTS product_orders 

CREATE TABLE product_orders(
	id_product  INT,
	id_orders INT,
	PRIMARY KEY (id_product, id_orders),
	FOREIGN KEY (id_product) REFERENCES product(id),
	FOREIGN KEY (id_orders ) REFERENCES orders (id)
)

CREATE TABLE shipper(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	name TEXT NOT NULL 
)

CREATE TABLE orders_shipper(
	id_orders INT,
	id_shipper INT,
	PRIMARY KEY (id_orders, id_shipper),
	FOREIGN KEY (id_orders) REFERENCES orders (id) ON DELETE CASCADE,
	FOREIGN KEY (id_shipper) REFERENCES shipper (id)
)

CREATE TABLE voucher(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	percent INT NOT NULL,
	min_price BIGINT,
	start_date DATE NOT NULL,
	end_date DATE
)

CREATE TABLE orders_voucher(
	id_orders INT,
	id_voucher INT,
	PRIMARY KEY (id_orders, id_voucher),
	FOREIGN KEY (id_orders) REFERENCES orders (id) ON DELETE CASCADE ,
	FOREIGN KEY (id_voucher) REFERENCES voucher (id)
)

DROP TABLE IF EXISTS price 

CREATE TABLE price(
	id INT PRIMARY KEY AUTO_INCREMENT ,
	id_product INT,
	FOREIGN KEY (id_product) REFERENCES product (id) ON DELETE CASCADE,
	price BIGINT NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE
)