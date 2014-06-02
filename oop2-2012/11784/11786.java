public abstract class Account {
    private int accountNo;
    private static int numberOfAccounts;
    
    protected Account() {
        this.numberOfAccounts++;
        this.accountNo = this.numberOfAccounts;
    }
    
    public static int getNoOfAccounts() {
        return numberOfAccounts;
    }
    
    public int getAccountNo() {
        return accountNo;
    }
    
    public abstract void deposit(double balance); 
        
    public abstract void withdraw(double balance); 
    
    public abstract double getBalance();
}
