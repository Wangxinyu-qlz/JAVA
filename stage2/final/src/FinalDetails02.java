public class FinalDetails02 {
    public static void main(String[] args) {
        System.out.println(BBB.num);//100
        System.out.println(BBB.num2);//BBB 静态代码块被执行.   0
//        包装类 String Boolean Double是final类型，不能被继承
    }
}

class BBB {
    public final static int num = 100;//BBB.num不会导致类加载->构造器不执行
    public static int num2 = 0;
    static {
        System.out.println("BBB 静态代码块被执行.");
    }
}

final class AAA {
//    如果一个类已经是final类，没有必要将其方法修饰为final方法
    public final void cry() {//final多余

    }
}
