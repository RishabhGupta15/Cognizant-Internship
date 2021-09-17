/**** Create database ****/
CREATE DATABASE IF NOT EXISTS criteriadb;

/**** Use the newly created database ****/
USE criteriadb;

/**** Create the table ****/
CREATE TABLE employee (
	id INT(50) NOT NULL AUTO_INCREMENT, 
	name VARCHAR(200) DEFAULT NULL, 
	designation VARCHAR(200) DEFAULT NULL,
	department VARCHAR(200) DEFAULT NULL,
	PRIMARY KEY (id)
);

/**** Insert the data ****/
INSERT INTO employee (id, name, designation, department) VALUES (1, 'Mike', 'Software Developer', 'Software Development');
INSERT INTO employee (id, name, designation, department) VALUES (2, 'David', 'Team Lead', 'Software Development');
INSERT INTO employee (id, name, designation, department) VALUES (3, 'Peter', 'Manager', 'Human Resources');
INSERT INTO employee (id, name, designation, department) VALUES (4, 'Andrew', 'VP', 'Human Resources');
INSERT INTO employee (id, name, designation, department) VALUES (5, 'Jane', 'VP', 'Software Development');
INSERT INTO employee (id, name, designation, department) VALUES (6, 'Ariana', 'Software Developer', 'Software Development');
INSERT INTO employee (id, name, designation, department) VALUES (7, 'Elsa', 'Manager', 'Administation');