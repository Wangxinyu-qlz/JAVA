package castle.src;
/*
减少代码重复
可以运行的代码 != 良好的代码
对代码做维护时最能看出代码的质量

扩展性：比如要增加方向，up/down
	使用封装降低耦合
		Room类和Game类有大量的代码和出口有关
		Game类中大量使用了Room类的成员变量
		类和类之间的关系称作耦合
		耦合越低越好，保持距离是形成良好代码的关键
	用接口实现聚合
		给Room类实现新的方法，将方向的细节隐藏在Room类内部
 */
import java.util.HashMap;
import java.util.Scanner;

public class Game {
	private Room currentRoom;
	private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

	public Game() {
		handlers.put("go", new HandlerGo(this));
		handlers.put("bye", new HandlerBye(this));
		handlers.put("help", new HandlerHelp(this));
		createRooms();
	}

	private void createRooms() {
		Room outside, lobby, pub, study, bedroom;

		// 制造房间
		outside = new Room("城堡外");
		lobby = new Room("大堂");
		pub = new Room("小酒吧");
		study = new Room("书房");
		bedroom = new Room("卧室");

		// 初始化房间的出口
		outside.setExit("east", lobby);
		outside.setExit("south", study);
		outside.setExit("west", pub);
		lobby.setExit("west", outside);
		pub.setExit("east", outside);
		study.setExit("north", outside);
		study.setExit("east", bedroom);
		bedroom.setExit("west", study);
		lobby.setExit("up", pub);
		pub.setExit("down", lobby);

		currentRoom = outside; // 从城堡门外开始
	}

	private void printWelcome() {
		System.out.println();
		System.out.println("欢迎来到城堡！");
		System.out.println("这是一个超级无聊的游戏。");
		System.out.println("如果需要帮助，请输入 'help' 。");
		System.out.println();
		showPrompt();
	}

	public void goRoom(String direction) {
		Room nextRoom = currentRoom.getExit(direction);
		if (nextRoom == null) {
			System.out.println("那里没有门！");
		} else {
			currentRoom = nextRoom;
			showPrompt();
		}
	}

	public void showPrompt() {
		System.out.println("你在" + currentRoom); // Room类里toString的作用
		System.out.print("出口有: ");
		System.out.println(currentRoom.getExitDesc());
	}

	public void play() {
		Scanner in = new Scanner(System.in);
		while (true) {
			String line = in.nextLine();
			String[] words = line.split(" ");
			Handler handler = handlers.get(words[0]);
			String value = "";
			if (words.length>1)
				value = words[1];
			if (handler != null) {
				handler.doCmd(value);
				if (handler.isBye())
					break;
			}
		}
		in.close();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.printWelcome();
		game.play();
		System.out.println("感谢您的光临。再见！");
	}
}