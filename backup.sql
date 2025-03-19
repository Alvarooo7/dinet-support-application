CREATE TABLE IF NOT EXISTS application (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL,
    brand VARCHAR(255) NOT NULL,
    request_type VARCHAR(255) NOT NULL,
    submission_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS contact (
    id SERIAL PRIMARY KEY,
    contact_name VARCHAR(255) NOT NULL,
    contact_number VARCHAR(20) NOT NULL,
    application_code VARCHAR(20) NOT NULL
);

INSERT INTO application (id, code, brand, request_type, submission_date) VALUES
(1, 'APP-DINETAAA3', 'Toyota', 'Warranty Claim', '2025-03-18'),
(3, 'APP-DINETDFC3', 'Toyota', 'Sedan', '2025-03-14');

INSERT INTO contact (id, contact_name, contact_number, application_code) VALUES
(1, 'Jane Smith', '+987654321', 'APP-DINETAAA3'),
(2, 'Mike Johnson', '+1122334455', 'APP-DINETAAA3'),
(3, 'Pepe', '7474474', 'APP-DINETDFC3');

