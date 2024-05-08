package qiaolezi.furniture.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qiaolezi.furniture.bean.Furn;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: furniture_ssm
 * @author: Qiaolezi
 * @create: 2024-05-08 15:19
 * @description:
 **/
public class FurnMapperTest {
	@Test
	public void insertSelective() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		FurnMapper furnMapper = ac.getBean(FurnMapper.class);

		Furn furn = new Furn(null, "北欧风格沙发~", "顺平家居~", new BigDecimal(180), 666,
				7, "assets/images/product-image/1.jpg");

		int i = furnMapper.insertSelective(furn);
		System.out.println("添加成功！受影响的行数：" + i);
	}

	@Test
	public void selectByExample() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		FurnMapper furnMapper = ac.getBean(FurnMapper.class);
		List<Furn> furns = furnMapper.selectByExample(null);
		for (Furn furn : furns) {
			System.out.println(furn);
		}
	}

	@Test
	public void selectByPrimaryKey() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		FurnMapper furnMapper = ac.getBean(FurnMapper.class);
		Furn furn = furnMapper.selectByPrimaryKey(3);
		System.out.println(furn);
	}

	@Test
	public void deleteByPrimaryKey() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		FurnMapper furnMapper = ac.getBean(FurnMapper.class);
		int affectedRow = furnMapper.deleteByPrimaryKey(1);
		System.out.println(affectedRow > 0 ? "删除成功，受影响的行数：" + affectedRow : "删除失败！");
	}

	@Test
	public void updateByPrimaryKey() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		FurnMapper furnMapper = ac.getBean(FurnMapper.class);
		Furn furn = new Furn(2, "北欧盆景", "顺平家居", new BigDecimal(90), 666,
				7, "assets/images/product-image/4.jpg");
		int affectedRow = furnMapper.updateByPrimaryKey(furn);
		System.out.println(affectedRow > 0 ? "操作成功！" : "没有影响表数据");
	}
}
