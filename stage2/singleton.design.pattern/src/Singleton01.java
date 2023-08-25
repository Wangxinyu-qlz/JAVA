import javax.crypto.spec.IvParameterSpec;

/*
* 单例设计模式
*   1.保证在整个软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法
*   2.方式：饿汉式  懒汉式
* 步骤：
*   1.构造器私有化  防止用户new对象
*   2.类的内部创建对象
*   3.向外暴露一个静态的公共方法  getInstance
*   4.代码实现
* */
public class Singleton01 {
    public static void main(String[] args) {
//        可以创建多个对象
    GirlFriend g1 = new GirlFriend("小红");
    GirlFriend g2 = new GirlFriend("小花");

    System.out.println(GirlFriend1.n1);//100  在一开始就创建了，哪怕没有用到
//    通过方法获取对象
    GirlFriend1 gf1 = GirlFriend1.getInstance();
    System.out.println(gf1);
    GirlFriend1 gf2 = GirlFriend1.getInstance();
    System.out.println(gf2);
//    只能创建一个对象
    System.out.println(gf1 == gf2);//true
    }
}

//类GirlFriend
//可以创建多个对象
class GirlFriend {
    private String name;

    public GirlFriend(String name) {
        this.name = name;
    }
}

//只能创建一个对象
class GirlFriend1 {
    public static int n1 = 100;
    private String name;
//    2.在类的内部直接创建对象，私有静态
//    通常是重量级的对象，饿汉式可能造成创建了对象，但是没有使用，造成资源浪费
    private static GirlFriend1 gf = new GirlFriend1("小白");
//    3.提供公共静态方法，返回对象
    public static GirlFriend1 getInstance() {
        return gf;
    }
//    如何保证只能创建一个GirlFriend对象
//    1.构造器私有化
    private GirlFriend1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GirlFriend1{" +
                "name='" + name + '\'' +
                '}';
    }
}