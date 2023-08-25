package view;

import domin.House;
import service.HouseService;
import utils.Utility;

public class Menu {
    private boolean loop = true;
    private char key;
    HouseService houseservice = new HouseService(2);
    public void mainView() {
        do {
            System.out.println("=============房屋出租系统菜单=============");
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
        double rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        House house = new House(1, name, phone, address, rent, state);
        houseservice.add(house);
    }

    public void search() {
        System.out.println("========search=========");
        System.out.println("请输入您要查找的房子ID");
        int index = Utility.readInt();
        if(houseservice.search(index) != null) {
            System.out.println(houseservice.search(index));
        } else {
            System.out.println("不存在！");
        }
    }

    public void delHouse() {
        System.out.println("========delete house=========");
        System.out.print("请输入您要删除的房子ID(-1退出)");
        int index = Utility.readInt();
        if(index == -1) {
            System.out.println("您已放弃！");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if(choice == 'N') {
            System.out.println("您已放弃！");
        }
        else {
            if(houseservice.del(index)) {
                System.out.println("删除成功！！");
            } else {
                System.out.println("删除失败，您要删除的房子信息不存在！");
            }
        }
    }

    public void update() {
        System.out.println("========delete house=========");
        System.out.print("请输入您要修改信息的房子ID：");
        int updateindex = Utility.readInt();
        if(updateindex == -1) {
            System.out.println("您已放弃！");
            return;
        }
        House house = houseservice.search(updateindex);
        if(house == null) {
            System.out.println("您要修改信息的房子不存在！");
            return;
        }

        System.out.print("姓名（"+ house.getName() +"）：");
        String name = Utility.readString(8, "");//用户直接回车则不修改
        if(!"".equals(name)) {//如果不是直接回车，就修改信息
            house.setName(name);
        }

        System.out.print("电话（"+ house.getPhone() +"）：");
        String phone = Utility.readString(11, "");//用户直接回车则不修改
        if(!"".equals(phone)) {
            house.setPhone(phone);
        }

        System.out.print("地址（"+ house.getAddress() +"）：");
        String address = Utility.readString(16, "");//用户直接回车则不修改
        if(!"".equals(address)) {
            house.setAddress(address);
        }

        System.out.print("租金（"+ house.getRent() +"）：");
        double rent = Utility.readInt(-1);
        if(rent != -1) {
            house.setRent(rent);
        }

        System.out.print("状态（"+ house.getState() +"）：");
        String state = Utility.readString(3, "");//用户直接回车则不修改
        if(!"".equals(state)) {
            house.setState(state);
        }

        System.out.println("修改信息成功！");
    }

    public void list() {
        System.out.println("========house list=========");
        System.out.println("编号\t\t\t\t姓名\t\t\t\t电话\t\t\t\t地址\t\t\t\t租金\t\t\t\t状态");
        House[] houses = houseservice.list();
        for (House house : houses) {
            if (house == null) {
                break;
            }
            System.out.println(house);
        }
        System.out.println("this is all!");
    }

    public void quit() {
        System.out.println("========退出=========");
        char choice = Utility.readConfirmSelection();
        if(choice=='Y') {
            loop = false;
        }
        System.out.println("您已退出系统");
    }
}
