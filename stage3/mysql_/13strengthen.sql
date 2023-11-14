-- 单表查询增强

-- 查询1992.1.1以后入职的员工
-- TODO 时间可以直接比较 注意格式
select * from emp
    where hiredate <= '1992-01-01';

-- like 模糊查询
-- %:0到多个任意字符  _:任意单个字符
select * from emp
    where ename like '%A%';
select * from emp
    where ename like '__O%';
alter table emp modify mgr MEDIUMINT UNSIGNED DEFAULT null;
-- 显示没有上级的员工
select * from emp
    where mgr is null;

-- 按照工资从低到高显示雇员的信息
select * from emp
    order by sal;

-- 按照部门号升序，工资降序，显示雇员信息
select * from emp
    order by deptno, sal desc;

-- 分页查询
-- limit start, rows;
-- 从第star+1行开始取，取出rows行
select * from emp
    order by empno
    limit 0, 5;   -- 第一页

select * from emp
    order by empno
    limit 5, 5;   -- 第二页

select * from emp
    order by empno
    limit 10, 5;   -- 第三页

select * from emp
    order by empno
    limit 15, 5;

# select * from emp
#     order by empno
#TODO limit (第几页-1) * 每页的记录数

-- 显示每种岗位的雇员总数和平均工资
select job, count(*), avg(sal) from emp
    group by job;

-- 显示雇员总数以及获得补助的雇员数
select count(*), count(comm) from emp;
-- 统计没有获得补助的雇员人数 TODO 没有返回null count()会统计非null
select count(if(comm is null, 1, null)) from emp;
# select count(ifnull(comm, 1)) from emp;  # TODO 错误的写法，comm is null 返回0， comm is not null 返回  comm
select count(*) - count(comm) from emp;

-- 显示管理人员的总人数，TODO 需要去重
select count(distinct mgr) from emp;
-- 显示雇员工资的最大差额
select max(sal) - min(sal) from emp;

-- TODO 同时出现时顺序：group by, having(分组结果过滤), order by（过滤结果排序）, limit
select avg(sal) as avg_sal, deptno from emp
    group by deptno
    having  avg_sal > 1000
    order by avg_sal desc
    limit 0, 5;