ALTER TABLE patients
    MODIFY COLUMN name VARCHAR(100) NOT NULL,
    ADD COLUMN email VARCHAR(100) NOT NULL,
    ADD COLUMN phone VARCHAR(20) NOT NULL;

CREATE TABLE doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    crm VARCHAR(20) UNIQUE NOT NULL,
    speciality VARCHAR(50) NOT NULL,
    health_insurance_id BIGINT NULL,
    CONSTRAINT fk_doctor_health_insurance_id
        FOREIGN KEY (health_insurance_id) REFERENCES health_insurances(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
