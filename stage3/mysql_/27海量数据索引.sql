CREATE TABLE dept( /*部门表*/
deptno MEDIUMINT   UNSIGNED  NOT NULL  DEFAULT 0,
dname VARCHAR(20)  NOT NULL  DEFAULT '',
loc VARCHAR(13) NOT NULL DEFAULT ''
) ;
create database temp;

#创建表EMP雇员
CREATE TABLE emp
(empno  MEDIUMINT UNSIGNED  NOT NULL  DEFAULT 0, /*编号*/
ename VARCHAR(20) NOT NULL DEFAULT '', /*名字*/
job VARCHAR(9) NOT NULL DEFAULT '',/*工作*/
mgr MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,/*上级编号*/
hiredate DATE NOT NULL,/*入职时间*/
sal DECIMAL(7,2)  NOT NULL,/*薪水*/
comm DECIMAL(7,2) NOT NULL,/*红利*/
deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 /*部门编号*/
) ;

#工资级别表
CREATE TABLE salgrade
(
grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
losal DECIMAL(17,2)  NOT NULL,
hisal DECIMAL(17,2)  NOT NULL
);

#测试数据
INSERT INTO salgrade VALUES (1,700,1200);
INSERT INTO salgrade VALUES (2,1201,1400);
INSERT INTO salgrade VALUES (3,1401,2000);
INSERT INTO salgrade VALUES (4,2001,3000);
INSERT INTO salgrade VALUES (5,3001,9999);

delimiter $$
set global log_bin_trust_function_creators=TRUE;
#创建一个函数，名字 rand_string，可以随机返回我指定的个数字符串
create function rand_string(n INT)
returns varchar(255) #该函数会返回一个字符串
begin
#定义了一个变量 chars_str， 类型  varchar(100)
#默认给 chars_str 初始值   'abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ'
 declare chars_str varchar(100) default
   'abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ';
 declare return_str varchar(255) default '';
 declare i int default 0;
 while i < n do
    # concat 函数 : 连接函数mysql函数
   set return_str =concat(return_str,substring(chars_str,floor(1+rand()*52),1));
   set i = i + 1;
   end while;
  return return_str;
  end $$


 #这里我们又自定了一个函数,返回一个随机的部门号
create function rand_num( )
returns int(5)
begin
declare i int default 0;
set i = floor(10+rand()*500);
return i;
end $$

 #创建一个存储过程， 可以添加雇员
create procedure insert_emp(in start int(10),in max_num int(10))
begin
declare i int default 0;
#set autocommit =0 把autocommit设置成0
 #autocommit = 0 含义: 不要自动提交
 set autocommit = 0; #默认不提交sql语句
 repeat
 set i = i + 1;
 #通过前面写的函数随机产生字符串和部门编号，然后加入到emp表
 insert into emp values ((start+i) ,rand_string(6),'SALESMAN',0001,curdate(),2000,400,rand_num());
  until i = max_num
 end repeat;
 #commit整体提交所有sql语句，提高效率
   commit;
 end $$

 #添加8000000数据
call insert_emp(100001,8000000)$$

#命令结束符，再重新设置为;
delimiter ;

select count(*) from emp;

select * from emp
    where empno = 1234567;
-- ----------------------------------------------index----------------------------------
-- TODO 索引
-- 索引使用的tips：
    -- 1.频繁使用该字段查询索引
    -- 2.唯一性太差的字段不适合单独创建索引  性别（'男','女'）
    -- 3.更新非常频繁的字段不适合创建索引
    -- 4.不会出现在where子句中的字段不应该创建索引

-- 创建索引   emp.ibd:524M->655M 空间换时间  4.5s->57ms
-- empno_index索引名称，on emp(empno)在emp表的empno列创建索引
-- 创建索引的数据结构，比如二叉树，select(90%)极快，但是 insert delete update 慢
create index empno_index on emp(empno);

select * from emp
    where empno = 123454;

select * from emp
    where ename = 'axJxCT';  # 4.5s

-- 索引的类型
-- 1.主键索引，primary key类型自动为索引类型
-- 2.唯一索引（unique索引）unique类型自动为索引类型
-- 3.普通索引（index） 列名 index
-- 4.全文索引（fulltext）适用于MyISAM   开发中不使用mysql自带的全文索引，而是使用全文搜索框架：Solr和ElasticSearch(ES)
create table indextest01
(
    id int,
    `name` varchar(32)
);

-- 查询表中是否有索引
show index from indextest01;

-- 添加索引
-- unique索引 [使用场景：某列的值不会重复，优先考虑]
create unique index id_index on indextest01 (id);
-- 普通索引 [使用场景：某列的值会重复，优先考虑]
create index id_index on indextest01 (id);
-- 添加普通索引
alter table indextest01 add index id_index (id);
-- 添加主键索引
-- 建表时添加primary key关键字
alter table indextest01 add primary key (id);

-- 删除索引
drop index id_index on indextest01;
-- 删除主键索引
alter table indextest01 drop primary key;

-- 修改索引，先删除再添加

-- 查询索引
show index from indextest01;
show indexes from indextest01;
show keys from indextest01;
desc indextest01;
