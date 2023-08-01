// DVD 成为 Item 的一个子类
public class DVD extends Item {

    private String director;

    public DVD(String title, String director, int playingTime, String comment) {
        super(title, playingTime, false, comment);
        // 可行的，debug之后，可以看到两个title director playingTime comment，其中一个是自己的另一个是Item的，单步进入，优先将自己的四个变量赋值，Item的变量依然为NULL，“离我最近的是我的”原则
        // 子类中如果存在与父类相同的变量，父类中的会被隐藏起来，两者没有任何联系
        // this.title = title;
        // 父类中的所有东西子类均会继承，但是父类中的是private，子类没有直接访问权限（not visible），但是可以通过父类的函数访问。在谁的函数中指的成员变量就是谁的。
        // 这句存在时，最终的输出结果为：title:b
        // setTitle("b");
        this.director = director;
    }

    @Override
    public void print() {
        System.out.println("DVD:");
        // 调用父类中的print一定要加上super
        super.print();
        System.out.println("director:"+director);
    }

    public static void main(String[] args)
    {
        DVD dvd = new DVD("重庆森林", "王家卫", 3, "无人可约金城武，惨遭分手梁朝伟");
        dvd.print();
    }
}
