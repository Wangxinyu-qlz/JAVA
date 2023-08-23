public class Main01 {
    private static String name = "xxx";
    private int age = 0;

    public static void hi() {
        System.out.println("hi");
    }

    public void hihihi() {
        System.out.println("嗨嗨嗨，来啦~");
    }

    public static void main(String[] args) {
        /*
        * cmd执行:java Main01 banana jack
        * 执行结果：
        * 第1个参数：banana
        * 第2个参数：jack
        * */
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数：" + args[i]);
        }



        System.out.println(name);//Ok
        hi();//Ok

//        System.out.println(age);//编译Error
//        hihihi();//编译Error
//        静态方法main，访问本类的非静态成员，需要先创建对象，再调用即可
        Main01 main01 = new Main01();
        System.out.println(main01.age);//OK 0
        main01.hihihi();//OK 嗨嗨嗨，来啦~
    }
}
