
ALTER TABLE `native_fittings_test`.`users`
CHANGE COLUMN `created_on` `created_on` DATETIME NOT NULL ,
CHANGE COLUMN `updated_on` `updated_on` DATETIME NULL DEFAULT NULL ,
CHANGE COLUMN `last_login` `last_login` DATETIME NULL DEFAULT NULL ;