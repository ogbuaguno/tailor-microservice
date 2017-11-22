ALTER TABLE `native_fittings_test`.`addresses` 
ADD COLUMN `user_id` INT NOT NULL AFTER `id`,
ADD COLUMN `address_type` VARCHAR(20) NOT NULL AFTER `user_id`,
ADD FOREIGN KEY (`user_id`) REFERENCES users(`id`);