CREATE TABLE address (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         index INT,
                         city VARCHAR(255) NOT NULL,
                         street VARCHAR(255) NOT NULL,
                         house_number INT NOT NULL,
                         apartment_number INT
);