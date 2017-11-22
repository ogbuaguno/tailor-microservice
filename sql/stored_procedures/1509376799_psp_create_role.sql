USE native_fittings_test;
DROP PROCEDURE IF EXISTS `create_role`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `create_role`(name VARCHAR(50),description VARCHAR(256))
    BEGIN
        INSERT INTO `roles` (name, description) VALUES (name, description);
        SELECT * FROM roles WHERE id = last_insert_id();
END$$