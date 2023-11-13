abstract public class Template {

    public abstract void job();//抽象方法

    public void calculateTime() {
//        得到开始时间
        long start = System.currentTimeMillis();
        job();//TODO 动态绑定机制 运行态是AA，执行AA中的job
//        得到结束的时间
        long end = System.currentTimeMillis();
        System.out.println("执行时间=" + (end - start) + "毫秒");
    }
}
