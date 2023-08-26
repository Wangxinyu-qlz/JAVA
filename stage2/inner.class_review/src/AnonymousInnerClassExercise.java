import javafx.scene.control.Cell;

public class AnonymousInnerClassExercise {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method();
    }
}

class Outer {
    public void method() {
        new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了！");
            }
        }.ring();

        new Bell() {
            @Override
            public void ring() {
                System.out.println("上课了！");
            }
        }.ring();
    }
}

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmclock(Bell bell) {
        bell.ring();
    }
}