USE native_fittings;

CREATE TABLE IF NOT EXISTS `roles`(
 `id` INT NOT NULL auto_increment,
 `name` VARCHAR(50) NOT NULL,
 `description` VARCHAR(256) NOT NULL,
 PRIMARY KEY(`id`)
);