public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("zhao", 19, "student");
        persons[1] = new Person("qi", 15, "cook");
        persons[2] = new Person("Alice", 23, "student");
        persons[3] = new Person("Alic", 22, "s");
        persons[4] = new Person("Ali", 18, "stud");
//        冒泡
        Person person;
        for (int i = 0; i < persons.length - 1; i++) {//循环length - 1次
            //每次循环都比较相邻的数字，大的值往后走
            //每次大循环之后，一个值被排到正确的位置上，下次内循环少一次比较（-i）
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if(persons[j].getAge() > persons[j + 1].getAge()) {//从小到大排序
                    person = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = person;
                }
            }
        }
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
    }

}
class Person {
    private String name;
    private int age;
    private String job;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}