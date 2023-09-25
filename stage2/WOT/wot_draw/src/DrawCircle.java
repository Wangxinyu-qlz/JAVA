import javax.swing.*;
import java.awt.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class DrawCircle extends JFrame{//窗口/画框
//	定义一个面板
	private MyPanel mp = null;
	public static void main(String[] args) {
		DrawCircle drawCircle = new DrawCircle();

	}

	public DrawCircle() {
//		初始化画板
		mp = new MyPanel();
//		把面板放进窗口
		this.add(mp);
//		设置窗口大小
		this.setSize(4000, 3000);
//		点击窗口的x，程序完全退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);//可以显示
	}
}

//先定义一个画板 Panel，继承JPanel类，在此面板上画图
class MyPanel extends JPanel {
//	说明：
//	1.MyPanel 对象是一个画板
//	2.Graphics g画笔
//	3.Graphics提供了很多绘图方法
	@Override
	public void paint(Graphics g) {//绘图方法
		super.paint(g);//调用父类的方法，完成初始化
		System.out.println("paint()方法被调用了");
//		画圆
		g.drawOval(10, 10, 100, 100);

//		演示绘制不同的图形
//		直线
		g.drawLine(1, 1, 20, 20);
//		矩形边框
		g.drawRect(100, 100, 50, 60);
//		填充矩形
		g.setColor(Color.blue);//设置画笔颜色
		g.fillRect(100, 0, 50, 50);
//		填充椭圆
		g.fillOval(200, 0, 50, 64);
//		画图片
//		1.加载图像资源 /iloveyou.png表示在该项目的根目录(out/production/wot_draw/iloveyou.png)
		Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/iloveyou.png"));
		g.drawImage(image, 500, 500, 700, 700, this);//这里的尺寸会将原图resize
//		画字符串
		g.setColor(Color.red);
		g.setFont(new Font("隶书", Font.BOLD, 100));//设置字体
		g.drawString("你好！", 600, 1400);//左下角的坐标
	}
}