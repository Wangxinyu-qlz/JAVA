/*
* 多态
*
* */
public class PolyState {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];//向上造型
        animals[0] = new Cat("猫猫");
        animals[1] = new Dog("大壮");
        for (int i = 0; i < animals.length; i++) {
            animals[i].sleep();
            animals[i].eat();
            if(animals[i] instanceof Cat) {
                ((Cat) animals[i]).catchMouse();//向下造型
            }
        }
        Animal animal = new Animal("a");
        Cat cat = new Cat("b");
        System.out.println(animal instanceof Animal);//true
        System.out.println(cat instanceof Animal);//true
    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("eat");
    }
    public void sleep() {
        System.out.println("sleep");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void eat() {
        System.out.println("cat eats fish");
    }

    public void catchMouse() {
        System.out.println("cat can catch mouse");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void sleep() {
        System.out.println("dog sleep.ZZZ~");
    }
}