public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String number, String holder, double balance) {
        this.accountNumber = number;
        this.accountHolder = holder;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) { balance -= amount; return true; }
        return false;
    }
    @Override
    public String toString() {
        return "Titular: " + accountHolder + ", Cuenta: " + accountNumber + ", Saldo: $" + String.format("%.2f", balance);
    }
}
