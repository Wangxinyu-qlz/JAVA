import java.util.Vector;

/**
 * @author qiaolezi
 * @version 1.0
 * 敌方坦克
 */
public class EnemyTank extends Tank implements Runnable{
	//	在敌人坦克类，使用Vector 保存多个Shot
	Vector<Shot> shots = new Vector<>();
	public EnemyTank(int x, int y) {
		super(x, y);
	}

	@Override
	public void run() {
		while (true) {
//			如果shots.size() == 0，就创建一颗子弹，放入饭shots集合并启动
			Shot s = null;
			if(isLive && shots.size() < 2) {//坦克活着 & 子弹数量不够10个（单个坦克可以发射多个子弹）
//				判断坦克的方向并创建对应的子弹
				switch(getDirection()) {
					case 0:
						s = new Shot(getX() + 20, getY(), 0);
						break;
					case 1:
						s = new Shot(getX() + 60, getY() + 20, 1);
						break;
					case 2:
						s = new Shot(getX() + 20, getY() + 60, 2);
						break;
					case 3:
						s = new Shot(getX(), getY() + 20, 3);
						break;
				}
				shots.add(s);
//				启动
				new Thread(s).start();
			}


//			根据坦克的方向继续移动
			switch (getDirection()) {
				case 0:
					for (int i = 0; i < 30; i++) {
//  					让坦克保持一个方向，走30步
						if (getY() > 0) {
							moveUp();
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}
					break;

				case 1:
					for (int i = 0; i < 30; i++) {
//  					让坦克保持一个方向，走30步
						if (getX() + 60 < 1000) {
							moveRight();
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					break;
				case 2:
					for (int i = 0; i < 30; i++) {
//  					让坦克保持一个方向，走30步
						if (getY() + 60  < 750) {
							moveDown();
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					break;
				case 3:
					for (int i = 0; i < 30; i++) {
//  					让坦克保持一个方向，走30步
						if (getX() > 0) {
							moveLeft();
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					break;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

//			随机改变坦克方向
			setDirection((int) (Math.random() * 4));

//			TODO 多线程，需要考虑清楚 该线程何时结束
			if(!isLive) {
				break;//退出线程
			}
		}
	}
}
