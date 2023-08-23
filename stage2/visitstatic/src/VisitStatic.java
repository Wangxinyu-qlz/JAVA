import javax.crypto.spec.IvParameterSpec;

public class VisitStatic {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.name);
        System.out.println(a.name);

//        编译Error：私有
//        System.out.println(A.a);
//        System.out.println(a.a);

        System.out.println(A.b);//OK
        System.out.println(a.b);//OK

        System.out.println(A.c);//OK
        System.out.println(a.c);//OK

        System.out.println(B.job);
    }
}

class A {
    public static String name = "www";
    private static int a = 0;
    protected static char b = 'A';
    static int c = 0;
}

class B {
    public static String job = "work";
}
