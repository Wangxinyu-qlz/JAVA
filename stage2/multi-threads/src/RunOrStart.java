/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-09-09 10:32
 * @description:
 **/
public class RunOrStart {
	public static void main(String[] args) {
		Thread thread = new Thread(){
			public void run() {
				hi();
			}
		};
		//start()不保证线程启动的顺序
		//wer hi    hi wer
		//thread.start();
		thread.run();//hi wer
		System.out.println("wer");

	}

	private static void hi() {
		System.out.println("hi");
	}
}
