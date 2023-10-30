/**
 * @author qiaolezi
 * @version 1.0
 * 客户端菜单界面
 */
public class QQView {
	private boolean loop = true;//控制是否显示菜单
	private String key = "";
	private UserClientService userClientService = new UserClientService();//用于登录服务器/注册用户
	private MessageClientService messageClientService = new MessageClientService();//用于聊天
	private FileClientService fileClientService = new FileClientService();//用于传输文件
	public static void main(String[] args) {
		new QQView().mainMenu();
		System.out.println("客户端退出系统");
	}

//	显示主菜单
	private void mainMenu() {

		while(loop) {
			System.out.println("===========欢迎登录QQ===========");
			System.out.println("\t\t 1 登录");
			System.out.println("\t\t 9 退出");
			System.out.print("请输入你的选择：");
			key = Utility.readString(1);

//			根据用户的输入，处理不同的逻辑
			switch (key) {
				case "1":
					System.out.print("请输入用户名：");
					String userId = Utility.readString(50);
					System.out.print("请输入密 码：");
					String password = Utility.readString(50);
//					TODO 需要到服务端验证该用户是否合法
					if(userClientService.checkUser(userId, password)) {//登陆成功
						System.out.println("===========欢迎（用户 " + userId + " 登陆成功）===========");
//						进入到二级菜单
						while (loop) {
							System.out.println("\n===========QQ二级菜单（用户 " + userId + " ）===========");
							System.out.println("\t\t 1 显示在线用户列表");
							System.out.println("\t\t 2 群发消息");
							System.out.println("\t\t 3 私聊消息");
							System.out.println("\t\t 4 发送文件");
							System.out.println("\t\t 9 退出系统");
							System.out.print("请输入你的选择：");
							key = Utility.readString(1);
							switch (key) {
								case "1":
									//写一个方法获取在线用户列表
									userClientService.onlineFriendList();
									System.out.println("在线用户列表");
									break;
								case "2":
									System.out.print("请输入群发消息内容：");
									String contentAll = Utility.readString(100);
									//编写群聊方法，将消息封装成一个message对象
									messageClientService.sendMessageToAll(userId, contentAll);
									break;
								case "3":
									System.out.print("请输入聊天对象（用户名）：");
									String getterId = Utility.readString(50);
									System.out.print("请输入聊天内容：");
									String content = Utility.readString(300);
									//编写方法，将私聊内容发送给服务端
									messageClientService.sendMessageToOne(userId, getterId, content);
									break;
								case "4":
									System.out.print("请输入你想发送文件的用户（需要在线）：");
									getterId = Utility.readString(50);
									System.out.print("请输入您要发送的文件的路径（形式 d:\\\\xx.jpg）");
									String src = Utility.readString(100);
									System.out.print("请输入您要发送到对方的路径（形式 d:\\\\xx.jpg）");
									String dest = Utility.readString(100);
									fileClientService.sendFileToOne(src, dest, userId, getterId);
									break;
								case "9":
									//向服务器发送 客户端退出 的消息
									userClientService.logout();
									loop = false;
									break;
							}
						}
					} else {//登陆失败
						System.out.println("登陆失败");
					}
					break;
				case "9" :
					loop = false;
					break;
			}
		}
	}
}
