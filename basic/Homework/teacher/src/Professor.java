public class Professor extends Teacher {
    private double factor = 1.3;
    public Professor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }
    public void introduce() {
        System.out.println("姓名：" + getName() + ";年龄:" + getAge() +
                ";职称:" + getPost() + ";基本工资:" + factor * getSalary());
    }
}
