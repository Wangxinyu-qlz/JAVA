-- 删除delete

-- 删除表中名为'老妖怪'的记录
delete from employee
    where user_name = '老妖怪';

select * from employee;

-- delete all data
delete from employee;

-- delete语句不能删除某一列，可以使用update设为null
-- delete语句不能删除表，只能使用drop table table_name 删除表
drop table employee;