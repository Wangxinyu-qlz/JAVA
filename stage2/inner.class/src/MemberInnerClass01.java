import javax.crypto.spec.IvParameterSpec;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();//Outer01的n1=10Outer08的name=张赛

//        外部其他类访问成员内部类的2种方式
//        1.
//        TODO outer08.new Inner08(); 相当于将new Inner08()当做outer08的一个成员，语法而已，不要纠结
        Outer08.Inner08 inner = outer08.new Inner08();
//        2.在外部类中写一个方法，返回一个Inner08的对象实例
        outer08.getInner08Instance();
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        System.out.println(inner08Instance.getClass());//class Outer08$Inner08


    }
}

class Outer08 {//外部类
    private int n1 = 10;
    public String name = "张赛";

    private void hi() {
        System.out.println("hi()");
    }
//            成员内部类
//            可以使用任意修饰符（public protected private 默认的）
//            作用域和类中其他方法属性一致，在外部类的方法中直接创建对象，并调用其方法
//            成员内部类---访问---外部类成员：直接访问
//            成员外部类---访问---内部类成员：创建对象，再访问
    class Inner08 {
        public double sal = 99.9;
        private String name = "test";
        private int n1 = 99;
        public void say() {
//            可以访问外部类的所有成员，包括私有的
            System.out.println("Outer01的n1=" + n1 + ";Outer08的name=" + name);//99
            System.out.println(Outer08.this.n1);//10
            hi();
        }
    }

    public Inner08 getInner08Instance(){
        return new Inner08();
    }

    public void t1() {
//        先创建对象，再访问
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
        System.out.println(inner08.name);
    }
}