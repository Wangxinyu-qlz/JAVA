/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2025-02-24 15:46
 * @description:
 **/
public class AlternatePrintABC {
    private int count = 0; // 用来控制打印顺序
    private final Object lock = new Object(); // 用于同步的锁

    public static void main(String[] args) {
        AlternatePrintABC alternatePrint = new AlternatePrintABC();

        // 创建三个线程，分别打印A、B和C
        Thread threadA = new Thread(alternatePrint::printA, "Thread-A");
        Thread threadB = new Thread(alternatePrint::printB, "Thread-B");
        Thread threadC = new Thread(alternatePrint::printC, "Thread-C");

        threadA.start();
        threadB.start();
        threadC.start();
    }

    // 打印 A
    public void printA() {
        for (int i = 0; i < 100; ++i) {
            synchronized (lock) {
                // 等待 count 为 0 时打印 A
                while (count % 3 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                ++count;
                lock.notifyAll(); // 通知其他线程执行
            }
        }
    }

    // 打印 B
    public void printB() {
        for (int i = 0; i < 100; ++i) {
            synchronized (lock) {
                // 等待 count 为 1 时打印 B
                while (count % 3 != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                ++count;
                lock.notifyAll(); // 通知其他线程执行
            }
        }
    }

    // 打印 C
    public void printC() {
        for (int i = 0; i < 100; ++i) {
            synchronized (lock) {
                // 等待 count 为 2 时打印 C
                while (count % 3 != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                ++count;
                lock.notifyAll(); // 通知其他线程执行
            }
        }
    }
}
