-- 字符串相关的函数 使用emp表

-- 返回字符串字符集
select charset(ename) from emp;

-- 链接字符串
select concat(ename, ' job is ', job) from emp;

-- 返回substring在string中出现的位置，没有返回0
select instr('hanshunping', 'han') from dual;  # 1

-- 转换为大写
select upper('hanshunpingBIG') from dual;
-- 转换为小写
select lower('HANSHUNPINGaewtr') from dual;

-- 从string中的左边开始截取length个字符
select left('hanshunmping', 19) from dual;  # hanshunmping

-- string的长度
select length('hello') from dual;

-- 在str1中，使用str3替换str2
select replace('hello', 'llo', 'el') from dual;  # heel

-- 逐字符统计字符串大小
select strcmp('hello', 'hello') from dual;  # 0
select strcmp('hello', 'he2') from dual;  # 1
select strcmp('hel', 'hello') from dual;  # -1

-- 获得substring
select substr('hanshunping', 1, 3) from dual;  # han

-- 去除前端空格
select trim('   hanshunping   0') from dual;  #hanshunping   0
-- 去除后端空格
select rtrim('hanshunping   ') from dual;  #hanshunping

-- 所有员工名字首字母大写，其余小写
select concat(substr(ename, 1, 1), lcase(substr(ename, 2))) from emp;