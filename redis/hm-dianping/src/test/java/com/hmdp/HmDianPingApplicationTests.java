package com.hmdp;

import com.hmdp.entity.Shop;
import com.hmdp.service.impl.ShopServiceImpl;
import com.hmdp.utils.RedisIdWorker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.hmdp.utils.RedisConstants.SHOP_GEO_KEY;

@SpringBootTest
class HmDianPingApplicationTests {
	@Resource
	private ShopServiceImpl shopService;

	@Resource
	private RedisIdWorker redisIdWorker;

	private ExecutorService es = Executors.newFixedThreadPool(500);
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void testIDWorker() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(300);

		Runnable task = () -> {
			for (int i = 0; i < 100; i++) {
				long id = redisIdWorker.nextId("order");
				System.out.println("id = " + id);
			}
			countDownLatch.countDown();
		};
		long start = System.currentTimeMillis();
		for (int i = 0; i < 300; i++) {
			es.submit(task);
		}
		countDownLatch.await();
		long end = System.currentTimeMillis();
		System.out.println("时间：" + (end - start));
	}

	//逻辑过期 数据预热
	@Test
	public void testSaveShop() {
		shopService.saveShop2Redis(1L, 10L);
	}

	@Test
	void loadShopData() {
		//获取店铺信息
		List<Shop> list = shopService.list();
		//将店铺分组，按照typeId放入一个集合
		Map<Long, List<Shop>> map = list.stream().collect(Collectors.groupingBy(Shop::getTypeId));
		//分批写入redis
		for(Map.Entry<Long, List<Shop>> entry : map.entrySet()){
			//获取类型id
			Long typeId = entry.getKey();
			String key = SHOP_GEO_KEY + typeId;
			//获取同类型的店铺集合
			List<Shop> value = entry.getValue();
			//写入redis
			//for(Shop shop : value) {//效率低
			//	stringRedisTemplate.opsForGeo().add(key, new Point(shop.getX(), shop.getY()), shop.getId().toString());
			//}
			List<RedisGeoCommands.GeoLocation<String>> location = new ArrayList<>(value.size());
			for(Shop shop : value) {//效率低
				location.add(new RedisGeoCommands.GeoLocation<>(
						shop.getId().toString(),
						new Point(shop.getX(), shop.getY())));
			}
			stringRedisTemplate.opsForGeo().add(key, location);
		}
	}

	//UV统计 用户访问量，页面点击量
	@Test
	public void testHyperLogLog() {
		String[] values = new String[1000];
		int j = 0;
		for (int i = 0; i < 1000000; i++) {
			j = i % 1000;
			values[j] = "user_" + i;
			if (j == 999) {
				stringRedisTemplate.opsForHyperLogLog().add("hll", values);
			}
		}
		Long size = stringRedisTemplate.opsForHyperLogLog().size("hll");
		System.out.println("size = " + size);
	}
}
