-- 子查询

-- 查询ecshope中各个类别中，价格最高的商品
-- 查询商品表，价格最高的商品 max+group by cat_id
select cat_id, max(shop_price)
    from ecs_goods
    group by cat_id;

select goods_id, cat_id, goods_name, shop_price
    from ecs_goods;

-- TODO 将子查询当做一张临时表可以解决很多复杂的查询
-- TODO Column 'cat_id' in field list is ambiguous
select goods_id, ecs_goods.cat_id, goods_name, shop_price
    from (
    select cat_id, max(shop_price) as max_price
    from ecs_goods
    group by cat_id
    ) temp, ecs_goods
    where temp.cat_id = ecs_goods.cat_id
        and temp.max_price = ecs_goods.shop_price