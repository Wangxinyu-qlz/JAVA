package service;
import domain.House;
import utils.Utility;

public class HouseService {
    private House[] houses;
    private int houseNums = 1;//记录当前有多少个房屋
    private int idCounter = 1;//记录当前id的值

    public HouseService(int size) {
        houses = new House[size];//创建HouseService对象时，指定数组大小
//        为了测试，初始化一个House对象
        houses[0] = new House(1, "zz", "158", "杨凌", 300, "未出租");
    }
    public House[] list() {
        return houses;
    }

    public boolean add(House newHouse) {
//        暂时不考虑数组扩容的问题：判断是否可以继续添加
        if(houseNums == houses.length) {
            System.out.print("数组已满，不能再添加了...");
            return false;
        }
//        将新的房屋对象添加到列表的最后一个
        houses[houseNums++] = newHouse;
//        id自增长机制
        newHouse.setId(++idCounter);
        return true;
    }

    public boolean del(int delId) {
//        先找到删除的房屋信息对应的下标
//        一定要搞清楚下标和房屋的编号不同
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
//            TODO 注意查找房屋得到方式，使用getId()方法最稳妥直观
            if(delId == houses[i].getId()) {//要删除的房屋（id），是数组下标为i的元素
                index = i;//使用index记录i
            }
        }
        if(index == -1) {//没找到
            return false;
        }
//        如果找到
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
//            别忘了将最后一个置空
        houses[--houseNums] = null;
        houseNums--;
        return true;
    }

    public House search(int id) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
//            TODO 注意查找房屋得到方式，使用getId()方法最稳妥直观
            if(id == houses[i].getId()) {//要删除的房屋（id），是数组下标为i的元素
                index = i;//使用index记录i
            }
        }
        if(index == -1) {//没找到
            return null;
        }
//        如果找到
        return houses[index];
    }
}
