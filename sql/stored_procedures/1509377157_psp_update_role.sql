USE native_fittings_test;
DROP PROCEDURE IF EXISTS `update_role`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `update_role`(id INT, name VARCHAR(50), description VARCHAR(256))
BEGIN
	  UPDATE roles r
    SET r.name = name, r.description = description
    WHERE r.id = id;

    SELECT * FROM roles r WHERE r.id = id;
END$$