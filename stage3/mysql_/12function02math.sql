-- 数学函数
select abs(-9) from dual;  # 9
-- 十进制->二进制
select bin(3) from dual;  # 11

-- 向上取整
select ceiling(3.3);  # 4
-- 向下取整
select floor(3.3);  # 3

-- 保留小数位数
select format(3.3, 3);  # 3.30
select format(3.322222, 3)  # 3.322

-- 转16进制
select hex(10);  # A

-- 求最小值
select least(1, 2, 3, -9);  # -9

-- 取余
select mod(12, 5);  # 2
select mod(12, 2);  # 0

-- 随机数,seed固定，随机数就固定
select rand(7);
-- 每次返回不同的随机数
select rand();
