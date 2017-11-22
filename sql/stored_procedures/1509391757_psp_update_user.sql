USE native_fittings_test;
DROP PROCEDURE IF EXISTS `update_user`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `update_user`(id INT, first_name VARCHAR(50), last_name VARCHAR(50),
                                                             email VARCHAR(100), mobile_no VARCHAR(50), password VARCHAR(100), billing_address_id INT,
                                                             shipping_address_id INT, role_id INT, measurement_id INT)
    BEGIN
        UPDATE users u
        SET u.first_name = first_name, u.last_name = last_name, u.email = email, u.mobile_no = mobile_no,
            u.password = password, u.billing_address_id = billing_address_id, u.shipping_address_id = shipping_address_id,
            u.role_id = role_id, u.updated_on = NOW(), u.measurement_id = measurement_id
        WHERE u.id = id;

        SELECT * FROM users u WHERE u.id = id;
    END$$