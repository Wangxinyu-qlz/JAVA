import view.HouseView;

public class HouseRentApp {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        整个程序的入口，创建HouseView对象，显示主菜单
//        HouseView houseview = new HouseView();
//        houseview.mainView();
        new HouseView().mainView();//创建匿名对象直接调用方法
        System.out.println("您已经退出了！");
    }
}