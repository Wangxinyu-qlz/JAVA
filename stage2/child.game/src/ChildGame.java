public class ChildGame {
    public static void main(String[] args) {
//        定义一个变量count，统计有多少小孩接入了游戏
//        count是独立于对象/类的变量，访问count很麻烦，没有用到OOP
        int count = 0;
        Child child = new Child("小明");
        child.join();
        count++;

        Child child1 = new Child("小");
        child.join();
        count++;

        Child child2 = new Child("明");
        child.join();
        count++;

        System.out.println("一共有" + count + "个小孩加入了游戏>");
    }
}

class Child {
    private String name;

    public Child(String name) {
        this.name = name;
    }
    public void join() {
        System.out.println(name + "加入了游戏");
    }
}
