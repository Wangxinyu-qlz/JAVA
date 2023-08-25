/*
* 演示局部内部类的使用
*
* */
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();//n1=100  Outer02.m2()

        System.out.println("outer02 HashCode=" + outer02);//outer02@1b6d3586
    }
}

class Outer02 {
    private int n1 = 100;
    private void m2() {
        System.out.println("Outer02.m2()");
    }
    public void m1() {//方法
//        局部内部类：定义在外部类的局部位置，通常在方法
//        不能使用访问修饰符，但是可以使用final修饰（局部变量可以使用final）
//        作用域仅仅在定义它的方法中或代码块中
        final class Inner02 {
            //            可以访问外部类的所有成员，包括方法
            private int n1 = 200;

            public void f1() {
//                局部内部类可以直接访问外部类的成员，比如下面
//                外部类 n1 和 m2()
//                如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，使用(外部类名.this.成员)
//                Outer02.this:外部类的对象，即哪个对象调用了m1()方法，Outer02.this就指向哪个对象
                System.out.println("n1=" + n1 + "外部类的n1=" + Outer02.this.n1);//n1=200外部类的n1=100
                System.out.println("n1=" + n1 + "内部类的n1=" + this.n1);//n1=200内部类的n1=200
                System.out.println("Outer02.this HashCode=" + Outer02.this);//Outer02@1b6d3586
                m2();

            }
        }
//        class Inner03 extends Inner02 {}

//        外部类在方法中可以创建内部类Inner02的对象，调用方法
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }

    {//代码块
        class Inner01 {
            class Inner02{}
        }
    }
}