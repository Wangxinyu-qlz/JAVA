-- 创建 furns_ssm
DROP DATABASE IF EXISTS spring_boot;
CREATE DATABASE spring_boot;
USE spring_boot;

-- 创建家居表
CREATE TABLE furn
(
    `id`       INT(11) PRIMARY KEY AUTO_INCREMENT, ## id
    `name`     VARCHAR(64)    NOT NULL,            ## 家居名
    `maker`    VARCHAR(64)    NOT NULL,            ## 厂商
    `price`    DECIMAL(11, 2) NOT NULL,            ## 价格
    `sales`    INT(11)        NOT NULL,            ## 销量
    `stock`    INT(11)        NOT NULL,            ## 库存
    `img_path` VARCHAR(256)   NOT NULL             ## 照片路径
);

-- 初始化家居数据

INSERT INTO furn(`id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '

北 欧风 格 小桌 子 ', ' 熊 猫家 居', 180, 666, 7,
        'assets/images/product-image/1.jpg');
INSERT INTO furn(`id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '

简 约风 格 小椅 子 ', ' 熊 猫家 居', 180, 666, 7,
        'assets/images/product-image/2.jpg');
INSERT INTO furn(`id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '

典 雅风 格 小台 灯 ', ' 蚂 蚁家 居', 180, 666, 7,
        'assets/images/product-image/3.jpg');
INSERT INTO furn(`id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, ' 温 馨风 格 盆景 架 ', ' 蚂 蚁家 居', 180, 666, 7,
        'assets/images/product-image/4.jpg');

SELECT *
FROM furn;


-- -----------------------------------------------------------------------------------
CREATE DATABASE `springboot_mybatis`;
use `springboot_mybatis`;
CREATE TABLE `monster`
(
    `id`       INT    NOT NULL AUTO_INCREMENT,
    `age`      INT    NOT NULL,
    `birthday` DATE         DEFAULT NULL,
    `email`    VARCHAR(255) DEFAULT NULL,
    `gender`   char(1)      DEFAULT NULL,
    `name`     VARCHAR(255) DEFAULT NULL,
    `salary`   DOUBLE NOT NULL,
    PRIMARY KEY (`id`)
) CHARSET = utf8;

SELECT *
FROM `monster`;
insert into monster
values (null, 20, '2000-11-11', 'nmw@sohu.com', '男', '牛魔王', 5000.88);
insert into monster
values (null, 10, '2011-11-11', 'bgj@sohu.com', '女', '白骨精', 8000.88);
INSERT INTO monster
VALUES (NULL, 20, '2000-11-11', 'xzj@sohu.com', '男', ' 蝎子精', 15000.88);
INSERT INTO monster
VALUES (NULL, 10, '2011-11-11', 'ytj@sohu.com', '女', ' 玉兔精', 18000.88);