import java.util.Scanner;

public class SavingAccount extends Account {
    Double interestRate;
    static Scanner scanner = new Scanner(System.in);
    public SavingAccount(long number, double sold, Client client) {
        super(number, sold, client);
    }

    public SavingAccount(long number, double sold, Client client, Double interestRate) {
        super(number, sold, client);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
    public static void MenuSavingAccount() {
        int choice = 1;
        while (choice != 0) {
            System.out.println("1- Add Saving Account\n"+ "2 -Display Saving Account\n" + "3- Update Saving Account\n" + "4-Delete  Saving Account\n" +" 0- Get out \n"+"  Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:addSavingAccount();
                    break;
                case 2:displaySavingAccount();
                    break;
                case 3:updateSavingAccount();
                    break;
                case 4:deleteSavingAccount();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");

            }}

    }
}
