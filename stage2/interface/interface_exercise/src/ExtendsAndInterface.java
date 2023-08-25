public class ExtendsAndInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("大圣");
        littleMonkey.fly();
        littleMonkey.swim();
        littleMonkey.change();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void change() {
        System.out.println("天生会七十二变！");
    }
}

interface Fish { public void swim();}

interface Bird { public void fly();}

class LittleMonkey extends Monkey implements Fish,Bird{
    public LittleMonkey(String name) {
        super(name);
    }

    public void swim() {
        System.out.println("通过学习会游泳.");
    }

    public void fly() {
        System.out.println("通过学习会飞翔.");
    }
}
