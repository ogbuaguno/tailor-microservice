USE native_fittings_test;

CREATE TABLE IF NOT EXISTS `address_types`(
 `id` INT NOT NULL auto_increment,
 `type` VARCHAR(50) NOT NULL,
 PRIMARY KEY(`id`)
);