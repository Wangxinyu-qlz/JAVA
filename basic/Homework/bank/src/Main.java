public class Main {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(100);
        checkingAccount.deposit(10);
        System.out.println(checkingAccount.getBalance());
    }
}