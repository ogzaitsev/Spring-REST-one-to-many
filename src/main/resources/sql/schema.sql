CREATE SCHEMA d_chief
    CREATE TABLE departments(
        id SERIAL PRIMARY KEY,
        department_name VARCHAR(64) NOT NULL,
        description VARCHAR(256),
        max_salary INT,
        min_salary INT
    )
    CREATE TABLE employees(
        id SERIAL PRIMARY KEY,
        department_id INT REFERENCES departments(id),
        first_name VARCHAR(64) NOT NULL,
        last_name VARCHAR(64) NOT NULL,
        salary INT
    );
