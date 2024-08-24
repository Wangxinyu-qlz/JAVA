import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: fmmall
 * @author: Qiaolezi
 * @create: 2024-08-19 21:13
 * @description:
 * 使用ConcurrentHashMap也是线程不安全的，
 **/
public class ThreadTest2 implements Runnable {
    private Map<String, Integer> map;
    public ThreadTest2() {
        map = new ConcurrentHashMap<>();
        map.put("0",0);
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            map.put("0", map.get("0")+1);
        }
    }

    public Map<String, Integer> getMap() {return map;}

    public static void main(String[] args) throws InterruptedException {
        ThreadTest2 test = new ThreadTest2();
        Thread thread1 = new Thread(test);
        Thread thread2 = new Thread(test);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(test.getMap().get("0"));//随机数
    }
}