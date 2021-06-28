CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL UNIQUE,
  `cpf` varchar(11) NOT NULL UNIQUE,
  `email` varchar(80) NOT NULL UNIQUE,
  `password` varchar(80) NOT NULL,
  `role` ENUM('ADMIN', 'STUDENT', 'TEACHER') NOT NULL,
  `date_of_birth` date,
  `age` varchar(255) DEFAULT NULL,
  `gender` ENUM('MALE', 'FEMALE', 'OTHER') NOT NULL,
  `active` bit(1) DEFAULT 1 NOT NULL,
  PRIMARY KEY (`id`)
)
