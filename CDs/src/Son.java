public class Son extends Father {
    protected String name = "儿子属性";
    public static void main(String[] args) {
        Father sample = new Son();
        System.out.println("调用的属性:" + sample.name);
    }
}