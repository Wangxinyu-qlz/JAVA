import java.util.Vector;

/**
 * @author qiaolezi
 * @version 1.0
 * 敌方坦克
 */
public class EnemyTank extends Tank{
	boolean isLive = true;
	//	在敌人坦克类，使用Vector 保存多个Shot
	Vector<Shot> shots = new Vector<>();
	public EnemyTank(int x, int y) {
		super(x, y);
	}

}
