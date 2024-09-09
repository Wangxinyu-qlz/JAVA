public class PolyParameter {
    public static void main(String[] args) {
        Phone phone = new Phone() {
            @Override
            public void ter() {

            }
        };
        Camera camera = new Camera();
        Computer computer = new Computer();

        computer.work(phone);
        computer.work(camera);
    }
}

interface Usb {
    public void start();
    public void end();

    public abstract void ter();

	static void tere() {

	}

    public static final int f = 0;
    int a = 0;
    //int b;
}

class Camera implements Usb {
    public void start() {
        System.out.println("相机开始工作.");
    }

    public void end() {
        System.out.println("相机停止工作.");
    }

    @Override
    public void ter() {

    }
}

abstract class Phone implements Usb {
    public void start() {
        System.out.println("手机开始工作.");
    }

    public void end() {
        System.out.println("手机停止工作.");
    }
}

class Computer {
    public void work(Usb usb) {
        usb.start();
        usb.end();
    }
}