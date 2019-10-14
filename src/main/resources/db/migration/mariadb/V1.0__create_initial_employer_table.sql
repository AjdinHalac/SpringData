CREATE TABLE `employer` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `uuid` binary(16) NOT NULL,
 `name` varchar(50) NOT NULL,
 `display_id` varchar(50) NOT NULL,
 `email` varchar(50) NOT NULL,
 `address` varchar(255) NOT NULL,
 `city` varchar(50) NOT NULL,
 `type` varchar(100) NOT NULL,
 `created_at` DATETIME NOT NULL,
 PRIMARY KEY (`id`),
  UNIQUE KEY `tnt_uuid` (uuid),
  UNIQUE KEY `tnt_dsply` (display_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8