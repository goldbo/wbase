USE [wbase]
GO
/****** 对象:  View [dbo].[viewUserInfo]    脚本日期: 04/24/2011 11:28:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[viewUserInfo] as(
SELECT NEWID() AS vid, u.id as uid, u.account, u.userPwd,u.userName, u.realName, p.postNo, p.postName, u.email, u.sex, u.officeTel,u.fax,u.phone, u.mobile, u.address,u.zipcode,u.picture, u.remark, u.createDate,o.nodeNo AS orgNodeNo, o.orgNo, o.orgName, 
                      u.isFlag,r.roleNo
FROM         dbo.wbase_user AS u LEFT OUTER JOIN
					  dbo.wbase_org_user AS ou ON u.account = ou.userAccount LEFT OUTER JOIN 
                      dbo.wbase_org AS o ON ou.orgNodeNo = o.nodeNo LEFT OUTER JOIN  
					  dbo.wbase_role_obj AS r ON u.account = r.objNo LEFT OUTER JOIN 
					  dbo.wbase_post_user AS pu ON u.account = pu.userAccount LEFT OUTER JOIN
					  dbo.wbase_post AS p ON pu.postNo = p.postNo
)


USE [wbase]
GO
/****** 导出表数据脚本 对象:  StoredProcedure [dbo].[Spgeninsertsql]    脚本日期: 06/28/2011 10:30:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create Proc [dbo].[Spgeninsertsql] (@Tablename Varchar(256))

As

Begin

/*当变量的字符数超过8000时，执行存储过程失败。*/
Declare @Sql Varchar(8000)

Declare @Sqlvalues Varchar(8000)

Set @Sql =' ('

Set @Sqlvalues = 'values (''+'

Select @Sqlvalues = @Sqlvalues + Cols + ' + '','' + ' ,@Sql = @Sql + '[' + Name + '],' 

From 

(Select Case 

When Xtype In (48,52,56,59,60,62,104,106,108,122,127) 

Then 'case When '+ Name +' Is Null Then ''null'' Else ' + 'cast('+ Name + ' As Varchar)'+' End'

When Xtype In (58,61)

Then 'case When '+ Name +' Is Null Then ''null'' Else '+''''''''' + ' + 'cast('+ Name +' As Varchar)'+ '+'''''''''+' End'

When Xtype In (167)

Then 'case When '+ Name +' Is Null Then ''null'' Else '+''''''''' + ' + 'replace('+ Name+','''''''','''''''''''')' + '+'''''''''+' End'

When Xtype In (231)

Then 'case When '+ Name +' Is Null Then ''null'' Else '+'''n'''''' + ' + 'replace('+ Name+','''''''','''''''''''')' + '+'''''''''+' End'

When Xtype In (175)

Then 'case When '+ Name +' Is Null Then ''null'' Else '+''''''''' + ' + 'cast(Replace('+ Name+','''''''','''''''''''') As Char(' + Cast(Length As Varchar) + '))+'''''''''+' End'

When Xtype In (239)

Then 'case When '+ Name +' Is Null Then ''null'' Else '+'''n'''''' + ' + 'cast(Replace('+ Name+','''''''','''''''''''') As Char(' + Cast(Length As Varchar) + '))+'''''''''+' End'

Else '''null'''

End As Cols,Name

From Syscolumns 

Where (Id = Object_Id(@Tablename)) And (Autoval Is Null)

) T 

Set @Sql ='select ''insert Into ['+ @Tablename + ']' + Left(@Sql,Len(@Sql)-1)+') ' + Left(@Sqlvalues,Len(@Sqlvalues)-4) + ')'' From '+@Tablename

--Print @Sql

Exec (@Sql)

End
