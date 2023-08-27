import java.util.Scanner;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class InputInteger {
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int num = 0;
			String inputStr = "";
			while(true) {
				System.out.println("整数：");
				try {
					num = Integer.parseInt(scanner.next());
					break;
				} catch (NumberFormatException e) {
					System.out.println("你输入的不是一个整数！");
				}
			}

		System.out.println("你输入的整数是：" + num);
	}
}


