-- 统计每个学生的总成绩
select `name`, (chinese + english + math) from student;

-- 所有学生总分+10分的情况
select `name`, (chinese + english + math + 10) from student;

-- 使用别名表示学生的分数
select `name`, (chinese + english + math) as total_grade from student;

-- 在where子句中使用运算符
-- 查询赵云的成绩
select * from student
    where name = '赵云';
-- 英语大于90的学生
select * from student
    where english > 90;
-- 总分大于200的学生
select * from student
    where (chinese + english + math) > 200;
-- 数学大于82且英语大于90的学生
select * from student
    where math > 82 and english > 90;
-- 语文大于数学的学生
select * from student
    where chinese > math;
-- 总分大于200， 数学小于语文， 姓'赵'的学生 TODO like '赵%' 注意 %
select * from student
    where (chinese + math + english) > 200 and math < chinese and name like '赵%';

-- 英语成绩80-90
select * from student
    where english >= 80 and english <= 90;
-- TODO between是闭区间  [a, b]
select * from student
    where english between 80 and 90;
-- 数学成绩为89 90 91
select * from student
    where math = 89 or math = 90 or math = 91;
select * from student
    where math in (89, 90, 91);
-- 姓李的学生
select * from student
 where name like '李%';

-- TODO order by语句必须放在最后
-- 数学升序
select * from student
    order by math desc;
-- 总分从高到低
select *, (chinese + english + math) from student
    order by (chinese + english + math) desc;

select * from student
    where chinese > 60 and english > 60
    order by math desc;