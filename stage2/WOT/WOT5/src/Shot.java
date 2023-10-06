/**
 * @author qiaolezi
 * @version 1.0
 */
public class Shot implements Runnable {
	int x;//子弹x坐标
	int y;//子弹y坐标
	int direction = 0;//子弹方向
	int speed = 7;//子弹速度
	boolean isLive = true;//子弹是否存活

	public Shot(int x, int y, int direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	@Override
	public void run() {
		while(true) {
//			休眠，否则子弹显示时间太短，看不到子弹
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

//			方向
			switch (direction) {
				case 0://上
					y -= speed;
					break;
				case 1://右
					x += speed;
					break;
				case 2://下
					y += speed;
					break;
				case 3://左
					x -= speed;
					break;
			}
//			调试：输出子弹的坐标
//			System.out.println("子弹坐标X=" + x + "，Y=" + y);
//			如果子弹移动到面板的边界，就销毁（将启动子弹的线程销毁）
//			当子弹碰到敌人坦克时，也应该结束线程
			if (!(x >= 0 && x <=1000 && y >=0 && y <=750 && isLive)) {
				this.isLive = false;//子弹
				break;
			}
		}
	}
}