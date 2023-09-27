/**
 * @author qiaolezi
 * @version 1.0
 */
public class Tank {
	private int x;//横坐标
	private int y;//纵坐标
	private int direction;//0上 1右 2下 3左
	private int speed;//坦克移动速度
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

//	上右下左移动方法
	public void moveUp() {y -= speed;}
	public void moveRight() {x += speed;}
	public void moveDown() {y += speed;}
	public void moveLeft() {x -=speed;}

}
