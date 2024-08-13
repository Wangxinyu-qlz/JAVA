package strategy;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 09:23
 * @description:
 **/
//具体策略类
public class AirStrategy implements TravelStrategy{
	@Override
	public void travelAlgorithm() {
		System.out.println("飞机");
	}
}
