import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author qiaolezi
 * @version 1.0
 * 演示通过键盘WSAD控制小球移动->JAVA的事件控制
 */
public class BallMove extends JFrame{
	MyPanel mp = null;
	public static void main(String[] args) {
		new BallMove();
	}

	public BallMove() {
		mp = new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

//画板
class MyPanel extends JPanel implements KeyListener {
//	为了让小球移动，将其左上角坐标(x, y)设置为变量
	int x = 10;
	int y = 10;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillOval(x, y, 20, 20);//默认黑色
	}

//	监听字符输入
	@Override
	public void keyTyped(KeyEvent e) {

	}

//	监听键按下
	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println((char) e.getKeyCode() + "被按下");
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {//下键
			y++;
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			y--;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			x--;
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x++;
		}
//		面板重绘
		this.repaint();
	}

//	监听键松开
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println((char) e.getKeyCode() + "被松开");
	}
}
