public class AbstractDetails02 {
    public static void main(String[] args) {

    }
}

//      抽象类本质还是类，所以可以有类的各种成员（非抽象方法 构造器 静态属性）
abstract class D {
    public int n1 = 0;
    public static String name = "qwee";

    public D(int n1) {
        this.n1 = n1;
    }
    public void hi() {
        System.out.println("hi~");

    }
}

//TODO:一个类如果继承了抽象类，他必须实现抽象类的@@所有@@抽象@@方法
//TODO:除非他自己也为抽象类
abstract class E {
    public abstract void hi();
}
abstract class F extends E {

}
class G extends E {
//    所谓实现方法，就是要有方法体；
    public void hi() {

    }
}

abstract class H{
    public abstract void hi();
//    TODO 抽象方法不能使用private final static修饰，这些关键字和重写冲突
//    private不能让子类实现
//    private abstract void hi1();
//    final不能让子类重写
//    final abstract void hi3();
//    static方法与重写无关（重写涉及运行类型，static方法只通过编译类型调用）
//    static abstract void hi2();
}
