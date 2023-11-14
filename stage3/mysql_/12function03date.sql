-- 日期函数

-- 获取当前日期
select current_date();
-- 获取当前时间
select current_time();
-- 返回当前日期时间
select now();  # 2023-11-14 20:46:11
-- 获取当前时间戳  年/月/日/时分/秒
select current_timestamp();


-- 创建测试表
create table message(
    id int,
    content varchar(30),
    send_time datetime
);
insert into message (id, content, send_time) VALUES (1, '北京新闻', current_timestamp);
insert into message (id, content, send_time) VALUES (2, '上海新闻', current_timestamp);
insert into message (id, content, send_time) VALUES (3, '广州新闻', current_timestamp);
select * from message;

-- 显示所有新闻信息，发布日期只显示日期 不显示时间
select id, content, date(send_time) from message;
-- 查询在10分钟内发布的新闻
select * from message
    where send_time > current_timestamp - interval 10 minute;
-- TODO send_time++++++++10 minutes++++++++++now
-- 如果send_time+10minutes >= now，说明send_time在10 minutes以内
select * from message
    where date_add(send_time, interval 10 minute) >= now();
select * from message
    where date_sub(now(), interval 10 minute) <= send_time;

-- 求时间差
select datediff('1990-1-1', '2023-5-1');  # -12173
select datediff('2023-5-1', '1990-1-1');  # 12173
-- 求活了多少天
select datediff(now(), '1999.6.12');
-- 求还能活多少天
-- TODO interval 10 year 后面可以是 年/月/日/时分/秒
select datediff(date_add('1999-03-10', interval 80 year), now());

-- 只有年
select year(now()) from dual;
-- 只有月
select month(now()) from dual;
-- 只有日
select day(now()) from dual;
-- 只有时
select hour(now()) from dual;
-- 只有分
select minute(now()) from dual;
-- 只有秒
select second(now()) from dual;

-- unix-timestamp  返回1970-1-1到现在的秒数
select unix_timestamp();  #  1621011251
-- TODO %Y-%m-%d %H:%i:%s格式是固定的
-- TODO 在开发中，可以存放一个整数，然后表示一个时间，通过from_unixtime转换
select from_unixtime(unix_timestamp(), '%Y-%m-%d %H:%i:%s') from dual;