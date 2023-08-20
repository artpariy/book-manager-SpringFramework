CREATE TABLE books (
	id bigserial PRIMARY KEY,
	name varchar(100) NOT NULL,
	author varchar(60) NOT NULL,
	publisher_id integer REFERENCES publishers(id),
	country_id integer REFERENCES country(id),
	language_id integer REFERENCES language(id),
	publication_date date NOT NULL,
	isbn varchar(20) NOT NULL,
	price double precision NOT NULL
);


CREATE TABLE publishers (
	id integer PRIMARY KEY,
	name varchar(150) NOT NULL
);

CREATE TABlE country (
	id integer PRIMARY KEY,
	name varchar(50) NOT NULL
);

CREATE TABLE language(
	id integer PRIMARY KEY,
	name varchar(50) NOT NULL
);
