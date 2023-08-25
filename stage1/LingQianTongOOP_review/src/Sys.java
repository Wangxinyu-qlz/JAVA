import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Sys {
    private double balance;
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    // TODO 这里不做初始化，会在明细中输出null 且在这里直接写为 "-------明细------" 输出的格式才正常，否则会有一个空行
    private String details = "-------明细------";
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date date = null;
    public void showMenu() {
        do {
            System.out.println("===========菜单===========");
            System.out.println("\t\t1.明细");
            System.out.println("\t\t2.收入");
            System.out.println("\t\t3.支出");
            System.out.println("\t\t4.退出");
            System.out.print("请选择(1-4):");
            String select = scanner.next();//TODO
            switch(select) {
                case "1" :
                    shoeDetails();
                    break;
                case "2" :
                    income();
                    break;
                case "3" :
                    expenditure();
                    break;
                case "4" :
                    quit();
                    break;
                default :
                    System.out.print("您的输入有误！请重新的输入：");
                    break;
            }
        } while (loop);
    }

    public void shoeDetails() {
        System.out.println(details);
    }

    public void income() {
        System.out.println("------收入------");
        System.out.print("金额：");
        double income = scanner.nextDouble();
        balance += income;
        date = new Date();
        details += "\n收入\t+" + income + "\t|" + sdf.format(date) + "|\t余额：" + balance;
    }

    public void expenditure() {
        System.out.println("------支出------");
        System.out.print("去向：");
        String item = scanner.next();
        System.out.print("金额：");
        double expenditure = scanner.nextDouble();
        balance -= expenditure;
        date = new Date();
        details += "\n" + item + "\t-" + expenditure + "\t|" + sdf.format(date) + "|\t余额：" + balance;
    }

    public void quit() {
        String choice;
        while(true) {
            System.out.println("确定要退出吗？请输入y/n:");
            choice = scanner.next();
            if(choice.equals("y")|| choice.equals("n")) {
                break;
            }
        }
        if(choice.equals("y")) {
            loop = false;
            System.out.println("您已退出");
        }
    }
}
