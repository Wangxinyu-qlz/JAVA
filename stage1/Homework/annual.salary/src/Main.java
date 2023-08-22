public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Worker("worker", 2000);
        employees[1] = new Waiter("waiter", 3000);
        employees[2] = new Peasant("peasant", 4000);
        employees[3] = new Teacher("teacher", 4500, 22, 30);
        employees[4] = new Scientist("scientist", 5000, 10000);
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] instanceof Worker) {
                System.out.println(((Worker)employees[i]).getSalary());
            }
            if(employees[i] instanceof Waiter) {
                System.out.println(((Waiter)employees[i]).getSalary());
            }
            if(employees[i] instanceof Peasant) {
                System.out.println(((Peasant)employees[i]).getSalary());
            }
            if(employees[i] instanceof Teacher) {
                System.out.println(((Teacher)employees[i]).getSalary());
            }
            if(employees[i] instanceof Scientist) {
                System.out.println(((Scientist)employees[i]).getSalary());
            }
        }
    }
}