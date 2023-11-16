-- 查看所有的存储引擎
show engines;
-- 不需要事务 优先选择MyISAM速度快
-- 需要事务 innoDB 只能选这个
-- Memory 数据存储在内存中，没有I/O操作，速度最快，但是服务器重启数据就丢失，经典用法：用户在线状态

-- 修改存储引擎
alter table transaction_test engine = InnoDB;