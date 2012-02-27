# SQL Manager 2007 for MySQL 4.3.4.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : wbase

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `wbase`;

CREATE DATABASE `wbase`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `wbase`;

#
# Structure for the `wbase_org` table : 
#

DROP TABLE IF EXISTS `wbase_org`;

CREATE TABLE `wbase_org` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `nodeNo` BIGINT(20) NOT NULL,
  `orgNo` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  `orgName` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `orgLevel` INTEGER(11) NOT NULL,
  `subNodeNo` BIGINT(20) NOT NULL,
  `remark` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `isFlag` INTEGER(11) NOT NULL,
  `viewOrder` INTEGER(11) NOT NULL,
  `createDate` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_org` table  (LIMIT 0,500)
#

INSERT INTO `wbase_org` (`id`, `nodeNo`, `orgNo`, `orgName`, `orgLevel`, `subNodeNo`, `remark`, `isFlag`, `viewOrder`, `createDate`) VALUES 
  ('402881b930d088900130d0889ec40001',0,'organization','珠海市网佳科技有限公司',1,-1,NULL,1,0,'2011-06-27 17:57:52');
COMMIT;

#
# Structure for the `wbase_org_user` table : 
#

DROP TABLE IF EXISTS `wbase_org_user`;

CREATE TABLE `wbase_org_user` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `userAccount` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `orgNodeNo` BIGINT(20) NOT NULL,
  `createDate` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_org_user` table  (LIMIT 0,500)
#

INSERT INTO `wbase_org_user` (`id`, `userAccount`, `orgNodeNo`, `createDate`) VALUES 
  ('402881b930d4f2870130d4f46d860003','administrator',0,'2011-06-28 14:34:06'),
  ('ff8080812f85910c012f85986d140002','admin',0,'2011-06-28 10:40:28');
COMMIT;

#
# Structure for the `wbase_post` table : 
#

DROP TABLE IF EXISTS `wbase_post`;

CREATE TABLE `wbase_post` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `postNo` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `postName` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `postLevel` INTEGER(11) NOT NULL,
  `remark` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `createDate` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_post` table  (LIMIT 0,500)
#

INSERT INTO `wbase_post` (`id`, `postNo`, `postName`, `postLevel`, `remark`, `createDate`) VALUES 
  ('ff8080812f85d158012f85d4941e0002','deptmamager','部门经理',2,'','2011-06-28 00:00:00'),
  ('ff8080812f85d158012f85d4fe450003','leadmanager','总经理',1,'','2011-06-28 00:00:00'),
  ('ff8080812f85e20f012f85e426350001','employee','员工',5,'','2011-06-28 00:00:00');
COMMIT;

#
# Structure for the `wbase_post_user` table : 
#

DROP TABLE IF EXISTS `wbase_post_user`;

CREATE TABLE `wbase_post_user` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `userAccount` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `postNo` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `createDate` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_post_user` table  (LIMIT 0,500)
#

INSERT INTO `wbase_post_user` (`id`, `userAccount`, `postNo`, `createDate`) VALUES 
  ('402881b92f95eff9012f95f0371b0001','admin','employee','2011-06-28 10:40:28'),
  ('402881b930d4f2870130d4f46d7c0002','administrator','employee','2011-06-28 14:34:06');
COMMIT;

#
# Structure for the `wbase_power` table : 
#

DROP TABLE IF EXISTS `wbase_power`;

CREATE TABLE `wbase_power` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `roleNo` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `resNodeNo` BIGINT(20) NOT NULL,
  `powerLevel` INTEGER(11) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_power` table  (LIMIT 0,500)
#

INSERT INTO `wbase_power` (`id`, `roleNo`, `resNodeNo`, `powerLevel`) VALUES 
  ('1','administrator',1295576234149,62),
  ('2','administrator',1295576179149,62),
  ('402881b92f8b3b56012f8b3c8f030001','administrator',123234523,62),
  ('402881b92f8b3b56012f8b3ca2530002','administrator',1295573339392,62),
  ('402881b92f8b3b56012f8b3cca990003','administrator',1295576219769,62),
  ('402881b92f8b3b56012f8b3cf5150004','administrator',1302838010664,62),
  ('402881b92f964a9a012f964bffac0001','employee',123234523,32),
  ('402881b92f964a9a012f964c0cb40002','employee',1295573339392,32),
  ('402881b92f964a9a012f964c1d010003','employee',1295576179149,32),
  ('402881b92f964a9a012f964c2b870004','employee',1295576219769,32),
  ('402881b9302b0f3801302b10cec00002','administrator',1306392514538,62),
  ('402881b930c06c970130c0736a930006','vcityadmin',1308898548355,62),
  ('402881b930c06c970130c0737dc90007','vcityadmin',1308898714652,62),
  ('402881b930c06c970130c07391480008','vcityadmin',1308898755152,62);
COMMIT;

#
# Structure for the `wbase_resource` table : 
#

DROP TABLE IF EXISTS `wbase_resource`;

CREATE TABLE `wbase_resource` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `nodeNo` BIGINT(20) DEFAULT NULL,
  `resNo` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  `resName` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `resLevel` INTEGER(11) NOT NULL,
  `subNodeNo` BIGINT(20) NOT NULL,
  `resPath` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `resPic` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `remark` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `isFlag` INTEGER(11) NOT NULL,
  `viewOrder` INTEGER(11) NOT NULL,
  `isTarget` INTEGER(11) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_resource` table  (LIMIT 0,500)
#

INSERT INTO `wbase_resource` (`id`, `nodeNo`, `resNo`, `resName`, `resLevel`, `subNodeNo`, `resPath`, `resPic`, `remark`, `isFlag`, `viewOrder`, `isTarget`) VALUES 
  ('1',0,'sysResManagement','系统资源管理',1,-1,'1','1','系统资源管理',1,1,1),
  ('402881b92da18778012da195473a0001',123234523,'userManagement','用户管理',1,0,'/UserAction.do?action=showUserList','/uploadfile/images/20110428/0a76ec95-4a79-4d01-9e6b-3caad0b2fe84.gif','',1,1,0),
  ('402881b92da62fa7012da63111e60001',1295573339392,'orgManagement','组织管理',1,0,'/platform/org/orgMain.jsp','/uploadfile/images/20110428/334c10a1-686b-45db-85bd-b91092999a0b.gif','',1,2,0),
  ('402881b92da65a6e012da65bdc070001',1295576179149,'roleManagement','角色管理',1,0,'/RoleAction.do?action=showRoleList','/uploadfile/images/20110428/4675d7e1-2e47-4b03-b740-a68d52680749.gif','',1,3,0),
  ('402881b92da65a6e012da65c6f070002',1295576219769,'postManagement','岗位管理',1,0,'/PostAction.do?action=showPostList','/uploadfile/images/20110428/4dad45bf-887b-4611-a448-b945067cbbcb.gif','',1,4,0),
  ('402881b92da65a6e012da65ca5210003',1295576234149,'resManagement','资源管理',1,0,'/platform/resource/resourceMain.jsp','/uploadfile/images/20110617/071d9d47-37d7-4f47-a6db-f7e8963581a2.jpg','',1,5,0),
  ('402881b92f572ab5012f57330c620001',1302838010664,'baseConifg','基础配置',1,0,'/platform/system/config_main.jsp','/uploadfile/view_pic.png','',1,99,0),
  ('402881b9302b0f3801302b107a280001',1306392514538,'FilesManagement','文档管理',1,0,'/platform/upload/upload.jsp','','',1,6,0),
  ('402881b930c06c970130c070f7800003',1308898548355,'vcityResource','虚拟资源管理',1,0,'','','',1,100,0),
  ('402881b930c06c970130c071c7220004',1308898714652,'vTask','交互任务管理',1,0,'','','',1,101,0),
  ('402881b930c06c970130c0733e270005',1308898755152,'vSurvey','调查问卷管理',1,0,'','','',1,102,0),
  ('402881b930d088900130d0889f1e0002',0,'system_res','系统资源',1,-1,NULL,NULL,NULL,1,0,1);
COMMIT;

#
# Structure for the `wbase_role` table : 
#

DROP TABLE IF EXISTS `wbase_role`;

CREATE TABLE `wbase_role` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `roleNo` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `roleName` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `remark` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `viewOrder` INTEGER(11) DEFAULT NULL,
  `createDate` DATETIME DEFAULT NULL,
  `isFlag` INTEGER(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_role` table  (LIMIT 0,500)
#

INSERT INTO `wbase_role` (`id`, `roleNo`, `roleName`, `remark`, `viewOrder`, `createDate`, `isFlag`) VALUES 
  ('402881b92dcb7367012dcb7744e30001','administrator','系统管理员','系统管理员',1,'2011-06-27 00:00:00',1),
  ('402881b930d4f2870130d4f577800004','vcityAdmin','虚拟体验社区管理员','',1,'2011-06-28 14:35:14',1);
COMMIT;

#
# Structure for the `wbase_role_obj` table : 
#

DROP TABLE IF EXISTS `wbase_role_obj`;

CREATE TABLE `wbase_role_obj` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `objNo` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `objType` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `roleNo` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `createDate` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_role_obj` table  (LIMIT 0,500)
#

INSERT INTO `wbase_role_obj` (`id`, `objNo`, `objType`, `roleNo`, `createDate`) VALUES 
  ('402881b92f8b6991012f8b6b3d110001','1303621708963','org','employee','2011-06-26 00:00:00'),
  ('402881b92f8b6991012f8b6b3d200002','1303527544966','org','employee','2011-06-26 00:00:00'),
  ('402881b930c06c970130c073f44c0009','admin','user','administrator','2011-06-26 00:00:00'),
  ('402881b930d4f2870130d4f5b0660005','administrator','user','vcityAdmin','2011-06-28 14:35:29');
COMMIT;

#
# Structure for the `wbase_sys_company` table : 
#

DROP TABLE IF EXISTS `wbase_sys_company`;

CREATE TABLE `wbase_sys_company` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `com_name` VARCHAR(64) COLLATE utf8_general_ci DEFAULT NULL,
  `com_logo` VARCHAR(512) COLLATE utf8_general_ci DEFAULT NULL,
  `com_remark` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Structure for the `wbase_sys_filetype` table : 
#

DROP TABLE IF EXISTS `wbase_sys_filetype`;

CREATE TABLE `wbase_sys_filetype` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `file_suffix` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  `file_pic` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `file_remark` VARCHAR(512) COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_sys_filetype` table  (LIMIT 0,500)
#

INSERT INTO `wbase_sys_filetype` (`id`, `file_suffix`, `file_pic`, `file_remark`) VALUES 
  ('402881b92f9ac1b7012f9ac2986a0001','xls','/uploadfile/filetype/xls.gif',''),
  ('402881b92f9ac1b7012f9ac2fecb0002','doc','/uploadfile/filetype/doc.gif',''),
  ('402881b92f9ad38c012f9ad4277b0001','jpeg','/uploadfile/filetype/jpeg.gif',''),
  ('402881b92f9ad772012f9ad865b50001','bpm','/uploadfile/filetype/bmp.gif',''),
  ('402881b92f9addd4012f9ade9a900001','dll','/uploadfile/filetype/dll.gif',''),
  ('402881b92f9af0b4012f9af2198a0001','chm','/uploadfile/filetype/chm.gif',''),
  ('402881b92f9af0b4012f9af2eb6e0002','ppt','/uploadfile/filetype/ppt.gif',''),
  ('402881b92f9af0b4012f9af3aef20003','exe','/uploadfile/filetype/exe.gif',''),
  ('402881b92f9af0b4012f9af525680005','cvs','/uploadfile/filetype/csv.gif',''),
  ('402881b92f9af0b4012f9af571020006','eml','/uploadfile/filetype/eml.gif',''),
  ('402881b92f9af0b4012f9af593100007','gif','/uploadfile/filetype/gif.gif',''),
  ('402881b92f9af0b4012f9af63e430008','ie','/uploadfile/filetype/ie.gif',''),
  ('402881b92f9af0b4012f9af761fd0009','htm','/uploadfile/filetype/htm.gif',''),
  ('402881b92f9af0b4012f9af7854c000a','html','/uploadfile/filetype/html.gif',''),
  ('402881b92f9af0b4012f9af7a7e6000b','ini','/uploadfile/filetype/ini.gif',''),
  ('402881b92f9af0b4012f9af7e404000c','java','/uploadfile/filetype/java.gif',''),
  ('402881b92f9af0b4012f9af811cc000d','mdb','/uploadfile/filetype/mdb.gif',''),
  ('402881b92f9af0b4012f9af84b05000e','xml','/uploadfile/filetype/xml.gif',''),
  ('402881b92f9af0b4012f9af89784000f','wpset','/uploadfile/filetype/wpset.gif',''),
  ('402881b92f9af0b4012f9af8ddd70010','vsd','/uploadfile/filetype/vsd.gif',''),
  ('402881b92f9af0b4012f9af8fd7c0011','txt','/uploadfile/filetype/txt.gif',''),
  ('402881b92f9af0b4012f9af92b8c0012','sys','/uploadfile/filetype/sys.gif',''),
  ('402881b92f9af0b4012f9af9503c0013','swf','/uploadfile/filetype/swf.gif',''),
  ('402881b92f9af0b4012f9af9962c0014','sql','/uploadfile/filetype/sql.gif',''),
  ('402881b92f9af0b4012f9af9beb60015','rtf','/uploadfile/filetype/rtf.gif',''),
  ('402881b92f9af0b4012f9afa08310016','rar','/uploadfile/filetype/rar.gif',''),
  ('402881b92f9af0b4012f9afaa3d80017','zip','/uploadfile/filetype/zip.gif',''),
  ('402881b92f9af0b4012f9afadc540018','psd','/uploadfile/filetype/psd.gif',''),
  ('402881b92f9af0b4012f9afb14ab0019','pdf','/uploadfile/filetype/pdf.gif','');
COMMIT;

#
# Structure for the `wbase_sys_messages` table : 
#

DROP TABLE IF EXISTS `wbase_sys_messages`;

CREATE TABLE `wbase_sys_messages` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `msg_title` VARCHAR(128) COLLATE utf8_general_ci DEFAULT NULL,
  `msg_starttime` DATETIME DEFAULT NULL,
  `msg_endtime` DATETIME DEFAULT NULL,
  `msg_contents` TEXT COLLATE utf8_general_ci,
  `msg_attachment` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `msg_flag` INTEGER(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Structure for the `wbase_sys_navigation` table : 
#

DROP TABLE IF EXISTS `wbase_sys_navigation`;

CREATE TABLE `wbase_sys_navigation` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `nav_name` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  `nav_link` VARCHAR(512) COLLATE utf8_general_ci DEFAULT NULL,
  `nav_open` INTEGER(11) DEFAULT NULL,
  `nav_flag` INTEGER(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Structure for the `wbase_sys_shortcut` table : 
#

DROP TABLE IF EXISTS `wbase_sys_shortcut`;

CREATE TABLE `wbase_sys_shortcut` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `cut_uid` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  `cut_nodeNo` BIGINT(20) DEFAULT NULL,
  `cut_order` INTEGER(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_sys_shortcut` table  (LIMIT 0,500)
#

INSERT INTO `wbase_sys_shortcut` (`id`, `cut_uid`, `cut_nodeNo`, `cut_order`) VALUES 
  ('402881b930d4f2870130d4f6fc640006','administrator',1308898548355,0),
  ('402881b930d4f2870130d4f6fc820007','administrator',1308898714652,1),
  ('402881b930d4f2870130d4f6fc820008','administrator',1308898755152,2);
COMMIT;

#
# Structure for the `wbase_user` table : 
#

DROP TABLE IF EXISTS `wbase_user`;

CREATE TABLE `wbase_user` (
  `id` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `account` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `userPwd` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `userName` VARCHAR(32) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `realName` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  `email` VARCHAR(512) COLLATE utf8_general_ci DEFAULT NULL,
  `sex` INTEGER(11) DEFAULT NULL,
  `officeTel` VARCHAR(64) COLLATE utf8_general_ci DEFAULT NULL,
  `fax` VARCHAR(64) COLLATE utf8_general_ci DEFAULT NULL,
  `phone` VARCHAR(64) COLLATE utf8_general_ci DEFAULT NULL,
  `mobile` VARCHAR(64) COLLATE utf8_general_ci DEFAULT NULL,
  `address` VARCHAR(512) COLLATE utf8_general_ci DEFAULT NULL,
  `zipcode` VARCHAR(32) COLLATE utf8_general_ci DEFAULT NULL,
  `picture` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `remark` VARCHAR(1024) COLLATE utf8_general_ci DEFAULT NULL,
  `createDate` DATETIME DEFAULT NULL,
  `isFlag` INTEGER(11) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci'
COMMENT='InnoDB free: 11264 kB';

#
# Data for the `wbase_user` table  (LIMIT 0,500)
#

INSERT INTO `wbase_user` (`id`, `account`, `userPwd`, `userName`, `realName`, `email`, `sex`, `officeTel`, `fax`, `phone`, `mobile`, `address`, `zipcode`, `picture`, `remark`, `createDate`, `isFlag`) VALUES 
  ('1','admin','21232f297a57a5a743894a0e4a801fc3','administrator','','',1,'zXXZc','','','','adsfasd','','/uploadfile/head/20110628/513dcdf5-ed85-437c-8977-1b441434a554.jpg','超级管理员',NULL,1),
  ('402881b930d4f2870130d4f46d680001','administrator','4297f44b13955235245b2497399d7a93','虚拟体验社区管理员','','',1,NULL,NULL,'','',NULL,NULL,'/common/images/default_head.png','虚拟体验社区管理员','2011-06-28 14:34:06',1);
COMMIT;

#
# Definition for the `viewuserinfo` view : 
#

DROP VIEW IF EXISTS `viewuserinfo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewuserinfo` AS 
  select 
    uuid() AS `vid`,
    `u`.`id` AS `uid`,
    `u`.`account` AS `account`,
    `u`.`userPwd` AS `userPwd`,
    `u`.`userName` AS `userName`,
    `u`.`realName` AS `realName`,
    `p`.`postNo` AS `postNo`,
    `p`.`postName` AS `postName`,
    `u`.`email` AS `email`,
    `u`.`sex` AS `sex`,
    `u`.`officeTel` AS `officeTel`,
    `u`.`fax` AS `fax`,
    `u`.`phone` AS `phone`,
    `u`.`mobile` AS `mobile`,
    `u`.`address` AS `address`,
    `u`.`zipcode` AS `zipcode`,
    `u`.`picture` AS `picture`,
    `u`.`remark` AS `remark`,
    `u`.`createDate` AS `createDate`,
    `o`.`nodeNo` AS `orgNodeNo`,
    `o`.`orgNo` AS `orgNo`,
    `o`.`orgName` AS `orgName`,
    `u`.`isFlag` AS `isFlag`,
    `r`.`roleNo` AS `roleNo` 
  from 
    (((((`wbase_user` `u` left join `wbase_org_user` `ou` on((`u`.`account` = `ou`.`userAccount`))) left join `wbase_org` `o` on((`ou`.`orgNodeNo` = `o`.`nodeNo`))) left join `wbase_role_obj` `r` on((`u`.`account` = `r`.`objNo`))) left join `wbase_post_user` `pu` on((`u`.`account` = `pu`.`userAccount`))) left join `wbase_post` `p` on((`pu`.`postNo` = `p`.`postNo`)));



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;