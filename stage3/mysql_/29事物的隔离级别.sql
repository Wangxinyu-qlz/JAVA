-- TODO 理解 ！！！事务的隔离级别  韩顺平JAVA P800
-- 多个连接开启各自事务，操作数据库中的数据时，数据库系统负责隔离操作，保证各个链接在获取数据时的准确性
-- 否则会发生：
    -- 脏读：读取到其他链接未提交的数据
    -- 不可重复读：同一查询在同一事务中多次进行，由于其他提交事务所做的修改或删除，每次返回不同的结果集
    -- 幻读：同一查询在同一事务中多次进行，由于其他提交事务所做的插入，每次返回不同的结果集


-- 查看当前的会话隔离级别
select @@transaction_isolation;
-- 查看当前的系统隔离级别
select @@global.transaction_isolation;
-- 设置当前会话的隔离级别
set session transaction isolation level read uncommitted;
set session transaction isolation level read committed;
set session transaction isolation level repeatable read;
set session transaction isolation level serializable;
-- 设置系统的隔离级别
set global transaction isolation level repeatable read;
-- 永久修改 mysql.ini配置文件 添加到最后
-- [mysqld]
-- transaction-isolation=READ-UNCOMMITTED
