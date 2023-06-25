CREATE TABLE branch_company (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                name VARCHAR(255) NOT NULL,
                                address_id BIGINT NOT NULL,
                                company_head_id BIGINT,
                                FOREIGN KEY (address_id) REFERENCES address (id),
                                FOREIGN KEY (company_head_id) REFERENCES company (id)
);