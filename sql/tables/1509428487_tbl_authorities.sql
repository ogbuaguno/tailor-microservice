CREATE TABLE `native_fittings_test`.`authorities` (
  `id` INT NOT NULL auto_increment,
  `role_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`role_id`) REFERENCES roles(`id`),
  FOREIGN KEY (`permission_id`) REFERENCES permissions(`id`));