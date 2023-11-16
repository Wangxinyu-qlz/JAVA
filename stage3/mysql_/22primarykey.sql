-- 主键的使用
-- 不重复 is not null
-- 主键只能有一个，但可以是复合主键（id+name）
create table prikeytest
(
    id int primary key,  # id列是主键，唯一不重复，is not null
#     `name` varchar(32) primary key,  # error:主键唯一
    `name` varchar(32),
    email varchar(32)
);
desc prikeytest;

insert into prikeytest values(1, '1', 'qwe.com'),
                             (2, '2', 'tom.com'),
                             (3, '3', 'tom.ae');

insert into prikeytest values(1, '1', 'qwe.com');  # Duplicate entry '1' for key 'prikeytest.PRIMARY'
# insert into prikeytest values(null, 'null', 'null.com');  # Column 'id' cannot be null

-- 复合主键的使用
create table prikeytest1
(
    id int,
    `name` varchar(32),
    email varchar(32),
    primary key (id, `name`)  # id+name复合主键 两个值不能同时相同
);

desc prikeytest1;
insert into prikeytest1 values(1, '1', 'qwe.com'),
                             (2, '2', 'tom.com'),
                             (3, '3', 'tom.ae');
insert into prikeytest1 values(1, '4', '4.com');  # OK
# insert into prikeytest1 values(1, '1', 'test.com');  # error:Duplicate entry '1-1' for key 'prikeytest1.PRIMARY'
