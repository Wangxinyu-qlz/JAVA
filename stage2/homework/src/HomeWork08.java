import java.util.Scanner;

/**
 * @author qiaolezi
 * @version 1.0
 */
public class HomeWork08 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		do {
			System.out.println("请输入red,blue,black,yellow,green:(qwe退出)");
			String color = scanner.next();
			switch (color) {
				case "red" :
//					TODO 注意这里的调用方法
					Color.RED.show();
					break;
				case "blue" :
					Color.BLUE.show();
					break;
				case "black" :
					Color.BLACK.show();
					break;
				case "yellow" :
					Color.YELLOW.show();
					break;
				case "green" :
					Color.GREEN.show();
					break;
				case "qwe" :
					loop = false;
					System.out.println("您已退出！");
					break;
				default :
					System.out.println("戳啦！没有这个选项");
			}
		} while (loop);
	}
}

enum Color implements II{
	RED(255,0,0), BLUE(0,0,255),
	BLACK(0,0,0), YELLOW(255,255,0),
	GREEN(0,255,0);
	private int redValue;
	private int greenValue;
	private int blueValue;

	Color(int redValue, int greenValue, int blueValue) {
		this.redValue = redValue;
		this.greenValue = greenValue;
		this.blueValue = blueValue;
	}

	public void show() {
		System.out.println("RGB:[" + redValue + "," + greenValue + "," + blueValue + "]");
	}
}

interface II {
	void show();
}
