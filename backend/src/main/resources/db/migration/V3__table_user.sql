CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(30) NOT NULL
);

ALTER TABLE patients
    ADD COLUMN user_id BIGINT UNIQUE,
    ADD CONSTRAINT fk_patients_users_id
        FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE doctors
    ADD COLUMN user_id BIGINT UNIQUE,
    ADD CONSTRAINT fk_doctors_users_id
        FOREIGN KEY (user_id) REFERENCES users(id);