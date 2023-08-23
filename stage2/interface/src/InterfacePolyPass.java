/*
* 演示多态传递现象
* */
public class InterfacePolyPass {
    public static void main(String[] args) {
//        接口类型的变量 指向 实现了改接口的类的对象实例
        IG ig = new Teacher();
//        如果 IG 继承了 IH 接口，而 Teacher 实现了 IG 接口
//        实际上相当于 Teacher 类实现了 IH 接口
        IH ih = new Teacher();
    }
}

interface IH {
    void hi();
}
interface IG extends IH {

}

class Teacher implements IG {
    public void hi() {//必须实现IH的方法

    }
}
