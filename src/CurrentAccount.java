import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class CurrentAccount extends Account {
    static int  bankCharges = 100;
    private Client clients;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<CurrentAccount> currentAccount = new ArrayList<>();

     public CurrentAccount(long accountNumber, double initialBalance, LocalDate creationDate, Client clients) {
        super(accountNumber, initialBalance, creationDate, clients);
        this.clients = clients;
    }

    public CurrentAccount(Client clients) {
        this.clients = clients;
    }

    public CurrentAccount() {
        super();
    }

    public int  getBankCharges() {
        return bankCharges;
    }

    public void setBankCharges(int bankCharges) {
        this.bankCharges = bankCharges;
    }

    public void MenuCurrentAccount() {
        int choice = 1;
        while (choice != 0) {
            System.out.println("\n1- Add Current Account" + "\n2 -Display Current Account" + " \n0- Get out " + "  Enter your choice :");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addCurrentAccount();
                    break;
                case 2:
                    displayCurrentAccount();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");

            }
        }

    }
    public void calculateActualBalance(int id) {
        LocalDate NowDate = GetDate();
        long DayBetwen= ChronoUnit.MONTHS.between(NowDate,currentAccount.get(id).GetDate());
        if (DayBetwen == 0 || DayBetwen > 12) {
           currentAccount.get(id).setInitialBalance(currentAccount.get(id).getInitialBalance()-100);
        }
        else {
            System.out.println(" the account still did not reach the condition of one year! ");
        }
    }

      void addCurrentAccount() {

        Scanner scanner = new Scanner(System.in);

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
        CurrentAccount newAccount = new CurrentAccount(accountNumber, initialBalance, GetDate(),clients);
        currentAccount.add(newAccount);

        System.out.println("Current account has been created successfully for client: " + Client.client.getFirst().getFirstName() + " " + Client.client.getFirst().getLastName());


    }

    public void displayCurrentAccount() {
        System.out.println(" ------list of Current Accounts ------ -----");
        for (CurrentAccount ca : currentAccount) {
            System.out.println(
                    "\naccountNumber:" + ca.getAccountNumber() +
                    "\n balance :" + ca.getInitialBalance() +
                    "\n Creation date :" + GetDate() +
                    "\n Client : " + Client.client.getFirst().getFirstName() +" \n" + Client.client.getLast().getLastName() + " \nID: " + Client.client.getFirst().getId() + "\n"+ Client.client.getFirst().getEmail() +"\n"+Client.client.getFirst().getPhoneNumber()+"\n"+Client.client.getFirst().getAddress() );
        }
    }

    public   LocalDate GetDate(){
        LocalDate CreationDate = LocalDate.now();

     return  CreationDate;
    }
}

