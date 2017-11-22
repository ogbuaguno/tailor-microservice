USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_country_by_name`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_country_by_name`(name VARCHAR(50))
BEGIN
	SELECT * FROM countries c WHERE c.name = name;
END$$