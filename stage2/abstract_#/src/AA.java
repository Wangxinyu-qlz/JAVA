public class AA extends Template {
//    计算任务
//    1+...+10000
    @Override
    public void job() {//实现了父类的抽象方法
        long number = 0;
        for (long i = 0; i < 100000000; i++) {
            number *= i;
        }
    }
}
