/*
* 演示懒汉式 单例模式
* */
public class Singleton02 {
    public static void main(String[] args) {
        System.out.println(Cat.n1);//111  没有调用getInstance

        Cat cat = Cat.getInstance();//构造器被调用
        System.out.println(cat);//Cat{name='小铃铛'}

        Cat cat2 = Cat.getInstance();//构造器被调用
        System.out.println(cat2);//Cat{name='小铃铛'}
        System.out.println(cat == cat2);//true
    }
}

class Cat {
    private String name;
    public static int n1 = 111;
    private static Cat cat;
//    构造器私有化
//    定义静态公共属性对象
//    提供公共静态方法，返回Cat对象
//    懒汉式只有当用户使用getInstance时，才会返回Cat对象，后面再次调用时，会返回第一次创建的cat对象
//    保证单例

//    有多线程风险
    public static Cat getInstance() {
        if(cat == null) {
            cat = new Cat("小铃铛");
        }
        return cat;
    }

    private Cat(String name) {
        this.name = name;
        System.out.println("构造器被调用");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
