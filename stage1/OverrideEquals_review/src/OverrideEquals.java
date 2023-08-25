public class OverrideEquals {
    public static void main(String[] args) {
        Person person1 = new Person("a", 1);
        Person person2 = new Person("b", 2);
        System.out.println(person1.equals(person1));
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    默认情况下，==比较引用类型的地址是否相等
//    equals()方法，本身是判断应用类型的地址是否相等，但是很多类会重写String
    public boolean equals(Object object) {//Object时Person的父类，可以传进来Person类型的对象
//        person1.equals(person1)：this和object的地址都是一样的
        System.out.println(this);//Person@1b6d3586
        System.out.println(object);//Person@1b6d3586
        if(this == object) {//this：Person类型
            return true;
        }
        if(object instanceof Person) {//如果是Person类型，做转型，获取name和age并做等价判断
            return ((Person)object).name.equals(this.name) && ((Person)object).age == this.age;
        }
        return false;//如果不是Person类型，直接返回false
    }
}