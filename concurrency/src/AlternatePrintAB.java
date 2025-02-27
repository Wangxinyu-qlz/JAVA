/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2025-02-24 15:34
 * @description:
 **/
public class AlternatePrintAB {
	private int count = 0;
	private final Object lock = new Object();

	public static void main(String[] args) {
		AlternatePrintAB alternatePrint = new AlternatePrintAB();
		Thread theadA = new Thread(alternatePrint::printA, "thead-A");
		Thread theadB = new Thread(alternatePrint::printB, "thead-B");
		theadA.start();
		theadB.start();
	}

	public void printA() {
		for(int i=0; i<100; ++i) {
			synchronized(lock) {
				while(count % 2 != 0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("A" + count++);

				lock.notifyAll();
			}
		}
	}

	public void printB() {
		for(int i=0; i<100; ++i) {
			synchronized(lock) {
				while(count % 2 == 0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("B" + count++);
				lock.notifyAll();
			}
		}
	}
}
