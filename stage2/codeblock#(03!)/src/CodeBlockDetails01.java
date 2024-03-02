/*
* * 注意事项：
*   1.static{}是静态代码块，作用是对类进行初始化，随着类的加载而执行，只执行1次
*   2.{}是普通代码块，每创建一个对象，就会执行一次
*   3.类的加载时间：创建实例对象（new）  创建子类对象，父类也被加载（并且父类先被加载）   使用类的静态成员时（属性，方法）
*   4.普通代码块，在创建对象时，被隐式地调用
*   5.只使用类的静态成员时，普通代码块不会执行
* */
public class CodeBlockDetails01 {
    public static void main(String[] args) {
//        1.创建对象实例时（new）
//      BB的静态代码块
//      AA的静态代码块被执行
        AA aa = new AA();
//        2.创建子类对象时，父类也会被加载，并且父类先被加载
        BB bb = new BB();//因为AA被创建时，BB被加载了，所以这一句没有输出结果，但如果单独执行，会输出：BB的静态代码块
//        3.使用类的静态成员时（属性，方法）
        //Animal的静态代码块1正在被执行
        //Cat的静态代码块正在被执行
        //999
        System.out.println(Cat.n1);
//
//        DD的静态代码块1正在被执行  (static代码块只被执行一次)
//        DD的普通代码块正在被执行   (普通代码块随着对象的创建被调用)且只在创建对象时被调用
//        DD的普通代码块正在被执行   (普通代码块随着对象的创建被调用)且只在创建对象时被调用
        DD dd1 = new DD();
        DD dd2 = new DD();
//        只使用类的静态成员时，普通代码块不会执行
        //DD的静态代码块1正在被执行
        //8848
        System.out.println(DD.age);
        //EE的静态代码块1正在被执行
        //2323
        System.out.println(EE.age);


    }
}

class EE {
    public static int age = 2323;

    static {
        System.out.println("EE的静态代码块1正在被执行");
    }

    {
        System.out.println("EE的普通代码块正在被执行");
    }
}

class DD {
    public static int age = 8848;

    static {
        System.out.println("DD的静态代码块1正在被执行");
    }

    {
        System.out.println("DD的普通代码块正在被执行");
    }
}

class Animal {
    static {
        System.out.println("Animal的静态代码块1正在被执行");//1
    }
}

class Cat extends Animal {
    public static int n1 = 999;
    static {
        System.out.println("Cat的静态代码块1正在被执行");//2
    }
}

class BB {
    static {
        System.out.println("BB的静态代码块");//1
    }
}

class AA extends BB {
    static {
        System.out.println("AA的静态代码块被执行");//2
    }
}
