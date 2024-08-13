package strategy;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 09:24
 * @description:
 * 表示的是在遇到一种问题有多种解法的时候，
 * 根据环境或者条件的不同选择不同的算法或者策略来完成该功能
 *
 * 环境类(Context):用来操作策略的上下文环境，也就是我们游客。
 * 抽象策略类(Strategy):策略的抽象，出行方式的抽象
 * 具体策略类(ConcreteStrategy):具体的策略实现，每一种出行方式的具体实现。
 **/
//环境类
public class Traveler {
	//出行策略接口
	TravelStrategy travelStrategy;
	//设置出行策略
	public void setTravelStrategy(TravelStrategy travelStrategy) {
		this.travelStrategy = travelStrategy;
	}
	//为当前用户设置出行方式
	public void travelStyle() {
		travelStrategy.travelAlgorithm();
	}

	public static void main(String[] args) {
		Traveler traveler = new Traveler();
		traveler.setTravelStrategy(new TrainStrategy());
		traveler.travelStyle();
	}
}
