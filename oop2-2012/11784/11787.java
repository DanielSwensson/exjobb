import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
   static Scanner input = new Scanner(System.in);
   static ArrayList<User> users = new ArrayList<User>();
   
   public static void main(String[] args) {
       boolean finishUserLogin = false;
       
       do {
           try{
               System.out.println("\nUser Maintenance: \n(1)Login \n(2)Create User \n(0)Quit application");
               String name, pass;
               int choose = input.nextInt();
               if (choose == 1) {
                   boolean exists = false;
                   System.out.println("Login to existing user account. \nWrite your username:");
                   name = input.next();
                   
                   System.out.println("Write your password:");
                   pass = input.next();
                   
                   for (User user : users) {
                       if (name.equals(user.getUsername()) && pass.equals(user.getPassword())) {
                           accountMaintenance(user); 
                           exists = true;
                           break;
                       }
                   }

                   if (!exists) {
                       System.out.println("Username or password does not exist");
                   }
                  
               }
               else if (choose == 2) {
                   boolean exists = false;
                   System.out.println("Create new account. \nWrite your username:");
                   name = input.next();
                   
                   System.out.println("Write your password:");
                   pass = input.next();
                   
                   for (User user : users) {
                       if (name.equals(user.getUsername())) {
                           System.out.println("Username already exists");
                           exists = true;
                           break;
                       }
                   }
                   if (!exists) {
                       users.add(new User(name, pass));
                   }
               }
               else if (choose == 0) {
                   System.out.println("Quitting...");
                   System.exit(1);
               }
               else {
                   System.out.println("You pressed the wrong key!");
               }
           }
           catch (java.util.InputMismatchException inpEx) {
               System.out.println("Invalid key, only numbers without decimals are allowed!");
               input.nextLine();
           }
           catch (Exception ex) {
               System.out.println(ex);
               input.nextLine();
           }
       } while(!finishUserLogin); 
   }
   
   public static void accountMaintenance(User userAccount)  {
       boolean finishAccountMaintenance = false;
       System.out.println("\nUser " + userAccount.getUsername() + " successfully logged in.");
       do {
           try {
               
               System.out.println("\nAccount Maintenance: \n(1)Add Account \n(2)Choose Account \n(3)Remove Account \n(9)Log out");
               int choose = input.nextInt();
               if (choose == 1) {
                   if (userAccount.getNoOfAccounts() >= 5) {
                       System.out.println("You cannot create more than 5 accounts.");
                   }
                   else {
                       addAccount(userAccount);    
                   }
               }
               else if (choose == 2) {
                   chooseAccount(userAccount, choose);
               }
               else if (choose == 3) {
                   chooseAccount(userAccount, choose);
               }
               else if (choose == 9) {
                   break;
               }
               else {
                   System.out.println("Option " + choose + " does not exist");
               }
           }
           catch (java.util.InputMismatchException inpEx) {
               System.out.println("Invalid key, only numbers without decimals are allowed!");
               input.nextLine();
           }
           
           catch (java.lang.IndexOutOfBoundsException boundsEx) {
               System.out.println("That position does not exist, please try again.");
               input.nextLine();
           }
           catch (Exception ex) {
               System.out.println(ex);
               input.nextLine();
           }
       } while (!finishAccountMaintenance);
   }
   
   public static void chooseAccount(User userAccount, int choice) {
       int choose;
       if (userAccount.getNoOfAccounts() == 0) {
           System.out.println("\nYou have not added any accounts");
       }
       else {
           for (int i = 0; i < userAccount.getNoOfAccounts(); i++) {
               System.out.println("Position " + (i + 1) + ": " + userAccount.getAccount(i).getClass().getName() + " - " + userAccount.getAccount(i).getAccountNo());
           }
           
           if (choice == 2) {
               System.out.println("\nChoose position:");
           }
           else if (choice == 3) {
               System.out.println("\nWhich position do you want to remove?");
           }
           choose = input.nextInt();
           
           if (choose > userAccount.getTotalNoOfAccounts()) {
               System.out.println("Position " + choose + " does not exist");
           }
           else { 
               if (choice == 2) {
                   process(userAccount.getAccount(choose - 1));
                   System.out.println("Opening Account number " + choose);
               }
               else if (choice == 3) {
                   if (userAccount.getAccount(choose - 1).getBalance() > 0) {  
                       System.out.println("Account with a balance cannot be removed. \nWithdraw all the money and try again");
                   }
                   else {
                       userAccount.removeAccount(choose - 1);
                       System.out.println("Removing Account number " + choose);
                   }
               }
               
           }
        }
   }
    
   public static void addAccount(User userAccount) {
       boolean finishAccount = false;
       int accountType;
       
       do {
            System.out.println("\nChoose account type: \n(1)SavingsAccount \n(2)Transactional Account \n(9)Back");
            accountType = input.nextInt();
            
            if (accountType == 1) {
                finishAccount = true;
                userAccount.addSavingsAccount();
            }
            else if (accountType == 2) {
                
                for (int i = 0; i < userAccount.getNoOfAccounts(); i++) {
                    if (userAccount.getAccount(i) instanceof TransactionalAccount) {
                        finishAccount = true;
                        System.out.println("Only one Transactional Account allowed");
                    }
                }
                if (!finishAccount) {
                    userAccount.addTransactionalAccount();
                    finishAccount = true;
                }
            }
            else if (accountType == 9) {
                break;
            }
            else {
                System.out.println("Option " + accountType + " does not exist");
            }
       } while (!finishAccount);
   }
   
   
   //Account related functions.
   public static void process(Account account) {
        int choose, payments;
        boolean finishProcess = true; 

        do {
             try {
                 text(account);
        
                 choose = input.nextInt();
        
                 if (choose == 1) {
                     depo(account);
                 }
                 else if (choose == 2) {
                     take(account);
                 }
                 else if (choose == 3) {
                     details(account);
                 }
                 else if (choose == 4 && account instanceof SavingsAccount) {
                     plan(account);
                 }
                 else if (choose == 4 && account instanceof TransactionalAccount) {
                     payments(account);
                 }
                 else if (choose == 5 && account instanceof TransactionalAccount) {
                     viewPayments(account); 
                 }
                 else if (choose == 9) {
                     break;
                 }
                 else {
                     System.out.println("Option " + choose + " does not exist");
                 }
             }
             catch (java.util.InputMismatchException inpEx) {
               System.out.println("Invalid key, only numbers without decimals are allowed!");
               input.nextLine();
             }
             catch (Exception x) {
                 System.out.println("An unexpected error has occured. Please try again.");
                 input.nextLine();
                 
             }
        } while (finishProcess);
   }

   public static void text(Account account) {
       
       if (account instanceof SavingsAccount) {
           System.out.println("\nWhich service do you want to use?" + "\n(1)Deposit" + 
           "\n(2)Withdraw" + "\n(3)View account details" + "\n(4)Savingsplan" + "\n(9)Back");
       }
       else if (account instanceof TransactionalAccount) {
           System.out.println("\nWhich service do you want to use?" + "\n(1)Deposit" + 
           "\n(2)Withdraw" + "\n(3)View account details" + "\n(4)Make payment" + 
           "\n(5)View Payments" + "\n(9)Back");
       }
   }    

   public static void depo(Account account) {
       System.out.println("Which amount do you want to deposit?"); 
       double dep = input.nextDouble();
       account.deposit(dep);
       System.out.println("You have successfully deposited " + dep + " Sek"); 
    
   }
    
   public static void take(Account account) {
       System.out.println((int)account.getBalance() + " Sek is available on account number " + account.getAccountNo()); 
       System.out.println("How much do you want to withdraw?"); 
       account.withdraw(input.nextDouble());
   
   }
    
   public static void details(Account account) {
       System.out.println(account); 
   }
  
   public static void payments(Account account) {
   
       System.out.println("Who do you want to pay?");
       String paymentName = input.next();
        
       System.out.println("What amount do you want to pay?");
       int paymentAmount = input.nextInt();
        
       if (paymentAmount > account.getBalance()) {
           System.out.println("The payment exceeds the account balance." +
           "\nPlease deposit more money and try again.");
       }
       else {
           System.out.println("A payment of " + paymentAmount + " Sek has been made to " + 
           paymentName + ".");
           account.withdraw(paymentAmount);
           ((TransactionalAccount)account).pay(paymentName, paymentAmount);
       }
   }
   
   public static void viewPayments(Account account) {
        
       if (((TransactionalAccount)account).getPaymentNo() == 0) {
           System.out.println("No payments have been made"); 
       }
       else {
           System.out.println("You have performed the following payments: "); 
           for (int i = 0; i < ((TransactionalAccount)account).getPaymentNo(); i++) {
               System.out.println(((TransactionalAccount)account).getPayments(i));
           }
       }
   }
    
   public static void plan(Account account) {
       System.out.println("How long will you keep your money deposited?");
       int years = input.nextInt();
       System.out.println(((SavingsAccount)account).showPlan(years));
   }
}


