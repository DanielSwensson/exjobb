
public class SavingsAccount extends Account {
    private final double INTREST = 1.05;
    private double totalBalance = 0;
    private boolean withdrawal = false;
    
    public SavingsAccount() {
    }
    
    public void deposit(double balance) {
        this.totalBalance += balance;
    }
    
    public void withdraw(double balance) {
        if (withdrawal) {
            System.out.println("Only one withdrawal per year allowed.");
        }
        else {
            if (balance > this.totalBalance) {
                System.out.println("The amount you specified is larger than the deposited amount");
            }
            else {
                this.totalBalance -= balance;
                this.withdrawal = true;
            }
        }
    }
    
    public double getBalance() {
        return totalBalance;
    }
    
    public double getIntrest() {
        return this.INTREST;
    }
    
    public double getReturn() {
        return this.getBalance() * (this.getIntrest() - 1);
    }
    
    public String toString() {
        return "Your account no is " + super.getAccountNo() + "\nThe current balance is " + this.getBalance() + " Sek." 
        + "\nThe intrest rate of the savings account is: 5%." + "\nThe return will be " +
        (int)this.getReturn() + " sek after one year.";
    }
    
    public String showPlan(int years) {
        double plan = this.getBalance() * Math.pow(this.getIntrest(), years);
        
        return "With " + this.getBalance() + " Sek deposited for " + years + " years, with an " + 
         "5% intrest rate, the return will be " + (plan - this.getBalance()) + " Sek.";
    }
    
}
