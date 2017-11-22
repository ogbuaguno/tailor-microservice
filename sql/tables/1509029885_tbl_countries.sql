USE native_fittings;

CREATE TABLE IF NOT EXISTS `countries`(
 `id` INT NOT NULL auto_increment,
 `name` VARCHAR(50) NOT NULL,
 PRIMARY KEY(`id`)
);