public class InterfaceDetails02 {
    public static void main(String[] args) {
//        证明：接口属性中，只能是final，而且是public static final
        System.out.println(IB.n1);//100   static 得证
//        IB.n1 = 30//Error   Cannot assign a value to final variable 'n1'

    }
}

interface IB {
//    TODO 接口属性中，只能是final，而且是public static final
    int n1 = 100;//等价于 public static final int n1 = 100;
    void hi();
}

interface IC {
    void hii();
}

//接口可以继承多个接口
interface ID extends IB,IC {

}

//接口不能继承类
//interface IE extends Pig { }//Error

//一个类可以同时实现多个接口，要实现所有接口的方法
class Pig implements IB,IC {
    public void hi() {

    }

    public void hii() {

    }
}
