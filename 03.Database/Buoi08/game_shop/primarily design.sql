CREATE table game(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name TEXT NOT NULL,
	year INT,
	id_developer INT,
	id_publisher INT,
	price BIGINT,
	status TEXT NOT NULL,
	description TEXT NOT NULL
)

tag(
	id PK,
	name
)

category(
	id PK,
	name
)

discuss(
	id PK,
	id_game,
	id_user,
	content
)

rating(
	id PK,
	id_game,
	id_user,
	point
)

users(
	id PK,
	username,
	email,
	password,
	gender,
	dob,
	address,
	bank_account,
	status,
)

role()

users_role()

orders(
	id PK,
	id_product,
	id_user
)
