CREATE TABLE IF NOT EXISTS check_in (
    id VARCHAR(36) PRIMARY KEY,
    plate VARCHAR(20),
    location VARCHAR(255),
    check_in_date TIMESTAMP with TIME ZONE,
    check_out_date TIMESTAMP with TIME ZONE
);
