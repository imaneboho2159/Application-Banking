import java.util.Scanner;

public class Account {
   private long accountNumber;
   private double initialBalance;
   private Client clients;


  static Scanner scanner = new Scanner(System.in);
   public Account(long accountNumber, double initialBalance,Client clients) {
       this.accountNumber = accountNumber;
       this.initialBalance = initialBalance;

   }

    public Account() {

    }

    public long getAccountNumber() {
       return accountNumber;
   }
   public  double getInitialBalance() {
       return initialBalance;
   }

   public void setAccountNumber(){
       this.accountNumber = accountNumber;
   }
   public void setInitialBalance(double initialBalance) {
       this.initialBalance = initialBalance;
   }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public static void MenuAccount(){

       int choice = 1;
       while(choice != 0){
           System.out.println("------ Menu Account ------");
           System.out.println("1- Menu of Current Account");
           System.out.println("2- Menu of Saving Account");
           System.out.println(" Enter your choice :");
           choice=scanner.nextInt();
           scanner.nextLine();
           CurrentAccount currentAccount=new CurrentAccount();
           switch(choice){
               case 1: currentAccount.MenuCurrentAccount();
               break;
               /*case 2:SavingAccount.MenuSavingAccount();
               break;*/
               default:
                   System.out.println("Invalid choice");
           }
       }
   }
}
