import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    public long accountNumber;
    private double initialBalance;  // Removed static modifier
    private LocalDate creationDate;
    private Client clients;

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    public Account(long accountNumber, double initialBalance, LocalDate creationDate, Client clients) {
        this.accountNumber = accountNumber;
        this.initialBalance = initialBalance;
        this.clients = clients;
        this.creationDate = creationDate;
    }

    public Account() {}

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setAccountNumber(long accountNumber) {
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

    public Double actualBalanceForCurrentAccount() {
        LocalDate nowDate = CurrentAccount.GetDate();
        Double actualBalance = null;
        long monthsBetween = ChronoUnit.MONTHS.between(creationDate, nowDate);
        if (monthsBetween > 0) {
            long totalCharge = 100 * monthsBetween;
            actualBalance = this.initialBalance - totalCharge;
        }
        return actualBalance;
    }

    public Double actualBalanceForSavingAccount() {
        LocalDate nowDate = SavingAccount.GetSDate();
        Double actualBalance = null;
        long monthsBetween = ChronoUnit.MONTHS.between(creationDate, nowDate);
        if (monthsBetween >= 12) {
            long totalInterestRate = 100 * monthsBetween;
            actualBalance = this.initialBalance + totalInterestRate;
        }
        return actualBalance;
    }

    public static void deposit() {
        System.out.print("Enter Account Number: ");
        long accountNum = scanner.nextLong();
        scanner.nextLine();
        Account account = null;
        for (Account ac : accounts) {
            if (ac.getAccountNumber() == accountNum) {
                account = ac;
                break;
            }
        }
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter the amount of money you want to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        double actualBalance = account.getInitialBalance();
        account.setInitialBalance(actualBalance + amount);

        Operation operation = new Operation("DEPOSIT", amount, LocalDate.now(), account);
        System.out.println("Deposit successful. New balance: " + account.getInitialBalance());
    }

    public static void menuAccount() {
        int choice = 1;
        while (choice != 0) {
            System.out.println("------ Menu Account ------");
            System.out.println("1- Menu of Current Account");
            System.out.println("2- Menu of Saving Account");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            CurrentAccount currentAccount = new CurrentAccount();
            SavingAccount savingAccount = new SavingAccount();
            switch (choice) {
                case 1:
                    currentAccount.MenuCurrentAccount();
                    break;
                case 2:
                    savingAccount.MenuSavingAccount();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

