/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-22 11:18
 * @description:
 * 演示死锁的情况
 * 两个方法m1 m2分别获取l1 l2两把锁，然后再分别获取l2 l1，需要的锁都由对方持有
 * 但是如果将Object()换成 包装类型/String，不会发生死锁，因为是不可变对象
 * TODO 两个synchronized()必须是嵌套而不是并列
 **/
public class DeadLockExample {

    private  Object lock1 = new Object();
    private  Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " acquired lock1 in method1");
            //try {
            //    // Simulate some work
            //    Thread.sleep(100);
            //} catch (InterruptedException e) {
            //    //Thread.currentThread().interrupt();
            //}

            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2 in method1");
                // Do something with both locks
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " acquired lock2 in method2");
            //try {
            //    // Simulate some work
            //    Thread.sleep(100);
            //} catch (InterruptedException e) {
            //    //Thread.currentThread().interrupt();
            //}

            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1 in method2");
                // Do something with both locks
            }
        }
    }

    public static void main(String[] args) {
        DeadLockExample deadlockExample = new DeadLockExample();

        Runnable task1 = deadlockExample::method1;
        Runnable task2 = deadlockExample::method2;

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
