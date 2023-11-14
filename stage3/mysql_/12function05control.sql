-- 控制函数
-- if(exp1, exp2, exp3) 如果exp1为true，返回exp2，否则返回exp3
select if(true, '北京', '上海');

-- ifnull(exp1, exp2) 如果exp1为null，返回exp2，否则返回exp1
select ifnull(null, '北京');

-- select case when exp1 then exp2 when exp3 then exp4 else exp5 end;
-- 如果exp1为true，返回exp2，如果exp3为true，返回exp4，否则返回exp5
select case when false then '北京' when true then '错误' else '上海' end;

-- TODO is null
-- 如果comm为null，返回0.00，否则返回comm
select ename, if(comm is null, '0.00', comm) from emp;
select ename, ifnull(comm, '0.00') from emp;
-- TODO = 具体值
select ename, (select case
    when job = 'CLERK' then '普通员工'
    when job = 'MANAGER' then '经理'
    when job = 'SALESMAN' then '销售员'
    else job end)
    from emp;