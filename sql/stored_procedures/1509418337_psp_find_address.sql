USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_address`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_address`(id INT)
BEGIN
	SELECT a.*, c.name AS country_name FROM addresses a
    INNER JOIN countries c ON c.id = a.country_id
    WHERE a.id = id;
END$$
DELIMITER ;