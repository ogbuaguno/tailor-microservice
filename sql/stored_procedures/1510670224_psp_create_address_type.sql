USE native_fittings_test;
DROP PROCEDURE IF EXISTS `create_address_type`;


DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `create_address_type`(type VARCHAR(50))
BEGIN
        INSERT INTO `address_types` (type) VALUES (type);
        SELECT * FROM address_types WHERE id = last_insert_id();
END$$;