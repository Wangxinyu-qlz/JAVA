public class Test {
    public static void main(String[] args) {
        Worker tom = new Worker("tom", 20000);
        Manager milan = new Manager("milan", 5000, 200000);
        Test test  = new Test();
        test.showEmpAnnual(tom);
        test.showEmpAnnual(milan);
        test.testWork(tom);
        test.testWork(milan);
    }

//    实现获取任意员工对象的年工资
    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnualSalary());
    }
//    实现普通员工调用work方法，经理调用manage方法
    public void testWork(Employee e) {
        if(e instanceof Worker) {
            ((Worker) e).work();
        } else if(e instanceof Manager) {
            ((Manager) e).manage();
        } else {
            System.out.println("戳啦！");
        }
    }
}
