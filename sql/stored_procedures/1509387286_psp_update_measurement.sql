USE native_fittings_test;
DROP PROCEDURE IF EXISTS `update_measurement`;

DELIMITER $$
CREATE DEFINER=`sohsoft`@`localhost` PROCEDURE `update_measurement`(id INT, biceps INT, chest INT, blazer_length INT, crotch INT, hip INT,
knee INT, neck INT, pants_length INT, shoulders INT, sleeve INT, stomach INT, thigh INT,
wrist INT)
    BEGIN
        UPDATE measurements m
        SET m.biceps = biceps, m.chest =  chest, m.blazer_length = blazer_length, m.crotch = crotch,
        m.hip = hip, m.knee = knee, m.neck = neck, m.pants_length = pants_length, m.shoulders = shoulders,
        m.sleeve = sleeve, m.stomach = stomach, m.thigh = thigh, m.wrist = wrist
        WHERE m.id = id;

        SELECT * FROM measurements WHERE m.id = id;
END$$