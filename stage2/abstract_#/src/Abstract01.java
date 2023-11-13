/*
* 抽象类的价值更多作用于设计，设计者设计好之后，让子类继承并实现抽象类
* TODO：面试频繁考点，在框架和设计模式使用较多
* */
public class Abstract01 {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

//    实现了一个eat方法，但是没有实际意义
//    即：父类方法不确定性问题
//    ===>考虑将该方法设计为抽象(abstract)方法
//    具有抽象方法的类，必须为抽象类
//    抽象方法就是没有实现的方法--->就是没有方法体
//    一般来说，抽象类会被继承，由其子类实现抽象方法
//    public void eat() {
//        System.out.println("eat.");
//    }
    public abstract void eat();
}
