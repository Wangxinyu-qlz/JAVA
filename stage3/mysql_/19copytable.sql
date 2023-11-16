-- 表的复制 蠕虫复制
create table my_table01
    (
        id int,
        `name` varchar(32),
        sal double,
        job varchar(32),
        deptno int
);

insert into my_table01 values(1,'张三',1000,'经理',1);

desc my_table01;
select * from my_table01;
-- 先将emp表的记录复制到my_table01
insert into my_table01
    (id, name, sal, job, deptno)
    select empno, ename, sal, job, deptno from emp;
-- 自我复制
insert into my_table01
    select * from my_table01;

-- 删除表中的重复记录
create table my_table02 like  my_table01;  # TODO 复制表的结构
desc my_table02;
insert into my_table02
    select * from my_table01;

-- TODO 去重
/*
    1.先创建一张临时表my_temp，该表的结构和my_table02一致
    2.将my_temp表中的记录 通过 distinct 关键字处理后，将记录复制到my_temp
    3.清除掉my_table02中的记录，
    4.将my_temp中的记录复制到my_table02
    5.drop my_temp
*/

create table my_temp like my_table02;
insert into my_temp
    select distinct * from my_table02;
-- 清除my_table02表中记录
delete from my_table02;
insert into my_table02
    select * from my_temp;
drop table my_temp;
select * from my_table02;