import java.util.Vector;

/**
 * @author qiaolezi
 * @version 1.0
 * 敌方坦克
 */
public class EnemyTank extends Tank implements Runnable{
	//	在敌人坦克类，使用Vector 保存多个Shot
	Vector<Shot> shots = new Vector<>();

//	增加成员，EnemyTank 可以得到敌人坦克的Vector
	Vector<EnemyTank> enemyTanks = new Vector();

//	这里提供一个方法，可以将MyPanel的对象的成员 Vector<EnemyTank> enemyTanks = new Vector<>();
//	设置到EnemyTank类的成员enemyTanks
	public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
		this.enemyTanks = enemyTanks;
	}

//	编写方法，判断当前的敌人坦克，是否和enemyTanks中的其他坦克发生重叠（碰撞）
	public boolean isTouchEnemyTank() {
//		判断当前敌人坦克（this）的方向
		switch(this.getDirection()) {
			case 0:
//				让当前的这个敌人坦克，和其他所有的敌人坦克比较
				for (int i = 0; i < enemyTanks.size(); i++) {
//					从Vector中取出一辆坦克
					EnemyTank enemyTank = enemyTanks.get(i);
//					不和自己比较
					if(enemyTank != this) {
//						如果敌人坦克的方向是上/下
//						x范围 [enemyTank.getX(), enemyTank.getX() + 40]
//						y范围 [enemyTank.getY(), enemyTank.getY() + 60]
						if(enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
//							当前坦克左上角坐标 [this,getX(), this.getY()]
							if(this.getX() >= enemyTank.getX()
									&& this.getX() <= enemyTank.getX() + 40
									&& this.getY() >= enemyTank.getY()
									&& this.getY() <= enemyTank.getY() + 60) {
								return true;
							}
//							当前坦克右上角坐标 [this,getX() + 40, this.getY()]
							if(this.getX() + 40 >= enemyTank.getX()
									&& this.getX() + 40 <= enemyTank.getX() + 40
									&& this.getY() >= enemyTank.getY()
									&& this.getY() <= enemyTank.getY() + 60) {
								return true;
							}
						}
//						如果敌人坦克的方向是右/左
//						x范围 [enemyTank.getX(), enemyTank.getX() + 60]
//						y范围 [enemyTank.getY(), enemyTank.getY() + 40]
						if(enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
//							当前坦克左上角坐标 [this,getX(), this.getY()]
							if(this.getX() >= enemyTank.getX()
									&& this.getX() <= enemyTank.getX() + 60
									&& this.getY() >= enemyTank.getY()
									&& this.getY() <= enemyTank.getY() + 40) {
								return true;
							}
//							当前坦克右上角坐标 [this,getX() + 40, this.getY()]
							if(this.getX() + 40 >= enemyTank.getX()
									&& this.getX() + 40 <= enemyTank.getX() + 60
									&& this.getY() >= enemyTank.getY()
									&& this.getY() <= enemyTank.getY() + 40) {
								return true;
							}
						}
					}
				}
				break;
			case 1:
//				让当前的这个敌人坦克，和其他所有的敌人坦克比较
				for (int i = 0; i < enemyTanks.size(); i++) {
//					从Vector中取出一辆坦克
					EnemyTank enemyTank = enemyTanks.get(i);
//					不和自己比较
					if(enemyTank != this) {
//						如果敌人坦克的方向是上/下
//						x范围 [enemyTank.getX(), enemyTank.getX() + 40]
//						y范围 [enemyTank.getY(), enemyTank.getY() + 60]
						if(enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
//							当前坦克右上角坐标 [this,getX() + 60, this.getY()]
							if(this.getX() + 60 >= enemyTank.getX()
									&& this.getX() + 60 <= enemyTank.getX() + 40
									&& this.getY() >= enemyTank.getY()
									&& this.getY() <= enemyTank.getY() + 60) {
								return true;
							}
//							当前坦克右下角坐标 [this,getX() + 60, this.getY() + 40]
							if(this.getX() + 60 >= enemyTank.getX()
									&& this.getX() + 60 <= enemyTank.getX() + 40
									&& this.getY() + 40 >= enemyTank.getY()
									&& this.getY() + 40 <= enemyTank.getY() + 60) {
								return true;
							}
						}
//						如果敌人坦克的方向是右/左
//						x范围 [enemyTank.getX(), enemyTank.getX() + 60]
//						y范围 [enemyTank.getY(), enemyTank.getY() + 40]
						if(enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
//							当前坦克右上角坐标 [this,getX() + 60, this.getY()]
							if(this.getX() + 60 >= enemyTank.getX()
									&& this.getX() + 60 <= enemyTank.getX() + 60
									&& this.getY() >= enemyTank.getY()
									&& this.getY() <= enemyTank.getY() + 40) {
								return true;
							}
//							当前坦克右下角坐标 [this,getX() + 60, this.getY() + 40]
							if(this.getX() + 60 >= enemyTank.getX()
									&& this.getX() + 60 <= enemyTank.getX() + 60
									&& this.getY() + 40  >= enemyTank.getY()
									&& this.getY() + 40  <= enemyTank.getY() + 40) {
								return true;
							}
						}
					}
				}
				break;
			case 2:
//				让当前的这个敌人坦克，和其他所有的敌人坦克比较
				for (int i = 0; i < enemyTanks.size(); i++) {
//					从Vector中取出一辆坦克
					EnemyTank enemyTank = enemyTanks.get(i);
//					不和自己比较
					if(enemyTank != this) {
//						如果敌人坦克的方向是上/下
//						x范围 [enemyTank.getX(), enemyTank.getX() + 40]
//						y范围 [enemyTank.getY(), enemyTank.getY() + 60]
						if(enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
//							当前坦克左下角坐标 [this,getX(), this.getY() + 60]
							if(this.getX() >= enemyTank.getX()
									&& this.getX() <= enemyTank.getX() + 40
									&& this.getY() + 60 >= enemyTank.getY()
									&& this.getY() + 60 <= enemyTank.getY() + 60) {
								return true;
							}
//							当前坦克右下角坐标 [this,getX() + 40, this.getY() + 60]
							if(this.getX() + 40 >= enemyTank.getX()
									&& this.getX() + 40 <= enemyTank.getX() + 40
									&& this.getY() + 60 >= enemyTank.getY()
									&& this.getY() + 60 <= enemyTank.getY() + 60) {
								return true;
							}
						}
//						如果敌人坦克的方向是右/左
//						x范围 [enemyTank.getX(), enemyTank.getX() + 60]
//						y范围 [enemyTank.getY(), enemyTank.getY() + 40]
						if(enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
//							当前坦克左下角坐标 [this,getX(), this.getY() + 60]
							if(this.getX() >= enemyTank.getX()
									&& this.getX() <= enemyTank.getX() + 60
									&& this.getY() + 60 >= enemyTank.getY()
									&& this.getY() + 60 <= enemyTank.getY() + 40) {
								return true;
							}
//							当前坦克右下角坐标 [this,getX() + 40, this.getY() + 60]
							if(this.getX() + 40 >= enemyTank.getX()
									&& this.getX() + 40 <= enemyTank.getX() + 60
									&& this.getY() + 60 >= enemyTank.getY()
									&& this.getY() + 60 <= enemyTank.getY() + 40) {
								return true;
							}
						}
					}
				}
				break;
			case 3:
//				让当前的这个敌人坦克，和其他所有的敌人坦克比较
				for (int i = 0; i < enemyTanks.size(); i++) {
//					从Vector中取出一辆坦克
					EnemyTank enemyTank = enemyTanks.get(i);
//					不和自己比较
					if(enemyTank != this) {
//						如果敌人坦克的方向是上/下
//						x范围 [enemyTank.getX(), enemyTank.getX() + 40]
//						y范围 [enemyTank.getY(), enemyTank.getY() + 60]
						if(enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
//							当前坦克左上角坐标 [this,getX(), this.getY()]
							if(this.getX() >= enemyTank.getX()
									&& this.getX() <= enemyTank.getX() + 40
									&& this.getY() >= enemyTank.getY()
									&& this.getY() <= enemyTank.getY() + 60) {
								return true;
							}
//							当前坦克左下角坐标 [this,getX(), this.getY() + 40]
							if(this.getX() >= enemyTank.getX()
									&& this.getX() <= enemyTank.getX() + 40
									&& this.getY() + 40 >= enemyTank.getY()
									&& this.getY() + 40 <= enemyTank.getY() + 60) {
								return true;
							}
						}
//						如果敌人坦克的方向是右/左
//						x范围 [enemyTank.getX(), enemyTank.getX() + 60]
//						y范围 [enemyTank.getY(), enemyTank.getY() + 40]
						if(enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
//							当前坦克左上角坐标 [this,getX(), this.getY()]
							if(this.getX() >= enemyTank.getX()
									&& this.getX() <= enemyTank.getX() + 60
									&& this.getY() >= enemyTank.getY()
									&& this.getY() <= enemyTank.getY() + 40) {
								return true;
							}
//							当前坦克左下角坐标 [this,getX(), this.getY() + 40]
							if(this.getX() >= enemyTank.getX()
									&& this.getX() <= enemyTank.getX() + 60
									&& this.getY() + 40 >= enemyTank.getY()
									&& this.getY() + 40 <= enemyTank.getY() + 40) {
								return true;
							}
						}
					}
				}
				break;
		}
		return false;

	}

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
						if (getY() > 0 && !isTouchEnemyTank()) {
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
						if (getX() + 60 < 1000 && !isTouchEnemyTank()) {
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
						if (getY() + 60  < 750 && !isTouchEnemyTank()) {
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
						if (getX() > 0 && !isTouchEnemyTank()) {
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
