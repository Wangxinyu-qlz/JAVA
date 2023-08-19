public class Son extends Father {
    protected String name = "儿子属性";
    public static void main(String[] args) {
        Father sample = new Son();
        System.out.println("调用的属性:" + sample.name);

        F f = new S();
        System.out.println("调用的属性:" + f.name);
    }
}

class F {
    String name = "父亲";
}
class S extends F {
    String name = "儿子";
}
