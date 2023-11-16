-- 多列子查询

-- 查询和宋江的语数英完全相同的人，其本人排除在外
select *
    from student
    where (chinese, math, english) = (select chinese, math, english
                                      from student
                                      where name = '宋江')
    and name <> '宋江';

-- 查询与SMITH的部门和岗位完全相同的人，其本人排除在外
select *
    from emp
    where (deptno, job) = (select deptno, job
                           from emp
                           where ename = 'ALLEN')
    and ename <> 'ALLEn';

-- 查询每个部门工资高于本部门平均工资的人的资料
select ename, sal, temp.avg_sal, emp.deptno
    from (select deptno, avg(sal) as avg_sal
          from emp
          group by deptno
          ) temp, emp
    where emp.sal > temp.avg_sal
    and emp.deptno = temp.deptno;

-- 查询每个部门的信息以及人员数量
select count(*), deptno
    from emp
    group by deptno;

-- TODO table.*表示将该表的所有列显示出来，多表查询中，多表的列不重复时，才可以直接写列名
select temp.*, temp.personnumber
    from dept, (select count(*) as personnumber, deptno
    from emp
    group by deptno) temp
    where dept.deptno = temp.deptno;