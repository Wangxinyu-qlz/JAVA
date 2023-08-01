public class VendingMachine 
{
//  成员变量 生存周期为对象的生存周期
//  在实例化对象时，自动初始化
    int price = 80;//商品价格   声明的同时赋值是可以的
    // price = 80;//Syntax error on token ";", , expected    声明可以不在方法中，但是单独赋值需要在方法中
    int balance;//用户投币金额
    int total;//卖出商品总价格

//  构造函数，在实例化对象时，会先找这个函数，然后执行该函数之前的成员变量声明，最后在执行构造函数内部的语句
//  构造函数没有返回类型
//  同名  但   参数表   不同的函数构成了    重载关系
//  实例化时会根据参数的数量及类型寻找对应的构造函数进行   重 载
    VendingMachine()
    {
        total = 0;
    }
//  VendingMachine vm1 = new VendingMachine(30);语句会执行此构造函数，将price的值修改为了30
    VendingMachine(int price)
    {
        this.price = price;
    }

    void setPrice(int price)
    {
        this.price = price;
    }

    void showPrompt()
    {
        System.out.println("Welcome!");
    }

    // 投币
    void insertMoney(int amount)
    {
        balance = balance + amount;
        showBalance();//内部直接调用即可
    }

    // 取商品
    void getGood()
    {
        
        if ( balance >= price )
        {
            System.out.println("Here you are:");
            balance = balance - price;
            total = total + price;
        }
    }

    // 计算余额
    void showBalance()
    {
        System.out.println(this.balance);
    }

    public static void main(String[] args)
    {
        VendingMachine vm = new VendingMachine();//成员函数将价格初始化为100
        vm.showPrompt();
        vm.insertMoney(100);
        vm.showBalance();//100
        vm.getGood();//100
        vm.showBalance();//20

        VendingMachine vm1 = new VendingMachine(30);//将价格重载为30
        vm1.showPrompt();
        vm1.insertMoney(100);
        vm1.showBalance();//100
        vm1.getGood();//100
        vm1.showBalance();//70
    }
}
