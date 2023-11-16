-- check的使用
-- TODO mysql5.7只做语法校验，不会生效 oracle和sql server会生效
create table checktest
    (
        id int primary key ,
        `name` varchar(32),
        sex varchar(6) check (sex in ('男','女')),
        sal double check ( sal > 0 )
);

insert into checktest values (1,'张三','男',10000);
insert into checktest values (2,'李四','女',10000);
# insert into checktest values (3,'王五','男',-10000);  # Check constraint 'checktest_chk_2' is violated.
select * from checktest;