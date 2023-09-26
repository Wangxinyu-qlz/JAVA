import org.junit.jupiter.api.Test;

import javax.swing.*;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class TankGame02 extends JFrame {
//	定义MyPanel
	MyPanel mp = null;
	@Test
	public static void main(String[] args) {
		new TankGame02();
	}

	public TankGame02() {
		mp = new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
