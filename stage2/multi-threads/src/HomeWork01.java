import javax.crypto.spec.IvParameterSpec;
import java.util.Scanner;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork01 {
	public static void main(String[] args) {
		Random random = new Random();
		Q q = new Q();
		random.setDaemon(true);
		random.start();
		q.start();
	}
}

class Random extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println((int) (Math.random() * 100));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}

class Q extends Thread {
	Scanner scanner = new Scanner(System.in);
	@Override
	public void run() {
		while(true) {
			System.out.println("请输入Q：");
			char c = scanner.next().toUpperCase().charAt(0);
			if(c == 'Q') {
				System.out.println("Q线程终止");
				break;
			}
		}
	}
}