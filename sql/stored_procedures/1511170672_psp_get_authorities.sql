USE native_fittings_test;
DROP PROCEDURE IF EXISTS `get_authorities`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `get_authorities`(role_id INT)
BEGIN
	SELECT r.name AS role_name, group_concat(p.name separator ',')
    AS permissionNames FROM roles r
    INNER JOIN authorities au ON au.role_id = r.id
    INNER JOIN permissions p ON p.id = au.permission_id
    WHERE r.id = role_id
    GROUP BY r.name;
END$$