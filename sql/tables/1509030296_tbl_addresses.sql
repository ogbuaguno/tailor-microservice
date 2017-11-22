USE native_fittings;

CREATE TABLE IF NOT EXISTS `addresses`(
 `id` INT NOT NULL auto_increment,
 `address` VARCHAR(100) NOT NULL,
 `state` VARCHAR(20) NOT NULL,
 `country_id` INT NOT NULL,
 `zip_code` VARCHAR(10) NOT NULL,
 PRIMARY KEY(`id`),
 FOREIGN KEY(`country_id`) REFERENCES countries(`id`)
);