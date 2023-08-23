public class Interface01 {
    public static void main(String[] args) {
//        创建相机手机对象
        Camera camera = new Camera();
        Phone phone = new Phone();

//        创建计算机
        Computer computer = new Computer();
//        相机手机接入计算机
        computer.work(camera);
        computer.work(phone);

    }
}

