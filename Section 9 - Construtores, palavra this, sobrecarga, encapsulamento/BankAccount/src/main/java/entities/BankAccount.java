package entities;

public class BankAccount {
    private int accoutNumber;
    private String accountOwner;
    private double balance;
    private static double TAX = 5.00;

    public BankAccount(int accoutNumber, String accountOwner, double initialDeposit) {
        this.accoutNumber = accoutNumber;
        this.accountOwner = accountOwner;
        deposit(initialDeposit);
    }

    public BankAccount(int accoutNumber, String accountOwner) {
        this.accoutNumber = accoutNumber;
        this.accountOwner = accountOwner;
    }

    public int getAccoutNumber() {
        return accoutNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public void deposit(double value) {
        this.balance += (value);
    }

    public void withdraw(double value) {
        this.balance -= (value + 5);
    }

    public String toString() {
        return "\n-------Data Account-------\n" +
                "Accout Number: " + this.getAccoutNumber() + "\n" +
                "Account Owner: " + this.getAccountOwner() + "\n" +
                "Balance: $ " + String.format("%.2f",this.getBalance()) +
                "\n--------------------------\n";
    }
}
