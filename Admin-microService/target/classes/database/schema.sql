CREATE TABLE IF NOT EXISTS admins (
     email VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS admin_decisions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    coordinator_email VARCHAR(255) NOT NULL,
    admin_email VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    reason VARCHAR(1000),
    decision_date TIMESTAMP NOT NULL
    );