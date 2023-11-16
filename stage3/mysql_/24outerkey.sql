-- 外键
-- 外键指向的表的字段，必须是primary key或者unique
-- 表的类型是innodb，才支持外键
-- 外键和主键的字段类型要一致，长度可以不同
--  1. 创建主表
create table my_class (
    id int primary key ,
    `name` varchar(32) not null default '');

-- 创建从表
create table my_student (
    id int primary key ,
    `name` varchar(32) not null default '',
    class_id int,
    -- 指定外键关系
    foreign key (class_id) references my_class(id));

insert into my_class values (1, '1班'), (2, '2班');
select * from my_class;

insert into my_student values(1, 'tom', 1), (2, 'jack', 2);
  # Cannot add or update a child row: a foreign key constraint fails
  # (`db02`.`my_student`, CONSTRAINT `my_student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `my_class` (`id`))
insert into my_student values(3, 'ttt', 3);  # error 3号班级不存在
insert into my_student values(3, 'ooo', null); # ok 暂时不知道放在那个班级（前提是该列允许为空，没有写not null）
select * from my_student;

-- 一旦建立主外键关系，无法随意删除数据，删除主表数据之前会核实从表有无数据指向它
-- 主表无法随意删除，从表无法随意添加
  # Cannot delete or update a parent row: a foreign key constraint fails
# (`db02`.`my_student`, CONSTRAINT `my_student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `my_class` (`id`))
delete from my_class
    where id = 1;