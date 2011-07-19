CREATE TABLE IF NOT EXISTS `users` (
`username` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
`enabled` tinyint(1) NOT NULL,
PRIMARY KEY (`username`)
);

CREATE TABLE IF NOT EXISTS `groups` (
`id` int(11) NOT NULL default '0',
`group_name` varchar(255) default NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `group_members` (
`group_id` int(11) NOT NULL default '0',
`username` varchar(255) default NULL,
PRIMARY KEY (`group_id`, `username`)
);

CREATE TABLE IF NOT EXISTS `group_authorities` (
`group_id` int(11) NOT NULL default '0',
`authority` varchar(255) NOT NULL default '',
PRIMARY KEY (`group_id`,`authority`)
);