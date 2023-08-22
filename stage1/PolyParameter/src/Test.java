public class Test {
    public static void main(String[] args) {
        Worker tom = new Worker("tom", 20000);
        Manager mialn = new Manager("mialn", 5000, 200000);
        Test test  = new Test();
        test.showEmpAnnual(tom);
        test.showEmpAnnual(mialn);
        test.testWork(tom);
        test.testWork(mialn);
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
