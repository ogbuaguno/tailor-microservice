USE native_fittings_test;
DROP PROCEDURE IF EXISTS `create_address`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `create_address`(address VARCHAR(100),
city VARCHAR(20), state VARCHAR(20), country_id INT, zip_code VARCHAR(10))
    BEGIN
        INSERT INTO `addresses` (address, city, state, country_id, zip_code)
		    VALUES (address, city, state, country_id, zip_code);
        SELECT * FROM addresses WHERE id = last_insert_id();
END$$