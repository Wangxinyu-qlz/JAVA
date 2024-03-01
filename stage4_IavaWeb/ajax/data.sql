create database ajaxdb;
use ajaxdb;

create table `user` (
    id INT primary key ,
    usernmae varchar(32) not null default '',
    pwd char(32) not null default '',
    email varchar(32) not null default ''
);

-- 测试数据
insert into `user` values (100, 'king', MD5('123'), 'king@qq.com');
insert into `user` values (200, 'qiaolezi', MD5('666'), 'qiaolezi@qq.com');