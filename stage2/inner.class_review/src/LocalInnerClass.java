import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import sun.management.HotspotClassLoadingMBean;

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer01 outer01 = new Outer01();
        outer01.m2();
    }
}

class Outer01 {
    private int age = 0;
    private void m1() {
        System.out.println("这是Outer01的私有方法");
    }

    public void m2() {
        class Inner01 {
            private int age = 1;

            {
                System.out.println("这是Inner01的普通代码块");
            }

//            static {//运行Error
//                System.out.println("这是Inner01的静态代码块");
//            }

            public Inner01(int age) {
                this.age = age;
            }

            private void innerM1() {
                System.out.println("这是Inner01的私有方法");
            }

            public void innerM2() {
                System.out.println(age);//2
                System.out.println(Outer01.this.age);//0
            }

            class InnerInner01 { }
        }



        Inner01 inner01 = new Inner01(2);
        inner01.innerM2();
        inner01.innerM1();
        System.out.println(inner01.age);
    }
}