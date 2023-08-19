public class Account {
    private String name;
    private double balance;
    private int password;

    public Account(String name, double balance, int password) {
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 4)
        {
            this.name = name;
        } else {
            System.out.println("名字无效，已重置");
            this.name = "佚名";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance >= 20)
        {
            this.balance = balance;
        } else {
            System.out.println("余额不足，请保证账户中至少有20元");
            this.balance = balance;
        }
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        if(password.toString().length() == 6)
        {
            this.password = password;
        } else {
            System.out.println("密码无效，已重置");
            this.password = 123456;
        }
    }
    public String info() {
        return "信息为：name=" + name + ";balance=" + balance + ";password=" + password;
    }
}
