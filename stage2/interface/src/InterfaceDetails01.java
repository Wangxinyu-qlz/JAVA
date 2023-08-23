public class InterfaceDetails01 {
    public static void main(String[] args) {
//        接口不能被实例化，接口是抽象化的
//        new IA();//Error

    }
}

interface IA {
//    接口中的所有方法都是public方法，抽象方法可以不用 abstract 修饰
//    一个类实现接口，必须将接口中所有的方法实现
    void say();
    void hi();
}

class SSS implements IA {//alt + enter快捷补全代码
    public void say() {

    }

//    'say()' in 'SSS' clashes with 'say()' in 'IA';
//    attempting to assign weaker access privileges ('package-private'); was 'public'
//    void say() {}//Error

    public void hi() {

    }
}

//抽象类可以不实现接口的方法
abstract class Tiger implements IA {

}
