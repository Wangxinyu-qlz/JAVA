public class Scientist extends Employee {
    private double bonus;

    public Scientist(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getSalary() {
        return super.getSalary() + bonus;
    }
}
