package strategy;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-13 09:24
 * @description:
 * 对象行为型模式
 *
 * 表示的是在遇到一种问题有多种解法的时候，
 * 根据环境或者条件的不同选择不同的算法或者策略来完成该功能
 *
 * 环境类(Context):用来操作策略的上下文环境，也就是我们游客。
 * 抽象策略类(Strategy):策略的抽象，出行方式的抽象
 * 具体策略类(ConcreteStrategy):具体的策略实现，每一种出行方式的具体实现。
 *
 *
 * 优点：
 *      我们之前在选择出行方式的时候，往往会使用if-else语句，
 *      也就是用户不选择A那么就选择B这样的一种情况。
 *      这种情况耦合性太高了，而且代码臃肿，
 *      有了策略模式我们就可以避免这种现象，
 *      策略模式遵循开闭原则，实现代码的解耦合。
 *      扩展新的方法时也比较方便，
 *      只需要继承策略接口就好了
 *  缺点：
 *      客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
 *      策略模式会出现很多的策略类。context在使用这些策略类的时候，
 *      这些策略类由于继承了策略接口，所以有些数据可能用不到，但是依然初始化了。
 *
 * 与状态模式的区别
 *      策略模式只是条件选择方法，只执行一次方法，
 *      而状态模式是随着状态的改变不停地更改执行方法。
 *      举个例子，就好比我们旅游，对于策略模式我们只需要选择其中一种出行方法就好了，
 *      但是状态模式不一样，可能我们到了A地点选择的是火车，到了B地点又选择飞机，
 *      根据不同的状态选择不同的出行方式。
 * 与工厂模式的区别
 *      工厂模式是创建型模式 ，它关注对象创建，提供创建对象的接口，
 *      让对象的创建与具体的使用客户无关。 策略模式是对象行为型模式 ，
 *      它关注行为和算法的封装 。再举个例子，还是我们出去旅游，
 *      对于策略模式我们只需要选择其中一种出行方法就好，但是工厂模式不同，
 *      工厂模式是你决定哪种旅行方案后，由工厂代替你去构建具体方案
 *      （工厂代替你去买火车票）。
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
