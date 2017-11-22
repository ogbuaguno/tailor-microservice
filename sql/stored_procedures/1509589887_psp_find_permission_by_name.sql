USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_permission_by_name`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_permission_by_name`(name VARCHAR(50))
BEGIN
	SELECT * FROM permisisons p WHERE p.name = name;
END$$