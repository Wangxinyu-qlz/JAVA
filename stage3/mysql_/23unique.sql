-- unique的使用
-- 如果没有指定not null，unique字段可以有多个null
-- 可以有多个unique主键
create table uniquetest
    (
        id int unique,
        `name` varchar(32),
        email varchar(32)
    );

desc uniquetest;
insert into uniquetest values(1, '1', 'qwe.com'),
                             (2, '2', 'tom.com'),
                             (3, '3', 'tom.ae');
insert into uniquetest values(1, '4', '4.com');  # error:Duplicate entry '1' for key 'uniquetest.id'
insert into uniquetest values(null, '4', '4.com');  # ok
select * from uniquetest;

-- 多个unique主键
create table uniquetest2
    (
        id int unique,
        `name` varchar(32) unique,
        email varchar(32)
    );

desc uniquetest2;
insert into uniquetest2 values(1, '1', 'qwe.com'),
                             (2, '2', 'tom.com'),
                             (3, '3', 'tom.ae');
insert into uniquetest2 values(1, '4', '4.com');  # error:Duplicate entry '1' for key 'uniquetest.id'
insert into uniquetest2 values(null, '4', '4.com');  # ok
insert into uniquetest2 values(5, '4', '4.com');  # error:Duplicate entry '4' for key 'uniquetest2.name'
select * from uniquetest2;