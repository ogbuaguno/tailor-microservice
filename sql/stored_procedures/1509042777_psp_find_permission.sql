USE native_fittings;
DROP PROCEDURE IF EXISTS `find_permission`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_permission`(id INT)
	BEGIN
		SELECT * FROM permissions p WHERE p.id = id;
	END$$