DROP database IF EXISTS cruise_company;

CREATE database cruise_company;

USE cruise_company;

CREATE TABLE liners
(
    name VARCHAR(20) NOT NULL UNIQUE,
    passengers Integer NOT NULL,
    crew Integer NOT NULL,
    id BIGINT PRIMARY KEY auto_increment

);

CREATE TABLE cruises
(
    name VARCHAR(20) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    liner_id BIGINT NOT NULL,
    id BIGINT PRIMARY KEY auto_increment
);

CREATE TABLE roles
(
  name VARCHAR(20),
  id BIGINT PRIMARY KEY auto_increment
);

CREATE TABLE users
(
    login VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role_id BIGINT NOT NULL,
    id BIGINT PRIMARY KEY auto_increment,
    FOREIGN KEY (role_id) REFERENCES roles (id)

);
CREATE TABLE applications
(
    login VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    birthdate DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    id BIGINT PRIMARY KEY auto_increment,
    FOREIGN KEY (login) references users (login)
);

INSERT INTO liners VALUES ('Ship 1', 100, 20, DEFAULT);
INSERT INTO liners VALUES ('Ship 2', 200, 40, DEFAULT);
INSERT INTO cruises VALUES ('Route 1', '2022-01-01 15:00:00', '2022-01-21 15:00:00', 1, DEFAULT);
INSERT INTO cruises VALUES ('Route 2', '2022-01-01 15:00:00', '2022-01-21 15:00:00', 2, DEFAULT);
INSERT INTO roles VALUES ('admin', DEFAULT);
INSERT INTO roles VALUES ('client', DEFAULT);
INSERT INTO users VALUES ('user1', MD5('adminpass'), 1, DEFAULT);
INSERT INTO users VALUES ('user2', MD5('user2pass'), 2, DEFAULT);
INSERT INTO users VALUES ('user3', MD5('user3pass'), 2, DEFAULT);
INSERT INTO users VALUES ('user4', MD5('user4pass'), 2, DEFAULT);

SELECT * FROM liners;
SELECT * FROM cruises;
SELECT * FROM users;
SELECT * FROM roles;
select * FROM applications;
