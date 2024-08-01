package finalize.src;

/*
* finalize方法几乎不会用，只是应付面试
* */
public class Fanalize_ {
    public static void main(String[] args) {
        Car oooo = new Car("奥迪");
//对象置为空，成为垃圾，垃圾回收器会回收（销毁）该对象
//释放该对象指向的堆空间，别的对象可以使用
//在销毁对象前，可以调用对象的finalize方法
//程序员可以重写finalize方法，如释放资源：数据库链接，打开文件等
//如果不重写，则调用Object类的finalize方法
        oooo = null;
        /*
        * 这里并没有输出 ： 销毁汽车oooo
        * 因为并没有立即回收，有自己的机制
        * */
        System.out.println("程序已经退出了");
//        主动调用垃圾回收机制，一般情况下可以立即回收oooo指向的堆空间
//        运行结果：程序已经退出了  销毁汽车oooo
        System.gc();
    }
}

class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }
//    重写finalize方法
    @Override
    protected void finalize() throws Throwable {
        System.out.println("销毁汽车" + this.name);
    }
}
