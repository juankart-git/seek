CREATE TABLE IF NOT EXISTS candidates(
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    gender VARCHAR(255),
    salary_expected VARCHAR(255),
    birthday DATE,
    phone VARCHAR(255),
    document_number INTEGER
);

