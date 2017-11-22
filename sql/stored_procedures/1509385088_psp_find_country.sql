USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_country`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_country`(id INT)
BEGIN
	SELECT * FROM countries c WHERE c.id = id;
END$$