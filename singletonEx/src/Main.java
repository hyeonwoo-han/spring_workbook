public class Main {
    public static void main(String[] args) {
        Account acct1 = new Account("insang1", 1000000);
        acct1.deposit(20000);
        Account acct2 = new Account("insang2", 2000000);
        acct2.withdraw(5000);
    }
}