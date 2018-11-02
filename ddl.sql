CREATE TABLE objective (
objective TINYTEXT NOT NULL);

CREATE TABLE summary (
summary TINYTEXT NOT NULL);

CREATE TABLE education (
id INTEGER NOT NULL PRIMARY KEY,
school_name TINYTEXT NOT NULL,
school_city VARCHAR(20) NOT NULL,
school_state VARCHAR(20) NOT NULL,
degree TINYTEXT NOT NULL,
major TINYTEXT NOT NULL,
grad_month VARCHAR(15) NOT NULL,
grad_year INTEGER NOT NULL,
is_anticipated boolean);

CREATE TABLE personal_info (
first_name TINYTEXT NOT NULL,
last_name TINYTEXT NOT NULL,
email TINYTEXT NOT NULL,
street1 TINYTEXT NOT NULL,
street2 TINYTEXT,
city TINYTEXT NOT NULL,
state TINYTEXT NOT NULL,
zip TINYTEXT NOT NULL);