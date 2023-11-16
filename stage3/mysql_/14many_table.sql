-- 多表查询
-- 两个表查询时，规则：
-- 1.确定主表
-- 2.从主表中取出每一行，和第二张表的每一行记录进行组合（笛卡尔积）
-- 3.返回结果 记录数量 = 主表行数 * 第二张表行数
-- 4.所以要写出正确的过滤条件 where

-- 显示雇员名称 工资 所在部门的名字 deptno
-- 指定显示指定表的列时，需要指定表的名字 table.列
select ename, sal, dname, emp.deptno
    from emp, dept
    where emp.deptno = dept.deptno;

-- 显示10号部门的雇员名称 工资 所在部门的名字
select ename, sal, dname, emp.deptno
    from emp, dept
    where emp.deptno = dept.deptno and emp.deptno = 10;
select ename, sal, dname, emp.deptno
    from emp, dept
    where emp.deptno = dept.deptno
    having emp.deptno = 10;  # 在 HAVING 子句中使用无聚合条件可能会导致效率低下。可以考虑将它们移至 WHERE 中

-- TODO 显示各个员工的姓名、工资、工资的级别
-- TODO sql语句先写简单的，再加入过滤条件
select ename, sal, grade
    from emp, salgrade
    where emp.sal between salgrade.losal and salgrade.hisal;

-- 显示雇员名字、工资、所在部门的名字，按照部门降序排序
select ename, sal, dname, emp.deptno
    from emp, dept
    where emp.deptno = dept.deptno
    order by deptno desc;