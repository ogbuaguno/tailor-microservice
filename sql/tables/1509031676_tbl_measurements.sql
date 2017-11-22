USE native_fittings;

CREATE TABLE IF NOT EXISTS `measurements`(
 `id` INT NOT NULL auto_increment,
 `biceps` INT NOT NULL,
 `chest` INT NOT NULL,
 `blazer_length` INT NOT NULL,
 `crotch` INT NOT NULL,
 `hip` INT NOT NULL,
 `knee` INT NOT NULL,
 `neck` INT NOT NULL,
 `pants_length` INT NOT NULL,
 `shoulders` INT NOT NULL,
 `sleeve` INT NOT NULL,
 `stomach` INT NOT NULL,
 `thigh` INT NOT NULL,
 `wrist` INT NOT NULL,
 PRIMARY KEY(`id`)
);