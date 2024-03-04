package threadlocal;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-03-01 16:24
 * @description: ThreadLocal作用：在一个线程中共享数据，并保证线程安全
 **/
public class T1 {
    //创建ThreadLocal对象, 做成public static.
    public static ThreadLocal<Object> threadLocal1 = new ThreadLocal<>();
    public static ThreadLocal<Object> threadLocal2 = new ThreadLocal<>();

    //Task 是线程类 -> 内部类 / 线程
    public static class Task implements Runnable {
        @Override
        public void run() {
            Dog dog = new Dog();
            Pig pig = new Pig();
            System.out.println("Task 放入了 dog= " + dog);
            //给threadLocal1放入Dog对象    隔山打牛 该dog和当前的线程关联起来
            /**
             *     public void set(T value) {
             *          //1.关联到当前线程
             *         Thread t = Thread.currentThread();
             *          //2.通过线程对象，获取到ThreadLocal对象
             *          //ThreadLocalMap 类型是ThreadLocal.ThreadLocalMap
             *         ThreadLocalMap map = getMap(t);
             *          //3.如果map存在且!=null，将数据（dog, pig）
             *          放入map：Key:threadLocal Value:存放的数据
             *          4.一个threadlocal只能关联一个数据，如果map中有数据且再次set()，就会替换原来的值
             *          如果map中没有数据，set()会将当前的线程放入map
             *         if (map != null) {
             *             map.set(this, value);
             *         } else {
             *             createMap(t, value);
             *         }
             *     }
             */
            threadLocal1.set(dog);
            //threadLocal1.set(pig);//替换
            threadLocal2.set(pig);//数据会被threadLocal关联，并被当前Thread管理
            System.out.println("Task 在run 方法中 线程=" + Thread.currentThread().getName());
            new Service().update();
        }
    }

    public static void main(String[] args) {
        new Thread(new Task()).start();//主线程启动一个新的线程,注意不是主线程
    }
}