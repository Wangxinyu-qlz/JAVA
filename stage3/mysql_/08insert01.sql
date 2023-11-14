-- 创建一张商品表goods(id int, goods_name varchar(10), price double );
-- 添加两条记录
create table `goods` (
    id int,
    goods_name varchar(10),
    price double );

-- 添加数据
insert into `goods` (id, goods_name, price)
    values(10, '华为手机', 2000);

insert into `goods` (id, goods_name, price)
    values(11, '苹果手机', 4000);

-- 底层会自动类型转换 字符串->int 如果失败则报错
insert into `goods` (id,  goods_name, price)
    values('12', '锤子手机', 3500);
-- Incorrect integer value: 'abc' for column 'id' at row 1
# insert into `goods` (id,  goods_name, price)
#     values('abc', '锤子手机', 3500);

-- 数据长度要在列的规定范围内         varchar(10)
-- Data truncation: Data too long for column 'goods_name' at row 1
# insert into `goods` (id,  goods_name, price)
#     values(13, '锤子手机锤子手机锤子手机锤子手机锤子手机锤子手机锤子手机锤子手机锤子手机锤子手机锤子手机', 3500);

-- 数据顺序要与列顺序匹配
-- Incorrect integer value: '锤子手机' for column 'id' at row 1
# insert into `goods` (id,  goods_name, price)
#     values('锤子手机', 14, 2000);

-- 字符和日期数据必须使用 '' 单引号包含
-- Unknown column '大飞' in 'field list'
-- Data truncation: Incorrect date value: '1987' for column 'birthday' at row 1
# insert into `employee` (id, sex, user_name, birthday, entry_date, job, salary, resume, image)
#     values(1, '男', '大飞', 2000-1-12, '2023-5-4 10:20:34', '砍柴', 3000, '大王叫我来巡山', '');

-- 允许一次插入多条记录
insert into `goods` (id,  goods_name, price)
    values(13, 'oppo手机', 3500), (14, 'vivo手机', 3500);

-- 如果给表中的所有字段插入数据，字段名称可省略
insert into `goods`
    values(15, 'oppo手机', 3500), (16, 'vivo手机', 4600);

-- 默认值，不给某个字段值时，有默认值添加默认值，没有报错
insert into `goods` (id,  goods_name)
    values(17, 'oppo手机');

create table `goods2` (
    id int,
    goods_name varchar(10),
    price double not null default 100);

insert into `goods2` (id, goods_name)
    values(1, '小米手机');
select * from goods2;

desc goods;
select * from goods;
-- 练习
desc employee;
-- 列可以插入空值（null），但前提是允许为null
insert into `employee` (id, sex, user_name, birthday, entry_date, job, salary, resume, image)
    values(1, '男', '大飞', '2000-1-12', '2023-5-4 10:20:34', '砍柴', 3000, '大王叫我来巡山', '');