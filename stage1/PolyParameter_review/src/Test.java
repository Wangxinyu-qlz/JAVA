/*
* 多态参数
* 形参是父类，接受的参数可以是他的子类
* */
public class Test {
    public static void main(String[] args) {
        Employee e1 = new Worker("worker", 5000);
        Employee e2 = new Manager("Manager", 4500, 10000);
        Test test = new Test();
        test.showEmployee(e1);
        test.showEmployee(e2);
        test.testWork(e1);
        test.testWork(e2);
    }

    public void showEmployee(Employee e) {
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e) {
        if(e instanceof Worker) {
            ((Worker)e).work();
        } else if (e instanceof Manager) {
            ((Manager)e).manage();
        } else {
            System.out.println("Error!");
        }
    }
}
