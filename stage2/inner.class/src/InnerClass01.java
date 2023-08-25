/*
* 内部类：
*   最大的特点是可以直接访问私有属性，且可以体现出类与类之间的包含关系
* */
public class InnerClass01 {
    public static void main(String[] args) {

    }
}

class Outer {//外部类
    private int n1 = 1;
    {
        System.out.println("Outer的代码块");
    }
    public void m1() {
        System.out.println("Outer的方法m1");
    }

    public Outer(int n1) {
        this.n1 = n1;
    }

    class Inner {//内部类

    }
}

class Other {}
