public class FinalDetails01 {
    public static void main(String[] args) {
        CC cc = new CC();//OK
        EE ee = new EE();
        ee.call();//OK
    }
}

class A01 {
//    final修饰的@@普通@@属性，必须初始化，初始化的位置：1.定义时 2.构造器 3.代码块中
    public final double TAX_RATE1 = 0.08;
//    public final double TAX_RATE2;//常量必须初始化
    public final double TAX_RATE3;
    public final double TAX_RATE4;

    public A01() {
        TAX_RATE3 = 0.02;
    }

    {
        TAX_RATE4 = 0.03;
    }
}

class BB {
//    如果final修饰的属性是静态的，初始化的位置只能是 1.定义时 2.静态代码块
    public static final double TAX_RATE = 99.2;
    public static final double TAX_RATE2;
//    public static final double TAX_RATE3;//Error 不能在构造器中初始化

//    静态属性不能在构造器中赋值
//    public BB() {
//        TAX_RATE3 = 8.8;
//    }
    {
//        TAX_RATE2 = 3.0;//Error 不能在普通代码块中赋值
    }
    static {
        TAX_RATE2 = 2.2;
    }

}

//final 类不能继承，但可以实例化
final class CC {

}

//如果类不是final，但是有final方法，虽然不能重写，但是可以继承
class DD {
    final public void call() {
        System.out.println("类DD的cal方法");
    }
}

class EE extends DD {

}
