import java.util.Vector;

/**
 * @author qiaolezi
 * @version 1.0
 */
//自己的坦克
public class Hero extends Tank{
//	定义一个Shot对象，表示一个射击（线程）
	Shot shot = null;
	Vector<Shot> shots = new Vector<>();
	public Hero(int x, int y) {
		super(x, y);
	}

	//射击
	public void shotEnemyTank() {
//		控制最多只能有5颗子弹，且坦克死了就不能发射子弹
		if (shots.size() == 5 || !isLive) {
			return;
		}
//		创建Shot对象，需要根据当前hero的位置和方向
//		TODO getDirection? 继承了父类的所有方法和属性
		switch(getDirection()) {
			case 0://上
				shot = new Shot(getX() + 20, getY(), 0);
				break;
			case 1://右
				shot = new Shot(getX() + 60, getY() + 20, 1);
				break;
			case 2://下
				shot = new Shot(getX() + 20, getY() + 60, 2);
				break;
			case 3://左
				shot = new Shot(getX(), getY() + 20, 3);
				break;
		}
//将新建的shot放入到shots中
		shots.add(shot);
//		启动射击线程
		new Thread(shot).start();

	}
}
