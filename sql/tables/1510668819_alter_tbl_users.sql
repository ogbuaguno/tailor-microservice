ALTER TABLE `native_fittings_test`.`users`
DROP FOREIGN KEY `users_ibfk_2`,
DROP FOREIGN KEY `users_ibfk_1`;
ALTER TABLE `native_fittings_test`.`users`
DROP COLUMN `shipping_address_id`,
DROP COLUMN `billing_address_id`,
DROP INDEX `shipping_address_id` ,
DROP INDEX `billing_address_id` ;