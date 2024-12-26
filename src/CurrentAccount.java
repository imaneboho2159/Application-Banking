import java.util.ArrayList;
import java.util.Scanner;


public class CurrentAccount extends Account {
    static Double bankCharges;
    private Client clients;


    static Scanner scanner = new Scanner(System.in);
    static ArrayList<CurrentAccount> currentAccount = new ArrayList<>();

    public CurrentAccount(long accountNumber, double initialBalance, Client clients) {
        super(accountNumber, initialBalance, clients);
    }

    public CurrentAccount() {
        super();
    }

    public Double getBankCharges() {
        return bankCharges;
    }

    public void setBankCharges(Double bankCharges) {
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

    public void addCurrentAccount() {
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
        CurrentAccount newAccount = new CurrentAccount(accountNumber, initialBalance, clients);
        currentAccount.add(newAccount);

        System.out.println("Current account has been created successfully for client: " + Client.client.getFirst().getFirstName() + " " + Client.client.getFirst().getLastName());


    }

    public void displayCurrentAccount() {
        System.out.println(" ------list of Current Accounts ------ -----");
        for (CurrentAccount ca : currentAccount) {
            System.out.println("CurrentAccount" +
                    "\naccountNumber=" + getAccountNumber() +
                    "\n balance=" + getInitialBalance() +
                    "\n bankCharges=" + bankCharges +
                    "\n client=" + Client.client.getFirst().getFirstName() +" " + Client.client.getLast().getLastName() + " ID: " + Client.client.getFirst().getId() );
        }
    }


                ;

    }

