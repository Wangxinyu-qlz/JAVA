
/*
* 成员方法返回类型是引用类型
* */
public class ParameterDeliver {
    public static void main(String[] args){
        Person p = new Person();
        p.name = "bob";
        p.age = 5;
//      创建Tools
        MyTools tools = new MyTools();
        Person p2 = tools.copyPerson(p);

//      到此，p和p2是Person的对象，但是两个独立的对象，属性相同
        System.out.println("p的属性 name=" + p.name + ";age=" + p.age);//p的属性 name=bob;age=5
        System.out.println("p2的属性 name=" + p2.name + "age=" + p2.age);//p2的属性 name=bob;age=5
        System.out.println(p == p2);//false
    }
}

class Person{
    String name;
    int age;
}

class MyTools{
    public Person copyPerson(Person p){
        Person p2 = new Person();
        p2.name = p.name;
        p2.age = p.age;
        return p2;
    }
}
