public class Account {
    int balance;
    int PIN;
    int accountNumber;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void checkBalance(){
        System.out.println("Account balance is: " + this.balance);
    }

    public void deposit(int amount){
        this.balance += amount;
    }
    public void withdraw(int amount){
        this.balance -= amount;
    }
}
