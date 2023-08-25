public class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    public double getAAnnual() {
        return super.getAnnual();
    }

    public void work() {
        System.out.println("work.");
    }
}
