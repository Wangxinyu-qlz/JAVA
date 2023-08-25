package view;

import domin.House;
import service.HouseService;
import utils.Utility;

public class Menu {
    private boolean loop;
    private char key;
    HouseService houseservice = new HouseService();
    public void mainView() {
        do {
            System.out.println("\n=============房屋出租系统菜单=============");
            System.out.println("\t\t\t1  新 增 房 源");
            System.out.println("\t\t\t2  查 找 房 物");
            System.out.println("\t\t\t3  删除房屋信息");
            System.out.println("\t\t\t4  修改房屋信息");
            System.out.println("\t\t\t5  房 屋 列 表");//房屋列表
            System.out.println("\t\t\t6  退       出");
            System.out.println("请输入你的选择（1-6）：");
            key = Utility.readChar();
            switch (key) {
                case '1' :
                    addHouse();
                    break;
                case '2' :
                    search();
                    break;
                case '3' :
                    delHouse();
                    break;
                case '4' :
                    update();
                    break;
                case '5' :
                    list();
                    break;
                case '6' :
                    quit();
                    break;
            }
        } while (loop);
    }

    public void addHouse() {
        System.out.println("=======Add House=======");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(11);
        System.out.print("地址：");
        String address = Utility.readString(18);
        System.out.print("租金：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        House house = new House("js", "12312302015", "长沙", 2000, "已出租");
        houses.add(house);
    }

    public void search() {

    }

    public void delHouse() {

    }

    public void update() {

    }

    public void list() {

    }

    public void quit() {

    }

}
