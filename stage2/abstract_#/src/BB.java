public class BB {
//    计算任务
//    1+...+10000
    public void job() {

//        得到开始时间
        long start = System.currentTimeMillis();
        long number = 0;
        for (long i = 0; i < 100000000; i++) {
            number *= i;
        }
//        得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("BBjob执行时间=" + (end - start) + "毫秒");
    }
}
