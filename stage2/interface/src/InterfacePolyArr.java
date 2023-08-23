public class InterfacePolyArr {
    public static void main(String[] args) {
        Usb[] usbs = new Usb[2];
        usbs[0] = new MyCamera();
        usbs[1] = new MyPhone();
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
//            usbs[i].call();//Error
            if(usbs[i] instanceof MyPhone) {
                ((MyPhone)usbs[i]).call();
            }
        }

    }
}

interface Usb{
    void work();
}

class MyPhone implements Usb {
    public void call() {
        System.out.println("手机可以打电话...");
    }

    @Override
    public void work() {
        System.out.println("手机工作中...");
    }
}

class MyCamera implements Usb {

    @Override
    public void work() {
        System.out.println("相机工作中...");
    }
}
