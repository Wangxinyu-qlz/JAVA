public class InterfacePolyParameter {
    public static void main(String[] args) {
//        接口的多态
//        接口类型的变量 可以指向 实现了IF接口的类的对象实例
        IF if01 = new Monster();
        if01 = new Car();

//       继承的多态
//        父类类型的变量 可以指向 继承了AAA的子类的对象实例
        AAA aaa = new BBB();
        aaa = new CCC();
    }
}

interface IF {

}

class Monster implements IF {

}

class Car implements IF {}

class AAA{}

class BBB extends AAA{}

class CCC extends AAA{}