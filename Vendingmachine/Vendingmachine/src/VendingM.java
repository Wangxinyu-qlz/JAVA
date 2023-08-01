// package VendingM;

public class VendingM
{
    int price = 80;
    int balance;//用户支付的金额
    int total;

    VendingM()
    {
        total = 0;
    }

    VendingM(int price)
    {
        this.price = price;
    }

    void setprice(int price)
    {
        this.price = price;//this.price指的是内部定义的price
    }

    void showprice()
    {
        System.out.println("单价为：" + price);
    }
    
    void showPrompt()
    {
        System.out.println("欢迎您！");
    }

    void insertMoney(int amount)
    {
        balance += amount;
    }

    void showBalance()
    {
        System.out.println("您支付的金额为：" + balance);
    }

    void getGood()
    {
        if( balance >= price)
        {
            balance -= price;
            total += price;
            System.out.println("找您：" + balance + "\n请拿好您的商品，欢迎下次光临!");
        }
    }


    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        VendingM vm = new VendingM(12);
        vm.showPrompt();
        vm.showprice();
        vm.insertMoney(20);
        vm.showBalance();
        vm.getGood();

    }
}