-- 优惠券id
local voucherId = ARGV[1]
-- 用户id
local userId = ARGV[2]
-- 订单id
local orderId = ARGV[3]

-- 库存key
local stockKey = 'seckill:stock:' .. voucherId
-- 订单key
local orderKey = 'seckill:order:' .. voucherId

-- 脚本业务
-- 判断库存是否充足
if(tonumber(redis.call('get', stockKey)) <= 0) then
    return 1
end

-- 判断用户是否下单 SISMENBER orderKey userId
if(redis.call('sismember', orderKey, userId) == 1) then
    return 2
end

-- 扣库存
redis.call('incrby', stockKey, -1)

-- 下单
redis.call('sadd', orderKey, userId)

-- 发送消息到队列总 XADD stream.orders * k1 v1 k2 v2 k3 v3
-- 这里使用id是因为VoucherOrder类中的属性名是id，方便实体化
redis.call('xadd', 'stream.orders', '*', 'userId', userId, 'voucherId', voucherId, 'id', orderId)

return 0