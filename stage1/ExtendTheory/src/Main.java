/*
* 多态：
*       方法重载：sum.sum(1, 1)  sum.sum(1, 1, 1)
*       方法重写：不同的对象调用的方法不同：son.call()  grandfather.call()
*       对象的多态：
*           编译类型（Animal）：Animal animal;
*           运行类型（Cat）：animal = new Cat(); animal.cry();//喵喵叫
*           运行类型（Dog）：animal = new Dog(); animal.cry();//汪汪叫
* */
public class Main {
    public static void main(String[] args) {
        /*
        1.初始化时，先执行Son类中的无参构造器
        2.由Son类中的无参构造器中的this("hello")转到Son类中的有参构造器
        3.由Son类中的有参构造器中的super("hahaha")转到父类（Father类）中的有参构造器
        TODO Father类中的有参构造器中，有一个隐藏的super()
        @@@@DeBug时：@@到构造器中的super();语句，如没有显式声明（隐藏），到构造器的声明语句@@->初始化属性->无参构造器中的语句
        4.转到GrandFather类中，转到无参构造器中的super()，初始化该类中的属性，输出“我是爷爷”
        5.回到Father类中，转到有参构造器中的super()，初始化该类中的属性，输出“hahaha我是爸爸的有参构造”
        6.回到Son类中，转到有参构造器，初始化该类的属性，输出“我是儿子的有参构造”
        7.转到Son类中的无参构造器，输出“我是儿子的无参构造”
        * 输出结果：
        * 我是爷爷
        * hahaha我是爸爸的有参构造
        * 我是儿子的有参构造
        * 我是儿子的无参构造
        * */
        Son son = new Son();
//      @@@@输出结果看查找关系
//      1.子类（自己）是否有该属性
//      2.子类（自己）有，并可以访问，则返回
//      3.子类（自己）没有，向父类查找，有且可以访问则返回
//      4.父类没有，重复3，直到Object类，都没有则报错
        System.out.println(son.name);//儿子
        System.out.println(son.age);//1

//        System.out.println(son.aa);//Error没有访问权限，且不会继续访问GrandFather类中的aa
        System.out.println(son.getAa());//0 通过公有方法访问私有变量
        System.out.println(son.hobby);//下棋
        son.testCall();
        Father fatherer = new Father();
        /*
        * Father类中的this.call()输出的是：爷爷的call
        * Father类中的this.name输出的是：爸爸
        * Father类中的this.hobby输出的是：下棋
        * */
        fatherer.fathercall();

//        向上转型
//        父类的引用指向子类的对象
//        可以调用父类中的所有成员
//        不能调用子类的特有类型
        Father father = new Son();
//        调用方法注意：@@@@@@子类重写的方法运行时从子类中开始查找@@@@@@，子类特有的方法编译时检查报错
//        father.testcall();//Error(编译) 从Father类中查找，不从子类Son中查找
        System.out.println(father.name);//爸爸
        System.out.println(father.age);//45
        System.out.print("向上转型调用的call是：");
        father.call();//OK 从子类Son中查找  输出结果：儿子的call
        System.out.print("Fasther father = new Son():father.call1():");
        father.call1();
        GrandFather grandfather = new Son();
        System.out.println(grandfather.name);//爷爷

//        向下转型
//        只能强转父类引用，不能强转父类的对象
//        要求父类的引用必须指向当前目标类型的对象
//        可以调用子类类型中所有的成员
        Father father1 = new Father();
//        Son son1 = (Son) father1;//Error(运行):class Father cannot be cast to class Son
        Father father2 = new Son();
        Son son2 = (Son) father2;//OK
        son2.testCall();//OK 调用Son类中的特有方法
    }
}
class GrandFather {
    String name = "爷爷";
    String hobby = "下棋";
    int aa = 1;//通过son.aa访问不到，在Father类中找到了aa，但是private，直接报错

    public GrandFather() {
        super();//隐藏
        System.out.println("我是爷爷");
    }
    public void call() {
        System.out.println("爷爷的call");
    }
}
class Father extends GrandFather{
    String name = "爸爸";
    int age = 45;
    private int aa = 0;

    public int getAa() {
        return aa;
    }

    public Father() {
        super();//隐藏
        System.out.println("我是爸爸的无参构造");
    }
    public Father(String name) {
        super();//隐藏
        System.out.println(name + "我是爸爸的有参构造");//此处的name是super("hahaha")传递的“hahaha”
    }
    public void fathercall() {
        System.out.print("Father类中的this.call()输出的是：");
        this.call();//爷爷的call
        System.out.println("Father类中的this.name输出的是：" + this.name);//爸爸 Father的name
        System.out.println("Father类中的this.hobby输出的是：" + this.hobby);//下棋 GrandFather的hobby
    }

    public void call1() {
        System.out.println("爸爸的call1");
    }
}
class Son extends Father {
    String name = "儿子";
    int age = 1;
    public Son() {
        this("hello");
        System.out.println("我是儿子的无参构造");
    }
    public Son(String name) {
        super("hahaha");
        System.out.println("我是儿子的有参构造");
    }

    public void testCall() {
//        先找自己的call，再找上级的call，遵循@@就近原则@@
        this.call();//输出：儿子的cal
        this.call1();//输出：爸爸的call1
//        直接找父类的call
        super.call();//输出：爷爷的call
    }
    @Override
//    子类和父类中，名称、形参列表一样的方法构成和重写关系
//    子类的返回类型==父类的返回类型 || 子类的返回类型 is 父类的返回类型 的子类
//    子类方法不能缩小(可以放大)父类方法的访问权限：protected void call() //Error
    public void call() {
        System.out.println("儿子的call");
    }
}