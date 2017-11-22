USE native_fittings_test;
DROP PROCEDURE IF EXISTS `update_user_login`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `update_user_login`(id INT)
BEGIN
	UPDATE users u
    SET u.last_login = NOW()
    WHERE u.id = id;
END$$