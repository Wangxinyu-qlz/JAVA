public class ExtendsVSImplements {
    public static void main(String[] args) {
        LittleMonkey sun = new LittleMonkey("悟空");
        sun.climbing();
        sun.fly();
        sun.swim();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println("猴子生来会爬树...");
    }

    public String getName() {
        return name;
    }
}

interface Bird {
    void fly();
}

interface Fish {
    void swim();
}

//当子类继承父类，自动拥有父类的功能
//如果子类要扩展功能，可是通过实现接口的功能实现
//可以理解为：实现接口，是JAVA单继承机制的补充
//继承满足is-a关系，但是接口灵活，满足like-a关系
//接口可以实现代码解耦 【即 接口规范性+动态绑定】
class LittleMonkey extends Monkey implements Bird,Fish {
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + "通过学习，会飞...");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + "通过学习，会游泳...");
    }
}
