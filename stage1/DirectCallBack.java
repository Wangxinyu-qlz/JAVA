/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-10 11:42
 * @description:
 **/
public class DirectCallBack {
	class Request{
		public void send(Callback callBack) throws Exception {
			Thread.sleep(3000);
			System.out.println("收到响应");
			callBack.processResponse();
		}
	}

	static class Callback {
		public void processResponse() {
			System.out.println("响应处理");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final DirectCallBack directCallBack = new DirectCallBack();
		Request request = directCallBack.new Request();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try{
					request.send(new Callback());
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}).start();
		System.out.println("请求已发送");
		Thread.sleep(10*1000);
	}
}
