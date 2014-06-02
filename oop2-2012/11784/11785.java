import java.util.ArrayList;

public class User 
{
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private String password, username;
    
    public User(String user, String pass) {
        this.username = user;
        this.password = pass;
    }
    
    public void addSavingsAccount() {       
        accounts.add(new SavingsAccount()); 
    }
    
    public void addTransactionalAccount() {       
        accounts.add(new TransactionalAccount()); 
    }
    
    public void removeAccount(int accountNumber) {
        accounts.remove(accountNumber);    
    }
    
    public int getTotalNoOfAccounts() {
        return accounts.get(0).getNoOfAccounts();
    }
    
    public int getNoOfAccounts() {
        return accounts.size();
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Account getAccount(int i) {
        return accounts.get(i);
    }
    
    public int getIndex(int i) {
        int index = -1;
        for (Account account : accounts) {
            if (account.getAccountNo() == i) {
                index = accounts.indexOf(account);
            }
        }
        return index;
    }
    
    public String toString() {
        return "Account belongs to username " + this.getUsername() + ".\n" + getNoOfAccounts() + " bankaccounts belong to this useraccount";
    }
}
