USE native_fittings_test;
DROP PROCEDURE IF EXISTS `find_user`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `find_user`(id INT)
BEGIN
	SELECT * FROM users u
    INNER JOIN addresses a ON a.id = u.billing_address_id AND a.id = u.shipping_address_id
    INNER JOIN countries c ON c.id = a.country_id
    LEFT JOIN measurements m ON m.id = u.measurement_id
    WHERE u.id = id;
END$$
