/*
java8的lambda表达式
	(parameters) -> expression  或
	(parameters) ->{ statements; }

	可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
	可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
	可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
	可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定表达式返回了一个数值。
 */

public class Lambda_ {
    final static String salutation = "你好 ";

    public static void main(String[] args) {
        Lambda_ tester = new Lambda_();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");//Hello Runoob
        greetService2.sayMessage("Google");//Hello Google

        //  lambda 表达式只能引用标记了 final 的外层局部变量
        //  也就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
        greetService1 = message -> System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");

        //在 lambda 表达式中访问外层的局部变量
        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);  // 输出结果为 3
        //    lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
        int num1 = 10;
        Converter<Integer, String> s1 = (param) -> System.out.println(String.valueOf(param + num1));
        s1.convert(20);  // 输出结果为 30
        //num1 = 0;//error:TODO lambda 表达式中使用的变量应为 final 或有效 final

        //在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
        String first = "";
        //Comparator<String> comparator = (first, second) ->
        //        Integer.compare(first.length(), second.length());  //编译会出错 first与局部变量重名
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }

    private static class Comparator<T> {
    }
}
