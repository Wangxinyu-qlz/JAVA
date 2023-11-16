-- 子查询
-- 显示与SMITH同一部门的所有员工
select deptno
    from emp
    where ename = 'SMITH';
select *
    from emp
    where deptno = (select distinct deptno  # 不加distinct:Subquery returns more than 1 row，子查询返回多个值[20,20, 20...]
                    from emp
                    where ename = 'SMITH');

-- 查询和部门10的工作相同的雇员的
-- 名字、岗位、工资、部门号，
-- 但是不包含10号部门自己的

/*
    1.查询10号工作岗位有哪些工作
    2.将1的结果当做子查询使用
*/
select distinct job
    from emp
    where deptno = 10;

select ename, job, sal, deptno
    from emp
    where job in (select distinct job
                  from emp
                  where deptno = 10)
    and deptno <> 10;  # !=

