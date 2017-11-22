USE native_fittings;
DROP PROCEDURE IF EXISTS `update_permission`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `update_permission`(id INT, name VARCHAR(50), description VARCHAR(256))
    BEGIN
        UPDATE permissions p
        SET p.name = name, p.description = description
        WHERE p.id = id;

        SELECT * FROM permissions p WHERE p.id = id;
    END$$