package view;
import utils.Utility;
import service.HouseService;
import domain.House;

/*
* 1.显示界面
* 2.接受用户输入
* 3.调用HouseService完成对房屋信息的操作
* */
public class HouseView {
//    显示主菜单
    private boolean loop = true;//控制显示菜单循环
    private char key = ' ';//接受用户输入
    private HouseService houseservice = new HouseService(1);
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
        System.out.println("\n=============添加房屋=============");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("租金：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
//        创建新的House对象，id系统自动分配，自增长
        House house = new House(0, "aa", "123", "杨凌", 200, "未出租");
        if(houseservice.add(house)) {
            System.out.println("添加成功！");
        }
    }

    public void delHouse() {
        System.out.println("\n=============删除房屋=============");
        System.out.print("请选择您要删除的房屋编号（-1退出）：");
        int delId = Utility.readInt();
        if(delId == -1) {
            System.out.println("你放弃了删除");
            return;//return终止函数@@@@TODO
        }
        char choice = Utility.readConfirmSelection();//该方法本身就有循环判断的逻辑
        if(choice == 'Y') {
            if(houseservice.del(delId)) {
                System.out.println("删除成功！");
            } else {
                System.out.println("编号不存在，删除失败！");
            }
        } else {
            System.out.println("你放弃了删除");
        }
    }

    public void search() {
        System.out.println("\n=============查找房屋=============");
        System.out.print("请选择您要查找的房屋编号：");
        int searchId = Utility.readInt();
        if(houseservice.search(searchId) != null) {
            System.out.println("找到了！");
        } else {
            System.out.println("编号不存在！");
        }
    }

    public void update() {
            System.out.println("\n=============修改房屋信息=============");
            System.out.print("请选择待修改的房屋的信息编号（-1表示退出）：");
            int updateId = Utility.readInt();
            if(updateId == -1) {
                System.out.println("你放弃了修改");
                return ;
            }
//            根据输入的updateId查找对象
            House house = houseservice.search(updateId);
            if(house == null) {
                System.out.println("要修改信息的房屋不存在！");
                return ;
            }

            System.out.print("姓名（"+ house.getName() +"）：");
            String name = Utility.readString(8, "");//用户直接回车则不修改
            if(!"".equals(name)) {
                house.setName(name);
            }

            System.out.print("电话（"+ house.getPhone() +"）：");
            String phone = Utility.readString(12, "");
            if(!"".equals(phone)) {
                house.setPhone(phone);
            }

            System.out.print("地址（"+ house.getAddress() +"）：");
            String address = Utility.readString(16, "");
            if(!"".equals(address)) {
                house.setAddress(address);
            }

            System.out.print("租金（"+ house.getRent() +"）：");
//            int rent = Utility.readInt(house.getRent());
//            house.setRent(rent);
            int rent = Utility.readInt(-1);
            if(rent != -1) {
                house.setRent(rent);
            }

            System.out.print("状态（"+ house.getState() +"）：");
            String state = Utility.readString(3, "");
            if(!"".equals(state)) {
                house.setState(state);
            }
            System.out.println("修改成功！");
    }

    public void list() {
        System.out.println("\n=============房屋列表=============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态\t\t");
//                    遍历获取house信息
        House[] houses = houseservice.list();
        for (int i = 0; i < houses.length; i++) {//有空信息，实际只有一条信息
            if(houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("房屋列表显示完毕");
    }

    public void quit() {
        System.out.println("\n=============退出=============");
            char choice = Utility.readConfirmSelection();
            if(choice == 'Y') {
                loop = false;
            }
    }
}
