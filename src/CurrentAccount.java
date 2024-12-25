import java.util.Scanner;

public class CurrentAccount extends Account {
    Double bankCharges ;
    static Scanner scanner = new Scanner(System.in);

    public CurrentAccount(long number, double sold, Client client) {
        super(number, sold, client);
    }

    public Double getBankCharges() {
        return bankCharges;
    }

    public void setBankCharges(Double bankCharges) {
        this.bankCharges = bankCharges;
    }
    public static void MenuCurrentAccount() {
        int choice = 1;
        while (choice != 0) {
        System.out.println("1- Add Current Account\n"+ "2 -Display Current Account\n" + "3- Update Current Account\n" + "4-Delete Current Account\n" +" 0- Get out \n"+"  Enter your choice");
        choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice) {
            case 1:addCurrentAccount();
            break;
            case 2:displayCurrentAccount();
            break;
            case 3:updateCurrentAccount();
            break;
            case 4:deleteCurrentAccount();
            break;
            case 0:
                return;
                default:
                    System.out.println("Invalid choice");

        }}

    }
}
