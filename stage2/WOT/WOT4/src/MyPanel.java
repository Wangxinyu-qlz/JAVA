import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author qiaolezi
 * @version 1.0
 */
//游戏的绘图区域
//	为了监听 键盘事件，实现KeyListener
//	为了让 Panel 不停的重绘子弹，需要 Panel 实现Runnable，作为线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable {
//	定义我的坦克
	Hero hero = null;
//	定义敌方坦克->Vector
	Vector<EnemyTank> enemyTanks = new Vector<>();
//	炸弹->Vector
	Vector<Bomb> bombs = new Vector<>();
//	当子弹击中坦克对象时，就加入一个Bomb对象到bombs
	int enemyTankNumber = 3;//敌方坦克数量

//	定义三张炸弹图像，用于显示爆炸效果
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;

	public MyPanel() {
		hero = new Hero(600, 100);//初始化自己的坦克
		hero.setSpeed(3);
//		初始化敌方坦克
		for (int i = 0; i < enemyTankNumber; i++) {
			EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
			enemyTank.setDirection(2);
			enemyTank.setSpeed(2);
//			启动敌人坦克线程
			new Thread(enemyTank).start();
//			给该enemyTank初始化一颗子弹
			Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirection());
			enemyTank.shots.add(shot);
//			启动线程 shot 对象
			new Thread(shot).start();
			enemyTanks.add(enemyTank);
		}
//		初始化图片对象
		image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
		image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
		image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 1000, 750);//填充矩形，默认为黑色

//		画己方坦克
		if (hero != null && hero.isLive) {
			drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);
		}

//		画出hero的子弹
		for(int i = 0; i < hero.shots.size(); i++) {
			Shot shot = hero.shots.get(i);
			if(shot != null && shot.isLive) {//注意这里的条件顺序
				g.setColor(Color.red);
				g.draw3DRect(shot.x, shot.y, 3, 3, false);
			} else {//如果该shot对象已经无效，从shots集合中删除
				hero.shots.remove(shot);
			}
		}

//		如果 bombs 集合中有对象，就画出
		for (int i = 0; i < bombs.size(); i++) {
//			取出炸弹
			Bomb bomb = bombs.get(i);
//			根据当前 bomb 对象的 life 值画出对应的图片
			if(bomb.life > 6) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
			} else if(bomb.life > 3) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
			} else {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
			}
//			让炸弹生命值减少
			bomb.lifeDown();
//			如果 bomb—life 为0，从集合中删除
			if(bomb.life == 0) {
				bombs.remove(bomb);
			}
		}

//		画敌方坦克，遍历Vector
//		TODO 使用 enemyTanks.size() ，击毁坦克就不再绘制
		for (int i = 0; i < enemyTanks.size(); i++) {
			EnemyTank enemyTank = enemyTanks.get(i);
//			判断坦克是否存活
			if(enemyTank.isLive) {//如果坦克还活着
				drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 0);
	//		    画出 enemyTank 所有的子弹
				for (int j = 0; j < enemyTank.shots.size(); j++) {
	//				取出敌方子弹，准备绘制
					Shot shot = enemyTank.shots.get(j);
	//				绘制，如果子弹isLive，则绘制
					if(shot.isLive) {//isLive == true
						g.draw3DRect(shot.x, shot.y, 3, 3, false);
					} else {//isLive == false
	//					将子弹从Vector中移除，否则会一直绘制
						enemyTank.shots.remove(shot);
					}
				}
			}
		}
	}

	/**
	 * @param x 坦克左上角x坐标
	 * @param y 坦克左上角y坐标
	 * @param g 画笔
	 * @param direction 方向
	 * @param type 类型（坦克型号）
	 */
	public void drawTank(int x,  int y, Graphics g, int direction, int type) {
//		根据不同类型的坦克，设置不同的颜色
		switch (type) {
			case 0://己方坦克
				g.setColor(Color.cyan);
				break;
			case 1://敌方坦克
				g.setColor(Color.yellow);
				break;
		}

//		根据坦克的方向绘制坦克
//      direction 表示方向
//
		switch (direction) {
			case 0://向上
				g.fill3DRect(x, y, 10, 60, false);//左履带
				g.fill3DRect(x + 30, y, 10, 60, false);//右履带
				g.fill3DRect(x + 10, y + 10, 20, 40, false);//车身
				g.fillOval(x + 10, y + 20, 20, 20);//顶盖
				g.drawLine(x + 20, y + 30, x + 20, y);//炮筒
				break;
			case 1://向右
				g.fill3DRect(x, y, 60, 10, false);//左履带
				g.fill3DRect(x, y + 30, 60, 10, false);//右履带
				g.fill3DRect(x + 10, y + 10, 40, 20, false);//车身
				g.fillOval(x + 20, y + 10, 20, 20);//顶盖
				g.drawLine(x + 30, y + 20, x + 60, y + 20);//炮筒
				break;
			case 2://向下
				g.fill3DRect(x, y, 10, 60, false);//左履带
				g.fill3DRect(x + 30, y, 10, 60, false);//右履带
				g.fill3DRect(x + 10, y + 10, 20, 40, false);//车身
				g.fillOval(x + 10, y + 20, 20, 20);//顶盖
				g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮筒
				break;
			case 3://向左
				g.fill3DRect(x, y, 60, 10, false);//左履带
				g.fill3DRect(x, y + 30, 60, 10, false);//右履带
				g.fill3DRect(x + 10, y + 10, 40, 20, false);//车身
				g.fillOval(x + 20, y + 10, 20, 20);//顶盖
				g.drawLine(x + 30, y + 20, x, y + 20);//炮筒
				break;
			default:
				System.out.println("暂时不做处理");
		}
	}

//	如果我们的坦克可以发射多个子弹
//	在判断我方子弹是否击中敌人坦克时，需要把我们的子弹集合中所有的子弹，都取出和敌人所有的坦克进行判断
	public void hitEnemyTank() {
//		遍历己方子弹
		for (int j = 0; j < hero.shots.size(); j++) {
			Shot shot = hero.shots.get(j);
//			判断是否击中敌方坦克
			if(shot != null && shot.isLive) {//我方子弹存活的情况下
//				遍历所有敌方坦克
				for (int i = 0; i < enemyTanks.size(); i++) {
					EnemyTank enemyTank = enemyTanks.get(i);
					hitTank(shot, enemyTank);
				}
			}
		}
	}

//	编写方法，判断敌人坦克是否击中我的坦克
	public void hitHero() {
//		遍历所有的敌人坦克
		for (int i = 0; i < enemyTanks.size(); i++) {
//			取出敌人坦克
			EnemyTank enemyTank = enemyTanks.get(i);
//			遍历某个敌人坦克的所有子弹
			for (int j = 0; j < enemyTank.shots.size(); j++) {
//              取出子弹
				Shot shot = enemyTank.shots.get(j);
//				判断shot是否击中我方坦克
				if(hero.isLive && shot.isLive) {
					hitTank(shot, hero);
				}
			}
		}
	}


//	编写方法，判断子弹是否击中坦克
//	什么时候判断 子弹击中坦克？ run方法中，循环中
	public void hitTank(Shot shot, Tank tank) {
//		判断shot 击中坦克
		switch (tank.getDirection()) {
			case 0://上
			case 2://下
				if(shot.x > tank.getX() && shot.x < tank.getX() + 40 &&
						shot.y > tank.getY() && shot.y < tank.getY() + 60) {
					shot.isLive = false;
					tank.isLive = false;
//					坦克被击毁后，将坦克从集合中移除 否则会击中坦克尸体
					enemyTanks.remove(tank);
//					创建Bomb对象，加入到bombs集合
					Bomb bomb = new Bomb(tank.getX(), tank.getY());
					bombs.add(bomb);
				}
				break;
			case 1://右
			case 3://左
				if(shot.x > tank.getX() && shot.x < tank.getX() + 60 &&
				shot.y > tank.getY() && shot.y < tank.getY() + 40) {
					shot.isLive = false;
					tank.isLive = false;
				}
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {//上
			hero.setDirection(0);
//			修改坦克坐标
			if (hero.getY() > 0) {
				hero.moveUp();
			}
		} else if(e.getKeyCode() == KeyEvent.VK_D) {//右
			hero.setDirection(1);
			if (hero.getX() + 60 < 1000) {
				hero.moveRight();
			}
		} else if(e.getKeyCode() == KeyEvent.VK_S) {//下
			hero.setDirection(2);
			if (hero.getY() + 60 < 750) {
				hero.moveDown();
			}
		} else if(e.getKeyCode() == KeyEvent.VK_A) {//左
			hero.setDirection(3);
			if (hero.getX() > 0) {
				hero.moveLeft();
			}
		}

//		如果用户按下J，就发射
		if(e.getKeyCode() == KeyEvent.VK_J) {//J（发射）
//			只能发射一颗子弹
//			if (hero.shot == null || !hero.shot.isLive) {
//				hero.shotEnemyTank();
//			}

//			发射多颗子弹
			hero.shotEnemyTank();
		}
//		面板重绘
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void run() {
		while(true) {//每隔100毫秒，重绘区域
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

//			判断是否击中敌方坦克
			hitEnemyTank();
//			判断是否击中我方坦克
			hitHero();

			this.repaint();
		}
	}
}
