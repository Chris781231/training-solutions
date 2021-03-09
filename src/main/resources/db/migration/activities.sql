CREATE TABLE `activities` (
    `id` BIGINT AUTO_INCREMENT,
    `start_time` DATETIME NOT NULL,
    `activity_desc` VARCHAR(500),
    `activity_type` ENUM('BIKING','HIKING','RUNNING','BASKETBALL'),
    PRIMARY KEY(`id`)
);