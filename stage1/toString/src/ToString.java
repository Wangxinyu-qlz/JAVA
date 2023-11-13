public class ToString {
    public static void main(String[] args) {
        Monster monster = new Monster("小妖怪", "巡山", 1000);
        System.out.println(monster.toString());//重写前Monster@27d6c5e0
//        直接输出对象名字，默认调用toString方法
        System.out.println(monster);//重写后：Monster{name='小妖怪', job='巡山', salary=1000}
    }
}
class Monster {
    private String name;
    private String job;
    private int salary;

    @Override
    public String toString() {//一般输出对象的属性
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Monster(String name, String job, int salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
