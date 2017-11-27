SET MODE MySQL;

--
-- Table structure for table `tbl_weather`
--

DROP TABLE IF EXISTS `tbl_weather`;

CREATE TABLE `tbl_weather` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `destination_id` bigint(20) NOT NULL,
  `weather_date` DATE NOT NULL,
  `weather_type` VARCHAR(255) NOT NULL,
  `temperature` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);
