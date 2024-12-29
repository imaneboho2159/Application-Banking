import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class SavingAccount extends Account {
    int interestRate =100;
    private Client clients;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<SavingAccount> savingAccount = new ArrayList<>();




    public SavingAccount(long accountNumber, double initialBalance, LocalDate creationDate, Client clients) {
        super(accountNumber, initialBalance, creationDate, clients);
        this.clients = clients;
    }

    public SavingAccount() {

    }



    public  void MenuSavingAccount() {
        int choice = 1;
        while (choice != 0) {
            System.out.println("1- Add Saving Account\n"+ "2 -Display Saving Account\n" +" 0- Get out \n"+"  Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:addSavingAccount();
                    break;
                case 2:displaySavingAccount();
                    break;

                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");

            }}
    }
    void addSavingAccount() {
        System.out.print("Enter account number :");
        long accountNumber = scanner.nextLong();
        System.out.print("Enter initial balance :");
        double initialBalance = scanner.nextDouble();
        System.out.print("Enter The ID of client :");
        int cId = scanner.nextInt();
        scanner.nextLine();
        for (Client c : Client.client) {
            if (cId == c.getId()) {
                clients = c;
                break;
            }
            if (clients == null) {
                System.out.println("Client not found");
                return;
            }
        }
        SavingAccount newAccount = new SavingAccount(accountNumber, initialBalance, GetSDate(),clients);
        savingAccount.add(newAccount);

        System.out.println("Current account has been created successfully for client: " + Client.client.getFirst().getFirstName() + " " + Client.client.getFirst().getLastName());
    }
    public void displaySavingAccount() {
        System.out.println(" ------list of Current Accounts ------ -----");
        for (SavingAccount sa: savingAccount) {
            System.out.println(
                    "\naccountNumber:" + sa.getAccountNumber() +
                            "\n balance :" + getInitialBalance() +
                            "\n Creation date :" + GetSDate() +
                            "\n Client : " + Client.client.getFirst().getFirstName() +" \n" + Client.client.getLast().getLastName() + " \nID: " + Client.client.getFirst().getId() + "\n"+ Client.client.getFirst().getEmail() +"\n"+Client.client.getFirst().getPhoneNumber()+"\n"+Client.client.getFirst().getAddress() );
        }
    }
    public  static LocalDate GetSDate(){
        LocalDate CreationDate = LocalDate.now();

        return  CreationDate;
    }

}
