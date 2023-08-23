public class ChildGame {
    public static void main(String[] args) {
//        定义一个变量count，统计有多少小孩接入了游戏
//        count是独立于对象/类的变量，访问count很麻烦，没有用到OOP
        Child child = new Child("小明");
        child.join();
        child.count++;

        Child child1 = new Child("小");
        child.join();
        child1.count++;

        Child child2 = new Child("明");
        child.join();
        child2.count++;

        System.out.println("一共有" + Child.count + "个小孩加入了游戏>");

        System.out.println("child.count=" + child.count);//3
        System.out.println("child1.count=" + child1.count);//3
        System.out.println("child2.count=" + child2.count);//3
    }
}

class Child {
    private String name;
//    定义一个类变量  静态变量
//    该变量被Child类的所有对象实例共享 TODO
    public static int count = 0;
    public Child(String name) {
        this.name = name;
    }
    public void join() {
        System.out.println(name + "加入了游戏");
    }
}
