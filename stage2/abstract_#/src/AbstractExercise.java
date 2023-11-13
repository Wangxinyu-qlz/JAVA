public class AbstractExercise {
    public static void main(String[] args) {
        CommonEmployee e = new CommonEmployee("zhangiang", "9527", 20000.0);
        e.work();
        Manager m = new Manager("猪猪猪", "0001", 2.0);
        m.work();
    }
}

abstract class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public abstract void work();
}
class CommonEmployee extends Employee {
    public CommonEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }
    public void work() {
        System.out.println("普通员工" + super.getName() + "工作中");
    }
}
class Manager extends Employee {
    public Manager(String name, String id, double salary) {
        super(name, id, salary);
    }
    public void work() {
        System.out.println("经理" + super.getName() + "工作中");
    }
}