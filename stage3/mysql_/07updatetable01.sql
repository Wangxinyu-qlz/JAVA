# 修改表的操作练习

-- 员工表emp增加一个image列，varchar类型，在resume后面
alter table employee
    add image varchar(32) not null default ''
    after resume;

-- 显示表结构
desc employee;

-- 修改job列，使其长度为60
alter table employee
    modify job varchar(60) not null default '';

-- 删除列sex
alter table employee
    drop sex;

alter table employee
    add sex char(2) not null default ''
    after id;

-- 修改表名
rename table employee to employee;

-- 修改表的字符集
alter table employee
    character set utf8mb4;

-- 修改列名/字段名以及数据类型
alter table employee
    change name user_name varchar(32) not null default '';

alter table employee
    change id id varchar(64) not null default '';