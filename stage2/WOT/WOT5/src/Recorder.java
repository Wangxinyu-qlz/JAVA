import java.io.*;
import java.util.Vector;

/**
 * @author qiaolezi
 * @version 1.0
 * 用于记录相关信息，和文件交互
 */
public class Recorder {
//	记录击毁敌方坦克数量
	private static int allEnemyTankNum = 0;
//	定义IO对象，用于写入数据到文件中
	private static FileWriter fileWriter = null;
	private static BufferedReader bufferedReader = null;
	private static BufferedWriter bufferedWriter = null;
	private static String recordFile = "C:\\My_Code\\Java\\stage2\\WOT\\WOT5\\src\\myRecord.txt";
//  定义Vector，指向MyPanel 对象的敌人坦克的 Vector
	private static Vector<EnemyTank> enemyTanks = null;

	//定义一个Node 的Vector，用于保存敌人的信息node
	public static Vector<Node> nodes = new Vector<>();

	public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
		Recorder.enemyTanks = enemyTanks;
	}

//	用于读取recordFile文件，恢复相关信息
	public static Vector<Node> getNodeAndAllEnemyTankRecord() {
		try {
			bufferedReader = new BufferedReader(new FileReader(recordFile));
			allEnemyTankNum = Integer.parseInt(bufferedReader.readLine());
//			循环读取坦克信息，生成nodes集合
			String line = "";
			while((line = bufferedReader.readLine()) != null) {
				String[] xyd = line.split(" ");
				Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
				nodes.add(node);//放入到nodes Vector
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if(bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}

		return nodes;
	}

//	游戏退出时，将allEnemyTankNum保存到文件
//	升级 保存敌人坦克的坐标和方向
//	TODO 乱码Bug
//	 1.bufferedWriter.write(allEnemyTankNum);
//	 以上写法会出现乱码，需要在末尾加上"\r\n" --> bufferedWriter.write(allEnemyTankNum + "\r\n");
	public static void keepRecord() {
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(recordFile));
			bufferedWriter.write(allEnemyTankNum + "\r\n");
//			OOP， 定义一个属性，通过setXxx得到 敌方坦克的Vector
			for (int i = 0; i < enemyTanks.size(); i++) {
				EnemyTank enemyTank = enemyTanks.get(i);
				if(enemyTank.isLive) {//建议判断是否存活
//					保存该坦克的信息
					String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
					bufferedWriter.write(record + "\r\n");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if(bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static int getAllEnemyTankNum() {
		return allEnemyTankNum;
	}

	public static void setAllEnemyTankNum(int allEnemyTankNum) {
		Recorder.allEnemyTankNum = allEnemyTankNum;
	}

//	当击毁一辆坦克时，allEnemyTankNum++
	public static void addAllEnemyTankNum() {
		Recorder.allEnemyTankNum++;
	}
}
