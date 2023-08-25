package service;
import domin.House;

public class HouseService {
    private int numOfHouse = 0;//当前的房子数量
    private int id = 0;//当前房子的ID
    House[] houses;

    public HouseService(int size) {
        houses = new House[size];//创建大小为size的对象数组
//        TODO 初始化第一个房子信息
    }

    public int getNumOfHouse() {
        return numOfHouse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumOfHouse(int numOfHouse) {
        this.numOfHouse = numOfHouse;
    }

    public boolean add(House house) {
//        判断能不能添加
        if(houses.length == numOfHouse) {//当前房子的数量已经等于数组的长度，则不能添加
            System.out.println("当前数组已经满了，不能再添加了");
            return false;
        }
        houses[numOfHouse++] = house;
        house.setId(++id);
        return true;
    }

    public boolean del(int index) {
        int flag = -1;
        for (int i = 0; i < houses.length; i++) {
            if(houses[i].getId() == index){
                flag = i;
                break;
            }
        }
        if(flag == -1) {//没找到
            return false;
        }
        for (int i = index; i < numOfHouse - 1; i++) {//TODO 注意这里的开始
            houses[i] = houses[i + 1];
        }
//        TODO 这里的顺序？
        houses[--numOfHouse] = null;

        return true;
    }

    public boolean update() {
        return true;
    }

    public House search(int index) {//按照房子的ID查找
//        TODO 设立flag变量 记录没找到（-1），找到的下标
        int flag = -1;
        for (int i = 0; i < houses.length; i++) {
            if(houses[i].getId() == index) {
                flag = i;
                break;
            }
        }
        if(flag == -1) {
            return null;
        }
        return houses[flag];
    }

    public House[] list() {
        return houses;
    }
}
