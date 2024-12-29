import java.util.Scanner;

public class BankApplication{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MenuApplication();
    }
    public static void MenuApplication(){
        int choice=1;
        while(choice!=0){
            System.out.println("\n ----Menu Application-----");
            System.out.println("1. Manage Client ");
            System.out.println("2. Manage Account ");
            System.out.println("3. Manage Operations ");
            System.out.println("0. Exit");
            System.out.print("Enter your choice :");
            choice=scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1: MenuClient();
                    break;
                case 2: Account.menuAccount();
                    break;
                case 3: MenuOperation();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }
    public static void MenuClient(){
        int choice=1;

        while(choice!=0){
            System.out.println("\n ----Menu Client-----");
            System.out.println("1. Add Client ");
            System.out.println("2. Display Client ");
            System.out.println("3. Update  Client ");
            System.out.println("4. Delete Client ");
            System.out.println("0. Exit");
            System.out.print("Enter your choice : ");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:Client.addClient();
                    break;
                case 2:Client.displayClient();
                    break;
                case 3:Client.updateClient();
                    break;
                case 4:Client.deleteClient();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }

    public static void MenuOperation(){
        int choice=1;
        while(choice!=0){
            System.out.println("\n ----Menu Operation-----");
            System.out.println("1. Deposit  ");
            System.out.println("2. Withdraw ");
            System.out.println("3. Transfer  ");
            System.out.println("4. Operation History");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    Operation.deposit();
                    break;
            }}}}
                /*case 2:Operation.withdraw();
                break;
                case 3: Operation.transfer();
                break;
                case 4: Operation.operationHistory();
                break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                    default:
                        System.out.println("Invalid choice");


            }
        }
 }
*/