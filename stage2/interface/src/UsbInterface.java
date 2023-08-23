/*
* 1.在JDK7.0之前，接口中的所有方法体都没有方法体，即都是抽象方法
* 2.JDK8.0之后，接口可以有静态方法和普通方法，即方法的具体实现
* */
public interface UsbInterface {//接口
    public void start();
    public void end();

}
