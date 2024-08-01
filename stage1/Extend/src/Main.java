package Extend.src;

public class Main {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "Bob";
        pupil.age = 11;
        pupil.testing();
        pupil.setScore(89);
        pupil.showInfo();

        Graduate graduate = new Graduate();
        graduate.name = "Alice";
        graduate.age = 12;
        graduate.testing();
        graduate.setScore(100);
        graduate.showInfo();
    }
}