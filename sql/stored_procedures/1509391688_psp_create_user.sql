USE native_fittings_test;
DROP PROCEDURE IF EXISTS `create_user`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `create_user`(first_name VARCHAR(50), last_name VARCHAR(50),
email VARCHAR(100), mobile_no VARCHAR(50), password VARCHAR(100), billing_address_id INT,
shipping_address_id INT, role_id INT, measurement_id INT)
    BEGIN
        INSERT INTO `users`(first_name, last_name, email, mobile_no, password, billing_address_id,
        shipping_address_id, role_id, measurement_id, created_on)
        VALUES (first_name, last_name, email, mobile_no, password, billing_address_id,
        shipping_address_id, role_id, measurement_id, NOW()) ;

        SELECT * FROM users WHERE id = last_insert_id();
END$$