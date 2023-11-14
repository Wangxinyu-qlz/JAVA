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
    where emp.deptno = dept.deptno