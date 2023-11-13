/*
*匿名内部类：
*   1.本质是类
*   2.内部类
*   3.没有名字
*   4.同时是一个对象
* */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 {//外部类
    private int n1 = 120;
    public void method() {
//        基于接口的匿名内部类
//        1.需求：使用接口IA，并创建对象
//        2.传统方式：写一个类，实现该接口，并创建对象
//        3.需求：Tiger 类只使用一次，后面再也不用
//        4.可以使用匿名内部类简化开发
//        5.tiger的编译类型是 IA
//        6.tiger的运行类型是 @@匿名内部类  XXX = Outer04$1
        /*
        * 底层： 分配 类名 Outer04$1
        * class XXX implements IA {
        *       @Override
        *       public void cry() {
        *           System.out.println("老虎叫~");
        *       }
        * }
        * */
//        Tiger tiger = new Tiger();
//        tiger.cry();
//        7.JDk底层在创建匿名内部类 Outer04$1，立即创建Outer04$1实例，并且将地址返回给tiger
//        8.匿名内部类只能使用一次，tiger可以反复使用
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫~");
            }
        };
        System.out.println("tiger的运行类型是：" + tiger.getClass());//class Outer04$1
        tiger.cry();//老虎叫~

//演示基于类的匿名内部类
//        1.father的编译类型是  Father
//        2.father的编译类型是  Outer04$2
//        3.底层会创建匿名内部类
//        4.同时也直接返回了  匿名内部类 Outer04$2的对象
//        5.参数列表会传递给构造器
        /*
        * class Outer04$2 extends Father {}
        * */
        Father father = new Father("jack") {
//            这里不能重写构造器，因为不知
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        father.test();//匿名内部类重写了test方法
        System.out.println("father的运行类型是：" + father.getClass());//class Outer04$2

//        基于抽象类的匿名内部类
        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("小狗吃骨头");
            }
        };
        animal.eat();//小狗吃骨头
    }
}

interface IA {
    public void cry();
}
//class Tiger implements IA {
//    public void cry() {
//        System.out.println("Tiger cry~");
//    }
//}
class Father {
    public Father(String name) {
        super();
        System.out.println("接收到的name=" + name);//接收到的name=jack
    }
    public void test() {

    }
}

abstract class Animal {
    abstract void eat();
}