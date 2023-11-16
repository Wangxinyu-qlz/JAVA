-- 数据库用户权限管理
-- 给不同的开发人员不同的数据库操作权限

-- 1. 创建新的数据库用户
--  'hsp'@'localhost' 用户完整信息 用户名@登录地址（主机名） '123456'密码（加密过的）
create user 'hsp'@'localhost' identified by '123456';
select * from mysql.user;

-- 2.删除用户
drop user 'hsp'@'localhost';

-- 3.登录用户

-- 4.修改自己的密码

-- 5.修改其他人的密码（需要权限）