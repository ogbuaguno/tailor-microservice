USE native_fittings_test;
DROP PROCEDURE IF EXISTS `update_address`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `update_address`(id INT, address VARCHAR(100),
city VARCHAR(20), state VARCHAR(20), country_id INT, zip_code VARCHAR(10))
BEGIN
	UPDATE addresses a
    SET a.address = address, a.city = city, a.state = state,
    a.country_id = country_id, a.zip_code = zip_code
    WHERE a.id = id;

    SELECT * FROM addresses a WHERE a.id = id;
END$$