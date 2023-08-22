import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
* 完成各个功能：
* 1.显示菜单并选择
* 2.零钱明细
* 3.收入
* 4.支出
* 5.退出
* 将各个功能封装为方法
* */
public class SmallChangesSysOOP {
    Scanner scanner = new Scanner(System.in);
    private double balance;
    private boolean loop = true;
    private String details = "-----------------零钱通明细------------------";
    private Date data = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化日期
//    菜单功能
    public void mainMenu() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n-----------------零钱通菜单------------------");
            System.out.println("\t\t\t\t1  零钱通明细");
            System.out.println("\t\t\t\t2  收益入账");
            System.out.println("\t\t\t\t3  消费");
            System.out.println("\t\t\t\t4  退出");
            System.out.println("请选择（1-4）：");

            String key = scanner.nextLine();
            switch (key) {
                case"1" :
                    this.details();
                    break;
                case"2" :
                    this.imcome();
                    break;
                case"3" :
                    this.expenditure();
                    break;
                case"4" :
                    this.quit();
                    break;
                default :
                    System.out.println("输入错误！");
                    break;
            }
        } while (loop);
    }
//    明细功能
    public void details() {
        System.out.println(details);
    }
//    收入
    public void imcome() {
        System.out.print("入账金额：");
        double income = scanner.nextDouble();
        if(income <= 0) {
            System.out.println("非法输入!");
            return;//方法不在执行，退出
        }
        balance += income;
        data = new Date();
        details +="\n" + "入账：+" + income + "\t|" + sdf.format(data) + "|\t" + "余额：" + balance + "\t";
    }
//    支出
    public void expenditure() {
        System.out.println("消费金额：");
        double expenditure = scanner.nextDouble();
        if(expenditure <= 0) {
            System.out.println("非法输入!");
            return;
        }
        if(expenditure > balance) {
            System.out.println("余额不足！");
            return;
        }
        System.out.println("活动：");
        String item = scanner.next();
        balance -= expenditure;
        data = new Date();
        details +="\n" + item + "\t-" + expenditure + "\t|" + sdf.format(data) + "|\t" + "余额：" + balance + "\t";
    }
//    退出
    public void quit() {
        String choice;
        while(true) {//一段代码只做一件事，只接收一个y/n，耦合性低，易读，易改
            System.out.println("确定要退出吗？y/n");
            choice = scanner.next();
            if("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        if("y".equals(choice)) {
            loop = false;
            System.out.println("您已退出！");
        }
    }
}
