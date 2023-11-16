-- 合并查询 union   union all
select ename, sal, job
    from emp
    where sal > 2500;
select ename, sal, job
from emp
where job = 'MANAGER';

-- union all 简单的合并，不去重
select ename, sal, job
    from emp
    where sal > 2500
union all
select ename, sal, job
from emp
where job = 'MANAGER';

-- union 去重
select ename, sal, job
    from emp
    where sal > 2500
union
select ename, sal, job
from emp
where job = 'MANAGER';