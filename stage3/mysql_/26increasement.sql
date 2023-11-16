-- 自增长
-- 自增配合primary key使用
-- 一般修饰int类型 也支持double(很少用)
-- 可以在添加时指定一个值给自增长的字段 （不建议使用）
-- 自增从此字段的最大值+1
-- 默认从1开始，可以修改初始默认值
create table increasetest
    (
     id int primary key auto_increment,
     email varchar(32) not null default '',
     `name` varchar(32) not null default ''
);
-- 可以修改默认的自增长开始值
alter table increasetest auto_increment = 100;
desc increasetest;

insert into increasetest (email, `name`) values ('123@qq.com', '123');
insert into increasetest values (null, '456@qq.com', '456');
-- 指定一个值
insert into increasetest values (9, '456@qq.com', '456');
select * from increasetest;
delete from increasetest
    where id = 1;