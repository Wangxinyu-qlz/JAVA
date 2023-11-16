-- 自连接

-- 显示员工和她上级的名字
-- 同一张表当做两张表使用，给表取别名，如果列名不明确，给列取别名
select distinct worker.ename as '职员名', boss.ename as '上级名'
    from emp worker, emp boss
    where worker.mgr = boss.empno;
