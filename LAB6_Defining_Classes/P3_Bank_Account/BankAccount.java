package ADVANCED.LAB6_Defining_Classes.P3_Bank_Account;

public class BankAccount {
    private int id;
    private double balance;

    private static double interestRate = 0.02;
    private static int accountCounter = 0;

    public BankAccount(){
        accountCounter++;
        this.id = accountCounter;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountCounter() {
        return accountCounter;
    }

    public void setAccountCounter(int accountCounter) {
        this.accountCounter = accountCounter;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double money){
        this.balance += money;
    }

    public double getInterest(int year){
        return year * interestRate * this.balance;
    }
}
