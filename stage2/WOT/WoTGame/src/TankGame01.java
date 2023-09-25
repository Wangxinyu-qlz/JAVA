import org.junit.jupiter.api.Test;

import javax.swing.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class TankGame01 extends JFrame {
//	定义MyPanel
	MyPanel mp = null;
	@Test
	public static void main(String[] args) {
		new TankGame01();
	}

	public TankGame01() {
		mp = new MyPanel();
		this.add(mp);
		this.setSize(1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
