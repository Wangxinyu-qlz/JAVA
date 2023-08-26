/**
 * @author qiaolezi
 * @version 1.0
 */
public class Homework02 {
	public static void main(String[] args) {
		System.out.println(Frock.getNextNum());//100100
		System.out.println(Frock.getNextNum());//100200
		Frock frock1 = new Frock();
		Frock frock2 = new Frock();
		Frock frock3 = new Frock();
		System.out.println(frock1.getSerialNumber());//100300
		System.out.println(frock2.getSerialNumber());//100400
		System.out.println(frock3.getSerialNumber());//100500
	}
}

class Frock {
	private static int currentNum = 100000;//衣服出厂起始序列号
	int serialNumber;

	public static int getNextNum() {//生成序列号  TODO 每调用一次currentNum加100
		currentNum = currentNum + 100;
		return currentNum;
	}

	public Frock() {
		this.serialNumber = getNextNum();
	}

	public int getSerialNumber() {
		return serialNumber;
	}
}
