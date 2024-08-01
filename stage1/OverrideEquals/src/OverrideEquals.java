package OverrideEquals.src;

public class OverrideEquals {
    public static void main(String[] args) {
        Person person = new Person("jack", 10, '男');
        Person person1 = new Person("jack", 10, '男');
        Person person2 = new Person("Smith", 10, '男');
        Person person3 = new Person("Bob", 10, '男');
//        TODO @@@一定要注意有没有重写equals方法@@@
        System.out.println(person.equals(person1));//重写前为false,重写后为true
        System.out.println(person2.equals(person3));//false
        System.out.println(person == person1);//false  都是new的对象
        Person person4 = person;
        System.out.println(person == person4);//true  person4指向了person的对象

//        TODO debug：ch1:'A' 65     ch2:'\f' 12  int和char类型的的比较
        int it = 65;
        float f = 65.0f;
        System.out.println("65==65.0f?:" + (it == f));//true
        char ch1 = 'A';
        char ch2 = 12;
        System.out.println("65=='A'?:" + (it == ch1));//true
        System.out.println("12(int)==12(char)?:" + (12 == ch2));//true
//        编译错误
//        System.out.println("hello" == new Person("q", 12, '男'));

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
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;
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
