import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank(new ArrayList<>());
        bank.addAccount(new Account(new CreditAccount("Account 1", 0, 20, 25)));
        bank.addAccount(new Account(new SavingAccount("Account 2", 0, 20)));
        bank.addAccount(new Account(new CheckingAccount("Account 3", 0)));

        bank.getAccounts();
    }
}


import java.util.ArrayList;
import java.util.List;

public class Bank {

    public List<Account> accountList = new ArrayList<>();

    public Bank(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void getAccounts() {
        for(Account account : this.accountList) {
            System.out.println(account.__str__());
        }
    }
}


public class Account {

    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;
    private CreditAccount creditAccount;

    public Account(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public Account(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public Account(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public String __str__(CheckingAccount checkingAccount) {
        return checkingAccount.__str__();
    }

    public String __str__(SavingAccount savingAccount) {
        return savingAccount.__str__();
    }

    public String __str__(CreditAccount creditAccount) {
        return creditAccount.__str__();
    }
}


public class CreditAccount {

    public String name;
    public int balance;
    public int interest_rate;
    public int credit_limit;

    public CreditAccount(String name, int balance, int interest_rate, int credit_limit) {
        this.name = name;
        this.balance = balance;
        this.interest_rate = Math.max(interest_rate, 0);
        this.credit_limit = credit_limit;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(int amount) {

    }

    public String __str__() {
        return "placeholder";
    }

}


public class SavingAccount {

    public String name;
    public int balance;
    public int interest_rate;

    public SavingAccount(String name, int balance, int interest_rate) {
        this.name = name;
        this.balance = balance;
        this.interest_rate = Math.max(interest_rate, 0);
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public String __str__() {
        return "SavingAccount(Name = " + this.name + ", " +
                "Balance = " + this.balance + ", Interest Rate = " + this.interest_rate;
    }

    public void apply_daily_interest() {
        int daily_interest = this.balance * (this.interest_rate/100);
        this.balance = this.balance + daily_interest;
    }
}


public class CheckingAccount {

    public String name;
    public int balance;

    public CheckingAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(int amount) {
        if(this.balance - amount < 0) {
            System.out.println("Not enough funds");
        } else {
            this.balance = this.balance - amount;
        }
    }

    public String __str__() {
        return "CheckingAccount(Name = " + this.name + ", Balance = " + this.balance;
    }
}

