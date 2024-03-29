if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_post_user')
            and   type = 'U')
   drop table dbo.wbase_post_user
go

/*==============================================================*/
/* Table: wbase_post_user                                       */
/*==============================================================*/
create table dbo.wbase_post_user (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   userAccount          varchar(32)          collate Chinese_PRC_CI_AS not null,
   postNo               varchar(32)          collate Chinese_PRC_CI_AS not null,
   createDate           datetime             null,
   constraint PK_WBASE_POST_USER primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_sys_company')
            and   type = 'U')
   drop table dbo.wbase_sys_company
go

/*==============================================================*/
/* Table: wbase_sys_company                                     */
/*==============================================================*/
create table dbo.wbase_sys_company (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   com_name             varchar(64)          collate Chinese_PRC_CI_AS null,
   com_logo             varchar(512)         collate Chinese_PRC_CI_AS null,
   com_remark           varchar(1024)        collate Chinese_PRC_CI_AS null,
   constraint PK_WBASE_SYS_COMPANY primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_post')
            and   type = 'U')
   drop table dbo.wbase_post
go

/*==============================================================*/
/* Table: wbase_post                                            */
/*==============================================================*/
create table dbo.wbase_post (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   postNo               varchar(32)          collate Chinese_PRC_CI_AS not null,
   postName             varchar(32)          collate Chinese_PRC_CI_AS not null,
   postLevel            int                  not null constraint DF_wbase_post_postLevel default (1),
   remark               nvarchar(1024)       collate Chinese_PRC_CI_AS null,
   createDate           datetime             null,
   constraint PK_WBASE_POST primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_sys_shortcut')
            and   type = 'U')
   drop table dbo.wbase_sys_shortcut
go

/*==============================================================*/
/* Table: wbase_sys_shortcut                                    */
/*==============================================================*/
create table dbo.wbase_sys_shortcut (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   cut_uid              varchar(32)          collate Chinese_PRC_CI_AS null,
   cut_nodeNo           bigint               null,
   cut_order            int                  null,
   constraint PK_WBASE_SYS_SHORTCUT primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_sys_filetype')
            and   type = 'U')
   drop table dbo.wbase_sys_filetype
go

/*==============================================================*/
/* Table: wbase_sys_filetype                                    */
/*==============================================================*/
create table dbo.wbase_sys_filetype (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   file_suffix          varchar(32)          collate Chinese_PRC_CI_AS null,
   file_pic             varchar(1024)        collate Chinese_PRC_CI_AS null,
   file_remark          varchar(512)         collate Chinese_PRC_CI_AS null,
   constraint PK_WBASE_SYS_FILETYPE primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_power')
            and   type = 'U')
   drop table dbo.wbase_power
go

/*==============================================================*/
/* Table: wbase_power                                           */
/*==============================================================*/
create table dbo.wbase_power (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   roleNo               varchar(32)          collate Chinese_PRC_CI_AS not null,
   resNodeNo            bigint               not null,
   powerLevel           int                  not null,
   constraint PK_WBASE_POWER primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_user')
            and   type = 'U')
   drop table dbo.wbase_user
go

/*==============================================================*/
/* Table: wbase_user                                            */
/*==============================================================*/
create table dbo.wbase_user (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   account              varchar(32)          collate Chinese_PRC_CI_AS not null,
   userPwd              varchar(32)          collate Chinese_PRC_CI_AS not null,
   userName             varchar(32)          collate Chinese_PRC_CI_AS not null,
   realName             varchar(32)          collate Chinese_PRC_CI_AS null,
   email                varchar(512)         collate Chinese_PRC_CI_AS null,
   sex                  int                  null constraint DF_wbase_user_sex default (1),
   officeTel            varchar(64)          collate Chinese_PRC_CI_AS null,
   fax                  varchar(64)          collate Chinese_PRC_CI_AS null,
   phone                varchar(64)          collate Chinese_PRC_CI_AS null,
   mobile               varchar(64)          collate Chinese_PRC_CI_AS null,
   address              varchar(512)         collate Chinese_PRC_CI_AS null,
   zipcode              varchar(32)          collate Chinese_PRC_CI_AS null,
   picture              nvarchar(1024)       collate Chinese_PRC_CI_AS null,
   remark               nvarchar(1024)       collate Chinese_PRC_CI_AS null,
   createDate           datetime             null,
   isFlag               int                  not null constraint DF_wbase_user_isFlag default (1),
   constraint PK_WBASE_USER primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_sys_messages')
            and   type = 'U')
   drop table dbo.wbase_sys_messages
go

/*==============================================================*/
/* Table: wbase_sys_messages                                    */
/*==============================================================*/
create table dbo.wbase_sys_messages (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   msg_title            varchar(128)         collate Chinese_PRC_CI_AS null,
   msg_starttime        datetime             null,
   msg_endtime          datetime             null,
   msg_contents         text                 collate Chinese_PRC_CI_AS null,
   msg_attachment       varchar(1024)        collate Chinese_PRC_CI_AS null,
   msg_flag             int                  null,
   constraint PK_WBASE_SYS_MESSAGES primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

execute sp_addextendedproperty 'MS_Description', 
   '公告滚动信息',
   'user', 'dbo', 'table', 'wbase_sys_messages'
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_sys_navigation')
            and   type = 'U')
   drop table dbo.wbase_sys_navigation
go

/*==============================================================*/
/* Table: wbase_sys_navigation                                  */
/*==============================================================*/
create table dbo.wbase_sys_navigation (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   nav_name             varchar(32)          collate Chinese_PRC_CI_AS null,
   nav_link             varchar(512)         collate Chinese_PRC_CI_AS null,
   nav_open             int                  null,
   nav_flag             int                  null,
   constraint PK_WBASE_SYS_NAVIGATION primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_org_user')
            and   type = 'U')
   drop table dbo.wbase_org_user
go

/*==============================================================*/
/* Table: wbase_org_user                                        */
/*==============================================================*/
create table dbo.wbase_org_user (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   userAccount          varchar(32)          collate Chinese_PRC_CI_AS not null,
   orgNodeNo            bigint               not null,
   createDate           datetime             null,
   constraint PK_WBASE_ORG_USER primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_org')
            and   type = 'U')
   drop table dbo.wbase_org
go

/*==============================================================*/
/* Table: wbase_org                                             */
/*==============================================================*/
create table dbo.wbase_org (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   nodeNo               bigint               not null,
   orgNo                varchar(32)          collate Chinese_PRC_CI_AS null,
   orgName              varchar(32)          collate Chinese_PRC_CI_AS not null,
   orgLevel             int                  not null constraint DF_wbase_org_orgLevel default (1),
   subNodeNo            bigint               not null,
   remark               nvarchar(1024)       collate Chinese_PRC_CI_AS null,
   isFlag               int                  not null constraint DF_wbase_org_isFlag default (1),
   viewOrder            int                  not null constraint DF_wbase_org_viewOrder default (1),
   createDate           datetime             not null,
   constraint PK_WBASE_ORG primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_role_obj')
            and   type = 'U')
   drop table dbo.wbase_role_obj
go

/*==============================================================*/
/* Table: wbase_role_obj                                        */
/*==============================================================*/
create table dbo.wbase_role_obj (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   objNo                varchar(32)          collate Chinese_PRC_CI_AS not null,
   objType              varchar(32)          collate Chinese_PRC_CI_AS not null,
   roleNo               varchar(32)          collate Chinese_PRC_CI_AS not null,
   createDate           datetime             null,
   constraint PK_WBASE_ROLE_OBJ primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

execute sp_addextendedproperty 'MS_Description', 
   '对象类别为 用户和组织',
   'user', 'dbo', 'table', 'wbase_role_obj'
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_role')
            and   type = 'U')
   drop table dbo.wbase_role
go

/*==============================================================*/
/* Table: wbase_role                                            */
/*==============================================================*/
create table dbo.wbase_role (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   roleNo               varchar(32)          collate Chinese_PRC_CI_AS not null,
   roleName             varchar(32)          collate Chinese_PRC_CI_AS not null,
   remark               nvarchar(1024)       collate Chinese_PRC_CI_AS null,
   viewOrder            int                  null constraint DF_wbase_role_viewOrder default (1),
   createDate           datetime             null,
   isFlag               int                  null constraint DF_wbase_role_isFlag default (1),
   constraint PK_WBASE_ROLE primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('dbo.wbase_resource')
            and   type = 'U')
   drop table dbo.wbase_resource
go

/*==============================================================*/
/* Table: wbase_resource                                        */
/*==============================================================*/
create table dbo.wbase_resource (
   id                   varchar(32)          collate Chinese_PRC_CI_AS not null,
   nodeNo               bigint               null,
   resNo                varchar(32)          collate Chinese_PRC_CI_AS null,
   resName              varchar(32)          collate Chinese_PRC_CI_AS not null,
   resLevel             int                  not null,
   subNodeNo            bigint               not null,
   resPath              nvarchar(1024)       collate Chinese_PRC_CI_AS null,
   resPic               nvarchar(1024)       collate Chinese_PRC_CI_AS null,
   remark               nvarchar(1024)       collate Chinese_PRC_CI_AS null,
   isFlag               int                  not null,
   viewOrder            int                  not null,
   isTarget             int                  not null,
   constraint PK_WBASE_RESOURCE primary key (id)
         on "PRIMARY"
)
on "PRIMARY"
go

execute sp_addextendedproperty 'MS_Description', 
   '即模块菜单表',
   'user', 'dbo', 'table', 'wbase_resource'
go



INSERT INTO wbase_org (id, nodeNo, orgNo, orgName, orgLevel, subNodeNo, remark, isFlag, viewOrder, createDate) VALUES 
  ('402881b930d088900130d0889ec40001',0,'organization','珠海市网佳科技有限公司',1,-1,NULL,1,0,'2011-06-27 17:57:52');

INSERT INTO wbase_org_user (id, userAccount, orgNodeNo, createDate) VALUES 
  ('402881b930d4f2870130d4f46d860003','administrator',0,'2011-06-28 14:34:06')

  INSERT INTO wbase_org_user (id, userAccount, orgNodeNo, createDate) VALUES 
('ff8080812f85910c012f85986d140002','admin',0,'2011-06-28 10:40:28');

INSERT INTO wbase_post (id, postNo, postName, postLevel, remark, createDate) VALUES  ('ff8080812f85d158012f85d4941e0002','deptmamager','部门经理',2,'','2011-06-28 00:00:00');
 INSERT INTO wbase_post (id, postNo, postName, postLevel, remark, createDate) VALUES ('ff8080812f85d158012f85d4fe450003','leadmanager','总经理',1,'','2011-06-28 00:00:00');
INSERT INTO wbase_post (id, postNo, postName, postLevel, remark, createDate) VALUES  ('ff8080812f85e20f012f85e426350001','employee','员工',5,'','2011-06-28 00:00:00');


INSERT INTO wbase_post_user (id, userAccount, postNo, createDate) VALUES ('402881b92f95eff9012f95f0371b0001','admin','employee','2011-06-28 10:40:28');
INSERT INTO wbase_post_user (id, userAccount, postNo, createDate) VALUES   ('402881b930d4f2870130d4f46d7c0002','administrator','employee','2011-06-28 14:34:06');

INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES ('1','administrator',1295576234149,62);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('2','administrator',1295576179149,62);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b92f8b3b56012f8b3c8f030001','administrator',123234523,62);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b92f8b3b56012f8b3ca2530002','administrator',1295573339392,62);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b92f8b3b56012f8b3cca990003','administrator',1295576219769,62);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b92f8b3b56012f8b3cf5150004','administrator',1302838010664,62);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b92f964a9a012f964bffac0001','employee',123234523,32);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b92f964a9a012f964c0cb40002','employee',1295573339392,32);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b92f964a9a012f964c1d010003','employee',1295576179149,32);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b92f964a9a012f964c2b870004','employee',1295576219769,32);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b9302b0f3801302b10cec00002','administrator',1306392514538,62);
 INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES  ('402881b930c06c970130c0736a930006','vcityadmin',1308898548355,62);
 INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES  ('402881b930c06c970130c0737dc90007','vcityadmin',1308898714652,62);
INSERT INTO wbase_power (id, roleNo, resNodeNo, powerLevel) VALUES   ('402881b930c06c970130c07391480008','vcityadmin',1308898755152,62);


INSERT INTO wbase_resource (id, nodeNo, resNo, resName, resLevel, subNodeNo, resPath, resPic, remark, isFlag, viewOrder, isTarget)  
   select '1',0,'sysResManagement','系统资源管理',1,-1,'1','1','系统资源管理',1,1,1 
union select   '402881b92da18778012da195473a0001',123234523,'userManagement','用户管理',1,0,'/UserAction.do?action=showUserList','/uploadfile/images/20110428/0a76ec95-4a79-4d01-9e6b-3caad0b2fe84.gif','',1,1,0
union select '402881b92da62fa7012da63111e60001',1295573339392,'orgManagement','组织管理',1,0,'/platform/org/orgMain.jsp','/uploadfile/images/20110428/334c10a1-686b-45db-85bd-b91092999a0b.gif','',1,2,0
union select '402881b92da65a6e012da65bdc070001',1295576179149,'roleManagement','角色管理',1,0,'/RoleAction.do?action=showRoleList','/uploadfile/images/20110428/4675d7e1-2e47-4b03-b740-a68d52680749.gif','',1,3,0
union select '402881b92da65a6e012da65c6f070002',1295576219769,'postManagement','岗位管理',1,0,'/PostAction.do?action=showPostList','/uploadfile/images/20110428/4dad45bf-887b-4611-a448-b945067cbbcb.gif','',1,4,0
union select '402881b92da65a6e012da65ca5210003',1295576234149,'resManagement','资源管理',1,0,'/platform/resource/resourceMain.jsp','/uploadfile/images/20110617/071d9d47-37d7-4f47-a6db-f7e8963581a2.jpg','',1,5,0
union select '402881b92f572ab5012f57330c620001',1302838010664,'baseConifg','基础配置',1,0,'/platform/system/config_main.jsp','/uploadfile/view_pic.png','',1,99,0
union select '402881b9302b0f3801302b107a280001',1306392514538,'FilesManagement','文档管理',1,0,'/platform/upload/upload.jsp','','',1,6,0
union select '402881b930c06c970130c070f7800003',1308898548355,'vcityResource','虚拟资源管理',1,0,'','','',1,100,0
union select '402881b930c06c970130c071c7220004',1308898714652,'vTask','交互任务管理',1,0,'','','',1,101,0
union select '402881b930c06c970130c0733e270005',1308898755152,'vSurvey','调查问卷管理',1,0,'','','',1,102,0
union select '402881b930d088900130d0889f1e0002',0,'system_res','系统资源',1,-1,NULL,NULL,NULL,1,0,1


INSERT INTO wbase_role (id, roleNo, roleName, remark, viewOrder, createDate, isFlag) VALUES   ('402881b92dcb7367012dcb7744e30001','administrator','系统管理员','系统管理员',1,'2011-06-27 00:00:00',1);
INSERT INTO wbase_role (id, roleNo, roleName, remark, viewOrder, createDate, isFlag) VALUES   ('402881b930d4f2870130d4f577800004','vcityAdmin','虚拟体验社区管理员','',1,'2011-06-28 14:35:14',1);

INSERT INTO wbase_role_obj (id, objNo, objType, roleNo, createDate) VALUES ('402881b92f8b6991012f8b6b3d110001','1303621708963','org','employee','2011-06-26 00:00:00');
 INSERT INTO wbase_role_obj (id, objNo, objType, roleNo, createDate) VALUES  ('402881b92f8b6991012f8b6b3d200002','1303527544966','org','employee','2011-06-26 00:00:00');
INSERT INTO wbase_role_obj (id, objNo, objType, roleNo, createDate) VALUES   ('402881b930c06c970130c073f44c0009','admin','user','administrator','2011-06-26 00:00:00');
INSERT INTO wbase_role_obj (id, objNo, objType, roleNo, createDate) VALUES   ('402881b930d4f2870130d4f5b0660005','administrator','user','vcityAdmin','2011-06-28 14:35:29');


INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES ('402881b92f9ac1b7012f9ac2986a0001','xls','/uploadfile/filetype/xls.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES  ('402881b92f9ac1b7012f9ac2fecb0002','doc','/uploadfile/filetype/doc.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES   ('402881b92f9ad38c012f9ad4277b0001','jpeg','/uploadfile/filetype/jpeg.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9ad772012f9ad865b50001','bpm','/uploadfile/filetype/bmp.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9addd4012f9ade9a900001','dll','/uploadfile/filetype/dll.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af2198a0001','chm','/uploadfile/filetype/chm.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af2eb6e0002','ppt','/uploadfile/filetype/ppt.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af3aef20003','exe','/uploadfile/filetype/exe.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af525680005','cvs','/uploadfile/filetype/csv.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af571020006','eml','/uploadfile/filetype/eml.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES    ('402881b92f9af0b4012f9af593100007','gif','/uploadfile/filetype/gif.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af63e430008','ie','/uploadfile/filetype/ie.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af761fd0009','htm','/uploadfile/filetype/htm.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af7854c000a','html','/uploadfile/filetype/html.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af7a7e6000b','ini','/uploadfile/filetype/ini.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af7e404000c','java','/uploadfile/filetype/java.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af811cc000d','mdb','/uploadfile/filetype/mdb.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af84b05000e','xml','/uploadfile/filetype/xml.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af89784000f','wpset','/uploadfile/filetype/wpset.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af8ddd70010','vsd','/uploadfile/filetype/vsd.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af8fd7c0011','txt','/uploadfile/filetype/txt.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af92b8c0012','sys','/uploadfile/filetype/sys.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af9503c0013','swf','/uploadfile/filetype/swf.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af9962c0014','sql','/uploadfile/filetype/sql.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9af9beb60015','rtf','/uploadfile/filetype/rtf.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9afa08310016','rar','/uploadfile/filetype/rar.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9afaa3d80017','zip','/uploadfile/filetype/zip.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9afadc540018','psd','/uploadfile/filetype/psd.gif','');
INSERT INTO wbase_sys_filetype (id, file_suffix, file_pic, file_remark) VALUES     ('402881b92f9af0b4012f9afb14ab0019','pdf','/uploadfile/filetype/pdf.gif','');



INSERT INTO wbase_sys_shortcut (id, cut_uid, cut_nodeNo, cut_order) VALUES  ('402881b930d4f2870130d4f6fc640006','administrator',1308898548355,0);
INSERT INTO wbase_sys_shortcut (id, cut_uid, cut_nodeNo, cut_order) VALUES   ('402881b930d4f2870130d4f6fc820007','administrator',1308898714652,1);
INSERT INTO wbase_sys_shortcut (id, cut_uid, cut_nodeNo, cut_order) VALUES   ('402881b930d4f2870130d4f6fc820008','administrator',1308898755152,2);


INSERT INTO wbase_user (id, account, userPwd, userName, realName, email, sex, officeTel, fax, phone, mobile, address, zipcode, picture, remark, createDate, isFlag)  
select   '1','admin','21232f297a57a5a743894a0e4a801fc3','administrator','','',1,'zXXZc','','','','adsfasd','','/uploadfile/head/20110628/513dcdf5-ed85-437c-8977-1b441434a554.jpg','超级管理员',NULL,1
union select '402881b930d4f2870130d4f46d680001','administrator','4297f44b13955235245b2497399d7a93','虚拟体验社区管理员','','',1,NULL,NULL,'','',NULL,NULL,'/common/images/default_head.png','虚拟体验社区管理员','2011-06-28 14:34:06',1

