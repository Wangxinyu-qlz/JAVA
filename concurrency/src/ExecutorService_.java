import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Java
 * @author: Qiaolezi
 * @create: 2024-08-14 15:52
 * @description:
 **/
public class ExecutorService_ {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);
	// 使用AtomicInteger确保线程安全
    private AtomicInteger total = new AtomicInteger(0);

    // 定义一个方法进行累加操作
    public void accumulate(int value) {
        total.addAndGet(value);
    }

    // 获取当前累加器的值
    public int getTotal() {
        return total.get();
    }

    public static void main(String[] args) {
        // 创建累加器实例
        ExecutorService_ accumulator = new ExecutorService_();
        // 创建并提交多个任务
        for (int i = 0; i < 1000; i++) {
            int value = 2;
            executorService.submit(() -> accumulator.accumulate(value));
        }
        // 关闭线程池
        executorService.shutdown();
        // 等待线程池中所有任务完成
        while (!executorService.isTerminated()) {
             //主线程等待所有任务完成
        }
        // 输出累加结果
        System.out.println("Final total: " + accumulator.getTotal());
    }

}
