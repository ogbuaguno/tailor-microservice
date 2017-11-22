USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_measurement`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_measurement`(id INT)
BEGIN
	SELECT * FROM measurements m WHERE m.id = id;
END$$