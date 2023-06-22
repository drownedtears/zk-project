CREATE TABLE company_head (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              legal_form VARCHAR(255),
                              address_id BIGINT NOT NULL,
                              FOREIGN KEY (address_id) REFERENCES address (id)
);