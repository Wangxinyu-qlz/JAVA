-- 统计函数
-- 统计总人数
select count(*) from student;
-- 数学成绩大于90的人数
select count(*) from student
    where math >= 90;
-- 总分大于250
select count(*) from student
    where (chinese + math + english) > 250;

-- TODO count(列)统计满足条件的某列的数量，但会排除为 null 的列

create table test(
    `name` varchar(15)
);
insert into test values ('tom');
insert into test values ('jerry');
insert into test values (null);
select * from test;
select count(*) from test; # 5
-- 过滤掉为 null 的列
select count(name) from test; # 4
select count(if(name is not null, 1, null)) from test; # 4
select count(if(name is not null, name, null)) from test; # 4


-- sum函数 只对数值有作用
select sum(chinese) from student;
select sum(math) as math_total_grade,
       sum(english) as english_total_grade,
       sum(chinese) as chinese_total_grade
from student;
select sum(math+ chinese + english) from student;

-- 语文平均分
select sum(chinese) / count(*) from student;


-- AVG函数 求平均值
select avg(chinese) from student;
select avg(chinese + math + english) from student;


-- max min
select max(chinese + math + english) from student;
select min(chinese + math + english) from student;

select * from student
    where chinese + math + english = (select max(chinese + math + english) from student);
