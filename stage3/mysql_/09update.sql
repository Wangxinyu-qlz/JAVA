-- 修改employee表中的数据

-- 不带where条件子句的update语句 会修改表中所有的数据
update employee set salary = 5000;

-- 将小妖怪的薪水改为1000
update employee
    set salary = 1000
    where user_name = '小妖怪';

-- 将老妖怪的薪水在原有的基础上+1000
insert into employee (id, sex, user_name, birthday, entry_date, job, salary, resume, image)
    values (200, '男', '老妖怪', '1900-2-28',  '2018-1-1', '老妖怪', 9000, '老妖怪', '');
update employee
    set salary = salary + 1000
    where user_name = '老妖怪';

-- 可以修改多个列
update employee
    set salary = salary + 5000, job = '军师'
    where user_name = '老妖怪';

select * from employee;