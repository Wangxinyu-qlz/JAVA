public class OverLoad {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.calculate(1, 1));
        System.out.println(c.calculate(1, 1.1));
        System.out.println(c.calculate(1.1, 1.1));
        System.out.println(c.calculate(1, 1, 1));
    }
}

class Calculator {
    //以下4个方法构成重载
    public int calculate(int a, int b) {
        return a + b;
    }
    public double calculate(int a, double b) {
        return a + b;
    }
    public double calculate(double a, double b) {
        return a + b;
    }
    public int calculate(int a, int b, int c) {
        return a + b + c;
    }
}
