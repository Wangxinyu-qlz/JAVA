/*
* 不希望创建实例，也可以使用某个方法
* 工具类可以设计成static方法
* 比如for循环输出数组
* */
public class StaticMethod {
//    JVM调用main方法->必须为public
//    JVM调用main，不必创建对象->必须为static
    public static void main(String[] args) {
        Student student = new Student("qwe");
        Student student1 = new Student("rty");

        student.payFee(100);
//        Student.payFee(100);//OK

        student1.payFee(100);
//        Student.payFee(100);//OK

        Student.showTotalFee();
    }
}

class Student {
    private String name;
    private static double fee = 0;

    public Student(String name) {
        this.name = name;
    }

    public void test() {
        System.out.println("test");
    }

//    静态方法，可以访问静态变量
    public static void payFee(double fee) {
        Student.fee += fee;

//        TODO 静态方法只能访问静态变量和方法
//        System.out.println(name);//编译Error
        showTotalFee();//OK
//        test();//编译Error
    }

    public static void showTotalFee() {
        System.out.println("总学费有：" + Student.fee);
    }
}
