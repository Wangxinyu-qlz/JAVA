package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hmdp.dto.Result;
import com.hmdp.entity.ShopType;
import com.hmdp.mapper.ShopTypeMapper;
import com.hmdp.service.IShopTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.CACHE_SHOP_TYPE_KEY;
import static com.hmdp.utils.RedisConstants.CACHE_SHOP_TYPE_TTL;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Slf4j
@Service
public class ShopTypeServiceImpl extends ServiceImpl<ShopTypeMapper, ShopType> implements IShopTypeService {
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private IShopTypeService typeService;
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public Result queryTypeList() {
		//1.从redis查询所有的商铺类型缓存
		Set<String> shopTypes = stringRedisTemplate.opsForZSet().range(CACHE_SHOP_TYPE_KEY, 0, -1);
		// 2. 存在，转换为 ShopType 对象列表并返回
		if (!CollectionUtils.isEmpty(shopTypes)) {
			List<ShopType> shopTypeList = new ArrayList<>();
			for (String shopTypeJson : shopTypes) {
				try {
					ShopType shopType = objectMapper.readValue(shopTypeJson, ShopType.class);
					shopTypeList.add(shopType);
				} catch (JsonProcessingException e) {
					log.error("An error occurred", e);
					// 处理 JSON 转换异常
					return Result.fail("数据处理错误");
				}
			}
			return Result.ok(shopTypeList);
		}
		//3.不存在，从数据库查询
		List<ShopType> typeList = typeService.query().orderByAsc("sort").list();
		System.out.println(typeList);
		if (CollectionUtils.isEmpty(typeList)) {
			//4.不存在，返回错误
			return Result.fail("商铺类型不存在");
		}

		//5.存在，保存到redis，设置有效期
		ZSetOperations<String, String> zSetOps = stringRedisTemplate.opsForZSet();
		for (ShopType type : typeList) {
			try {
				//将ShopType转换为JsonNode
				JsonNode jsonNode = objectMapper.valueToTree(type);
				//将sort字段去除
				if (jsonNode.isObject()) {
					ObjectNode objectNode = (ObjectNode) jsonNode;
					objectNode.remove("sort");
				}
				//将ObjectNode转换为JSON字符串
				String json = objectMapper.writeValueAsString(jsonNode);
				zSetOps.add(CACHE_SHOP_TYPE_KEY, json, type.getSort());
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}
		stringRedisTemplate.expire(CACHE_SHOP_TYPE_KEY, CACHE_SHOP_TYPE_TTL, TimeUnit.MINUTES);
		//返回
		return Result.ok(typeList);
	}
}
