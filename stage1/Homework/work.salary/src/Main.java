public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker("张三", 500, 30);
        System.out.println(worker.getSalary());
        Manager manager = new Manager("李四", 350, 30, 4500);
        System.out.println(manager.getSalary());
        System.out.println(350 * 30 * 1.2 + 4500);
    }
}