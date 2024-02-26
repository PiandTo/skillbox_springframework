CREATE DATABASE users;

-- USE DATABASE users;

CREATE SCHEMA users_schema;

CREATE TABLE
    users_schema.user (
        ID BIGINT NOT NULL AUTO_INCREMENT,
        name VARCHAR(255) NOT NULL,
        surname VARCHAR(255) NOT NULL,
        patronymic VARCHAR(255) NOT NULL,
        gender VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        phone_number VARCHAR(255) NOT NULL,
        login VARCHAR(255) NOT NULL,
        avatar VARCHAR(255) NOT NULL,
        description VARCHAR(255) NOT NULL,
        PRIMARY KEY (ID)
    )

CREATE TABLE
    users_schema.address (
        ID BIGINT NOT NULL AUTO_INCREMENT,
        city VARCHAR(255) NOT NULL,
        street VARCHAR(255) NOT NULL,
        building VARCHAR(255) NOT NULL,
        PRIMARY KEY (ID)
    )