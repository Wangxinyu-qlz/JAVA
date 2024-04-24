create database spring;
use spring;

create table monster(id INT PRIMARY KEY ,`name` VARCHAR(64) NOT NULL DEFAULT '',
                     skill VARCHAR(64) NOT NULL DEFAULT ''
) CHARSET = utf8;

INSERT INTO monster VALUES(100, '孙悟空', '72变');
INSERT INTO monster VALUES(200, '猪八戒', '高老庄');
INSERT INTO monster VALUES(300, '沙和尚', '流沙河');

# 用户表
create table `user_account`
(
    user_id     INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `user_name` VARCHAR(64) NOT NULL DEFAULT '',
    `money`     DOUBLE      NOT NULL DEFAULT 0.0
) CHARSET = utf8;
INSERT INTO `user_account`
VALUES (NULL, '张三', 1000);
INSERT INTO `user_account`
VALUES (NULL, '李四', 2000);

# 商品表
create table `goods`
(
    goods_id     INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `goods_name` VARCHAR(64) NOT NULL DEFAULT '',
    `price`      DOUBLE      NOT NULL DEFAULT 0.0
) CHARSET = utf8;
INSERT INTO `goods`
VALUES (NULL, '风扇', 10.0);
INSERT INTO `goods`
VALUES (NULL, '台灯', 12.0);
INSERT INTO `goods`
VALUES (NULL, '可口可乐', 3.0);

# 商品表
create table `goods_amount`
(
    goods_id     INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `goods_num` INT NOT NULL DEFAULT 0
) CHARSET = utf8;
INSERT INTO `goods_amount` VALUES (1, 200);
INSERT INTO `goods_amount` VALUES (2, 20);
INSERT INTO `goods_amount` VALUES (3, 15);

# TODO 查看数据集的默认隔离级别
SELECT @@global.transaction_isolation