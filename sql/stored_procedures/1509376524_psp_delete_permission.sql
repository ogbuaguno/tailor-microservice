USE native_fittings_test;
DROP PROCEDURE IF EXISTS `delete_permission`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `delete_permission`(id INT)
BEGIN

	DELETE FROM permissions WHERE permissions.id = id;
END$$