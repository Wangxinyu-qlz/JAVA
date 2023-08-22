public class Teacher extends Employee {
    private double classDay;
    private double classSalary;

    public Teacher(String name, double salary, double classDay, double classSalary) {
        super(name, salary);
        this.classDay = classDay;
        this.classSalary = classSalary;
    }

    public double getSalary() {
        return super.getSalary() + classSalary * classDay;
    }
}
