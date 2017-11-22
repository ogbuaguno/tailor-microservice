USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_role`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_role`(id INT)
BEGIN
	SELECT * FROM roles r WHERE r.id = id;
END$$