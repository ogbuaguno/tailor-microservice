USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_address`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_address`(id INT)
BEGIN
	SELECT * FROM addresses a WHERE a.id = id;
END$$