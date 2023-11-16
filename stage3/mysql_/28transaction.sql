-- TODO 事务:用于保证数据的一致性
create table transaction_test(
    id int,
    `name` varchar(32));
select * from transaction_test;

-- 开启事务
start transaction ;
-- 设置保存点
savepoint init;
-- 执行dml操作
insert into transaction_test values (1, 'qwe');

savepoint step1;

insert into transaction_test values (2, 'abc');

-- ******init**********step1***********now
    -- now -> step1 -> init OK
    -- now -> init OK
    -- now -> init -> step1 !!!NOWAY!!!

-- 回退到step1
rollback to savepoint step1;
-- 回退到init
rollback to savepoint init;
-- 回退到事物开始的状态
rollback;

-- 提交事物，一旦提交，无法回滚
commit ;


-- 细节：
    -- 1.不开启事务会自动提交
    -- 2.开启事务，不添加保存点，执行rollback会自动回退到事务开始时的状态
    -- 3.事务提价之前，可创建多个保存点
    -- 4.事务提交之前，可选择回退的保存点
    -- 5.innoDB存储引擎 支持事务，MyISAM不支持
    -- 6.开启事务的两种写法：  start transaction;     set autocommit=off;
set autocommit=off;