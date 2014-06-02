
import java.util.ArrayList;
public class TransactionalAccount extends Account {
    private ArrayList payment = new ArrayList();
    private ArrayList paymentName = new ArrayList();
    private int paymentNo;
    private double totalBalance = 0;
    
    public TransactionalAccount() {   
    }
    
    public void deposit(double balance) {
        this.totalBalance += balance;
    }
    
    public void withdraw(double balance) {
        if (balance > this.totalBalance) {
            System.out.println("The amount you specified is larger than the deposited amount");
        }
        else {
            this.totalBalance -= balance;
        }
    }
    
    public double getBalance() {
        return totalBalance;
    }
    
    public void pay(String billName, int pay) {
        
        this.paymentName.add(billName);
        this.payment.add(pay);
        ++this.paymentNo;
    
    }
    
    public String getPayments(int i) {
        String payments = null;
        if (!payment.isEmpty() && !paymentName.isEmpty()) {
           
            payments = (this.payment.get(i) + " - " + this.paymentName.get(i)); 
                
        }
        return payments;
    }
    
    public int getPaymentNo() {
        return paymentNo;
    }
    
    public String toString() {
        return "Your account no is " + this.getAccountNo() + "." + "\nThe current balance is " + this.getBalance() + " Sek.";
    }
}


