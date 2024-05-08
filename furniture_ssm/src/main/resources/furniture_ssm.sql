-- 创建 furniture_ssm
DROP DATABASE IF EXISTS furniture_ssm;
CREATE DATABASE furniture_ssm;
USE furniture_ssm;

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
VALUES (NULL, '北欧风格小桌子 ', '熊猫家居', 180, 666, 7, 'assets/images/product-image/1.jpg');
INSERT INTO furn(`id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '简约风格小椅子 ', '熊猫家居', 180, 666, 7, 'assets/images/product-image/2.jpg');
INSERT INTO furn(`id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '典雅风格小台灯 ', '蚂蚁家居', 180, 666, 7, 'assets/images/product-image/3.jpg');
INSERT INTO furn(`id`, `name`, `maker`, `price`, `sales`, `stock`, `img_path`)
VALUES (NULL, '温馨风格盆景架', '蚂蚁家居', 180, 666, 7, 'assets/images/product-image/4.jpg');

SELECT *
FROM furn;

# 查询列名
SELECT column_name
FROM information_schema.columns
WHERE table_schema = 'furniture_ssm'
AND table_name = 'furn';