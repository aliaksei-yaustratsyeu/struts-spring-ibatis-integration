CREATE TABLE employees (
    id INT(10) unsigned NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    PRIMARY KEY (id),
    INDEX employees_ix1 (first_name),
    INDEX employees_ix2 (last_name),
    INDEX employees_ix3 (first_name, last_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;