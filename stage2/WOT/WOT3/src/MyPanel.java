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
	Vector<EnemyTank> enemyTanks = new Vector<>();
	int enemyTankNumber = 3;//敌方坦克数量
	public MyPanel() {
		hero = new Hero(100, 100);//初始化自己的坦克
		hero.setSpeed(3);
//		初始化敌方坦克
		for (int i = 0; i < enemyTankNumber; i++) {
			EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
			enemyTank.setDirection(2);
			enemyTanks.add(enemyTank);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 1000, 750);//填充矩形，默认为黑色

//		画己方坦克
		drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);

//		会画出hero的子弹
		if(hero.shot != null && hero.shot.isLive != false) {//注意这里的条件顺序
			g.setColor(Color.red);
			g.draw3DRect(hero.shot.x, hero.shot.y, 3, 3, false);
		}

//		画敌方坦克，遍历Vector
//		TODO 使用 enemyTanks.size() ，击毁坦克就不再绘制
		for (int i = 0; i < enemyTanks.size(); i++) {
			EnemyTank enemyTank = enemyTanks.get(i);
			drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 0);
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

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {//上
			hero.setDirection(0);
//			修改坦克坐标
			hero.moveUp();
		} else if(e.getKeyCode() == KeyEvent.VK_D) {//右
			hero.setDirection(1);
			hero.moveRight();
		} else if(e.getKeyCode() == KeyEvent.VK_S) {//下
			hero.setDirection(2);
			hero.moveDown();
		} else if(e.getKeyCode() == KeyEvent.VK_A) {//左
			hero.setDirection(3);
			hero.moveLeft();
		}

//		如果用户按下J，就发射
		if(e.getKeyCode() == KeyEvent.VK_J) {//J（发射）
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
			this.repaint();
		}
	}
}
