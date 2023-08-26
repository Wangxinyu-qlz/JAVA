public class AnonymousInnerClassExercise01 {
    public static void main(String[] args) {
//        当做实参传递，简洁高效，软编码
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一个茶壶");
            }
        });

//        传统方法：
//        1.创建一个类->实现接口IL ===> 硬编码
//        2.new一个对象
        f1(new Chahu());
    }

//    静态方法，参数是接口类型
    public static void f1(IL il) {
        il.show();
    }
}

interface IL {
    void show();
}

//类->实现接口 ===> 硬编码
class Chahu implements IL {
    public void show() {
//        修改这里会影响所有的Chahu实例
        System.out.println("这是一个茶壶");
    }
}