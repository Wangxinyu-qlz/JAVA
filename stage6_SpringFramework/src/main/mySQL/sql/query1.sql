create database spring;
use spring;

create table monster(id INT PRIMARY KEY ,`name` VARCHAR(64) NOT NULL DEFAULT '',
skill VARCHAR(64) NOT NULL DEFAULT '') CHARSET = utf8

INSERT INTO monster VALUES(100, '孙悟空', '72变');
INSERT INTO monster VALUES(200, '猪八戒', '高老庄');
INSERT INTO monster VALUES(300, '沙和尚', '流沙河');