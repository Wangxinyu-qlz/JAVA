import java.util.Date;
import java.util.Calendar;
public class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class CheckingAccount extends BankAccount {
    private double tip = 1;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }
    public void deposit(double amount) {
        super.deposit(amount - 1);
//        super.setBalance(getBalance() + amount - 1);
//        1块钱入银行账号
    }
    public void withdraw(double amount) {
        super.withdraw(amount + 1);
    }
}
class SavingAccount extends BankAccount {
    private double interestrate = 0.1;
    private int numberoffree = 3;

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    public double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    public int getNumberoffree() {
        return numberoffree;
    }

    public void setNumberoffree(int numberoffree) {
        this.numberoffree = numberoffree;
    }

    public void earnMonthlyInterest() {
        super.deposit(getBalance() * interestrate);
        this.numberoffree = 3;
    }

    public void deposit(double amount) {
        if( numberoffree > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        numberoffree--;
    }

    public void withdraw(double amount) {
        if(numberoffree > 0) {
            super.deposit(amount);
        } else {
            super.withdraw(amount + 1);
        }
        numberoffree--;
    }
}
