USE native_fittings;
DROP PROCEDURE IF EXISTS `create_permission`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `create_permission`(name VARCHAR(50),description VARCHAR(256))
    BEGIN
        INSERT INTO `permissions` (name, description) VALUES (name, description);
        SELECT * FROM permissions WHERE id = last_insert_id();
    END$$