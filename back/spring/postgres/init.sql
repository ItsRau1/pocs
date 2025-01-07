CREATE TABLE IF NOT EXISTS check_in (
    id VARCHAR(36) PRIMARY KEY,
    plate VARCHAR(20),
    location VARCHAR(255),
    cost NUMERIC(36,2),
    check_in_date TIMESTAMP,
    check_out_date TIMESTAMP
);
