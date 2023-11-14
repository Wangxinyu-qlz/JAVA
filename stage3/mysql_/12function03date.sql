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
select * from message
    where date_add(send_time, interval 10 minute) >= now();