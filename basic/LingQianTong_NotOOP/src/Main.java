import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        boolean loop = true;
        String key = "";
        System.out.println("----------------欢迎使用零钱通----------------");
        System.out.println("您的初始账户余额为0.0元。");
//        完成零钱通明细
//        思路：1.收入和支出保存到数组 2.对象 3.String拼接
        String details = "\n-----------------零钱通明细------------------";
//        完成收入
//        定义新的变量，存放收入
        double income = 0.0;
        double balance = 0.0;
        double expenditure = 0.0;
        String item = "";
        Date data = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化日期
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-----------------零钱通菜单------------------");
            System.out.println("\t\t\t\t1  零钱通明细");
            System.out.println("\t\t\t\t2  收益入账");
            System.out.println("\t\t\t\t3  消费");
            System.out.println("\t\t\t\t4  退出");
            System.out.println("请选择（1-4）：");

            key = scanner.nextLine();
            switch (key) {
                case"1" :
                    System.out.println(details);
                    break;
                case"2" :
                    System.out.print("入账金额：");
                    income = scanner.nextDouble();
                    if(income <= 0) {
                        System.out.println("非法输入!");
                        break;
                    }
                    balance += income;
                    data = new Date();
//                          拼接收入信息
                    details +="\n" + "入账：+" + income + "\t|" + sdf.format(data) + "|\t" + "余额：" + balance + "\t";
                    break;
                case"3" :
                    System.out.println("消费金额：");
                    expenditure = scanner.nextDouble();
//                    这一块，易读性差，坚持一段代码只做一件事
//                    if(expenditure <= 0) {
//                        System.out.println("非法输入!");
//                    } else if(expenditure > balance) {
//                        System.out.println("余额不足！");
//                    } else {
//                        balance -= expenditure;
//                        data = new Date();
//                        details +="\n" + item + "\t-" + expenditure + "\t|" + sdf.format(data) + "|\t" + "余额：" + balance + "\t";
//                    }
                    if(expenditure <= 0) {
                        System.out.println("非法输入!");
                        break;
                    }
                    if(expenditure > balance) {
                        System.out.println("余额不足！");
                        break;
                    }
                    System.out.println("活动：");
                    item = scanner.next();
                    balance -= expenditure;
                    data = new Date();
//                          拼接收入信息
                    details +="\n" + item + "\t-" + expenditure + "\t|" + sdf.format(data) + "|\t" + "余额：" + balance + "\t";
                    break;

                case"4" :
                    String choice = "";
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
                    break;
                default :
                    System.out.println("输入错误！");
                    break;
            }
        } while (loop);
    }
}