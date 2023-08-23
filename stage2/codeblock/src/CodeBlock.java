/*
* 1.相当于另外一种形式的构造器，是对构造器的补充，可以做初始化的操作
* 2.场景：如果构造器中都有重复的语句，可以抽取到初始化块中，提高代码的重用性
* */
public class CodeBlock {
    public static void main(String[] args) {
        /*
        * 输出结果：
        * 电影屏幕打开
        * 广告开始
        * ......
        * @@@@@@@@@@@@@@
        * String name 正在被调用
        * @@@@@@@@@@@@@@
        * String name, double price正在被调用
        * */
        Movie movie = new Movie("盗梦空间");
        Movie movie2 = new Movie("复仇者联盟", 50);

    }
}

class Movie {
    private String name;
    private double price;
    private String director;
/*
* 3个构造器都有相同的语句
* 代码冗余
* 可以把重复的代码放在代码块中
* 这样不管调用哪一个构造器，创建对象，都会优先调用代码块的内容
* */
    static {
        System.out.println("电影屏幕打开");
        System.out.println("广告开始");
        System.out.println("......");
    }
    {
        System.out.println("@@@@@@@@@@@@@@");
    }
    public Movie(String name) {
        this.name = name;
        System.out.println("String name 正在被调用");
    }

    public Movie(String name, double price) {
//        System.out.println("电影屏幕打开");
//        System.out.println("广告开始");
//        System.out.println("......");
        this.name = name;
        this.price = price;
        System.out.println("String name, double price正在被调用");
    }

    public Movie(String name, double price, String director) {
//        System.out.println("电影屏幕打开");
//        System.out.println("广告开始");
//        System.out.println("......");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
