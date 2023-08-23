public class Computer {
//    编写一个方法，计算机工作
//    1.usbInterface 形参 是一个接口类型 UsbInterface
//    2.接受 实现了UsbInterface接口的类 的对象实例
    public void work(UsbInterface usbInterface) {
//        通过接口，调用方法
        usbInterface.start();
        usbInterface.end();
    }
}
