CREATE TABLE dept( /*部门表*/
deptno MEDIUMINT   UNSIGNED  NOT NULL  DEFAULT 0,
dname VARCHAR(20)  NOT NULL  DEFAULT '',
loc VARCHAR(13) NOT NULL DEFAULT ''
) ;

insert into  dept values(10,'ACCOUNTING','NEW YORK');
insert into  dept values(20,'RESEARCH','DALLAS');
insert into  dept values(30,'SALES','CHICAGO');
insert into  dept values(40,'OPERATIONS','BOSTON');

select * from dept;
drop table emp;
desc emp;
#创建表EMP雇员
CREATE TABLE emp
(empno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0, /*编号*/
ename VARCHAR(20) NOT NULL DEFAULT '', /*名字*/
job VARCHAR(9) NOT NULL DEFAULT '',/*工作*/
mgr MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,/*上级编号*/
hiredate DATE NOT NULL,/*入职时间*/
sal DECIMAL(7,2) NOT NULL,/*薪水*/
comm DECIMAL(7,2),/*红利*/
deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 /*部门编号*/
) ;

insert into emp
values(7369,'SMITH','CLERK',7902,'1980-12-17',800.00,NULL,20),
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600.0,300.0,30),
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250.0,500.0,30),
(7566,'JONES','MANAGER',7839,'1981-04-02',2975.0,NULL,20),
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250.0,1400.0,30),
(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850.0,NULL,30),
(7782,'CLARK','MANAGER',7839,'1981-06-09',2450.0,NULL,10),
(7788,'SCOTT','ANALYST',7566,'1987-04-19',3000.0,NULL,20),
(7839,'KING','PRESIDENT',8923,'1981-11-17',5000.0,NULL,10),
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500.0,0.00,30),
(7876,'ADAMS','CLERK',7788,'1987-05-23',1100.0,NULL,20),
(7900,'JAMES','CLERK',7698,'1981-12-03',950.0,NULL,30),
(7902,'FORD','ANALYST',7566,'1981-12-03',3000.0,NULL,20),
(7934,'MILLER','CLERK',7782,'1982-01-23',1300.0,NULL,10);
select * from emp;

#工资级别表
CREATE TABLE salgrade
(
grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,  #工资级别
losal DECIMAL(17,2)  NOT NULL,  # 该级别的最低工资
hisal DECIMAL(17,2)  NOT NULL  # 该级别的最高工资
);

#测试数据
INSERT INTO salgrade VALUES (1,700,1200);
INSERT INTO salgrade VALUES (2,1201,1400);
INSERT INTO salgrade VALUES (3,1401,2000);
INSERT INTO salgrade VALUES (4,2001,3000);
INSERT INTO salgrade VALUES (5,3001,9999);
select * from salgrade;

-- 显示每个部门的平均工资和最高工资
select avg(sal), max(sal), deptno
    from emp group by deptno;  # 按照部门分组 40号部门没有人，所以查询结果中没有40号部门的信息
-- 显示每个部门的 每个岗位的平均工资 和 最高工资
select avg(sal), max(sal), deptno, job
    from emp group by deptno, job
    order by deptno;

-- 显示平均工资 低于2000的 部门号 和 平均工资
select deptno, avg(sal)
from emp group by  deptno
having avg(sal) < 2000;

-- 使用名别
select deptno, avg(sal) as avg_sal
    from emp group by deptno
    having avg_sal < 2000;

select * from emp
    group by deptno;

-- ----------------------------------------分隔符------------------------------------------------

delimiter $$  # 命令分组，两其链接的两段代码分为一组
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