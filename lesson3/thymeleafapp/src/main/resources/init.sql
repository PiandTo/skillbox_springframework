DROP SCHEMA IF EXISTS thymeleaf CASCADE;

-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
-- CREATE EXTENSION pgcrypto;

CREATE SCHEMA thymeleaf;

CREATE TABLE thymeleaf.contact (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid (),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(50),
    phone VARCHAR(50)
);

INSERT INTO
    thymeleaf.contact
VALUES (
        '5a9f9f9f-9f9f-9f9f-9f9f-9f9f9f9f9f9f',
        'John1',
        'Doe',
        'XWv4M@example.com',
        '123-456-7890'
    );

INSERT INTO
    thymeleaf.contact
VALUES (
        '94fd9e28-74b7-419a-b19c-ebcea2f3647f',
        'Jane2',
        'Doe',
        'XWv4M@example.com',
        '123-456-7890'
    );

INSERT INTO
    thymeleaf.contact
VALUES (
        'b5779a5c-a214-44ee-9ff2-4f7defdcb89e',
        'Joe3',
        'Doe',
        'XWv4M@example.com',
        '123-456-7890'
    );