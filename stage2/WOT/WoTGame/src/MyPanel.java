import javax.swing.*;
import java.awt.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
//游戏的绘图区域
public class MyPanel extends JPanel {
//	定义我的坦克
	Hero hero = null;
	public MyPanel() {
		hero = new Hero(100, 100);//初始化自己的坦克
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 1000, 750);//填充矩形，默认为黑色

//		画坦克
		drawTank(hero.getX(), hero.getY(), g, 0, 0);
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
		switch (direction) {
			case 0:
				g.fill3DRect(x, y, 10, 60, false);//左履带
				g.fill3DRect(x + 30, y, 10, 60, false);//右履带
				g.fill3DRect(x + 10, y + 10, 20, 40, false);//车身
				g.fillOval(x + 10, y + 20, 20, 20);//顶盖
				g.drawLine(x + 20, y + 30, x + 20, y);//炮筒
				break;
			default:
				System.out.println("暂时不做处理");
		}
	}
}
