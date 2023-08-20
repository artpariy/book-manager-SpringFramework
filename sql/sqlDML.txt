INSERT INTO publishers (id, name) 
VALUES (1, 'Jonathan Cape(UK)');

INSERT INTO country(id, name)
VALUES(1, 'Scotland');

INSERT INTO language(id, name)
VALUES(1, 'English');

INSERT INTO books (name, author, publisher_id, country_id, language_id, publication_date, isbn, price)
VALUES ('Glue', 'Irvine Welsh', 1, 1, 1, '2001-05-17', '978-0393322156', 5.99);
