DROP TABLE IF EXISTS Book;


CREATE TABLE `Book`(
`id` int NOT NULL,
`name` VARCHAR(255) DEFAULT NULL,
`title` VARCHAR(255) DEFAULT NULL,
 PRIMARY KEY (`id`)
 );