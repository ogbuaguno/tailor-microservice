USE native_fittings_test;
DROP PROCEDURE IF EXISTS `create_address`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`locfind_addressalhost` PROCEDURE `create_address`(user_id INT, address_type VARCHAR(20),
        address VARCHAR(100), city VARCHAR(20), state VARCHAR(20), country_id INT, zip_code VARCHAR(10))
BEGIN
        INSERT INTO `addresses` (user_id, address_type, address, city, state, country_id, zip_code)
        VALUES (user_id, address_type, address, city, state, country_id, zip_code);

        SELECT * FROM addresses WHERE id = last_insert_id();
END$$