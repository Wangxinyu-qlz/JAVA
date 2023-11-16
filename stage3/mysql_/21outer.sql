-- 列出部门名称和这些部门的员工名称和工作，
-- 同时要求显示出哪些没有员工的部门
-- 使用 笛卡尔积 做不到
select dname, ename, job
    from emp, dept
    where emp.deptno = dept.deptno
    order by dname;

-- TODO 外连接
-- 左外连接（左侧的表完全显示）
-- 右外连接（右侧的表完全显示）
select * from student;

create table exam(
    id int,
    grade double
);

insert into exam values(1, 80), (2, 88), (3, 88), (4, 89), (5, 78);
select * from exam;

-- 使用左外连接，显示所有人的成绩，如果没有成绩，也显示该人的姓名和id，成绩显示为null
-- from table1 left join table2
--       左表              右表
-- 左表没有匹配也会显示
select `name`, student.id, grade
    from student left join exam
    on student.id = exam.id;

-- 使用右外连接，显示所有人的成绩，如果没有名字匹配，显示null
-- from table1 right join table2
--       左表              右表
-- 右表没有匹配也会显示
select `name`, student.id, grade
    from student right join exam
    on student.id = exam.id;

-- 列出部门名称和这些部门的员工名称和工作，同时列出没有员工的部门名
select dname, ename, job
    from dept left join emp
    on dept.deptno = emp.deptno;

select dname, ename, job
    from emp right join dept
    on dept.deptno = emp.deptno;