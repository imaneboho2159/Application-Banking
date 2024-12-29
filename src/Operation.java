

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Operation {
    public String type;
    public Double amount;
    public Account accounts;

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Operation> operations = new ArrayList<>();

    public Operation(String type, Double amount, LocalDate creationDate, Account accounts) {
        this.type = type;
        this.amount = amount;
        this.accounts = accounts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getAccounts() {
        return accounts;
    }

    public void setAccounts(Account accounts) {
        this.accounts = accounts;
    }

    public static void deposit() {
        System.out.print("Enter Account Number: ");
        long accountNum = scanner.nextLong();
        scanner.nextLine();
        Account account = null;
        for (Account ac : Account.accounts) {
            if (ac.getAccountNumber() == accountNum) {
                account = ac;
                break;
            }
        }
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        double actualBalance = account.getInitialBalance(); // Use instance method
        System.out.print("Enter the amount of money you want to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        account.setInitialBalance(actualBalance + amount);

        Operation operation = new Operation("DEPOSIT", amount, LocalDate.now(), account);
        System.out.println("Deposit successful. New balance: " + account.getInitialBalance());
    }
}
