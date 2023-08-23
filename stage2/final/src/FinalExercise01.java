public class FinalExercise01 {
    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        System.out.println(c1.calculate1());

        Circle c2 = new Circle(2);
        System.out.println(c1.calculate2());

        Circle c3 = new Circle(2);
        System.out.println(c1.calculate3());
    }
}

class Circle {
    private double radius;
    private final double PI1 = 3.1415926;
    private final double PI2;
    private final double PI3;

    {
        PI2 = 3.14;
    }

    public Circle(double radius) {
        this.radius = radius;
        PI3 = 3;
    }

    public double calculate1 () {
        return 0.5 * PI1 * radius * radius;
    }

    public double calculate2 () {
        return 0.5 * PI2 * radius * radius;
    }

    public double calculate3 () {
        return 0.5 * PI3 * radius * radius;
    }
}