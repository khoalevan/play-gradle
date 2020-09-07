CREATE TABLE sunworld.supplier (
	id INT auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	code varchar(100) NOT NULL,
	CONSTRAINT supplier_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_unicode_ci;
ALTER TABLE sunworld.supplier ADD config TEXT NULL;


-- RENAME TABLE sunworld.ca_account TO sunworld.supplier;

-- ALTER TABLE sunworld.devices CHANGE ca_id supplier_id int(11) DEFAULT 1 NULL;

ALTER TABLE sunworld.devices ADD supplier_id INT DEFAULT 1 NULL;

ALTER TABLE sunworld.users ADD supplier_id INT DEFAULT 1 NOT NULL;

ALTER TABLE sunworld.facilities ADD supplier_id INT DEFAULT 1 NOT NULL;

ALTER TABLE sunworld.facilities ADD config TEXT NULL;