USE native_fittings;

CREATE TABLE IF NOT EXISTS `users`(
 `id` INT NOT NULL auto_increment,
 `first_name` VARCHAR(50) NOT NULL,
 `last_name` VARCHAR(50) NOT NULL,
 `email` VARCHAR(100) NOT NULL UNIQUE,
 `mobile_no` VARCHAR(15) NOT NULL UNIQUE,
 `billing_address_id` INT NOT NULL,
 `shipping_address_id` INT NOT NULL,
 `role_id` INT NOT NULL,
 `measurement_id` INT UNIQUE,
 PRIMARY KEY(`id`),
 FOREIGN KEY(`billing_address_id`) REFERENCES addresses(`id`),
 FOREIGN KEY(`shipping_address_id`) REFERENCES addresses(`id`),
 FOREIGN KEY(`role_id`) REFERENCES native_fittings.roles(`id`),
 FOREIGN KEY(`measurement_id`) REFERENCES measurements(`id`)
);