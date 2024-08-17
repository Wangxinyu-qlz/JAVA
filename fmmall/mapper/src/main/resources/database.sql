create database fmmall;

use fmmall;

create table users(
    user_id bigint primary key auto_increment,
    user_name varchar(32),
    user_pwd varchar(64),
    user_realname varchar(32),
    user_img varchar(32)
) ;

insert into users (user_id, user_name, user_pwd, user_realname, user_img)
values (0000001, 'qlz', '123', 'wangliang', 'c:/img.png');

drop table users;  # 删除表

alter table users add user_pwd varchar(64) after user_name;