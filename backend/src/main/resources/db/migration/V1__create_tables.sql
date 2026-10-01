CREATE TABLE health_insurances (
    id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(100) NOT NULL UNIQUE,
    active BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE patients (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(150) NOT NULL,
    cpf         VARCHAR(11)  NOT NULL UNIQUE,
    health_insurance_id BIGINT NULL,
    CONSTRAINT fk_patient_health_insurance
        FOREIGN KEY (health_insurance_id) REFERENCES health_insurances(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;