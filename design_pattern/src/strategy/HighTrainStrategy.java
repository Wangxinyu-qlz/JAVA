package strategy;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 09:22
 * @description:
 **/
//具体策略类
public class HighTrainStrategy implements TravelStrategy{
	@Override
	public void travelAlgorithm() {
		System.out.println("高铁");
	}
}
