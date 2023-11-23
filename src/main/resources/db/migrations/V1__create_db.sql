CREATE TABLE IF NOT EXISTS client(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(200) constraint client_name_chk check(length(name) >= 3)


);
CREATE TABLE IF NOT EXISTS planet(
    id VARCHAR(255) PRIMARY KEY AUTO_INCREMENT
        constraint planet_id_chk CHECK(id REGEXP '^[A-Z0-9]+$'),
    name VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS ticket(
    id INT PRIMARY KEY AUTO_INCREMENT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES client(id),
    from_planet_id VARCHAR(255),
    FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    to_planet_id VARCHAR(255),
    FOREIGN KEY (to_planet_id) REFERENCES planet(id)
    );