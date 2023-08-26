public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.method();
    }
}

class Outer02 {
    private String name = "Outer02";
    public void method() {
        IAA iaa = new IAA() {//基于接口的匿名内部类
            @Override
            public void hi() {
                System.out.println("重写hi()方法");
            }
        };
        System.out.println("iaa的运行类型是：" + iaa.getClass());//Outer02$1
        iaa.hi();

        Father father  = new Father("张强") {//基于类的匿名内部类
            @Override
            public void test() {
                System.out.println("重写了test in Father.");
            }
        };
        father.test();

        Animal animal = new Animal() {//基于抽象类的匿名内部类
            @Override
            void eat() {
                System.out.println("简单吃点.");
            }
        };
        animal.eat();
    }
}

interface IAA {
    void hi();
}

class Father {
    public Father(String name) {
        super();
        System.out.println("接收到的name=" + name);
    }

    public void test(){
        System.out.println("test in Father");
    }
}

abstract class Animal {
    abstract void eat();
}

