public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();

        System.out.println("main outer05 HashCode=" + outer05);//main outer05 HashCode=Outer05@1b6d3586
    }
}

class Outer05 {
    private int n1 = 99;
    public void f1() {
//        不允许添加访问修饰符，它的地位是一个局部变量
//        作用域：仅仅在定义他的方法/代码块中 Outer05$1
        Person p = new Person() {
            private int n1 = 88;
            @Override
            public void hi() {
//                访问外部类变量，直接访问
//                外部类和匿名内部类有重名变量，匿名内部类访问遵循就近原则
//                访问外部类的成员，使用 (外部类名.this.成员)访问
                System.out.println("匿名内部类重写了hi方法，n1=" + n1);//匿名内部类重写了hi方法，n1=88
                System.out.println("外部类的n1=" + Outer05.this.n1);//外部类的n1 = 99
                System.out.println("Outer05.this HashCode=" + Outer05.this);//Outer05.this HashCode=Outer05@1b6d3586
            }
        };
        p.hi();//动态绑定，运行类型是Outer05$1  输出：匿名内部类重写了hi方法

        new Person() {}.hi();//输出结果：Person hi()

        new Person() {}.ok("Jack");//Person ok(Jack)

        Person p1 = new Person() {
            @Override
            public void ok(String name) {
                System.out.println("重写过的：" + name);
            }

            @Override
            public void hi() {
                System.out.println("重写");
            }
        };
        p1.ok("123");//重写过的：123
        p1.hi();//重写
    }
}

class Person {
    public void hi() {
        System.out.println("Person hi()");
    }

    public void ok(String name) {
        System.out.println("Person ok(" + name + ")");
    }
}

//抽象类/接口

