public class This {
    public static void main(String[] args) {
        TT t = new TT();
        t.f2();//f2()方法  f1()方法  f1()方法
        TT tt = new TT();
    }
}

class TT extends Object {
//    output：TT(String name, int n)构造器  TT()构造器
    public TT() {
//        在此处访问TT(String name, int n)构造器
//        只能在构造器中使用（只能在构造器中访问其他构造器）
//        @@@@注意：必须是构造器中的第一句
        this("bob", 23);
        System.out.println("TT()构造器");
    }
    public TT(String name, int n) {
        System.out.println("TT(String name, int n)构造器");
    }
    public void f1() {
        System.out.println("f1()方法");
    }

    public void f2() {
        System.out.println("f2()方法");
        f1();
        this.f1();
    }
}
