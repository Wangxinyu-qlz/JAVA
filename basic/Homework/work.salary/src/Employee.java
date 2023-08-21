public class Employee {
    private String name;
    private double salary;//单日工资
    private int workdays;//工作天数

    public Employee(String name, double salary, int workdays) {
        this.name = name;
        this.salary = salary;
        this.workdays = workdays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary * workdays;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkdays() {
        return workdays;
    }

    public void setWorkdays(int workdays) {
        this.workdays = workdays;
    }
}
class Manager extends Employee {
    private double factor = 1.2;
    private double bonus;

    public Manager(String name, double salary, int workdays, double bonus) {
        super(name, salary, workdays);
        this.bonus = bonus;
    }

    public double getSalary(){
        return super.getSalary() * factor + bonus;
    }
}
class Worker extends Employee {
    private double factor = 1.0;

    public Worker(String name, double salary, int workdays) {
        super(name, salary, workdays);
    }

    public double getSalary(){
        return super.getSalary() * factor;
    }
}