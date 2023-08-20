public class OverrideEquals {
    public static void main(String[] args) {
        Person person = new Person("jack", 10, '男');
        Person person1 = new Person("jack", 10, '男');
        Person person2 = new Person("Smith", 10, '男');
        Person person3 = new Person("Bob", 10, '男');
        System.out.println(person.equals(person1));//重写前为false,重写后为true
        System.out.println(person2.equals(person3));//false

    }
}

class Person {
    private String name;
    private int age;
    private char gender;
//    重写Object类的equals方法
    public boolean equals(Object obj) {
//        this：person/person2    obj:person1/person3
//        判断是否为同一个对象，是直接返回true
        if(this == obj){
            return true;
        }
//        判断类型
        if(obj instanceof Person) {
//            向下转型->得到obj的属性
            Person p = (Person)obj;
            return p.name.equals(this.name) && p.age == this.age && p.gender == this.gender;
        }
        return false;

    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
