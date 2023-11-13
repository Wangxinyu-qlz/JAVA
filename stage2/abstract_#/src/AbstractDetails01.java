public class AbstractDetails01 {
    public static void main(String[] args) {
//        抽象类不能被实例化
//    new A();//Error
    }
}

//        抽象类不一定要包含抽象方法
//        还可以有实现的方法
//        abstract只能修饰类和方法，不能修饰属性和其他的
abstract class A {
//    abstract public int h = 0;//error
    public void hi() {

    }
}
