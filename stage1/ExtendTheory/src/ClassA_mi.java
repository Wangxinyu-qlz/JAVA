public class ClassA_mi {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b);//B@1b6d3586

        A a = new A();
        System.out.println(a.hi());//B@4554617c
    }
}

class A {
    public B hi() {//返回类型是B
        return new B();
    }
}

class B {

}
