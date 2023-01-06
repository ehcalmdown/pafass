-- drop database if exists kwikmart; ENABLE ONLY ON INITIAL LAUNCH

create database kwikmart;

use kwikmart;

CREATE TABLE `customers` (
	`name` VARCHAR(32),
	`address` VARCHAR(128),
	`email` VARCHAR(128),

	PRIMARY KEY (`name`)
    
);

-- COPY data FROM 'database\data.csv' DELIMITER ':'; this is for postgre, not avail on certain systems
-- LOAD DATA INFILE 'database/data.csv' INTO TABLE customers FIELDS TERMINATED BY  ':';
LOAD DATA LOCAL INFILE 'C:/Users/holyy/OneDrive/Desktop/vttp/projects/assprep/eshop/database/data.csv' INTO TABLE customers FIELDS TERMINATED BY  ':';

CREATE TABLE `order_table` (
	`name` VARCHAR(32),
	`orderId` VARCHAR(16),
	`orderDate` DATE(20),
	`item` VARCHAR(32),
	`quantity` INT(128) DEFAULT '1',
	PRIMARY KEY (`name`)
);
