ALTER TABLE `native_fittings`.`users`
ADD COLUMN `password` VARCHAR(100) NOT NULL AFTER `mobile_no`,
ADD COLUMN `created_on` VARCHAR(45) NOT NULL AFTER `measurement_id`,
ADD COLUMN `updated_on` VARCHAR(45) NULL AFTER `created_on`,
ADD COLUMN `last_login` VARCHAR(45) NULL AFTER `updated_on`;
