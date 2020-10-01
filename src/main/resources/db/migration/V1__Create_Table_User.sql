CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(200) COLLATE utf8_bin NOT NULL UNIQUE,
  `email` varchar(80) COLLATE utf8_bin NOT NULL UNIQUE,
  `password` varchar(80) COLLATE utf8_bin NOT NULL,
  `role` ENUM('ADMIN', 'STUDENT', 'TEACHER') COLLATE utf8_bin NOT NULL,
  `date_of_birth` date NOT NULL,
  `age` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gender` ENUM('MALE', 'FEMALE', 'OTHER') COLLATE utf8_bin NOT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
)
