USE native_fittings_test;
DROP PROCEDURE IF EXISTS `create_country`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `create_country`(name VARCHAR(50))
    BEGIN
        INSERT INTO `countries` (name) VALUES (name);
        SELECT * FROM countries WHERE id = last_insert_id();
END$$