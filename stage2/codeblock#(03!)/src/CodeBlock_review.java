public class CodeBlock_review {
    public static void main(String[] args) {
        /*
        * 这是static代码块
        * 1
        * 这是普通代码块
        * 1
        * 这是普通代码块
        * */
        //AW aw = new AW(1);//创建对象实例
        /*
        * 这是static代码块
        * 1
        * 这是普通代码块
        * 1
        * 这是普通代码块
        * */
//        BW bw = new BW(2);//创建子类对象实例
        /*
        * 这是static代码块
        * 1
        * 这是普通代码块
        * 1
        * www
        * */
//        System.out.println(AW.name);//使用类的静态属性
        /*
        * 这是static代码块
        * 1
        * 这是普通代码块
        * 1
        * AW静态方法
        * */
        AW.sf();//使用类的静态方法
    }
}

class AW {
    private static int t = 1;
    private int tr = 0;
    protected static String name = "www";

    {//每创建一个对象，就执行一次
        System.out.println("这是普通代码块");
    }

    /*
    * TODO 类加载的时间：
    *   1.创建对象实例时
    *   2.创建子类实例时
    *   3.使用类的静态成员时
    * */
    static {//只在类加载时执行一次
        System.out.println("这是static代码块");
        /*TODO 静态方法/代码块只能调用静态方法/属性
        * TODO 调用非静态的方法/属性，只能先创建对象，再调用
        * * */
//        System.out.println(tr);//Error
//        System.out.println(nomal());//Error
        System.out.println(t);
        System.out.println(new AW(1).tr);//创建对象再调用
    }

    public AW(int tr) {
        this.tr = tr;
    }

    public void nomal() {
        System.out.println("AW普通方法");
    }

    public static void sf() {
        System.out.println("AW静态方法");
    }
}

class BW extends AW {
    public BW(int tr) {
        super(tr);
    }

    public void test() {
        System.out.println(name);
    }
}
