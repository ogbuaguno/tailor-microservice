USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_user`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_user`(id INT)
BEGIN
	SELECT * FROM users u WHERE u.id = id;
END$$