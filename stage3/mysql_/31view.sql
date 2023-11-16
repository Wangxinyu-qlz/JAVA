-- 视图
-- 创建一个视图，只能查询emp表的（empno, ename, job, deptno）信息
create view emp_view01
    as
    select empno, ename, job, deptno from emp;

-- 查看视图结构
desc emp_view01;

-- 查看视图的数据
select * from emp_view01;
select ename from emp_view01;

-- 查看创建视图的指令
show create view emp_view01;
-- 删除视图
drop view emp_view01;

-- 在文件管理系统中，视图只有一个结构文件，没有数据文件，创建视图只是构建了与基表数据之间的映射关系
-- 修改视图影响基表，修改基表影响视图
-- 视图可以再使用视图

create view emp_view02
    as
    select empno, ename from emp_view01;


select * from emp_view02;

-- 视图的作用
    -- 1.安全：可以隐藏一些字段，给用户提供一个视图
    -- 2.性能：使用视图加你相关的表和字段组合在一起，可以避免使用join查询数据，提高效率
    -- 3.灵活：旧表不合理，即将丢弃，但是很多应用是基于该表的，不易修改，可以建立视图映射到新表，通过较少的改动升级数据表

-- 使用多表构建视图
select *
    from emp, dept, salgrade
    where emp.deptno = dept.deptno and
          (sal between losal and hisal);

create view emp_view03
    as
    select empno, ename, dname, grade
    from emp, dept, salgrade
    where emp.deptno = dept.deptno and
          (sal between losal and hisal);

select * from emp_view03;