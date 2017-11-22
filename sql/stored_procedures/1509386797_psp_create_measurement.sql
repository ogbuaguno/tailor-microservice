USE native_fittings_test;
DROP PROCEDURE IF EXISTS `create_measurement`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `create_measurement`(biceps INT, chest INT, blazer_length INT, crotch INT, hip INT,
knee INT, neck INT, pants_length INT, shoulders INT, sleeve INT, stomach INT, thigh INT,
wrist INT)
    BEGIN
        INSERT INTO `measurements` (biceps, chest, blazer_length, crotch, hip, knee, neck,
        pants_length, shoulders, sleeve, stomach, thigh, wrist)
        VALUES (biceps, chest, blazer_length, crotch, hip, knee, neck,
        pants_length, shoulders, sleeve, stomach, thigh, wrist) ;
        SELECT * FROM measurements WHERE id = last_insert_id();
END$$