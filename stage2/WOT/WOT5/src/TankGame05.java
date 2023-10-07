import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class TankGame05 extends JFrame {
//	定义MyPanel
	MyPanel mp = null;
	static Scanner scanner = new Scanner(System.in);
	@Test
	public static void main(String[] args) {
		new TankGame05();
	}

	public TankGame05() {
		System.out.println("请输入选择：1：新游戏 2：继续");
		String key = scanner.next();
		mp = new MyPanel(key);
		Thread thread = new Thread(mp);
		thread.start();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(1300, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

//		在JFrame中，增加响应关闭窗口的处理
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Recorder.keepRecord();
				System.exit(0);
			}
		});
	}
}
