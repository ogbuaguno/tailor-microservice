USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_role_by_name`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_role_by_name`(name VARCHAR(50))
BEGIN
	SELECT * FROM roles r WHERE r.name = name;
END$$