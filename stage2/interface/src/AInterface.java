public interface AInterface {
//    写属性
    public int n1 = 10;
//    写方法
//    在接口中，抽象方法可以省略 abstract 关键字、
    public void hi();
//    在JDK8.0及以后，可以有默认实现方法，需要使用 default 关键字 修饰
    public default void ok() {
        System.out.println("OK~");
    }
//    在JDK8.0以后，可以有静态方法
    public static void cry() {
        System.out.println("cry~");
    }

}
